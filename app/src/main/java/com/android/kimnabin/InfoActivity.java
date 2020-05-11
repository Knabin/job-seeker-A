package com.android.kimnabin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class InfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
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
