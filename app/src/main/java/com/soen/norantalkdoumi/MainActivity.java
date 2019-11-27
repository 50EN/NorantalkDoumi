package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity{

    public static final int REQUEST_CODE = 1001;    // Lock Activity Code (Maybe Need to Change)
    public static String password = "";             // Temp User Password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call Lock Activity
        Intent intent = new Intent(getApplicationContext(), com.soen.norantalkdoumi.LockActivity.class);
        intent.putExtra("passwd", password);            // Transfer Password by Parameter (name:passwd)
        startActivityForResult(intent, REQUEST_CODE);


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Lock Activity
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_CANCELED) {
                // Get User Password in DB
                password = ""; // Need to Add DB Function

                // ReCall Lock Activity
                Intent intentRe = new Intent(getApplicationContext(), com.soen.norantalkdoumi.LockActivity.class);
                intentRe.putExtra("passwd", password);  // Transfer Password by Parameter (name:passwd)
                startActivityForResult(intentRe, REQUEST_CODE);
            }
        }

    }

}