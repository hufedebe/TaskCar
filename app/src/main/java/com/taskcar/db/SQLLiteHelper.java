package com.taskcar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hudeya on 31/07/2017.
 */

public class SQLLiteHelper extends SQLiteOpenHelper {

    //Logcat tag
    private static final String LOG = "SQLLiteHelper";

    //Versión de la base de datos
    private static final int DB_VERSION=1;
    //Nombre de la Base de datos
    private static final String DB_NAME ="TaskCar" ;

    //Nombre de las tablas
    private static final String TABLE_CITA = "cita";
    private static final String TABLE_VEHICULO = "vehiculo";



    //Tabla de Citas
    private static final String Table_Name = "Cita";
    private static final String col_1 = "IDCITA" ;
    private static final String col_2= "PLACA" ;
    private static final String col_3= "DIAHORACITA";
    private static final String col_4 = "IDTALLER";

    private static final String SQL_CREATE_CITA = "create table"+Table_Name +"ID INTEGER PRIMARY KEY AUTOINCREMENT, ";


    public SQLLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
