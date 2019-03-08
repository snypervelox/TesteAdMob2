package com.example.testeadmob;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private InterstitialAd mInterstitialAdVideo;
    private RewardedVideoAd mRewardedVideoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-6149747207896533~1497444922");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAdVideo = new InterstitialAd(this);
        mInterstitialAdVideo.setAdUnitId("ca-app-pub-3940256099942544/8691691433");
        mInterstitialAdVideo.loadAd(new AdRequest.Builder().build());
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    public void carregaInter(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "O anúncio intersticial ainda não foi carregado...");
        }
    }

    public void carregaInterVideo(View view) {
        if (mInterstitialAdVideo.isLoaded()) {
            mInterstitialAdVideo.show();
        } else {
            Log.d("TAG", "O anúncio intersticial (vídeo) ainda não foi carregado...");
        }
    }

    public void carregaReward(View view) {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        } else {
            Log.d("TAG", "O anúncio vídeo reward ainda não foi carregado...");
        }
    }

    public void carregaTela(View view) {
        Intent intent = new Intent(this, InterActivity.class);
        startActivity(intent);
    }
}