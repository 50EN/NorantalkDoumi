package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends BaseActivity{
    public static final int LOCK_REQUEST_CODE = 1001;// Lock Activity Code (Maybe Need to Change)
    public static final int RESERV_REQUEST_CODE = 1002;// Reserv Activity Code (Maybe Need to Change)
    public static final int SETTING_REQUEST_CODE = 1003;// Setting Activity Code (Maybe Need to Change)
    public static String password = "";             // Temp User Password
    DataBase database = new DataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//     DataBase.DbOpenHelper.DbHelper.create();
        //sqliteDB = init_database();


        // Get User Password in DB
        password = ""; // Need to Add DB Function
        // Call Lock Activity
        Intent intent = new Intent(getApplicationContext(), com.soen.norantalkdoumi.LockActivity.class);
        intent.putExtra("passwd", password);            // Transfer Password by Parameter (name:passwd)
        startActivityForResult(intent, LOCK_REQUEST_CODE);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        // Lock Activity
        if(requestCode == LOCK_REQUEST_CODE){
            if(resultCode == RESULT_CANCELED) {
                // Get User Password in DB
                password = "9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0"; // Need to Add DB Function

                // ReCall Lock Activity
                Intent intentRe = new Intent(getApplicationContext(), com.soen.norantalkdoumi.LockActivity.class);
                intentRe.putExtra("passwd", password);  // Transfer Password by Parameter (name:passwd)
                startActivityForResult(intentRe, LOCK_REQUEST_CODE);
            }
        }

    }

    // if(db != null && 값이 true 이면){intent lockactivity}

   /* private SQLiteDatabase init_database(){
        SQLiteDatabase db = null;
        File file = new File(getFilesDir(), "contact.db");

        System.out.println("PATH: "+file.toString());
        try{
            db = SQLiteDatabase.openOrCreateDatabase(file, null);
        }catch(SQLException e){
            e.printStackTrace();
        }

        if(db == null){
            System.out.println("DB creation failed. " +file.getAbsolutePath());
        }

        return db;

    }

    String pw = sqliteDB.rawQuery("SELECT password FROM" + tableName, null);
    if(pw != null){//pw가 not null이면 intent lock
        //intent로 lock으로 넘기기
        Intent intent = new Intent(, LockActivity);

        //onNewIntent();
    }*/
}
