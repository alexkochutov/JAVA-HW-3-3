package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldNotBeNegativeValue, -1, 0",
                    "shouldBeEqualFirstChannel, 0, 0",
                    "shouldBePositiveValue, 1, 1",
                    "shouldBeLessThenLastChannel, 8, 8",
                    "shouldBeEqualLastChannel, 9, 9",
                    "shouldNotBeMoreThenMaxVolume, 10, 0"
            }, delimiter = ',')
    void shouldSetCurrentChannel(String testName, int currentChannel, int expected) {
        Radio radio = new Radio();

        radio.setCurrentChannel(currentChannel);

        assertEquals(expected, radio.getCurrentChannel());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldIncreaseCurrentChannel, 8, 9",
                    "shouldSetToFirstChannel, 9, 0"
            }, delimiter = ',')
    void shouldChangeNextStation(String testName, int currentChannel, int expected) {
        Radio radio = new Radio();

        radio.setCurrentChannel(currentChannel);
        radio.nextChannel();

        assertEquals(expected, radio.getCurrentChannel());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldDecreaseCurrentChannel, 1, 0",
                    "shouldSetToFirstChannel, 0, 9"
            }, delimiter = ',')
    void shouldChangePrevStation(String testName, int currentChannel, int expected) {
        Radio radio = new Radio();

        radio.setCurrentChannel(currentChannel);
        radio.prevChannel();

        assertEquals(expected, radio.getCurrentChannel());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldNotBeNegativeValue, -1, 0",
                    "shouldBeEqualFirstChannel, 0, 0",
                    "shouldBePositiveValue, 1, 1",
                    "shouldBeLessThenLastChannel, 98, 98",
                    "shouldBeEqualLastChannel, 99, 99",
                    "shouldNotBeMoreThenMaxVolume, 100, 0"
            }, delimiter = ',')
    void shouldSetCurrentChannelForCustomConstructor(String testName, int currentChannel, int expected) {
        Radio radio = new Radio(100);

        radio.setCurrentChannel(currentChannel);

        assertEquals(expected, radio.getCurrentChannel());
    }


    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldIncreaseCurrentChannel, 98, 99",
                    "shouldSetToFirstChannel, 99, 0"
            }, delimiter = ',')
    void shouldChangeNextStationForCustomConstructor(String testName, int currentChannel, int expected) {
        Radio radio = new Radio(100);

        radio.setCurrentChannel(currentChannel);
        radio.nextChannel();

        assertEquals(expected, radio.getCurrentChannel());
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "shouldDecreaseCurrentChannel, 1, 0",
                    "shouldSetToFirstChannel, 0, 99"
            }, delimiter = ',')
    void shouldChangePrevStationForCustomConstructor(String testName, int currentChannel, int expected) {
        Radio radio = new Radio(100);

        radio.setCurrentChannel(currentChannel);
        radio.prevChannel();

        assertEquals(expected, radio.getCurrentChannel());
    }

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