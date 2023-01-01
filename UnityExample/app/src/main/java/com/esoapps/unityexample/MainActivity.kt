package com.esoapps.unityexample

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.esoapps.unityexample.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.unity3d.ads.IUnityAdsInitializationListener
import com.unity3d.ads.IUnityAdsLoadListener
import com.unity3d.ads.UnityAds
import com.unity3d.ads.UnityAdsShowOptions
import com.unity3d.ads.IUnityAdsShowListener
import com.unity3d.ads.UnityAds.*


class MainActivity : AppCompatActivity() , IUnityAdsInitializationListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)







        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()


            // Initialize the SDK:
            UnityAds.initialize(
                //applicationContext,
                this@MainActivity,
                unityGameID,
                testMode,
                this)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }




    //UNITY:

    private val unityGameID = "1234567"//TODO:ADD YOURS

    private val testMode = true

//    private val adUnitId = "video"
    private val adUnitId = "test"//TODO:ADD YOURS

    private val loadListener: IUnityAdsLoadListener = object : IUnityAdsLoadListener {
        override fun onUnityAdsAdLoaded(placementId: String) {

            Log.d("UnityAdsExample", "onUnityAdsAdLoaded: $placementId")

            UnityAds.show(
                //applicationContext as Activity,
                this@MainActivity,
                adUnitId,
                UnityAdsShowOptions(),
                showListener
            )


        }

        override fun onUnityAdsFailedToLoad(
            placementId: String,
            error: UnityAdsLoadError,
            message: String
        ) {
            Log.d(
                "UnityAdsExample",
                "Unity Ads failed to load ad for $placementId with error: [$error] $message"
            )
        }
    }





    private val showListener: IUnityAdsShowListener = object : IUnityAdsShowListener{
        override fun onUnityAdsShowFailure(placementId: kotlin.String, error: UnityAdsShowError, message: kotlin.String){
            Log.d("UnityAdsExample",
                "Unity Ads failed to show ad for $placementId with error: [$error] $message"
            )
        }
        override fun onUnityAdsShowStart(placementId: kotlin.String){
            Log.d("UnityAdsExample", "onUnityAdsShowStart: $placementId")
        }
        override fun onUnityAdsShowClick(placementId: kotlin.String){
            Log.d("UnityAdsExample", "onUnityAdsShowClick: " + placementId)
        }
        override fun onUnityAdsShowComplete(placementId: kotlin.String, state: UnityAdsShowCompletionState){
            Log.d("UnityAdsExample", "onUnityAdsShowComplete: " + placementId)
            //TODO:HERE:GO NEXT
        }
    }
    
    

    override fun onInitializationComplete() {

        displayInterstitialAd()
    }


    override fun onInitializationFailed(error: UnityAds.UnityAdsInitializationError?,
                                        message: String?) {
        Log.d("UnityAdsExample",
            "Error: $error $message ${error!!.ordinal} ${error!!.name} ${error!!.declaringClass}"
        )

        //TODO:HERE:GO NEXT
    }


    private fun displayInterstitialAd() {
        UnityAds.load(adUnitId, loadListener)
    }

}