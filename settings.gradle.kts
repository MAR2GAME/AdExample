pluginManagement {
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
		maven(url = "https://jitpack.io")
		maven(url = "https://maven.singular.net/")
		maven(url = "https://cboost.jfrog.io/artifactory/chartboost-ads/")
		maven(url = "https://artifact.bytedance.com/repository/pangle")
		maven(url = "https://android-sdk.is.com/")
		maven(url = "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
		maven(url = "https://artifact.bytedance.com/repository/pangle/")
		maven(url = "https://artifacts.applovin.com/android")
		maven(url = "https://jfrog.anythinktech.com/artifactory/overseas_sdk")

		maven ( url = "https://artifactory.bidmachine.io/bidmachine")
		maven ( url = "https://imobile-maio.github.io/maven")
		maven ( url = "https://maven.ogury.co")
		maven ( url = "https://repo.pubmatic.com/artifactory/public-repos")
		maven ( url = "https://s3.amazonaws.com/smaato-sdk-releases/")
		maven ( url = "https://verve.jfrog.io/artifactory/verve-gradle-release")
		maven ( url = "https://ysonetwork.s3.eu-west-3.amazonaws.com/sdk/android")
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
		maven(url = "https://jitpack.io")
		maven(url = "https://repository.liferay.com/nexus/content/repositories/public/")
		maven(url = "https://maven.singular.net/")
		maven(url = "https://cboost.jfrog.io/artifactory/chartboost-ads/")
		maven(url = "https://artifact.bytedance.com/repository/pangle")
		maven(url = "https://android-sdk.is.com/")
		maven(url = "https://dl-maven-android.mintegral.com/repository/mbridge_android_sdk_oversea")
		maven(url = "https://artifact.bytedance.com/repository/pangle/")
		maven(url = "https://artifacts.applovin.com/android")
		maven(url = "https://jfrog.anythinktech.com/artifactory/overseas_sdk")

		maven ( url = "https://artifactory.bidmachine.io/bidmachine")
		maven ( url = "https://imobile-maio.github.io/maven")
		maven ( url = "https://maven.ogury.co")
		maven ( url = "https://repo.pubmatic.com/artifactory/public-repos")
		maven ( url = "https://s3.amazonaws.com/smaato-sdk-releases/")
		maven ( url = "https://verve.jfrog.io/artifactory/verve-gradle-release")
		maven ( url = "https://ysonetwork.s3.eu-west-3.amazonaws.com/sdk/android")
		flatDir {
			dirs("libs")
		}
	}
}

rootProject.name = "AdExample"
include(":app")
 