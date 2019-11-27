package com.soen.norantalkdoumi;
/* this is data base for this app.
Use this at MSG activity, MSGPrev and pw.
 */

import android.provider.BaseColumns;

public final class DataBase {



    public static final class CreateDB implements BaseColumns{
        //TODO: fill in the DB
        public static final String PASSWORD = "password";
        public static final String PEOPLE = "people";
        public static final String Message = "message";
        public static final String TIME = "time";

        public static final String _MSGTABLENAME = "Message";
        public static final String _PWTABLENAME = "Password";



    }
}
