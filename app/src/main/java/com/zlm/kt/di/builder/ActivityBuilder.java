package com.zlm.kt.di.builder;

import com.zlm.kt.di.module.UserDetailModule;
import com.zlm.kt.di.module.UsersModule;
import com.zlm.kt.ui.users.UserDetailActivity;
import com.zlm.kt.ui.users.UsersActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * @author Milla
 * @create 2020/4/1
 */

@Module
public abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = {UsersModule.class})
    abstract UsersActivity bindUsersActivity();


    @ContributesAndroidInjector(modules = {UserDetailModule.class})
    abstract UserDetailActivity bindUserDetailActivity();
}
