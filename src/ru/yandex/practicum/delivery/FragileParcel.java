package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> обернута в защитную пленку");
        super.packageItem();
    }

    @Override
    public double calculateDeliveryCost() {
        return getWeight() * FRAGILE_PARCEL_PRICE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + getDescription() + ">> изменила местоположение на " + newLocation);
    }
}
