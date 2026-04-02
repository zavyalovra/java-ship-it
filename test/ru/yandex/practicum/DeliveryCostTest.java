package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {

    @Test
    public void shouldCalculateStandardParcelCost() {
        StandardParcel books = new StandardParcel("Книги", 5, "д. Давлеканово", 1);
        assertEquals(10, books.calculateDeliveryCost());
        StandardParcel air = new StandardParcel("Воздух", 0, "п. Раевка", 1);
        assertEquals(0, air.calculateDeliveryCost());
    }

    @Test
    public void shouldCalculateFragileParcelCost() {
        FragileParcel glass = new FragileParcel("Стекло", 2, "п. Верхние балыклы", 1);
        assertEquals(8, glass.calculateDeliveryCost());
        FragileParcel gas = new FragileParcel("Сжиженный природный газ (баллон прохудился)", 0, "п. Раевка", 1);
        assertEquals(0, gas.calculateDeliveryCost());
    }

    @Test
    public void shouldCalculatePerishableParcelCost() {
        PerishableParcel pie = new PerishableParcel("Бабушкины пирожки", 3, "д. Ивановка", 1, 1);
        assertEquals(9, pie.calculateDeliveryCost());
        PerishableParcel milk = new PerishableParcel("Молоко коровье (пустые бидоны)", 0, "п. Васильки", 1, 0);
        assertEquals(0, milk.calculateDeliveryCost());
    }
}