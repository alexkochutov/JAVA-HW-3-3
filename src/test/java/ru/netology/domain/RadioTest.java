package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldNotBeNegativeValue, -1, 0",
                    "shouldBeEqualZero, 0, 0",
                    "shouldBePositiveValue, 1, 1",
                    "shouldBeLessThenMaxVolume, 99, 99",
                    "shouldBeEqualMaxVolume, 100, 100",
                    "shouldNotBeMoreThenMaxVolume, 101, 0"
            }, delimiter = ',')
    void shouldSetCurrentVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);

        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldBeLessThenMaxVolume, 99, 100",
                    "shouldNotBeMoreThenMaxVolume, 100, 100"
            }, delimiter = ',')
    void shouldIncreaseCurrentVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        radio.increaseVolume();

        assertEquals(expected, radio.getCurrentVolume());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldBeMoreThenMinVolume, 1, 0",
                    "shouldNotBeLessThenMinVolume, 0, 0"
            }, delimiter = ',')
    void shouldDecreaseCurrentVolume(String testName, int currentVolume, int expected) {
        Radio radio = new Radio();

        radio.setCurrentVolume(currentVolume);
        radio.decreaseVolume();

        assertEquals(expected, radio.getCurrentVolume());
    }

}