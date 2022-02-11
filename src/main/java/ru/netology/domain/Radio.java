package ru.netology.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Radio {
    private int firstChannel = 0;
    private int countChannel = 10;
    private int lastChannel = 9;
    private int currentChannel;
    private int minVolume = 0;
    private int maxVolume = 100;
    private int currentVolume;

    public Radio(int countChannel) {
        this.countChannel = countChannel;
        this.lastChannel = countChannel - 1;
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