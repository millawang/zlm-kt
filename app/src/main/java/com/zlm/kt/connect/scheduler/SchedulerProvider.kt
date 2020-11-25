package com.zlm.kt.connect.scheduler

import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Milla
 * @create 2020/3/27
 */
class SchedulerProvider  // -------------------------------------------
// Prevent direct instantiation.
private constructor() : BaseSchedulerProviderImp {
    // -------------------------------------------
    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    // -------------------------------------------
    override fun io(): Scheduler {
        return Schedulers.io()
    }

    // -------------------------------------------
    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    // -------------------------------------------
    override fun <T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable: Observable<T> ->
            observable.subscribeOn(io())
                    .unsubscribeOn(io())
                    .observeOn(ui())
        }
    } // -------------------------------------------

    companion object {
        private var INSTANCE: SchedulerProvider? = null

        // -------------------------------------------
        @JvmStatic
        @get:Synchronized
        val instance: SchedulerProvider?
            get() {
                if (INSTANCE == null) {
                    INSTANCE = SchedulerProvider()
                }
                return INSTANCE
            }
    }
}