package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(10);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(10);

    public static void main(String[] args) {

        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    reportBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отслеживание посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже
    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.print("Введите описание посылки: ");
        String description = scanner.nextLine();
        System.out.print("Введите вес посылки: ");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.print("Адрес места назначения посылки: ");
        String deliveryAddress = scanner.nextLine();
        System.out.print("День месяца для отправки: ");
        int sendDay = Integer.parseInt(scanner.nextLine());
        System.out.println("Выберите тип посылки:");
        System.out.println("1 — Стандартная посылка");
        System.out.println("2 — Хрупкая посылка");
        System.out.println("3 — Скоропортящаяся посылка");
        int typeOfParcel = Integer.parseInt(scanner.nextLine());

        switch (typeOfParcel) {
            case 1:
                System.out.println("Оформляю стандартную посылку");
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                break;
            case 2:
                System.out.println("Оформляю хрупкую посылку");
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                break;
            case 3:
                System.out.println("Укажите срок годности посылки, в днях: ");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                System.out.println("Оформляю скоропортящуюся посылку");
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress,
                                                                         sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Неверный выбор.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + sum);
    }

    private static void reportStatus() {
        System.out.print("Введите текущее местоположение: ");
        String newLocation = scanner.nextLine();

        for (Parcel parcel : allParcels) {
            if (parcel instanceof Trackable trackableParcel) {
                trackableParcel.reportStatus(newLocation);
            }
        }
    }

    private static void reportBox() {
        System.out.println("Выберите интересующую вас коробку: ");
        System.out.println("1 — Коробка со стандартными посылками");
        System.out.println("2 — Коробка с хрупкими посылками");
        System.out.println("3 — Коробка со скоропортящимися посылками");
        int boxType = Integer.parseInt(scanner.nextLine());

        switch (boxType) {
            case 1:
                System.out.println("Содержимое со стандартными посылками:");
                System.out.println(standardBox.getAllParcels());
                break;
            case 2:
                System.out.println("Содержимое с хрупкими посылками:");
                System.out.println(fragileBox.getAllParcels());
                break;
            case 3:
                System.out.println("Содержимое со скоропортящимися посылками:");
                System.out.println(perishableBox.getAllParcels());
                break;
            default:
                System.out.println("Неверный выбор.");
        }

    }
}