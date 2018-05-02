package com.nimtego.flashlight;

import android.view.View;

public interface Presenter<T extends CommonView> extends View.OnClickListener {
    void attachView(T commonView);
    void detachView();
}
