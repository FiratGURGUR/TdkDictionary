package com.firatg.tdkdictionary.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.databinding.WebBinding;
import com.firatg.tdkdictionary.model.homepage.Url;

public class WebActivity extends AppCompatActivity {

    WebBinding webBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        webBinding = DataBindingUtil.setContentView(this,R.layout.activity_web);
        webBinding.setLifecycleOwner(this);
        Toolbar toolbar = webBinding.toolbarr;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String newString;
        Url url;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            url = (Url) extras.getSerializable("kural");
            webBinding.setTitle(url.getTitle());
            if(extras == null) {
                newString= null;
            } else {
                newString= url.getUrl();
                webBinding.webView.loadUrl(newString);
                hideElements();
                Log.i("ff",newString);
            }
        } else {
            url= (Url) savedInstanceState.getSerializable("kural");
            webBinding.setTitle(url.getTitle());
            webBinding.webView.loadUrl(url.getUrl());
            hideElements();
        }

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    public void hideElements() {
        webBinding.webView.getSettings().setJavaScriptEnabled(true);
        webBinding.webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url)
            {
                webBinding.webView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('header-outer-wrapper b30')[0].style.display='none'; " +
                        "document.getElementsByClassName('page-single-element')[0].style.display='none'; " +
                        "document.getElementsByClassName('right-sidebar-wrapper four columns b0')[0].style.display='none'; " +
                        "document.getElementsByClassName('footer-outer-wrapper')[0].style.display='none'; " +
                        "})()");
            }
        });
    }


}
