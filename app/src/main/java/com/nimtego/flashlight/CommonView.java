package com.nimtego.flashlight;

interface CommonView {
    void toast(String message);
    void alarm(String message);
    void intent(Class<MainActivity> commonView);
    void setImage(boolean isOn);
}
