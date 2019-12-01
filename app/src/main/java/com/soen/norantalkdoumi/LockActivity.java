package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LockActivity extends BaseActivity {
    public static String pw ;
    public static String input;
    public static String input_tmp;
    public static int input_len;
    public static DBManager dbManager;
//    final DBManager dbManager = new DBManager(getApplicationContext(), "noran.db",null,1);


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

        if(pw.equals("")){
            // Toast Message
            Toast toast = Toast.makeText(getBaseContext(),
                    "설정할 패스워드를 입력하세요.", Toast.LENGTH_LONG);
            toast.show();
        }

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
        final DBManager dbManager = new DBManager(getApplicationContext(), "noran.db",null,1);


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

                    // Toast Message
                    Toast toast = Toast.makeText(getBaseContext(),
                            "한번 더 입력해주세요.", Toast.LENGTH_LONG);
                    toast.show();
                }
                else {
                    if(input.equals(input_tmp)){    // Second Step (Final)
                        // Password Setting
                        Log.d("SET PASSWORD",encryptSHA256(input));

                        //insert encrypted pw
                        dbManager.insert_PW(encryptSHA256(input));

                        // Toast Message
                        Toast toast = Toast.makeText(getBaseContext(),
                                "패스워드가 설정되었습니다.", Toast.LENGTH_LONG);
                        toast.show();

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

                        // Toast Message
                        Toast toast = Toast.makeText(getBaseContext(),
                                "두 패스워드가 일치하지 않습니다.", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
            else {  // After Password Setting
                if(encryptSHA256(input).equals(pw)) {  // Correct Password
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
    public String encryptSHA256(String str){
        String SHA = "";
        try{
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < byteData.length ; i++){
                sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            SHA = null;
        }
        return SHA;
    }
}