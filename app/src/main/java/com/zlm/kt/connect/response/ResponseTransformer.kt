package com.zlm.kt.connect.response

import com.zlm.kt.connect.exception.ApiException
import com.zlm.kt.connect.exception.CustomException.handleException
import com.zlm.kt.other.AppConstants
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function

/**
 * @author Milla
 * @create 2020/3/27
 */
object ResponseTransformer {
    private const val SUCCESS = 1

    // -------------------------------------------
    fun <T> handleResult(): ObservableTransformer<Response<T>, T> {
        return ObservableTransformer { upstream: Observable<Response<T>> ->
            upstream
                    .onErrorResumeNext(ErrorResumeFunction())
                    .flatMap(ResponseFunction<T>())
        }
    }

    // -------------------------------------------
    fun <T> handleLoginResult(): ObservableTransformer<Response<T>, T> {
        return ObservableTransformer { upstream: Observable<Response<T>> ->
            upstream
                    .onErrorResumeNext(ErrorResumeFunction())
                    .flatMap(ResponseLoginFunction<T>())
        }
    }
    // -------------------------------------------
    /**
     * Local exception use.(Network,JSON error...)
     *
     * @param <T>
    </T> */
    private class ErrorResumeFunction<T> : Function<Throwable, ObservableSource<out Response<T>>> {
        override fun apply(throwable: Throwable): ObservableSource<out Response<T>> {
            return Observable.error(handleException(throwable!!))
        }
    }
    // -------------------------------------------
    /**
     * Server api response.
     *
     * @param <T>
    </T> */
    private class ResponseFunction<T> : Function<Response<T>, ObservableSource<T>> {
        override fun apply(response: Response<T>): ObservableSource<T> {
            val code = response.errorCode
            val message = response.errorMsg
            return if (code == SUCCESS) {
                Observable.just(response.data)
            } else {
                Observable.error(ApiException(code, message))
            }
        }
    }
    // -------------------------------------------
    /**
     * Server api response for login.
     *
     * @param <T>
    </T> */
    private class ResponseLoginFunction<T> : Function<Response<T>, ObservableSource<T>> {
        override fun apply(response: Response<T>): ObservableSource<T> {
            val code = response.errorCode
            val message = response.errorMsg
            return if (code == SUCCESS || code == AppConstants.NOT_CERTIFIED) {
                Observable.just(response.data)
            } else {
                Observable.error(ApiException(code, message))
            }
        }
    } // -------------------------------------------
}