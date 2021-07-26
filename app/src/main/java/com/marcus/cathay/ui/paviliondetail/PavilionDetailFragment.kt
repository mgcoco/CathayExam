package com.marcus.cathay.ui.paviliondetail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.ViewTreeObserver
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.marcus.basic.Constants
import com.marcus.basic.data.local.ImageData
import com.marcus.basic.ui.ImageViewerActivity
import com.marcus.basic.ui.base.BaseAdapter
import com.marcus.basic.ui.base.BaseFragment
import com.marcus.basic.util.IntentUtil
import com.marcus.basic.util.ItemDecorationUtil
import com.marcus.cathay.R
import com.marcus.cathay.data.response.PlantDetail
import com.marcus.cathay.databinding.FragmentPavilionDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class PavilionDetailFragment: BaseFragment<FragmentPavilionDetailBinding>(), PavilionDetailContract.IPavilionDetailView {

    @Inject
    lateinit var adapter: PlantAdapter

    @Inject
    lateinit var presenter: PavilionDetailPresenter

    private val args: PavilionDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun initialUi() {
        presenter.pavilionDetail = args.detail
        binding.data = presenter.pavilionDetail
        binding.presenter = presenter
        setupRecyclerView()
        (requireActivity() as AppCompatActivity).supportActionBar?.title = presenter.pavilionDetail!!.name

        binding.root?.viewTreeObserver?.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                binding.root?.viewTreeObserver?.removeOnGlobalLayoutListener(this)
                binding.list.layoutParams.height =
                    binding.root.measuredHeight - binding.plantData.measuredHeight
            }
        })
    }

    private fun setupRecyclerView(){
        binding.list.addItemDecoration(ItemDecorationUtil.getDefaultDecoration(requireContext()))

        binding.list.adapter = adapter

        object: BaseAdapter.OnItemClickListener<PlantDetail> {
            override fun onItemClick(pos: Int, data: PlantDetail) {
                showPlantDetail(data)
            }
        }.also { adapter.onItemClickListener = it }

        binding.list.setPullRefreshEnabled(false)
        binding.list.setLoadingMoreProgressStyle(ProgressStyle.LineScaleParty)
        binding.list.setFootViewText(
            requireActivity().getString(R.string.general_loading), requireActivity().getString(
                R.string.general_no_more_data
            )
        )

        binding.list.setLoadingListener(object : XRecyclerView.LoadingListener {
            override fun onRefresh() {
            }

            override fun onLoadMore() {
                loadData()
            }
        })

        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(
            requireActivity(),
            R.anim.layout_animation_fall_down
        )
        binding.list.layoutAnimation = animation
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_pavilion_detail
    }

    override fun loadData() {
        getPlantList()
    }

    private fun getPlantList(isRefresh: Boolean = false){
        presenter.getPlantList(presenter.pavilionDetail!!.name, isRefresh)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.top_nav_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> {
                adapter.clearItems()
                getPlantList(true)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun addPlantDetail(list: List<PlantDetail>, noMore: Boolean) {
        binding.list.loadMoreComplete()
        binding.list.setNoMore(noMore)
        if(list.isNotEmpty()) {
            adapter.addItems(list)
            binding.list.scheduleLayoutAnimation()
        }
    }

    override fun showPlantDetail(detail: PlantDetail) {
        NavHostFragment.findNavController(this).navigate(
            PavilionDetailFragmentDirections.actionNavigationPavilionDetailToNavigationPlantDetail(
                detail = detail
            )
        )
    }

    override fun viewFullImage(imageData: ImageData) {
        IntentUtil.openImageViewerActivity(attachContext, imageData)
    }

}