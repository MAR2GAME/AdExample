# 使用手册

### 安装
导入AAR文件(biddingsdk-release.aar)  
把 biddingsdk-release.aar 放入libs目录中
在add/build.gradle.kts中添加依赖
```
implementation(files("libs/biddingsdk-release.aar"))
```

### 添加依赖
settings.gradle.kts中添加对应的maven仓库
项目的build.gradle.kts中添加依赖
app/build.gradle.kts中添加依赖
```
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
```

### SDk配置
在广告平台配置好 admob/max/topon  
在清单文件中配置admob的appid  
```
<meta-data
    android:name="com.google.android.gms.ads.APPLICATION_ID"
    android:value="ca-app-pub-3615322193850391~3893272881"/>
```

### 修改广告配置文件
修改src/main/res/raw/adload_config.json 配置

### 初始化SDK
在MyApp的onCreate中初始化SDK

## SDK使用示例
参考MainActivity中示例

### 参数说明
adload_cache_time 广告缓存时间   
adload_retry_num 广告加载失败时重试次数   
adload_max_time 广告加载超时时间  
adload_poolsize_open 开屏广告池大小  
adload_poolsize_inter 插屏广告池大小  
adload_poolsize_video 激励视频广告池大小  
adload_trigger_timing_open 触发开屏广告预加载时机(具体逻辑要自己手动添加)  
adload_trigger_timing_inter 触发插屏广告预加载的时机(具体逻辑要自己手动添加)   
adload_trigger_timing_video 触发激励视频广告预加载的时机(具体逻辑要自己手动添加)  
config_list 对广告的频率限制：
```
{
      "type":"open",	//开屏广告
      "config": {
        "per_day": 100,	//每天100个
        "per_hour": 50,	//每小时50个
        "per_min": 10		//每分钟10个
      },
      "configs": [
        {
          "platform":"adMob",	//针对admob平台
          "per_day": 100,
          "per_hour": 50,
          "per_min": 10
        },
        {
          "platform":"max",
          "per_day": 100,
          "per_hour": 100,
          "per_min": 10
        },
        {
          "platform":"topOn",
          "per_day": 100,
          "per_hour": 50,
          "per_min": 10
        }
      ],
      "areas": [
        {
          "area_key":"foreGroundAdv",	//针对具体的广告点
          "configs": [
            {
              "platform":"adMob",
              "per_day": 100,
              "per_hour": 50,
              "per_min": 10
            },
            {
              "platform":"max",
              "per_day": 100,
              "per_hour": 50,
              "per_min": 10
            },
            {
              "platform":"topOn",
              "per_day": 100,
              "per_hour": 50,
              "per_min": 10
            }
          ]
        }
      ]
    }
```