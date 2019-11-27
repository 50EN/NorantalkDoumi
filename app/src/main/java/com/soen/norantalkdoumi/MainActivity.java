package com.soen.norantalkdoumi;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends BaseActivity{
    public static final int REQUEST_CODE = 1001;    // Lock Activity Code (Maybe Need to Change)
    public static String password = "";             // Temp User Password


    /*1. 디비에 pw 저장 여부 확인, 저장되면 intent lock
     * -> lock에서 받은 값이 true라면 메인 동작함. 아니면 다시 lock으로 넘겨줌 반복*/

    SQLiteDatabase sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteDB = init_db();


        // Get User Password in DB
        password = ""; // Need to Add DB Function
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

    // if(db != null && 값이 true 이면){intent lockactivity}

    private SQLiteDatabase init_db(){
        SQLiteDatabase db = null;
        File file = new File(getFilesDir(), "contact.db");

    }
    String pw = sqliteDB.rawQuery("SELECT password FROM" + tableName, null);
    if(pw != null){//pw가 not null이면 intent lock
        //intent로 lock으로 넘기기
        Intent intent = new Intent(, LockActivity);

        //onNewIntent();
    }
}
