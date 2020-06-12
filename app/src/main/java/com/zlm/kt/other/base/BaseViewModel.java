package com.zlm.kt.other.base;

import com.zlm.kt.connect.response.Response;
import com.zlm.kt.connect.response.ResponseTransformer;
import com.zlm.kt.connect.scheduler.BaseSchedulerProviderImp;
import com.zlm.kt.connect.scheduler.SchedulerProvider;
import com.zlm.kt.data.DataManager;

import java.lang.ref.WeakReference;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.CompositeDisposable;

/**
 * @author Milla
 * @create 2020/3/27
 */
public class BaseViewModel<N> extends ViewModel {

    // -------------------------------------------
    private final MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    private CompositeDisposable compositeDisposable;
    private DataManager dataManager;
    private BaseSchedulerProviderImp schedulerProvider;
    private WeakReference<N> navigator;

    // -------------------------------------------
    public BaseViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
        compositeDisposable = new CompositeDisposable();
        schedulerProvider = SchedulerProvider.getInstance();
    }

    // -------------------------------------------
    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    // -------------------------------------------
    public <T> ObservableTransformer<Response<T>, T> getResponseTransformer() {
        return ResponseTransformer.handleResult();
    }

    // -------------------------------------------
    public <T> ObservableTransformer<Response<T>, T> getResponseLoginTransformer() {
        return ResponseTransformer.handleLoginResult();
    }

    // -------------------------------------------
    public <T> ObservableTransformer<T, T> getSchedulerProvider() {
        return schedulerProvider.applySchedulers();
    }

    // -------------------------------------------
    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    // -------------------------------------------
    public DataManager getDataManager() {
        return dataManager;
    }

    // -------------------------------------------
    public N getNavigator() {
        return navigator.get();
    }

    // -------------------------------------------
    public void setNavigator(N navigator) {
        this.navigator = new WeakReference<>(navigator);
    }

    // -------------------------------------------
    public MutableLiveData<Boolean> isLoading() {
        return isLoading;
    }

    // -------------------------------------------
    public void setIsLoading(boolean isLoading) {
        this.isLoading.postValue(isLoading);
    }

    // -------------------------------------------
}
