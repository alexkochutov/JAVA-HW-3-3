package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldNotAcceptLessThenPossible() {
        Radio service = new Radio();

        int wrongStationNumber = -1;
        service.setCurrentStation(wrongStationNumber);

        int expected = 0;

        assertEquals(expected, service.getCurrentStation());
    }

    @Test
    void shouldNotAcceptMoreThenPossible() {
        Radio service = new Radio();

        int wrongStationNumber = 10;
        service.setCurrentStation(wrongStationNumber);

        int expected = 0;

        assertEquals(expected, service.getCurrentStation());
    }

    @Test
    void shouldSelectNextStation() {
        Radio service = new Radio();

        service.setCurrentStation(8);
        service.nextStation();

        int expected = 9;

        assertEquals(expected, service.getCurrentStation());
    }

    @Test
    void shouldJumpToFirstStation() {
        Radio service = new Radio();

        service.setCurrentStation(9);
        service.nextStation();

        int expected = 0;

        assertEquals(expected, service.getCurrentStation());
    }

    @Test
    void shouldSelectPrevStation() {
        Radio service = new Radio();

        service.setCurrentStation(1);
        service.prevStation();

        int expected = 0;

        assertEquals(expected, service.getCurrentStation());
    }

    @Test
    void shouldJumpToLastStation() {
        Radio service = new Radio();

        service.setCurrentStation(0);
        service.prevStation();

        int expected = 9;

        assertEquals(expected, service.getCurrentStation());
    }

    @Test
    void shouldIncreaseVolume() {
        Radio service = new Radio();

        service.setCurrentVolume(5);
        service.increaseVolume();

        int expected = 6;

        assertEquals(expected, service.getCurrentVolume());
    }

    @Test
    void shouldNotIncreaseVolume() {
        Radio service = new Radio();

        service.setCurrentVolume(10);
        service.increaseVolume();

        int expected = 10;

        assertEquals(expected, service.getCurrentVolume());
    }

    @Test
    void shouldDecreaseVolume() {
        Radio service = new Radio();

        service.setCurrentVolume(5);
        service.decreaseVolume();

        int expected = 4;

        assertEquals(expected, service.getCurrentVolume());
    }

    @Test
    void shouldNotDecreaseVolume() {
        Radio service = new Radio();

        service.setCurrentVolume(0);
        service.decreaseVolume();

        int expected = 0;

        assertEquals(expected, service.getCurrentVolume());
    }
}