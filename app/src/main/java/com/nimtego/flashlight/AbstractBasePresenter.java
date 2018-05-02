package com.nimtego.flashlight;

public abstract class AbstractBasePresenter<T extends CommonView> implements Presenter<T> {
    protected T commonView;

    @Override
    public void attachView(T commonView) {
        this.commonView = commonView;
    }

    @Override
    public void detachView() {
        commonView = null;
    }

    public T getView() {
        return commonView;
    }

    protected boolean isViewAttached() {
        return commonView != null;
    }

}
