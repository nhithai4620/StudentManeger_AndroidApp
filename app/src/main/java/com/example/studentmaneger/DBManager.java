package com.example.studentmaneger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    public final String TAG =  "DBManager";
    public static final String DATABASE_NAME = "student_manager";
    public static final String TABLE_NAME = "student";
    public static final String NAME = "name";
    public static final String BIRTH = "birth";
    public static final String ID = "id";
    public static final String NUMBER = "number";
    public static final String SEX = "sex";
    public static final String ADDRESS = "address";
    public static final String VAODOAN = "vaodoan";
    private Context context;
    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
        Log.d(TAG,"DBMANAGER");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" ("+
                NAME + " TEXT, "+
                BIRTH + " TEXT, "+
                ID + " TEXT, "+
                NUMBER + " TEXT, "+
                SEX + " TEXT, "+
                ADDRESS + " TEXT, "+
                VAODOAN + " TEXT) ";
        db.execSQL(sqlQuery);
        Log.d(TAG,"onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        Log.d(TAG,"onUpgrade");
    }
    public void addStudent(Student student){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,student.getName());
        values.put(BIRTH,student.getBirth());
        values.put(ID,student.getID());
        values.put(NUMBER,student.getNumber());
        values.put(SEX,student.getSex());
        values.put(ADDRESS,student.getAddress());
        values.put(VAODOAN,student.getVaoDoan());
        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d(TAG,"add Student successfully");

    }
    public int updateSudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,student.getName());
        values.put(BIRTH,student.getBirth());
        values.put(ID,student.getID());
        values.put(NUMBER,student.getNumber());
        values.put(SEX,student.getSex());
        values.put(ADDRESS,student.getAddress());
        values.put(VAODOAN,student.getVaoDoan());
        return db.update(TABLE_NAME,values,ID +"=?",new String[]{String.valueOf(student.getID())});
    }
    public void deleteStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,ID +"=?",new String[]{String.valueOf(id)});
    }
    public List<Student> getAllStudent(){
        List<Student> listStudent = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=  db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                Student student = new Student();
                student.setName(cursor.getString(0));
                student.setBirth(cursor.getString(1));
                student.setID(cursor.getString(2));
                student.setNumber(cursor.getString(3));
                student.setSex(cursor.getString(4));
                student.setAddress(cursor.getString(5));
                student.setVaoDoan(cursor.getString(6));
                listStudent.add(student);
            }while(cursor.moveToNext());
        }
        db.close();
        return listStudent;

    }


}
