package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private final int maxBoxSize;
    private final List<T> parcels = new ArrayList<>();

    public ParcelBox(int maxBoxSize) {
        this.maxBoxSize = maxBoxSize;
    }

    public boolean addParcel(T parcel) {
        int currentBoxSize = 0;

        for (Parcel p : parcels) {
            currentBoxSize += p.getWeight();
        }

        if (currentBoxSize + parcel.getWeight() > getMaxBoxSize()) {
            return false;
        }

        parcels.add(parcel);
        return true;
    }

    public List<T> getAllParcels() {
        return parcels;
    }

    public int getMaxBoxSize() {
        return maxBoxSize;
    }
}
