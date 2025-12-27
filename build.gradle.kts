buildscript {
	repositories {
		google()
		mavenCentral()
		maven(url = "https://artifacts.applovin.com/android")
		maven(url = "https://maven.singular.net/")
		maven(url = "https://cboost.jfrog.io/artifactory/chartboost-ads/")
		maven(url = "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
		maven(url = "https://artifact.bytedance.com/repository/pangle")

		maven(url = "https://jitpack.io")
		maven(url = "https://android-sdk.is.com/")
		maven(url = "https://jfrog.anythinktech.com/artifactory/overseas_sdk")

		maven ( url = "https://artifactory.bidmachine.io/bidmachine")
		maven ( url = "https://imobile-maio.github.io/maven")
		maven ( url = "https://maven.ogury.co")
		maven ( url = "https://repo.pubmatic.com/artifactory/public-repos")
		maven ( url = "https://s3.amazonaws.com/smaato-sdk-releases/")
		maven ( url = "https://verve.jfrog.io/artifactory/verve-gradle-release")
		maven ( url = "https://ysonetwork.s3.eu-west-3.amazonaws.com/sdk/android")
	}
	dependencies {
		classpath("com.applovin.quality:AppLovinQualityServiceGradlePlugin:5.10.5")
	}
}
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.kotlin.android) apply false
}