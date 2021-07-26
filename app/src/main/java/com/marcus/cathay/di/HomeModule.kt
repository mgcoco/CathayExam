package com.marcus.cathay.di

import androidx.fragment.app.Fragment
import com.marcus.cathay.ui.home.HomeContract
import com.marcus.cathay.ui.home.HomeFragment
import com.marcus.cathay.ui.home.HomePresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(value = [ActivityComponent::class, FragmentComponent::class])
abstract class HomeModule {

    @Binds
    abstract fun bindFragment(fragment: HomeFragment): HomeContract.IHomeView

    @Binds
    abstract fun bindPresenter(presenter: HomePresenter): HomeContract.IHomePresenter

}


@InstallIn(value = [ActivityComponent::class, FragmentComponent::class])
@Module
object HomeFragmentModule {

    @Provides
    fun bindFragment(fragment: Fragment): HomeFragment {
        return fragment as HomeFragment
    }
}