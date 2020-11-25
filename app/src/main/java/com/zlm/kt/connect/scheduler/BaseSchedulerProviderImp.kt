package com.zlm.kt.connect.scheduler

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler

/**
 * @author Milla
 * @create 2020/3/27
 */
interface BaseSchedulerProviderImp {
    fun computation(): Scheduler
    fun io(): Scheduler
    fun ui(): Scheduler
    fun <T> applySchedulers(): ObservableTransformer<T, T>
}