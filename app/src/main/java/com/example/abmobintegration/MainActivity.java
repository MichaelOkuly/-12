package com.example.abmobintegration;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private boolean adLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(MainActivity.this, "ca-app-pub-3940256099942544~3347511713");
        final AdView myAd = findViewById(R.id.myAd);
        final TextView myTextView = findViewById(R.id.textView1);

        myAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                adLoaded = true;
                myTextView.setText("The ad was loaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                adLoaded = false;
                myTextView.setText("The ad failed to load");
            }
        });

        final Button loadAdButton = findViewById(R.id.loadAdButton);
        loadAdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAd.loadAd(new AdRequest.Builder().addTestDevice("2E5C1BFE36D4707CC54D028594C19D17").build());
            }
        });
    }
}