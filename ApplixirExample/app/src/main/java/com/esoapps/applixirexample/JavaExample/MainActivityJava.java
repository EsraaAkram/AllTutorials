package com.esoapps.applixirexample.JavaExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.esoapps.applixirexample.GameActivity;
import com.esoapps.applixirexample.R;

public class MainActivityJava extends AppCompatActivity {

    private Button rewardBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main);

        rewardBtn=findViewById(R.id.rewardBtnJava);

    }

    public void rewardVideoJava(View view) {

        String url="https://js.appcdn.net/Android-test-1.html";//TODO:ADD YOUR URL
        //BLOGGER EXAMPLE:
//        String url="https://create-a-simple-web-page-with-html.blogspot.com/";

        WebViewApplixirJava webViewApplixirJava =new WebViewApplixirJava(
                this,
                url);

        setContentView(webViewApplixirJava);

        webViewApplixirJava.showAds(new WebViewApplixirJava.OnCompleteAdListener() {


            @Override
            public void statusCallBack(String status) {



                if(status.contains("closing")){//AD CLOSED


//TODO: HANDLE ON USER CLOSE THE AD YOU CAN MOVE A USER TO ANOTHER //SCREEN OR GIVE HIM GAME POINTS OR LIFE TO CONTINUE PLAYING


//EXAMPLE WHERE I STARTED ANOTHER ACTIVITY AFTER AD CLOSED
                    startActivity(new Intent(MainActivityJava.this, GameActivity.class));

                    //HERE I ADDED finish infinity
// because I moved user from screen to another
                    finishAffinity();

//if you still in the same activity just use this instead of start another activity and finish:
//setContentView(R.layout.activity_main);

                }
            }
        });














    }


}