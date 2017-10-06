package com.taskcar.db.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.taskcar.db.model.Car;
import com.taskcar.db.model.Cita;
import com.taskcar.db.model.Historia;
import com.taskcar.db.model.Horario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hfdeudor on 31/08/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 7;

    // Database Name
    private static final String DATABASE_NAME = "taskCarManager";

    // Table Names
    private static final String TABLE_MARCA = "marcas";
    private static final String TABLE_MODELO = "modelos";
    private static final String TABLE_VEHICULO = "vehiculos";
    private static final String TABLE_CITA = "citas";
    private static final String TABLE_HISTORIA="historia";

    // Common column names
    private static final String KEY_ID = "id";
    private static final String KEY_DESCRIPCION = "descripcion";


    // vehiculos Table - column names
    private static final String KEY_PLACA = "placa";
    private static final String KEY_DNI = "dni";
    private static final String KEY_ID_MARCA = "marca_id";
    private static final String KEY_ID_MODELO = "modelo_id";
    private static final String KEY_ANIO = "anio";


    //citas Table - column names
    private static final String KEY_EVENTO = "id_evento";
    private static final String KEY_TALLER = "idTaller";
    private static final String KEY_NOMBRE_TALLER="nombreTaller";
   // private static final String KEY_PLACA = "placa";
    private static final String KEY_DESCRIPCION_TALLER = "direccionTaller";
    private static final String KEY_FECHA_EVENTO = "diaHoraEvento";
    private  static final String KEY_ID_SERVICIO = "idServicio";
    private static  final String KEY_TIPO_SERVICIO = "tipoServicio";


    //historia Vehicular

    private static  final String KEY_PUNTUACION= "puntuacion";

    // Table Create Statements

    private static  final String CREATE_TABLE_CITA = "CREATE TABLE "+ TABLE_CITA+ "("+KEY_ID+ " INTEGER PRIMARY KEY, "+
                                                        KEY_EVENTO+" TEXT," + KEY_DNI+ " TEXT," +KEY_TALLER+ " TEXT,"+KEY_NOMBRE_TALLER+ " TEXT,"+ KEY_PLACA+" TEXT,"+
                                                        KEY_DESCRIPCION_TALLER+" TEXT," + KEY_FECHA_EVENTO+ " TEXT,"+
                                                        KEY_ID_SERVICIO+" TEXT,"+ KEY_TIPO_SERVICIO+ " TEXT" +")";


    private static final String CREATE_TABLE_HISTORIA = "CREATE TABLE "+ TABLE_HISTORIA+ "("+KEY_ID+ " INTEGER PRIMARY KEY, "+
            KEY_EVENTO+" TEXT," + KEY_DNI+ " TEXT," +KEY_TALLER+ " TEXT,"+KEY_NOMBRE_TALLER+ " TEXT,"+ KEY_PLACA+" TEXT,"+
            KEY_DESCRIPCION_TALLER+" TEXT," + KEY_FECHA_EVENTO+ " TEXT,"+
            KEY_ID_SERVICIO+" TEXT,"+ KEY_TIPO_SERVICIO+ " TEXT,"+ KEY_PUNTUACION+" TEXT" +")";

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
        db.execSQL(CREATE_TABLE_CITA);
        db.execSQL(CREATE_TABLE_HISTORIA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MARCA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODELO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VEHICULO);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CITA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORIA);

        // create new tables
        onCreate(db);
    }


    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
    public  void addCita(Cita cita){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENTO,cita.getIdEvento());
        values.put(KEY_DNI,cita.getDni());
        values.put(KEY_TALLER,cita.getIdTaller());
        values.put(KEY_TALLER, cita.getNombreTaller());
        values.put(KEY_PLACA, cita.getPlaca()); // Contact Name
        values.put(KEY_DESCRIPCION_TALLER,cita.getDireccionTaller());
        values.put(KEY_FECHA_EVENTO, cita.getDiaHoraEvento());
        values.put(KEY_ID_SERVICIO, cita.getIdServicio());
        values.put (KEY_TIPO_SERVICIO, cita.getTipoServicio());

        // Inserting Row
        db.insert(TABLE_CITA, null, values);
        db.close(); // Closing database connection

    }

    public  void addHistoria(Historia historia){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EVENTO,historia.getIdEvento());
        values.put(KEY_DNI,historia.getDni());
        values.put(KEY_TALLER,historia.getIdTaller());
        values.put(KEY_TALLER, historia.getNombreTaller());
        values.put(KEY_PLACA, historia.getPlaca()); // Contact Name
        values.put(KEY_DESCRIPCION_TALLER,historia.getDireccionTaller());
        values.put(KEY_FECHA_EVENTO, historia.getDiaHoraEvento());
        values.put(KEY_ID_SERVICIO, historia.getIdServicio());
        values.put (KEY_TIPO_SERVICIO, historia.getTipoServicio());
        values.put(KEY_PUNTUACION,historia.getPuntuacion());

        // Inserting Row
        db.insert(TABLE_HISTORIA, null, values);
        db.close(); // Closing database connection

    }

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

    public  List<Cita> getAllCitas(){
        List<Cita> citaList = new ArrayList<Cita>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CITA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Cita cita = new Cita();
                cita.setId(Integer.parseInt(cursor.getString(0)));
                cita.setIdEvento(cursor.getString(1));
                cita.setIdTaller(cursor.getString(2));
                cita.setNombreTaller(cursor.getString(3));
                cita.setPlaca(cursor.getString(4));
                cita.setDireccionTaller(cursor.getString(5));
                cita.setDiaHoraEvento(cursor.getString(6));
                cita.setIdServicio(cursor.getString(7));
                cita.setTipoServicio(cursor.getString(8));


                // Adding contact to list
                citaList.add(cita);
            } while (cursor.moveToNext());
        }

        // return contact list
        return citaList;


    }

    public  List<Cita> getAllCitasDNI(String dni){
        List<Cita> citaList = new ArrayList<Cita>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CITA + " WHERE DNI = '"+dni+"'";;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Cita cita = new Cita();
                cita.setId(Integer.parseInt(cursor.getString(0)));
                cita.setIdEvento(cursor.getString(1));
                cita.setDni(cursor.getString(2));
                cita.setIdTaller(cursor.getString(3));
                cita.setNombreTaller(cursor.getString(4));
                cita.setPlaca(cursor.getString(5));
                cita.setDireccionTaller(cursor.getString(6));
                cita.setDiaHoraEvento(cursor.getString(7));
                cita.setIdServicio(cursor.getString(8));
                cita.setTipoServicio(cursor.getString(9));


                // Adding contact to list
                citaList.add(cita);
            } while (cursor.moveToNext());
        }

        // return contact list
        return citaList;


    }

    public  List<Historia> getAllHistoriaDNI(String dni){
        List<Historia> historiaList = new ArrayList<Historia>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HISTORIA + " WHERE DNI = '"+dni+"'";;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Historia historia = new Historia();
                historia.setId(Integer.parseInt(cursor.getString(0)));
                historia.setIdEvento(cursor.getString(1));
                historia.setDni(cursor.getString(2));
                historia.setIdTaller(cursor.getString(3));
                historia.setNombreTaller(cursor.getString(4));
                historia.setPlaca(cursor.getString(5));
                historia.setDireccionTaller(cursor.getString(6));
                historia.setDiaHoraEvento(cursor.getString(7));
                historia.setIdServicio(cursor.getString(8));
                historia.setTipoServicio(cursor.getString(9));
                historia.setPuntuacion(cursor.getString(10));


                // Adding contact to list
                historiaList.add(historia);
            } while (cursor.moveToNext());
        }

        // return contact list
        return historiaList;


    }





    public  Cita getAllCitasIdEvento(String idEvento){
       // List<Cita> citaList = new ArrayList<Cita>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CITA + " WHERE ID_EVENTO = '"+idEvento+"'";;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();

        Cita cita = new Cita();
        cita.setId(Integer.parseInt(cursor.getString(0)));
        cita.setIdEvento(cursor.getString(1));
        cita.setDni(cursor.getString(2));
        cita.setIdTaller(cursor.getString(3));
        cita.setNombreTaller(cursor.getString(4));
        cita.setPlaca(cursor.getString(5));
        cita.setDireccionTaller(cursor.getString(6));
        cita.setDiaHoraEvento(cursor.getString(7));
        cita.setIdServicio(cursor.getString(8));
        cita.setTipoServicio(cursor.getString(9));

        // return contact
        return cita;
        // looping through all rows and adding to list
        /*
        if (cursor.moveToFirst()) {
            do {
                Cita cita = new Cita();


                // Adding contact to list
                citaList.add(cita);
            } while (cursor.moveToNext());
        }

        // return contact list
        return citaList;
        */

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

    public List<Car> getAllCarsDNI( String dni) {
        List<Car> carList = new ArrayList<Car>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_VEHICULO + " WHERE DNI = '"+dni+"'";

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

    public void deleteCita(Cita cita){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CITA, KEY_ID + " = ?",
                new String[] { String.valueOf(cita.getId()) });
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
