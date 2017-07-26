package com.example.devil.car_project.activities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

/**
 * Created by devil on 4/22/2017.
 */

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME ="carsInfo";
    // Contacts table name
    private static final String TABLE_CARS = "cars";
    // Cars Table Columns names
    private static final String KEY_CAR_NUMBER = "car_number";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDR = "address";
    private static final String KEY_REPORT = "report";
    private static final String KEY_FITNESS = "fitness";
    private static final String KEY_TAX = "tax";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CARS + "("
                + KEY_CAR_NUMBER + " TEXT PRIMARY KEY," + KEY_NAME + "TEXT"
                + KEY_ADDR + " TEXT" + KEY_FITNESS + "TEXT"+ KEY_REPORT + "TEXT" + KEY_TAX + "TEXT"+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARS);
// Creating tables again
        onCreate(db);
    }
    // Adding new cars
    public void addCars(Cars cars) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, cars.getName()); // Cars Name
        values.put(KEY_ADDR, cars.getAddress()); // Cars adress
        values.put(KEY_CAR_NUMBER, cars.getCar_number()); // Cars number
        values.put(KEY_FITNESS, cars.getFitness()); // Cars fitness
        values.put(KEY_REPORT, cars.getReport()); // Cars insurance report
        values.put(KEY_TAX, cars.getTax()); // Cars tax

// Inserting Row
        db.insert(TABLE_CARS, null, values);
        db.close(); // Closing database connection
    }
    // Getting one cars
    public List<Cars> getCars(String message) {

        List<Cars> carsese = new ArrayList<Cars>();
        SQLiteDatabase db = this.getReadableDatabase();
        String queryty="SELECT * FROM "+ TABLE_CARS+" WHERE "+KEY_CAR_NUMBER+" = ' "+message + " '";
        Cursor cursor = db.rawQuery(queryty,null);


            cursor.moveToFirst();

        if (cursor.moveToFirst()) {
                Cars cars = new Cars(KEY_NAME, KEY_ADDR, KEY_CAR_NUMBER, KEY_FITNESS, KEY_REPORT, KEY_TAX);
                cars.setCar_number(cursor.getString(0));
                cars.setName(cursor.getString(1));
                cars.setAddress(cursor.getString(2));
                cars.setAddress(cursor.getString(3));
                cars.setAddress(cursor.getString(4));
                cars.setAddress(cursor.getString(5));
// Adding contact to list

            carsese.add(cars);
        }
        cursor.close();
   return carsese;

    }
    // Getting All Cars
    public List<Cars> getAllCars() {
        List<Cars> carsList = new ArrayList<Cars>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CARS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Cars cars = new Cars(KEY_NAME, KEY_ADDR, KEY_CAR_NUMBER, KEY_FITNESS, KEY_REPORT, KEY_TAX);
                cars.setCar_number(cursor.getString(0));
                cars.setName(cursor.getString(1));
                cars.setAddress(cursor.getString(2));
                cars.setAddress(cursor.getString(3));
                cars.setAddress(cursor.getString(4));
                cars.setAddress(cursor.getString(5));
// Adding contact to list
                carsList.add(cars);
            } while (cursor.moveToNext());
        }

// return contact list
        return carsList;
    }
    // Getting cars Count
    public int getCarsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CARS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

// return count
        return cursor.getCount();
    }
    // Updating a cars
    public int updateCars(Cars cars) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FITNESS, cars.getFitness());
        values.put(KEY_REPORT, cars.getReport());
        values.put(KEY_TAX, cars.getTax());
        values.put(KEY_ADDR, cars.getAddress());
        values.put(KEY_CAR_NUMBER, cars.getCar_number());

// updating row
        return db.update(TABLE_CARS, values, KEY_CAR_NUMBER + " = ?",
                new String[]{String.valueOf(cars.getCar_number())});
    }

    // Deleting a cars
    public void deleteCars(Cars cars) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CARS, KEY_CAR_NUMBER + " = ?",
                new String[] { String.valueOf(cars.getCar_number()) });
        db.close();
    }
}
