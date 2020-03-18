package cn.qd.peiwen.mvp.base;

import android.content.Context;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

/**
 * Created by royfu on 16-12-28.
 */

public abstract class BasePresenter<V extends IBaseViewer> {
    protected Context context;
    protected WeakReference<V> attachedView;

    public BasePresenter(@NonNull Context context, V view) {
        attachView(view);
        this.context = context;
    }

    private void attachView(@NonNull V view) {
        attachedView = new WeakReference<>(view);
    }

    public void detachView() {
        if (isAttached()) {
            attachedView.clear();
        }
    }

    public boolean isAttached() {
        return attachedView != null && attachedView.get() != null;
    }

    public void onCreate(){

    }

    public void onResume(){

    }

    public void onPause(){

    }

    public void onDestroy(){

    }
}
