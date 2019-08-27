package com.cooleyepetizer.app

import androidx.lifecycle.ViewModelProviders
import com.cooleyepetizer.app.common_lib.mvvm.BaseMvvmActivity
import com.cooleyepetizer.app.databinding.ActivityTextMvvmBinding
import com.cooleyepetizer.app.viewmodel.PlaceViewModel

class TextActivity : BaseMvvmActivity<ActivityTextMvvmBinding,PlaceViewModel>() {


    override fun initViewModel(): PlaceViewModel {
        return ViewModelProviders.of(this)[PlaceViewModel::class.java]
    }

    private var viewModel : PlaceViewModel? = null

    override fun onBindLayout(): Int {
        return R.layout.activity_text_mvvm
    }

    override fun initView() {
        viewModel = ViewModelProviders.of(this)[PlaceViewModel::class.java]
        setCenterTitle("测试")
        viewModel?.getPlace(this)
    }

    override fun initData() {

    }

}