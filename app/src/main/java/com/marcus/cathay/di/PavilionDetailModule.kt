package com.marcus.cathay.di

import androidx.fragment.app.Fragment
import com.marcus.cathay.ui.paviliondetail.PavilionDetailContract
import com.marcus.cathay.ui.paviliondetail.PavilionDetailFragment
import com.marcus.cathay.ui.paviliondetail.PavilionDetailPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent


@Module
@InstallIn(value = [FragmentComponent::class])
abstract class PavilionModule {

    @Binds
    abstract fun bindFragment(fragment: PavilionDetailFragment): PavilionDetailContract.IPavilionDetailView

    @Binds
    abstract fun bindPresenter(presenter: PavilionDetailPresenter): PavilionDetailContract.IPavilionDetailPresenter

}


@InstallIn(value = [FragmentComponent::class])
@Module
object PavilionFragmentModule {

    @Provides
    fun bindFragment(fragment: Fragment): PavilionDetailFragment {
        return fragment as PavilionDetailFragment
    }
}