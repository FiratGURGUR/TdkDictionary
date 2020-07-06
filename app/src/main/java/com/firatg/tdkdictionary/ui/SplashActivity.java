package com.firatg.tdkdictionary.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.firatg.tdkdictionary.R;
import com.firatg.tdkdictionary.model.search.Suggestion;
import com.firatg.tdkdictionary.viewmodel.SearchViewModel;

import java.util.List;

public class SplashActivity extends AppCompatActivity {
    SearchViewModel searchViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.splash));
        setContentView(R.layout.activity_splash);


        searchViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);

        searchViewModel.gets().observe(this, new Observer<List<Suggestion>>() {
            @Override
            public void onChanged(List<Suggestion> suggestions) {

            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent openApp = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(openApp);
                finish();

            }
        }, 2000);

    }
}
