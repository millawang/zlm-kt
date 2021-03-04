package com.zlm.kt.ui.users;

import androidx.lifecycle.MutableLiveData;
import com.zlm.kt.data.DataManager

import com.zlm.kt.data.model.api.UsersResponse;
import com.zlm.kt.other.base.BaseViewModel;


/**
 * @author Milla
 * @create 2020/6/09
 */

class UsersViewModel (dataManager: DataManager):BaseViewModel<UsersNavigator>(dataManager) {
    val users:MutableLiveData<List<UsersResponse>> = MutableLiveData()
    // -------------------------------------------
    fun setUserList(userlist: List<UsersResponse>) {
        this.users.postValue(userlist)
        getNavigator()?.refreshAdapter(userlist)
    }
    // -------------------------------------------
    fun back() {
        getNavigator()?.back()
    }
    // -------------------------------------------
    // -------------------------------------------
    fun getUsers() {
        setIsLoading(true)
        dataManager
                .api.loadUser()
                ?.compose(getSchedulerProvider())
                ?.subscribe({ response->
                    if (response != null)
                    {
                        var list = response.toList()
                        this.setUserList(list as List<UsersResponse>)
                    }
                    setIsLoading(false) }, { throwable->
                    setIsLoading(false)
                    throwable.printStackTrace() })?.let { compositeDisposable.add(it) }
    }
}