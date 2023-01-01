package com.esoapps.applixirexample.KotlinExample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.esoapps.applixirexample.GameActivity
import com.esoapps.applixirexample.JavaExample.WebViewApplixirJava
import com.esoapps.applixirexample.R
import java.util.*

class MainActivityKotlin : AppCompatActivity() {

    private var rewardBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_kotlin_act)

        rewardBtn = findViewById(R.id.rewardBtnKotlin)
    }

    fun rewardVideoKotlin(view: View?) {
        val url = "https://js.appcdn.net/Android-test-1.html" //TODO:ADD YOUR URL
        //BLOGGER EXAMPLE:
//        String url="https://create-a-simple-web-page-with-html.blogspot.com/";
        val webViewApplixirKotlin = WebViewApplixirKotlin(
            this,
            url
        )
        setContentView(webViewApplixirKotlin)

        webViewApplixirKotlin.showAds (object :WebViewApplixirKotlin.OnCompleteAdListener{
            override fun statusCallBack(status: String?) {

                Log.d("status",status!! )

                if (status == "sys-closing") { //AD CLOSED


//TODO: HANDLE ON USER CLOSE THE AD YOU CAN MOVE A USER TO ANOTHER //SCREEN OR GIVE HIM GAME POINTS OR LIFE TO CONTINUE PLAYING


//EXAMPLE WHERE I STARTED ANOTHER ACTIVITY AFTER AD CLOSED
                    startActivity(Intent(this@MainActivityKotlin, GameActivity::class.java))

                    //HERE I ADDED finish infinity
// because I moved user from screen to another
                    finishAffinity()

//if you still in the same activity just use this instead of start another activity and finish:
//setContentView(R.layout.activity_main);
                }

            }

        })












    }
}