package ru.yandex.practicum.delivery;

public abstract class Parcel {
    static final int STANDARD_PARCEL_PRICE = 2;
    static final int PERISHABLE_PARCEL_PRICE = 3;
    static final int FRAGILE_PARCEL_PRICE = 4;

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <<" + getDescription() + ">> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <<" + getDescription() + ">> доставлена по адресу " + getDeliveryAddress());
    }

    public abstract double calculateDeliveryCost();

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }
}
