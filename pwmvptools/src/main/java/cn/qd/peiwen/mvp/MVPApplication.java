package cn.qd.peiwen.mvp;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import cn.qd.peiwen.mvp.base.BasePresenter;

public abstract class MVPApplication extends Application {

    protected List<BasePresenter> presenters = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        this.initPresent();
        for (BasePresenter presenter:this.presenters) {
            presenter.onCreate();
        }
    }

    @Override
    public void onTerminate() {
        for (BasePresenter presenter:this.presenters) {
            presenter.onDestroy();
            presenter.detachView();
        }
        super.onTerminate();
    }


    protected abstract void initPresent();
}
