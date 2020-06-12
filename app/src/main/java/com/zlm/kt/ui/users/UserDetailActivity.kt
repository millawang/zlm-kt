package com.zlm.kt.ui.users

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.zlm.kt.R
import com.zlm.kt.data.model.api.UsersResponse
import com.zlm.kt.databinding.ActivityUserDetailBinding
import com.zlm.kt.other.AppConstants
import com.zlm.kt.other.ViewModelProviderFactory
import dagger.android.AndroidInjection
import me.yokeyword.fragmentation.SupportActivity
import javax.inject.Inject

/**
 * @author Milla
 * @create 2020/6/9
 */
class UserDetailActivity: SupportActivity(), UserDetailNavigator {
    // -------------------------------------------
    @Inject
    internal lateinit var factory:ViewModelProviderFactory

    private lateinit var  binding:ActivityUserDetailBinding
    private lateinit var  viewModel:UserDetailViewModel
    // -------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        viewModel = ViewModelProviders.of(this, factory).get(UserDetailViewModel::class.java)
        viewModel.setNavigator(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)
        binding.setViewModel(viewModel)
        binding.setLifecycleOwner(this)
        init()
    }
    // -------------------------------------------
    private fun init() {
        if (getIntent().getExtras() != null && getIntent().getParcelableExtra<UsersResponse>(AppConstants.USER_DATA) != null)
        {
            var user  = intent.getParcelableExtra<UsersResponse>(AppConstants.USER_DATA) as UsersResponse
            viewModel.getUsers(user)
        }
    }
    // -------------------------------------------
    override fun back() {
        finish()
    }
    // -------------------------------------------
}