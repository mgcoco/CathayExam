package com.marcus.cathay.di

import androidx.fragment.app.Fragment
import com.marcus.cathay.ui.plantDetail.PlantDetailContract
import com.marcus.cathay.ui.plantDetail.PlantDetailFragment
import com.marcus.cathay.ui.plantDetail.PlantDetailPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(value = [FragmentComponent::class])
abstract class PlantDetailModule {

    @Binds
    abstract fun bindFragment(fragment: PlantDetailFragment): PlantDetailContract.IPlantDetailView

    @Binds
    abstract fun bindPresenter(presenter: PlantDetailPresenter): PlantDetailContract.IPlantDetailPresenter

}


@InstallIn(value = [FragmentComponent::class])
@Module
object PlantDetailFragmentModule {

    @Provides
    fun bindFragment(fragment: Fragment): PlantDetailFragment {
        return fragment as PlantDetailFragment
    }
}