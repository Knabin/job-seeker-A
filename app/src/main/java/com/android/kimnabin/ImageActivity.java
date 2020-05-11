package com.android.kimnabin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent it = getIntent();
        String tag = it.getStringExtra("tag");
        setView(tag, 5);

    }

    public void setView(String tag, int amount) {
        Resources res = getResources();
        for(int i = 1; i <= amount; i++) {
            String str_i = Integer.toString(i);
            int tvID = res.getIdentifier("tv_image"+i, "id", getPackageName());
            int tvID2 = res.getIdentifier("tv_image_"+i, "id", getPackageName());
            int ivID = res.getIdentifier("iv_image"+i, "id", getPackageName());
            int ivID2 = res.getIdentifier("iv_image_"+i, "id", getPackageName());

            ((TextView)findViewById(tvID)).setText(res.getIdentifier("text"+str_i+"_"+tag, "string", getPackageName()));
            ((TextView)findViewById(tvID2)).setText(res.getIdentifier("text_"+str_i+"_"+tag, "string", getPackageName()));
            ((ImageView)findViewById(ivID)).setImageResource(res.getIdentifier("image_img"+str_i, "drawable", getPackageName()));
            ((ImageView)findViewById(ivID2)).setImageResource(res.getIdentifier("image_icon"+str_i, "drawable", getPackageName()));
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
