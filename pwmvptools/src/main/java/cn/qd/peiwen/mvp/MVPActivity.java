package cn.qd.peiwen.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cn.qd.peiwen.mvp.base.BasePresenter;

public abstract class MVPActivity extends AppCompatActivity {
    protected List<BasePresenter> presenters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.layoutId());
        this.initPresent();
        this.initViewDisplay();
        this.initEventAndListener();
        for (BasePresenter presenter:this.presenters) {
            presenter.onCreate();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        for (BasePresenter presenter:this.presenters) {
            presenter.onResume();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        for (BasePresenter presenter:this.presenters) {
            presenter.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        for (BasePresenter presenter:this.presenters) {
            presenter.onDestroy();
            presenter.detachView();
        }
        super.onDestroy();
    }
    /***
     * 初始化UI组件
     */
    protected abstract int layoutId();
    /***
     * 初始化业务处理器
     */
    protected abstract void initPresent();
    /***
     * 初始化页面显示(绑定数据)
     */
    protected abstract void initViewDisplay();
    /***
     * 绑定View事件
     */
    protected abstract void initEventAndListener();
}
