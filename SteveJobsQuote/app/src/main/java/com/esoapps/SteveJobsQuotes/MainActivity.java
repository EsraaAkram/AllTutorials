package com.esoapps.SteveJobsQuotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private CircleImageView circleImg;
    private TextView quoteTv;
    private CircleImageView nextCircleImg;
    private AdView mAdView;

    //TODO:THAT IS YOUR TURN TO ADD MORE QUOTES HERE
    //0-first
    //1-second
    //2-third
    private String[] quotes={"Hope is being able to see that there is light despite all of the darkness",
            "There was never a night or a problem that could defeat sunrise or hope",
            "Let your hopes, not your hurts, shape your future",
            "I think it’s a mistake to ever look for hope outside of one’s self",
            "Hope is the only bee that makes honey without flowers",
            "Hope fills the holes of my frustration in my heart",
            "A whole stack of memories never equal one little hope",
            "He who has health, has hope; and he who has hope has everything",
            "To live without hope is to cease to live",
            "The miserable have no other medicine but only hope"};//index 9 //array length 10



    private int index=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //HIDING OUR ACTION BAR
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });



        //link our ui
        circleImg=findViewById(R.id.circleImg);
        quoteTv=findViewById(R.id.quoteTv);
        nextCircleImg=findViewById(R.id.nextCircleImg);

        mAdView=findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        //here we listen to user clicks
        nextCircleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //quoteTv.setText("Hope is being able to see that there is light despite all of the darkness");

                AlphaAnimation animation=new AlphaAnimation(0.0f,1.0f);
                animation.setDuration(1000);//HALF OF SEC
                //80/100 sec

                animation.setRepeatCount(0);
                animation.setRepeatMode(0);

                quoteTv.startAnimation(animation);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    //WHENEVER OUR ANIMATION STARTED LISTEN TO IT AND DO SOMETHING
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //ON ANIMATION START


                        quoteTv.setText(quotes[index]);

                        if(index<quotes.length-1){

                            index++;//+1

                        }else {

                            index=0;
                        }


                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //ON ANIMATION END

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });






            }
        });







    }
}