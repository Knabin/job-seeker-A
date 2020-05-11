package com.android.kimnabin;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class FavorActivity extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView;
    YouTubePlayer.OnInitializedListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favor);
        youtubeView = (YouTubePlayerView)findViewById(R.id.youtube);

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo("zeAtkPZSYBk");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youtubeView.initialize("AIzaSyAuaRZfULPpuMLG3aKy4drdxjnd_c4UfpU", listener);


        Intent it = getIntent();
        String tag = it.getStringExtra("tag");
        setView(tag, 3, 2);
    }

    public void setView(String tag, int amount) {
        Resources res = getResources();
        for(int i = 1; i <= amount; i++) {
            String str_i = Integer.toString(i);
            int resID = res.getIdentifier("tv_favor"+i, "id", getPackageName());
            int ivID = res.getIdentifier("iv_favor_"+i, "id", getPackageName());
            ((TextView)findViewById(resID)).setText(res.getIdentifier("text"+str_i+"_"+tag, "string", getPackageName()));
            ((ImageView)findViewById(ivID)).setImageResource(res.getIdentifier("favor_icon"+str_i, "drawable", getPackageName()));
        }
    }

    public void setView(String tag, int amount1, int amount2) {
        setView(tag, amount1);
        Resources res = getResources();
        for(int i = 1; i <= amount2; i++) {
            String str_i = Integer.toString(i);
            int resID = res.getIdentifier("tv_favor_"+i, "id", getPackageName());
            int ivID = res.getIdentifier("iv_favor"+i, "id", getPackageName());
            ((TextView)findViewById(resID)).setText(res.getIdentifier("text_"+str_i+"_"+tag, "string", getPackageName()));
            ((ImageView)findViewById(ivID)).setImageResource(res.getIdentifier("favor_img"+str_i, "drawable", getPackageName()));
        }
    }

    @Override
    public void onBackPressed() {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
        overridePendingTransition(R.anim.fadein, R.anim.hold);
        finish();
    }

    public void goBack(View v) {
        Intent it = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
        overridePendingTransition(R.anim.fadein, R.anim.hold);
        finish();
    }


}
