package com.zlm.kt.ui.users;

import androidx.lifecycle.MutableLiveData;

import com.zlm.kt.data.DataManager;
import com.zlm.kt.data.model.api.UserDetailResponse;
import com.zlm.kt.data.model.api.UsersResponse;
import com.zlm.kt.other.base.BaseViewModel;

/**
 * @author Milla
 * @create 2020/6/9
 */
class UserDetailViewModel (dataManager:DataManager):BaseViewModel<UserDetailNavigator>(dataManager) {

    private lateinit var user:UsersResponse
    val imgAvatorURL:MutableLiveData<String> = MutableLiveData()
    val name:MutableLiveData<String> = MutableLiveData()
    val login:MutableLiveData<String> = MutableLiveData()
    val bio:MutableLiveData<String> = MutableLiveData()
    val location:MutableLiveData<String> = MutableLiveData()
    val link:MutableLiveData<String> = MutableLiveData()

    // -------------------------------------------
    fun back() {
        getNavigator().back()
    }
    // -------------------------------------------
    fun getUsers(user:UsersResponse) {
        this.user = user
        this.login.postValue(user.login)
        setIsLoading(true)
        getCompositeDisposable().add(getDataManager()
                .getApi().loadUserInfo(user.login)
                .compose(getSchedulerProvider())
                .subscribe({ response->
                    if (response != null && response is UserDetailResponse)
                    {
                        setUserData(response)
                    }
                    setIsLoading(false) }, { throwable->
                    setIsLoading(false)
                    throwable.printStackTrace() }))
    }
    private fun setUserData(data:UserDetailResponse) {
        this.bio.postValue(data.bio)
        this.imgAvatorURL.postValue(data.avatar_url)
        this.name.postValue(data.name)
        this.location.postValue(data.location)
        this.link.postValue(data.html_url)
    }
}
