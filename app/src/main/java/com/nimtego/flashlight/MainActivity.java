package com.nimtego.flashlight;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CommonView {
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mPresenter = new PresenterMainActivity();
        mPresenter.attachView(this);
        ImageButton button = findViewById(R.id.button_flash);
        button.setOnClickListener(mPresenter);
    }

    @Override
    public void toast(String message) {
        Toast.makeText(MainActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void alarm(String message) {

    }

    @Override
    public void intent(Class<MainActivity> commonView) {

    }

    @Override
    public void setImage(boolean isOn) {
        ((ImageButton)findViewById(R.id.button_flash))
                .setImageResource(isOn ? R.drawable.ic_flash_on_black_24dp :
                        R.drawable.ic_flash_off_black_24dp);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
