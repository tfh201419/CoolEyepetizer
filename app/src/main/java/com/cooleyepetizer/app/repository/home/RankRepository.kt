package com.cooleyepetizer.app.repository.home

import com.cooleyepetizer.app.common_lib.config.BaseApplication
import com.cooleyepetizer.app.common_lib.net.ResultCallBack
import com.cooleyepetizer.app.common_lib.net.ResultTipObserver
import com.cooleyepetizer.app.common_lib.net.RetrofitEyeFactory
import com.cooleyepetizer.app.entity.eye_video.EyeItemResponse
import com.cooleyepetizer.app.entity.eye_video.EyeRankTabInfo
import com.cooleyepetizer.app.service.RankService

class RankRepository {

    fun getRankTabInfo(resultCallBack: ResultCallBack<EyeRankTabInfo>?){
        val api = RetrofitEyeFactory.createService(RankService::class.java)
        RetrofitEyeFactory.executeResult(api.getRankTabInfo(), object: ResultTipObserver<EyeRankTabInfo>(
            BaseApplication.instance) {
            override fun onSuccess(result: EyeRankTabInfo?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }
        })
    }

    fun getRankListData(url: String, resultCallBack: ResultCallBack<EyeItemResponse>?){
        val api = RetrofitEyeFactory.createService(RankService::class.java)
        RetrofitEyeFactory.executeResult(api.getRankListData(url),object: ResultTipObserver<EyeItemResponse>(
        BaseApplication.instance){
            override fun onSuccess(result: EyeItemResponse?) {
                resultCallBack?.onSuccess(result)
            }

            override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                resultCallBack?.onFailure()
            }

        })
    }

}