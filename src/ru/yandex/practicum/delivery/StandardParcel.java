package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public double calculateDeliveryCost() {
        return getWeight() * STANDART_PARCEL_PRICE;
    }
}
