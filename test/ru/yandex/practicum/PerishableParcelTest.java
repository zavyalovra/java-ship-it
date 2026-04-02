package ru.yandex.practicum;
import ru.yandex.practicum.delivery.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PerishableParcelTest {

    @Test
    void shouldBeFalseWhenParcelNotExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 2, "п. Васильки", 1, 5);
        assertFalse(parcel.isExpired(3));
    }

    @Test
    void shouldBeTrueWhenParcelExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 2, "п. Васильки", 1, 3);
        assertTrue(parcel.isExpired(10));
    }

    @Test
    void shouldBeFalseOnLastValidDay() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 2, "п. Васильки", 1, 5);
        assertFalse(parcel.isExpired(6));
    }
}
