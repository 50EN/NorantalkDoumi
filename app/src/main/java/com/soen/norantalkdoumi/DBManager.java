package com.soen.norantalkdoumi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBManager extends SQLiteOpenHelper {
    public DBManager(Context context, String name, SQLiteDatabase.CursorFactory factory,int version ){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "
                +_PWTABLENAME+"("
                +PASSWORD+" text not null);");
        db.execSQL("create table "
                +_MSGTABLENAME+"("
                /*+" integer primary key autoincrement, "*/
                +PEOPLE+" text not null, "
                +MONTH+"integer not null, "
                +DAY+"integer not null, "//store this type
                +HOUR+"integer not null, "
                +MIN+" integer not null, "
                +MESSAGE+" text not null);");//text 형식 길이 나중에 수정 필요함
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static final String PASSWORD = "password";
    public static final String PEOPLE = "people";
    public static final String MESSAGE = "message";
    public static final String MONTH = "month";
    public static final String DAY = "day";
    public static final String HOUR = "hour";
    public static final String MIN = "min";
    public static final String _MSGTABLENAME = "msgTable";
    public static final String _PWTABLENAME = "pwTable";

    //pw 설정
    public void insert_PW(String password){
        SQLiteDatabase db = getWritableDatabase();//db 수정 가능 한 상태로 열기
        db.execSQL("INSERT INTO "+_PWTABLENAME+" VALUES('"+password+"')"+";");
        Log.d("DB" ,"insert_pw: password inserted");

    }
    //Message insert
    public void insert_MSG(String people, int month, int day, int hour, int min, String message){
        SQLiteDatabase db = getWritableDatabase();//db 수정 가능 한 상태로 열기
        db.execSQL("INSERT INTO "+_MSGTABLENAME+" VALUES('"+people+"',"+month+","+day+","+hour+","+min+",'"+message+"')"+";");
        Log.d("DB", "insert_MSG: message inserted");
    }
    //pw 변경
    public void update_PW(String password){
        SQLiteDatabase db = getWritableDatabase();//db 수정 가능 한 상태로 열기
        db.execSQL("UPDATE "+_PWTABLENAME+" SET password ="+password+";");
    }
    //메시지 삭제
    public void delete_MSG(String people){//보내는 사람 이름으로 탐색하고 그 사람 이름이 행에 있을 경우 삭제
        SQLiteDatabase db = getWritableDatabase();//db 수정 가능 한 상태로 열기
        db.execSQL("DELETE FROM "+_MSGTABLENAME+" WHERE people='"+people+"';");
    }

    public void delete_PW(){//password 삭제
        SQLiteDatabase db = getWritableDatabase();//db 수정 가능 한 상태로 열기
        db.execSQL("DELETE FROM "+_PWTABLENAME+";");
    }

    public String getResult_PW(){
        SQLiteDatabase db = getReadableDatabase();//db 수정 가능 한 상태로 열기
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM pwTable", null);

//        Log.d("DB","Result1-2");

        while(cursor.moveToNext()){
            result += cursor.getString(0)
                    + " : ";
        }
        Log.d("DB",result);
        return "";
    }

    public String getResult_MSG(){
        SQLiteDatabase db = getReadableDatabase();//db 수정 가능 한 상태로 열기
        String result = "";

        Cursor cursor = db.rawQuery("SELECT * FROM pwTable", null);

        Log.d("DB","Result1-2");

        while(cursor.moveToNext()){
            result += cursor.getString(0)
                    + " : ";
        }
        Log.d("DB",result);
        return "";
    }
}
