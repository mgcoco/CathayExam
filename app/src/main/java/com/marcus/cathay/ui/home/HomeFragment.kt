package com.marcus.cathay.ui.home

import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.marcus.basic.ui.base.BaseAdapter
import com.marcus.basic.ui.base.BaseFragment
import com.marcus.basic.util.ItemDecorationUtil
import com.marcus.cathay.R
import com.marcus.cathay.data.response.PavilionDetail
import com.marcus.cathay.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding>(), HomeContract.IHomeView {

    @Inject
    lateinit var adapter: HomeAdapter

    @Inject
    lateinit var presenter: HomePresenter

    override fun initialUi() {
        binding.list.addItemDecoration(ItemDecorationUtil.getDefaultDecoration(requireContext()))

        binding.list.adapter = adapter

        object: BaseAdapter.OnItemClickListener<PavilionDetail> {
            override fun onItemClick(pos: Int, data: PavilionDetail) {
                showPavilionDetail(data)
            }

        }.also { adapter.onItemClickListener = it }

        val animation: LayoutAnimationController = AnimationUtils.loadLayoutAnimation(requireActivity(), R.anim.layout_animation_fall_down)
        binding.list.layoutAnimation = animation

    }

    override fun loadData() {
        presenter?.getPavilionList()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun addPavilionDetail(list: List<PavilionDetail>) {
        adapter.setItems(list)
        binding.list.scheduleLayoutAnimation()
    }

    override fun showPavilionDetail(detail: PavilionDetail) {
        findNavController(this@HomeFragment).navigate(
            HomeFragmentDirections.actionNavigationHomeToNavigationPavilionDetail(
                detail = detail
            )
        )
    }
}