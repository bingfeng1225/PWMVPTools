package cn.qd.peiwen.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.qd.peiwen.mvp.base.BasePresenter;

public abstract class MVPFragment extends Fragment {
    protected Unbinder unbinder;
    protected List<BasePresenter> presenters = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(this.layoutId(), container, false);
        unbinder = ButterKnife.bind(this, root);
        this.initPresent();
        this.initViewDisplay();
        this.initEventAndListener();
        for (BasePresenter presenter:this.presenters) {
            presenter.onCreate();
        }
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        for (BasePresenter presenter:this.presenters) {
            presenter.onDestroy();
            presenter.detachView();
        }
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
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
