plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
}

android {
	namespace = "com.mar2game.myapplication"
	compileSdk {
		version = release(36)
	}

	defaultConfig {
		applicationId = "com.mar2game.myapplication"
		minSdk = 29
		targetSdk = 36
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	buildFeatures {
		viewBinding = true
		buildConfig = true
	}
}

dependencies {
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	implementation(files("libs/biddingsdk-release.aar"))

	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	api("com.google.code.gson:gson:2.13.2")

	api("com.applovin:applovin-sdk:13.5.1")
	api("com.applovin.mediation:bigoads-adapter:+")
	api("com.applovin.mediation:chartboost-adapter:+")
	api("com.google.android.gms:play-services-base:18.9.0")
	api("com.applovin.mediation:fyber-adapter:+")
	api("com.applovin.mediation:google-ad-manager-adapter:+")
	api("com.applovin.mediation:google-adapter:+")
	api("com.applovin.mediation:inmobi-adapter:+")
	api("com.applovin.mediation:ironsource-adapter:+")
	api("com.applovin.mediation:vungle-adapter:+")
	api("com.applovin.mediation:facebook-adapter:+")
	api("com.applovin.mediation:mintegral-adapter:+")
	api("com.applovin.mediation:bytedance-adapter:+")
	api("com.applovin.mediation:unityads-adapter:+")

	api("com.google.android.ump:user-messaging-platform:4.0.0")
	api("com.google.android.gms:play-services-ads:24.8.0")

	api("com.google.ads.mediation:applovin:13.5.1.0")
	api("com.google.ads.mediation:chartboost:9.10.2.0")
	api("com.google.ads.mediation:fyber:8.4.1.0")
	api("com.google.ads.mediation:inmobi:11.1.0.0")
	api("com.google.ads.mediation:ironsource:9.2.0.0")
	api("com.google.ads.mediation:vungle:7.6.1.0")
	api("com.google.ads.mediation:facebook:6.21.0.0")
	api("com.google.ads.mediation:mintegral:17.0.31.0")
	api("com.google.ads.mediation:pangle:7.5.0.2.0")
	api("com.unity3d.ads:unity-ads:4.16.2")
	api("com.google.ads.mediation:unity:4.16.4.0")

	//TU (Necessary)
	api("com.thinkup.sdk:core-tpn:6.5.36.1")
	api("com.thinkup.sdk:nativead-tpn:6.5.36.1")
	api("com.thinkup.sdk:banner-tpn:6.5.36.1")
	api("com.thinkup.sdk:interstitial-tpn:6.5.36.1")
	api("com.thinkup.sdk:rewardedvideo-tpn:6.5.36.1")
	api("com.thinkup.sdk:splash-tpn:6.5.36.1")
	//Androidx (Necessary)
	api("androidx.appcompat:appcompat:1.6.1")
	api("androidx.browser:browser:1.4.0")
	//Admob
	api("com.thinkup.sdk:adapter-tpn-admob:6.5.36")
	//TU Adx SDK(Necessary)
	api("com.thinkup.sdk:adapter-tpn-sdm:6.5.36.4")
	api("com.smartdigimkttech.sdk:smartdigimkttech-sdk:6.5.40")
	//AppLovin
	api("com.thinkup.sdk:adapter-tpn-applovin:6.5.36")
	api("com.applovin:applovin-sdk:13.4.0")
	//Tramini
	api("com.thinkup.sdk:tramini-plugin-tpn:6.5.36")
}