package com.zlm.kt.ui.users;


import com.zlm.kt.data.model.api.UsersResponse;


/**
 * @author Milla
 * @create 2020/6/9
 */
interface UsersNavigator {

    fun refreshAdapter(users:List<UsersResponse>)
    fun back()
}
