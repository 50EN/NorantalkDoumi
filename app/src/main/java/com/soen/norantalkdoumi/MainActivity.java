package com.soen.norantalkdoumi;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends BaseActivity{
    /*1. 디비에 pw 저장 여부 확인, 저장되면 intent lock
    * -> lock에서 받은 값이 true라면 메인 동작함. 아니면 다시 lock으로 넘겨줌 반복*/

    SQLiteDatabase sqliteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sqliteDB = init_db();

    }

//if(db != null && 값이 true 이면){intent lockactivity}

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
