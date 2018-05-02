package com.nimtego.flashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;



public class PresenterMainActivity extends AbstractBasePresenter {
    private boolean flashLightStatus = false;
    private final String LOG_TAG = this.getClass().toString();

    public PresenterMainActivity() {

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_flash) {
            setFlashLigth(flashLightStatus ? Toggle.OFF : Toggle.ON);
        }
    }
    private void setFlashLigth(Toggle toggle) {
        CameraManager cameraManager = (CameraManager) ((AppCompatActivity) commonView)
                .getSystemService(Context.CAMERA_SERVICE);
        try {
            String cameraId = cameraManager.getCameraIdList()[0];
            try {
                cameraManager.setTorchMode(cameraId, toggle.equals(Toggle.ON));
            } catch (IllegalArgumentException e) {
                commonView.toast(e.getMessage());
            }
            flashLightStatus = toggle.equals(Toggle.ON);
            commonView.setImage(flashLightStatus);
            Log.v(LOG_TAG, toggle.toString());
        } catch (CameraAccessException e) {
        }

    }
}
