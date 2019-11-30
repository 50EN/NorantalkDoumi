package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import static com.soen.norantalkdoumi.MainActivity.LOCK_REQUEST_CODE;
import static com.soen.norantalkdoumi.ReservActivity.textName;

public class SettingActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv);

        ImageButton btnPrev = (ImageButton)findViewById(R.id.PrevM);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

        ImageButton btnPrev = (ImageButton)findViewById(R.id.PrevM);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reset Password
                Intent intent = new Intent(getApplicationContext(), com.soen.norantalkdoumi.LockActivity.class);
                intent.putExtra("passwd", "");
                startActivityForResult(intent, LOCK_REQUEST_CODE);
            }
        });

    }
}
