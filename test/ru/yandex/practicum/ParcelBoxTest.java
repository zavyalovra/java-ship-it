package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    @Test
    void shouldAddStandardParcels() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        box.addParcel(new StandardParcel("Книги", 4, "г. Москва", 1));
        box.addParcel(new StandardParcel("Журналы", 6, "г. Москва", 1));

        assertEquals(2, box.getAllParcels().size());
    }

    @Test
    void shouldNotAddStandardParcels() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10);

        box.addParcel(new StandardParcel("Книги", 4, "г. Москва", 1));
        box.addParcel(new StandardParcel("Журналы", 6, "г. Москва", 1));
        box.addParcel(new StandardParcel("Тетради", 2, "г. Москва", 1));

        assertEquals(2, box.getAllParcels().size());
    }

    @Test
    void shouldAddFragileParcels() {
        ParcelBox<FragileParcel> box = new ParcelBox<>(10);

        box.addParcel(new FragileParcel("Стекло", 4, "г. Москва", 1));
        box.addParcel(new FragileParcel("Хрусталь", 6, "г. Москва", 1));

        assertEquals(2, box.getAllParcels().size());
    }

    @Test
    void shouldNotAddFragileParcels() {
        ParcelBox<FragileParcel> box = new ParcelBox<>(10);

        box.addParcel(new FragileParcel("Стекло", 4, "г. Москва", 1));
        box.addParcel(new FragileParcel("Хрусталь", 6, "г. Москва", 1));
        box.addParcel(new FragileParcel("Рюмки", 2, "г. Москва", 1));

        assertEquals(2, box.getAllParcels().size());
    }

    @Test
    void shouldAddPerishableParcels() {
        ParcelBox<PerishableParcel> box = new ParcelBox<>(10);

        box.addParcel(new PerishableParcel("Молоко", 4, "г. Москва", 1, 1));
        box.addParcel(new PerishableParcel("Хлеб", 6, "г. Москва", 1, 1));

        assertEquals(2, box.getAllParcels().size());
    }

    @Test
    void shouldNotAddPerishableParcels() {
        ParcelBox<PerishableParcel> box = new ParcelBox<>(10);

        box.addParcel(new PerishableParcel("Молоко", 4, "г. Москва", 1, 1));
        box.addParcel(new PerishableParcel("Хлеб", 6, "г. Москва", 1, 1));
        box.addParcel(new PerishableParcel("Сок", 2, "г. Москва", 1, 1));

        assertEquals(2, box.getAllParcels().size());
    }
}
