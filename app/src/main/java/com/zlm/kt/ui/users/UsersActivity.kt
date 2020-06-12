package com.zlm.kt.ui.users

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zlm.kt.R
import com.zlm.kt.data.model.api.UsersResponse
import com.zlm.kt.databinding.ActivityUsersBinding
import com.zlm.kt.other.AppConstants
import com.zlm.kt.other.ViewModelProviderFactory
import com.zlm.kt.ui.adapter.UsersAdapter
import com.zlm.kt.ui.adapter.UsersAdapter.OnUserDataCallback
import dagger.android.AndroidInjection
import me.yokeyword.fragmentation.SupportActivity
import javax.inject.Inject

/**
 * @author Milla
 * @create 2020/6/9
 */
class UsersActivity: SupportActivity(), UsersNavigator {
    // -------------------------------------------
    @Inject
    internal lateinit var factory:ViewModelProviderFactory
    internal lateinit var adapter:UsersAdapter

    private lateinit var binding:ActivityUsersBinding
    private var userList:MutableList<UsersResponse> = ArrayList()
    private lateinit var viewModel: UsersViewModel

    // -------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_users)
        viewModel = ViewModelProviders.of(this, factory).get(UsersViewModel::class.java)
        viewModel.setNavigator(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        binding.setViewModel(viewModel)
        binding.setLifecycleOwner(this)
        init()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getUsers()
    }
    // -------------------------------------------
    private fun init() {
        val manager = LinearLayoutManager(this)
        var cb = object : OnUserDataCallback {
            override fun onItemClick(user: UsersResponse) {
                val intent = Intent()
                intent.setClass(this@UsersActivity, UserDetailActivity::class.java)
                intent.putExtra(AppConstants.USER_DATA, user)
                startActivity(intent)
            }
        }
        adapter = UsersAdapter(this@UsersActivity, cb)
        binding.listView.setLayoutManager(manager)
        binding.listView.setAdapter(adapter)
    }

    override fun refreshAdapter(users:List<UsersResponse>) {
        userList.clear();
        userList.addAll(users)
        adapter.setUserList(users)
    }


    // -------------------------------------------
    override fun back() {
        finish()
    }
    // -------------------------------------------
}