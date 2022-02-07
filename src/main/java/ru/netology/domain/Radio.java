package ru.netology.domain;

public class Radio {
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if ((currentVolume < this.getMinVolume()) || (currentVolume > this.getMaxVolume())) {
            return;
        }
        this.currentVolume = currentVolume;
    }

    public void increaseVolume() {
        if (currentVolume >= getMaxVolume()) {
            return;
        }
        setCurrentVolume(++currentVolume);
    }

    public void decreaseVolume() {
        if (currentVolume <= getMinVolume()) {
            return;
        }
        setCurrentVolume(--currentVolume);
    }
}