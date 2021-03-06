package com.cooleyepetizer.app.fragment.recommend

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cooleyepetizer.app.R
import com.cooleyepetizer.app.adapter.recommend.FollowAdapter
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmRefreshFragment
import com.cooleyepetizer.app.databinding.FragmentFollowBinding
import com.cooleyepetizer.app.viewmodel.recommend.FollowViewModel
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import kotlinx.android.synthetic.main.fragment_follow.*

class FollowFragment : BaseMvvmRefreshFragment<FragmentFollowBinding, FollowViewModel>() {

    private val followAdapter by lazy { activity?.let { FollowAdapter(it) } }

    override fun onBindLayout(): Int {
        return R.layout.fragment_follow
    }

    override fun onBindViewModel(): Class<FollowViewModel> {
        return FollowViewModel::class.java
    }

    override fun initView() {
        isHideToolBar(true)
        follow_list.layoutManager = LinearLayoutManager(activity)
        follow_list.adapter = followAdapter
    }

    override fun initData() {
        mViewModel?.getFollowFirstData()
        mViewModel?.followList?.observe(this, Observer {
            followAdapter?.setList(it)
        })
    }

    override fun getRefreshLayout(): SmartRefreshLayout {
        return refresh_layout
    }

    override fun loadDataByRefresh() {

    }

    override fun loadDataByLoadMore() {

    }


}