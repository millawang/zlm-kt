package com.zlm.kt.ui.users;

import androidx.lifecycle.MutableLiveData;

import com.zlm.kt.data.model.api.UsersResponse;


/**
 * @author Milla
 * @create 2020/6/9
 */
class UserItemViewModel {

    // -------------------------------------------
    val userName:MutableLiveData<String> =  MutableLiveData()
    val userAvator:MutableLiveData<String>  = MutableLiveData()

    // -------------------------------------------
    constructor(user:UsersResponse ) {
        userName.postValue(user.login);
        userAvator.postValue(user.avatar_url);
    }

    // -------------------------------------------
}
