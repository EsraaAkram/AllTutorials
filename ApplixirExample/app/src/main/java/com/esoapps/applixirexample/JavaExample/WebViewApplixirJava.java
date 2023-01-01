package com.esoapps.applixirexample.JavaExample;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;


public class WebViewApplixirJava extends WebView {


    private String webUrl;

    private Context context;



    public WebViewApplixirJava(@NonNull Context context, String webUrl) {
        super(context);

        this.context=context;
        this.webUrl=webUrl;

        WebSettings webSettings = this.getSettings();



        webSettings.setJavaScriptEnabled(true);




        //TODO:UN COMMENT THose LINES OF CODE IF YOU ARE USING BLOGGER AS A HOST FOR ADS:
        //String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        //webSettings.setUserAgentString(newUA);
        //this.setWebViewClient(new WebViewClient());

    }

    public void showAds(OnCompleteAdListener onCompleteAdListener){

        this.loadUrl(webUrl);

        this.addJavascriptInterface(new  Applixir(context){

            @JavascriptInterface
            @Override
            public void adStatusCallback(String status) {
                super.adStatusCallback(status);


                onCompleteAdListener.statusCallBack(status);


            }
        } ,"Android");



    }



    public interface OnCompleteAdListener {


        void statusCallBack(String status);

    }

    public class Applixir{
        Context mContext;

        public Applixir(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void adStatusCallback(String status) {




        }
    }



}
