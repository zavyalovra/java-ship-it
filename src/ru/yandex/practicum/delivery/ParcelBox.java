package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private int maxBoxSize;
    private List<Parcel> parcels = new ArrayList<>();

    public ParcelBox(int maxBoxSize) {
        this.maxBoxSize = maxBoxSize;
    }

    public void addParcel(Parcel parcel) {
        int currentBoxSize = 0;

        for (Parcel p : parcels) {
            currentBoxSize += p.getWeight();
        }

        if (currentBoxSize + parcel.getWeight() > maxBoxSize) {
            System.out.println("В коробке для посылок закончилось место");
            return;
        }

        parcels.add(parcel);
    };

    public List<Parcel> getAllParcels() {
        return parcels;
    }

    public int getMaxBoxSize() {
        return maxBoxSize;
    }

    public void setMaxBoxSize(int maxBoxSize) {
        this.maxBoxSize = maxBoxSize;
    }
}
