package com.example.shruti.placeselection2;

/**
 * Created by admin on 11/20/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class Car_MySQLiteHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "BookDB";

    public Car_MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_BOOK_TABLE = "CREATE TABLE books (  " +
                "title TEXT, "+
                "imageId BLOB )";

        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(db);

    }

    private static final String TABLE_BOOKS = "books";


    private static final String KEY_TITLE = "title";

    private static final String KEY_IMAGEID = "imageId";

    private static final String[] COLUMNS = {KEY_TITLE,KEY_IMAGEID};


    public void addBook(CAR book){

        Log.d("addBook", book.toString());


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(KEY_TITLE, book.getTitle());

        values.put(KEY_IMAGEID, book.getImageId());


        db.insert(TABLE_BOOKS,
                null,
                values);

        db.close();
    }
    public List<CAR> getAllBooks() {
        List<CAR> books = new LinkedList<CAR>();
        String query = "SELECT  * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        CAR book = null;
        if (cursor.moveToFirst()) {
            do {
               // book = new CAR("",0,"","");

                book.setTitle(cursor.getString(0));

                book.setImageId(cursor.getInt(1));
                books.add(book);
            } while (cursor.moveToNext());
        }
        Log.d("getAllBooks()", books.toString());
        return books;
    }

}