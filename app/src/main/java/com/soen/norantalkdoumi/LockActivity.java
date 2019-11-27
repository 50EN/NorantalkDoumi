package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LockActivity extends BaseActivity {
    public static String pw ;
    public static String input;
    public static String input_tmp;
    public static int input_len;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        // Initialize Variables
        Intent intent = getIntent();
        pw = intent.getExtras().getString("passwd");    // Seted User Password
        input = "";
        input_len = 0;
        input_tmp = "";

        // Press Key Buttons
        Button btnNum1 = (Button)findViewById(R.id.button1);
        btnNum1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "1";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum2 = (Button)findViewById(R.id.button2);
        btnNum2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "2";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum3 = (Button)findViewById(R.id.button3);
        btnNum3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "3";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum4 = (Button)findViewById(R.id.button4);
        btnNum4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "4";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum5 = (Button)findViewById(R.id.button5);
        btnNum5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "5";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum6 = (Button)findViewById(R.id.button6);
        btnNum6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "6";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum7 = (Button)findViewById(R.id.button7);
        btnNum7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "7";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum8 = (Button)findViewById(R.id.button8);
        btnNum8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "8";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum9 = (Button)findViewById(R.id.button9);
        btnNum9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "9";
                input_len += 1;
                passwdCheck();
            }
        });
        Button btnNum0 = (Button)findViewById(R.id.button11);
        btnNum0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input += "0";
                input_len += 1;
                passwdCheck();
            }
        });

        // Cancel Button
        Button btnDel = (Button)findViewById(R.id.Cancel);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.length()>0){
                    // Erase a Circle
                    switch(input_len) {
                        case 1:
                            ImageView imgview_circle1 = (ImageView) findViewById(R.id.imageview_circle1);
                            imgview_circle1.setImageResource(R.drawable.circle);
                            break;
                        case 2:
                            ImageView imgview_circle2 = (ImageView) findViewById(R.id.imageview_circle2);
                            imgview_circle2.setImageResource(R.drawable.circle);
                            break;
                        case 3:
                            ImageView imgview_circle3 = (ImageView) findViewById(R.id.imageview_circle3);
                            imgview_circle3.setImageResource(R.drawable.circle);
                            break;
                        case 4:
                            ImageView imgview_circle4 = (ImageView) findViewById(R.id.imageview_circle4);
                            imgview_circle4.setImageResource(R.drawable.circle);
                            break;
                    }

                    // Erase Last Character of Input
                    input = input.substring(0, input_len-1);
                    input_len -= 1;
                }
            }
        });

    }

    private void passwdCheck() {
        Log.d("INPUT: ",input);

        // Fill Circle
        switch(input_len){
            case 1:
                ImageView imgview_circle1 = (ImageView)findViewById(R.id.imageview_circle1);
                imgview_circle1.setImageResource(R.drawable.circle2);
                break;
            case 2:
                ImageView imgview_circle2 = (ImageView)findViewById(R.id.imageview_circle2);
                imgview_circle2.setImageResource(R.drawable.circle2);
                break;
            case 3:
                ImageView imgview_circle3 = (ImageView)findViewById(R.id.imageview_circle3);
                imgview_circle3.setImageResource(R.drawable.circle2);
                break;
            case 4:
                ImageView imgview_circle4 = (ImageView)findViewById(R.id.imageview_circle4);
                imgview_circle4.setImageResource(R.drawable.circle2);
                break;
        }

        if (input_len == 4) {   // Number is Four
            if(pw.equals("")){
                if(input_tmp.equals("")){   // First Step
                    input_tmp = input;
                    input = "";
                    input_len = 0;

                    // Initialize Circles
                    ImageView imgview_circle1 = (ImageView)findViewById(R.id.imageview_circle1);
                    imgview_circle1.setImageResource(R.drawable.circle);
                    ImageView imgview_circle2 = (ImageView)findViewById(R.id.imageview_circle2);
                    imgview_circle2.setImageResource(R.drawable.circle);
                    ImageView imgview_circle3 = (ImageView)findViewById(R.id.imageview_circle3);
                    imgview_circle3.setImageResource(R.drawable.circle);
                    ImageView imgview_circle4 = (ImageView)findViewById(R.id.imageview_circle4);
                    imgview_circle4.setImageResource(R.drawable.circle);
                }
                else {
                    if(input.equals(input_tmp)){    // Second Step (Final)
                        // Password Setting
                        Log.d("SET PASSWORD",input);
                        //
                        // Need to Add DB Function
                        //
                        setResult(RESULT_CANCELED);
                        finish();
                    }
                    else { // Wrong Re Password (Go to First Step)
                        input_tmp = "";
                        input = "";
                        input_len = 0;

                        // Initialize Circles
                        ImageView imgview_circle1 = (ImageView)findViewById(R.id.imageview_circle1);
                        imgview_circle1.setImageResource(R.drawable.circle);
                        ImageView imgview_circle2 = (ImageView)findViewById(R.id.imageview_circle2);
                        imgview_circle2.setImageResource(R.drawable.circle);
                        ImageView imgview_circle3 = (ImageView)findViewById(R.id.imageview_circle3);
                        imgview_circle3.setImageResource(R.drawable.circle);
                        ImageView imgview_circle4 = (ImageView)findViewById(R.id.imageview_circle4);
                        imgview_circle4.setImageResource(R.drawable.circle);
                    }
                }
            }
            else {  // After Password Setting
                if(input.equals(pw)) {  // Correct Password
                    setResult(RESULT_OK);
                    finish();
                }
                else {  // Not Correct Password
                    setResult(RESULT_CANCELED);
                    finish();
                }
            }

        }
    }

}