package com.taskcar.db.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taskcar.db.model.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hfdeudor on 31/08/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "taskCarManager";

    // Table Names
    private static final String TABLE_MARCA = "marcas";
    private static final String TABLE_MODELO = "modelos";
    private static final String TABLE_VEHICULO = "vehiculos";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_DESCRIPCION = "descripcion";


    // vehiculos Table - column names
    private static final String KEY_PLACA = "placa";
    private static final String KEY_DNI = "dni";
    private static final String KEY_ID_MARCA = "marca_id";
    private static final String KEY_ID_MODELO = "modelo_id";
    private static final String KEY_ANIO = "anio";

    // Table Create Statements
    // MARCA create statement
    private static final String CREATE_TABLE_MARCA = "CREATE TABLE "
            + TABLE_MARCA+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DESCRIPCION
            + " TEXT"+ ")";

    // mODELO table create statement
    private static final String CREATE_TABLE_MODELO = "CREATE TABLE "
            + TABLE_MODELO+ "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_DESCRIPCION
            + " TEXT"+ ")";

    // todo_tag table create statement
    private static final String CREATE_TABLE_VEHICULO = "CREATE TABLE "
            + TABLE_VEHICULO + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_PLACA + " TEXT," + KEY_DNI + " TEXT,"+ KEY_ID_MARCA+ " TEXT,"+ KEY_ID_MODELO+ " TEXT,"
            + KEY_ANIO + " TEXT" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creando tabla MARCA
        db.execSQL(CREATE_TABLE_MARCA);

        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Changan')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Citroen')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('DS')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Foton')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Great Wall')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Haval')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Jac')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Mazda')");
        db.execSQL("INSERT INTO " + TABLE_MARCA+ "("+ KEY_DESCRIPCION +") VALUES ('Suzuki')");

        db.execSQL(CREATE_TABLE_MODELO);

        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Benni')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('CS75')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Berlingo')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('C4')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('C4-Cactus')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('C-Elysse')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('DS3')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('DS4')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Sauvana')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('C30')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('M4')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Wingle-5')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('H2')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('H6')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('J4')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Refine')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('S3')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('S5')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Mazda-3')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Mazda-5')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Mazda-CX-5')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Mazda-CX-9')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('All New Celerio')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('APV Furgon')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Grand Nomade')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Grand Vitara')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Swift 1.4')");
        db.execSQL("INSERT INTO " + TABLE_MODELO+ "("+ KEY_DESCRIPCION +") VALUES ('Swift Sedan')");

        db.execSQL(CREATE_TABLE_VEHICULO);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARCA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODELO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VEHICULO);

        // create new tables
        onCreate(db);
    }


    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new vehicule
    public void addCar(Car car) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLACA, car.getPlaca()); // Contact Name
        values.put(KEY_DNI, car.getDni());
        values.put(KEY_ID_MARCA, car.getMarca());
        values.put(KEY_ID_MODELO, car.getModelo());
        values.put(KEY_ANIO,car.getAnio());

        // Inserting Row
        db.insert(TABLE_VEHICULO, null, values);
        db.close(); // Closing database connection
    }


    // Getting All Vehiculos
    public List<Car> getAllCars() {
        List<Car> carList = new ArrayList<Car>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_VEHICULO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Car car = new Car();
                car.setId(Integer.parseInt(cursor.getString(0)));
                car.setPlaca(cursor.getString(1));
                car.setDni(cursor.getString(2));
                car.setMarca(cursor.getString(3));
                car.setModelo(cursor.getString(4));
                car.setAnio(cursor.getString(5));

                // Adding contact to list
                carList.add(car);
            } while (cursor.moveToNext());
        }

        // return contact list
        return carList;
    }

    public void deleteCar(Car car) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VEHICULO, KEY_ID + " = ?",
                new String[] { String.valueOf(car.getId()) });
        db.close();
    }

    // Getting contacts Count
    /*
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    */
}
