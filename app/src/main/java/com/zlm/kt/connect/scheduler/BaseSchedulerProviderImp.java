package com.zlm.kt.connect.scheduler;


import androidx.annotation.NonNull;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

/**
 * @author Milla
 * @create 2020/3/27
 */
public interface BaseSchedulerProviderImp {

    @NonNull
    Scheduler computation();

    @NonNull
    Scheduler io();

    @NonNull
    Scheduler ui();

    @NonNull
    <T> ObservableTransformer<T, T> applySchedulers();
}
