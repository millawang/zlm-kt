package com.zlm.kt.other.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zlm.kt.connect.response.Response
import com.zlm.kt.connect.response.ResponseTransformer
import com.zlm.kt.connect.scheduler.BaseSchedulerProviderImp
import com.zlm.kt.connect.scheduler.SchedulerProvider.Companion.instance
import com.zlm.kt.data.DataManager
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * @author Milla
 * @create 2020/3/27
 */
open class BaseViewModel<N>(// -------------------------------------------
        val dataManager: DataManager) : ViewModel() {
    // -------------------------------------------
    // -------------------------------------------
    val isLoading = MutableLiveData<Boolean>()

    // -------------------------------------------
    val compositeDisposable: CompositeDisposable

    private val schedulerProvider: BaseSchedulerProviderImp?
    private var navigator: WeakReference<N>? = null

    // -------------------------------------------
    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    // -------------------------------------------
    fun <T> getResponseTransformer(): ObservableTransformer<Response<T>, T> {
        return ResponseTransformer.handleResult()
    }

    // -------------------------------------------
    fun <T> getResponseLoginTransformer(): ObservableTransformer<Response<T>, T> {
        return ResponseTransformer.handleLoginResult()
    }

    // -------------------------------------------
    fun <T> getSchedulerProvider(): ObservableTransformer<T, T> {
        return schedulerProvider!!.applySchedulers()
    }

    // -------------------------------------------
    fun getNavigator(): N? {
        return navigator!!.get()
    }

    // -------------------------------------------
    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    // -------------------------------------------
    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.postValue(isLoading)
    } // -------------------------------------------

    // -------------------------------------------
    init {
        compositeDisposable = CompositeDisposable()
        schedulerProvider = instance
    }
}