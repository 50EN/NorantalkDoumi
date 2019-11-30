package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.soen.norantalkdoumi.MainActivity.SETTING_REQUEST_CODE;

public class ReservActivity extends BaseActivity {
    public static  EditText textName;
    public static  EditText textTime;
    public static  EditText textDate;
    public static  EditText textMsg;

    public static String name = "";
    public static String time = "";
    public static String date = "";
    public static String msg = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserv);

        textName = (EditText) findViewById(R.id.Name);
        textTime = (EditText) findViewById(R.id.timeset);
        textDate = (EditText) findViewById(R.id.dateset);
        textMsg = (EditText) findViewById(R.id.message);

        textName.setText(name);
        textTime.setText(time);
        textDate.setText(date);
        textMsg.setText(msg);

        Button btnCheck = (Button)findViewById(R.id.Check);
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Need to Add Validation
                //

                name = String.valueOf(textName.getText());
                time = String.valueOf(textTime.getText());  // 12:03
                date = String.valueOf(textDate.getText());  // 11.30
                msg = String.valueOf(textMsg.getText());

                //
                // Data Transfer to DB
                // (name, Integer.parseInt(time.substring(0,2)), Integer.parseInt(time.substring(3,5)), Integer.parseInt(date.substring(0,2)), Integer.parseInt(date.substring(3,5)), msg);
                // String name, int hour, int min, int month, int day, String msg
                //

                name = "";
                time = "";
                date = "";
                msg = "";

                // Toast Message
                Toast toast = Toast.makeText(getBaseContext(),
                        "메시지가 예약되었습니다.", Toast.LENGTH_LONG);
                toast.show();

                setResult(RESULT_OK);
                finish();
            }
        });

        ImageButton btnPrev = (ImageButton)findViewById(R.id.PrevM);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = String.valueOf(textName.getText());
                time = String.valueOf(textTime.getText());
                date = String.valueOf(textDate.getText());
                msg = String.valueOf(textMsg.getText());
                finish();
            }
        });
        ImageButton btnSetting = (ImageButton)findViewById(R.id.setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call Setting Activity
                Intent intentSetting = new Intent(getApplicationContext(), com.soen.norantalkdoumi.SettingActivity.class);
                startActivityForResult(intentSetting, SETTING_REQUEST_CODE);
            }
        });
    }
}