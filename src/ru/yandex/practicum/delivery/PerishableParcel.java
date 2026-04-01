package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay,
                            int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public double calculateDeliveryCost() {
        return getWeight() * PERISHABLE_PARCEL_PRICE;
    }

    public boolean isExpired(int currentDay) {
        return !(getSendDay() + getTimeToLive() >= currentDay);   //возвращаем false, когда верно неравенство (посылка не испортилась)
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }
}
