package com.mar2game.myapplication

import android.app.Application
import android.util.Log
import com.datatool.biddingsdk.AppOpenHelper
import com.datatool.biddingsdk.R
import com.datatool.biddingsdk.api.Ad
import com.datatool.biddingsdk.api.AdmobConfig
import com.datatool.biddingsdk.api.IDConfig
import com.datatool.biddingsdk.api.MaxConfig
import com.datatool.biddingsdk.api.TopOnConfig

class MyApp: Application() {
	override fun onCreate() {
		super.onCreate()
		kotlinx.coroutines.runBlocking {

			val idConfig = IDConfig(
				AdmobConfig(
					"ADMOB_INTERSTITIAL_ID",
					"ADMOB_OPEN_ID",
					"ADMOB_VIDEO_ID"
				),
				MaxConfig(
					"MAX_SDK_KEY",
					"MAX_INTERSTITIAL_ID",
					"MAX_OPEN_ID",
					"MAX_VIDEO_ID"
				),
				TopOnConfig(
					"TopON_APP_ID",
					"TopON_APP_KEY",
					"TopON_INTERSTITIAL_ID",
					"TopON_OPEN_ID",
					"TopON_VIDEO_ID"
				)
			)

			val inputStream =resources.openRawResource(R.raw.adload_config)
			val safeConfig = inputStream.bufferedReader().use { it.readText() }
			Ad.init( BuildConfig.DEBUG, idConfig, safeConfig)

			// TODO: 前后台切换时展示开屏广告示例
//			if (BuildConfig.DEBUG) {
//				val callback = object : AdCallback {
//					private val TAG = "MyApp"
//					override fun onStartLoad(param: AdStartLoadParam) {
//						Log.e(TAG, "onStartLoad: ", )
//					}
//
//					override fun onFinishLoad(param: AdFinishLoadParam) {
//						Log.e(TAG, "onFinishLoad: ", )
//					}
//
//					override fun onLoadSuccess(param: AdLoadSuccessParam) {
//						Log.e(TAG, "onLoadSuccess: ", )
//					}
//
//					override fun onLoadFailed(param: AdLoadFailParam) {
//						Log.e(TAG, "onLoadFailed: ", )
//					}
//
//					override fun occurShow(areaKey: String) {
//						Log.e(TAG, "occurShow: ", )
//					}
//
//					override fun showSuccess(param: AdShowSuccessParam) {
//						Log.e(TAG, "showSuccess: ", )
//					}
//
//					override fun showFailed(param: AdShowFailParam) {
//						Log.e(TAG, "showFailed: ", )
//					}
//
//					override fun onClose(param: AdShowCloseParam) {
//						Log.e(TAG, "onClose: ", )
//					}
//
//					override fun onClicked(param: AdShowClickParam) {
//						Log.e(TAG, "onClicked: ", )
//					}
//				}
//				AppOpenHelper.startObserve(AdParam.ad_platform_bidding, callback)
//			}
		}
	}
}