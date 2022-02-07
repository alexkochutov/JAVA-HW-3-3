package ru.netology.domain;

public class Radio {
    private int firstChannel = 0;
    private int countChannel = 10;
    private int lastChannel = 9;
    private int currentChannel;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public Radio() {
    }

    public Radio(int countChannel) {
        this.countChannel = countChannel;
        this.lastChannel = countChannel - 1;
    }

    public int getFirstChannel() {
        return firstChannel;
    }

    public int getCountChannel() {
        return countChannel;
    }

    public int getLastChannel() {
        return lastChannel;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public void setCurrentChannel(int currentChannel) {
        if ((currentChannel < this.getFirstChannel()) || (currentChannel > this.getLastChannel())) {
            return;
        }
        this.currentChannel = currentChannel;
    }

    public void nextChannel() {
        if (currentChannel == getLastChannel()) {
            currentChannel = getFirstChannel();
            return;
        }
        setCurrentChannel(++currentChannel);
    }

    public void prevChannel() {
        if (currentChannel == getFirstChannel()) {
            currentChannel = getLastChannel();
            return;
        }
        setCurrentChannel(--currentChannel);
    }

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