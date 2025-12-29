package com.mar2game.myapplication

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.applovin.mediation.ads.MaxAdView
import com.datatool.biddingsdk.AdLoader
import com.datatool.biddingsdk.BiddingApplication
import com.datatool.biddingsdk.R
import com.datatool.biddingsdk.api.Ad
import com.datatool.biddingsdk.config.AdCallback
import com.datatool.biddingsdk.config.AdConfig
import com.datatool.biddingsdk.config.AdFinishLoadParam
import com.datatool.biddingsdk.config.AdLoadFailParam
import com.datatool.biddingsdk.config.AdLoadSuccessParam
import com.datatool.biddingsdk.config.AdParam
import com.datatool.biddingsdk.config.AdShowClickParam
import com.datatool.biddingsdk.config.AdShowCloseParam
import com.datatool.biddingsdk.config.AdShowFailParam
import com.datatool.biddingsdk.config.AdShowSuccessParam
import com.datatool.biddingsdk.config.AdStartLoadParam
import com.google.android.gms.ads.AdView
import com.mar2game.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

	companion object{
		private const val TAG = "MainActivity"
	}

	val callback = object : AdCallback {
		private val TAG = "MainActivity"
		override fun onStartLoad(param: AdStartLoadParam) {
			Log.e(TAG, "onStartLoad: ", )
		}

		override fun onFinishLoad(param: AdFinishLoadParam) {
			Log.e(TAG, "onFinishLoad: ", )
		}

		override fun onLoadSuccess(param: AdLoadSuccessParam) {
			Log.e(TAG, "onLoadSuccess: ", )
		}

		override fun onLoadFailed(param: AdLoadFailParam) {
			Log.e(TAG, "onLoadFailed: ", )
		}

		override fun occurShow(areaKey: String) {
			Log.e(TAG, "occurShow: ", )
		}

		override fun showSuccess(param: AdShowSuccessParam) {
			Log.e(TAG, "showSuccess: ", )
		}

		override fun showFailed(param: AdShowFailParam) {
			Log.e(TAG, "showFailed: ", )
		}

		override fun onClose(param: AdShowCloseParam) {
			Log.e(TAG, "onClose: ", )
		}

		override fun onClicked(param: AdShowClickParam) {
			Log.e(TAG, "onClicked: ", )
		}

	}

	private lateinit var binding: ActivityMainBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
		initPlay()
	}

	fun initPlay() {
		setConfig()
		setLoad()
		setBid(callback)
		setAdmob(callback)
		setMax(callback)
		setTopOn(callback)
	}

	fun setConfig() {
		val inputStream = resources.openRawResource(R.raw.adload_config)
		val adload_config = inputStream.bufferedReader().use { it.readText() }
		binding.configJson.setText(adload_config)
		binding.setConfig.setOnClickListener {
			AdConfig.updateConfigFromJson(binding.configJson.text.toString())
			Toast.makeText(this, "设置配置文件成功", Toast.LENGTH_LONG).show()
		}
	}

	fun setLoad() {
		binding.preloadOpen.setOnClickListener {
			AdLoader.loadOpen(this, AdParam.ad_platform_bidding, callback)
		}
		binding.preloadInter.setOnClickListener {
			AdLoader.loadInter(this,AdParam.ad_platform_bidding, callback)
		}
	}

	fun setBid(callback: AdCallback?) {
		binding.bidOpen.setOnClickListener {
			Toast.makeText(this, "open bid", Toast.LENGTH_SHORT).show()
			Ad.showOpenAd(this@MainActivity, AdParam.ad_platform_bidding, "bidOpen", callback)
		}
		binding.bidInter.setOnClickListener {
			Toast.makeText(this, "inter bid", Toast.LENGTH_SHORT).show()
			Ad.showInterstitialAd(this@MainActivity, AdParam.ad_platform_bidding, "bidInter", callback)
		}
	}

	fun setAdmob(callback: AdCallback?) {
		binding.admobOpen.setOnClickListener {
			Toast.makeText(this, "open admob", Toast.LENGTH_SHORT).show()
			Ad.showOpenAd(this@MainActivity, AdParam.ad_platform_admob, "admobOpen", callback)
		}
		binding.admobInter.setOnClickListener {
			Toast.makeText(this, "inter admob", Toast.LENGTH_SHORT).show()
			Ad.showInterstitialAd(this@MainActivity, AdParam.ad_platform_admob,"admobInter", callback)
		}
		binding.admobVideo.setOnClickListener {
			Toast.makeText(this, "video admob", Toast.LENGTH_SHORT).show()
			Ad.showVideoAd(this@MainActivity, AdParam.ad_platform_admob, "admobVideo", callback) { amount, type ->
				Log.e(TAG, "admobVideo reward: $amount $type")
			}
		}
		binding.admobBanner.setOnClickListener {
			showBanner()
		}
		binding.admobBannerHide.setOnClickListener {
			hideBanner()
		}
	}

	fun setMax(callback: AdCallback?) {
		binding.maxOpen.setOnClickListener {
			Toast.makeText(this, "open max", Toast.LENGTH_SHORT).show()
			Ad.showOpenAd(this@MainActivity, AdParam.ad_platform_max, "maxOpen", callback)
		}
		binding.maxInter.setOnClickListener {
			Toast.makeText(this, "inter max", Toast.LENGTH_SHORT).show()
			Ad.showInterstitialAd(this@MainActivity, AdParam.ad_platform_max, "maxInter", callback)
		}
		binding.maxVideo.setOnClickListener {
			Toast.makeText(this, "video max", Toast.LENGTH_SHORT).show()
			Ad.showVideoAd(this@MainActivity, AdParam.ad_platform_max, "maxVideo", callback) { amount, type ->
				Log.e(TAG, "maxVideo reward: $amount $type")
			}
		}
	}

	fun setTopOn(callback: AdCallback?) {
		binding.toponOpen.setOnClickListener {
			Toast.makeText(this, "open topon", Toast.LENGTH_SHORT).show()
			Ad.showOpenAd(this@MainActivity, AdParam.ad_platform_topon, "toponOpen", callback)
		}
		binding.toponInter.setOnClickListener {
			Toast.makeText(this, "inter topon", Toast.LENGTH_SHORT).show()
			Ad.showInterstitialAd(this@MainActivity, AdParam.ad_platform_topon, "toponInter", callback)
		}
		binding.toponVideo.setOnClickListener {
			Toast.makeText(this, "video topon", Toast.LENGTH_SHORT).show()
			Ad.showVideoAd(this@MainActivity, AdParam.ad_platform_topon, "toponVideo", callback) { amount, type ->
				Log.e(TAG, "toponVideo reward: $amount $type")
			}
		}
	}

	private val BANNER_VIEW_TAG_KEY = -1002
	var bannerContainer: FrameLayout?
		get() = this.window.decorView.getTag(BANNER_VIEW_TAG_KEY) as? FrameLayout
		set(value) = this.window.decorView.setTag(BANNER_VIEW_TAG_KEY, value)

	fun addBannerContainer() {
		if (bannerContainer == null) {
			bannerContainer = FrameLayout(this)
			bannerContainer?.let {
				val params = FrameLayout.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.WRAP_CONTENT,
					Gravity.BOTTOM
				)
				addContentView(it, params)
			}
		}
		bannerContainer?.visibility = View.VISIBLE
	}

	var banner: ViewGroup? = null
	fun showBanner() {
		if (bannerContainer == null) {
			addBannerContainer()
		}
		if (banner == null) {
//			banner = Ad.getBannerAd(this@MainActivity, AdParam.ad_platform_max, "maxBanner", callback)
			banner = Ad.getBannerAd(this@MainActivity, AdParam.ad_platform_admob, "admobBanner", callback)
			bannerContainer?.addView(banner)
		} else {
			banner?.let {
				it.visibility = View.VISIBLE
				if (banner is AdView) {
					val adView = banner as? AdView
					adView?.resume()
				}
				if (banner is MaxAdView) {
					val maxView = banner as? MaxAdView
					maxView?.startAutoRefresh()
				}
			}
		}
	}

	fun hideBanner() {
		banner?.let {
			if (banner is AdView) {
				val adView = banner as? AdView
				adView?.pause()
			}
			if (banner is MaxAdView) {
				val maxView = banner as? MaxAdView
				maxView?.stopAutoRefresh()
			}
			it.visibility = View.GONE
		}
	}

}