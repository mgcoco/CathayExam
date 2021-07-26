package com.marcus.cathay.ui.plantDetail

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.marcus.basic.data.local.ImageData
import com.marcus.basic.ui.base.BaseFragment
import com.marcus.basic.util.IntentUtil
import com.marcus.cathay.R
import com.marcus.cathay.databinding.FragmentPlantDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlantDetailFragment: BaseFragment<FragmentPlantDetailBinding>(), PlantDetailContract.IPlantDetailView {

    @Inject
    lateinit var presenter: PlantDetailPresenter

    private val args: PlantDetailFragmentArgs by navArgs()

    override fun initialUi() {
        presenter.plantDetail = args.detail
        binding.data = presenter.plantDetail
        binding.presenter = presenter
        (requireActivity() as AppCompatActivity).supportActionBar?.title = presenter.plantDetail?.nameCh
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_plant_detail
    }

    override fun loadData() {
    }

    override fun viewFullImage(imageData: ImageData) {
        IntentUtil.openImageViewerActivity(attachContext, imageData)
    }
}