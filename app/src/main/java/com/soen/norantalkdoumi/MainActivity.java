package com.soen.norantalkdoumi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends BaseActivity{
    public static final int LOCK_REQUEST_CODE = 1001;       // Lock Activity Code (Maybe Need to Change)
    public static final int RESERV_REQUEST_CODE = 1002;     // Reserv Activity Code (Maybe Need to Change)
    public static final int SETTING_REQUEST_CODE = 1003;    // Setting Activity Code (Maybe Need to Change)
    public static String password = "";             // Temp User Password
    public static LinearLayout reservLayout;
    public static Button btnDel;
    DataBase database = new DataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//     DataBase.DbOpenHelper.DbHelper.create();
        //sqliteDB = init_database();

        // Get User Password in DB
        password = "9af15b336e6a9619928537df30b2e6a2376569fcf9d7e773eccede65606529a0"; // Need to Add DB Function
        // Call Lock Activity
        Intent intent = new Intent(getApplicationContext(), com.soen.norantalkdoumi.LockActivity.class);
        intent.putExtra("passwd", password);            // Transfer Password by Parameter (name:passwd)
        startActivityForResult(intent, LOCK_REQUEST_CODE);

        ImageButton btnRecord = (ImageButton)findViewById(R.id.Record);
        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call Reservation Activity
                Intent intentReserv = new Intent(getApplicationContext(), com.soen.norantalkdoumi.ReservActivity.class);
                startActivityForResult(intentReserv, RESERV_REQUEST_CODE);
            }
        });
        ImageButton btnSetting = (ImageButton)findViewById(R.id.Setting);
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call Setting Activity
                Intent intentSetting = new Intent(getApplicationContext(), com.soen.norantalkdoumi.SettingActivity.class);
                startActivityForResult(intentSetting, SETTING_REQUEST_CODE);
            }
        });

        // Reservation Messeage Layout
        reservLayout = (LinearLayout) findViewById(R.id.ReservLayout);
        reservLayout.setVisibility(View.INVISIBLE);

        btnDel = (Button)findViewById(R.id.button10);
        btnDel.setVisibility(View.INVISIBLE);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Delete Reservation

                //
                // Need to Add Controling more than one data
                //
                reservLayout.setVisibility(View.INVISIBLE);
                btnDel.setVisibility(View.INVISIBLE);
            }
        });
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
        else if(requestCode == RESERV_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                reservLayout.setVisibility(View.VISIBLE);
                btnDel.setVisibility(View.VISIBLE);

                // Synchronize Reservation Layout

                //
                // Get Reserv Data in DB
                //

                TextView txtViewName = (TextView)findViewById(R.id.Name);
                TextView txtViewDate = (TextView)findViewById(R.id.Date);
                TextView txtViewTime = (TextView)findViewById(R.id.Time);
                TextView txtViewMsg = (TextView)findViewById(R.id.Message);

                txtViewName.setText("T");
                txtViewDate.setText("E");
                txtViewTime.setText("S");
                txtViewMsg.setText("T");
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
