package com.android.kimnabin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<MyIcon> myIcons = new ArrayList<>();
    private long backKeyPressedTime = 0;
    LinearLayout ll_info;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
                backKeyPressedTime = System.currentTimeMillis();
                Toast.makeText(getApplicationContext(), "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
                return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyIcon myIcon1 = new MyIcon(R.drawable.icon1, "자기소개", "1");
        myIcons.add(myIcon1);
        MyIcon myIcon2 = new MyIcon(R.drawable.icon2, "작품", "2");
        myIcons.add(myIcon2);
        MyIcon myIcon3 = new MyIcon(R.drawable.icon3, "활동", "3");
        myIcons.add(myIcon3);
        MyIcon myIcon4 = new MyIcon(R.drawable.icon4, "장단점", "4");
        myIcons.add(myIcon4);
        MyIcon myIcon5 = new MyIcon(R.drawable.icon5, "포부", "5");
        myIcons.add(myIcon5);
        MyIcon myIcon6 = new MyIcon(R.drawable.icon6, "관심사", "6");
        myIcons.add(myIcon6);

        ll_info = findViewById(R.id.ll_info);

        MyIconAdapter myIconAdapter = new MyIconAdapter(this, myIcons, R.layout.myicon);
        GridView gridView = findViewById(R.id.gv_main);
        gridView.setAdapter(myIconAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = null; String tag;
                switch (position) {
                    case 0:
                        it = new Intent(getApplicationContext(), ProfileActivity.class); break;
                    case 1:
                        it = new Intent(getApplicationContext(), ImageActivity.class); break;
                    case 2: case 3: case 4:
                        it = new Intent(getApplicationContext(), DetailActivity.class); break;
                    case 5:
                        it = new Intent(getApplicationContext(), FavorActivity.class); break;
                }
                if(it != null) {
                    tag = myIcons.get(position).getIconTag();
                    it.putExtra("tag", tag);
                    startActivity(it);
                    overridePendingTransition(R.anim.fadein, R.anim.hold);
                    finish();
                }
            }
        });

        ll_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getApplicationContext(), InfoActivity.class);
                startActivity(it);
                overridePendingTransition(R.anim.fadein, R.anim.hold);
                finish();
            }
        });
    }
}
