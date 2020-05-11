package com.android.kimnabin;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ProfileActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent it = getIntent();
        String tag = it.getStringExtra("tag");
        setView(tag, 3);
    }

    public void setView(String tag, int amount) {
        Resources res = getResources();
        for(int i = 1; i <= amount; i++) {
            String str_i = Integer.toString(i);
            int resID = res.getIdentifier("tv_profile"+i, "id", getPackageName());
            ((TextView)findViewById(resID)).setText(res.getIdentifier("text"+str_i+"_"+tag, "string", getPackageName()));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng home = new LatLng(37.556197, 126.814138);
        LatLng hs = new LatLng(37.568805, 126.805792);
        LatLng uv = new LatLng(37.500453, 126.867777);

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.531204, 126.8314070), 11));

        MarkerOptions marker = new MarkerOptions();
        marker.position(home).title("집").snippet("서울시 강서구 공항동");
        googleMap.addMarker(marker).showInfoWindow();

        marker.position(uv).title("동양미래대학교").snippet("재학 중인 대학교");
        googleMap.addMarker(marker);

        marker.position(hs).title("공항고등학교").snippet("출신 고등학교");
        googleMap.addMarker(marker);

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

    public void sendEmail(View v) {
        String uriText =
                "mailto:ppoxx77@gmail.com" +
                        "?subject=" + Uri.encode("") +
                        "&body=" + Uri.encode("");

        Uri uri = Uri.parse(uriText);

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "이메일 전송"));
    }

    public void sendCall(View v){
        String tel = "tel:01058099448";
        startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
    }

    public static Spanned fromHtml(String source) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.N) {
            // noinspection deprecation
            return Html.fromHtml(source);
        }
        return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY);
    }
}
