package com.android.kimnabin;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        btn_back = findViewById(R.id.btn_back);

        Intent it = getIntent();
        String tag = it.getStringExtra("tag");
        switch (tag)
        {
            case "3": case "5":
                setView(tag, 2, 5); break;
            case "4":
                setView(tag, 2, 2); break;
        }

    }

    public void setView(String tag, int amount) {
        Resources res = getResources();
        for(int i = 1; i <= amount; i++) {
            String str_i = Integer.toString(i);
            int resID = res.getIdentifier("tv_detail"+i, "id", getPackageName());
            int ivID = res.getIdentifier("iv_detail_"+i, "id", getPackageName());
            ((TextView)findViewById(resID)).setText(res.getIdentifier("text"+str_i+"_"+tag, "string", getPackageName()));
            ((ImageView)findViewById(ivID)).setImageResource(res.getIdentifier("detail_icon"+str_i+"_"+tag, "drawable", getPackageName()));
        }
    }


    public void setView(String tag, int amount1, int amount2) {
        setView(tag, amount1);
        Resources res = getResources();
        for(int i = 1; i <= amount2; i++) {
            String str_i = Integer.toString(i);
            int resID = res.getIdentifier("tv_detail_"+i, "id", getPackageName());
            ((TextView)findViewById(resID)).setText(res.getIdentifier("text_"+str_i+"_"+tag, "string", getPackageName()));
            ((TextView)findViewById(resID)).setVisibility(View.VISIBLE);
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

