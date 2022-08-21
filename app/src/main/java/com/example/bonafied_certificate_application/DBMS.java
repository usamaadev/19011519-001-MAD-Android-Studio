package com.example.bonafied_certificate_application;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBMS extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student_Bonafied_DB2";

    public DBMS(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table StudentDetails (student_name TEXT PRIMARY KEY, " +
                "father_name TEXT, gender TEXT, marital_status TEXT, religion TEXT, " +
                "blood_group TEXT, cnic_no TEXT, address TEXT,ptcl_no TEXT,cell_no TEXT,uog_email TEXT,personal_email TEXT,degree_title TEXT,roll_no TEXT,registration_no TEXT,session TEXT, program TEXT, " +
                "campus_name TEXT, department_name TEXT,faculty_name TEXT,challan_no TEXT," +
                "challan_date TEXT,degree_status TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop TABLE if exists StudentDetails");
    }

    public boolean insertUserData(

            String student_name,
            String father_name,
            int gender,
            int marital_status,
            int religion,
            int blood_group,
            String cnic_no,
            String address,
            String ptcl_no,
            String cell_no,
            String uog_email,
            String personal_email,
            String degree_title,
            String roll_no,
            String registration_no,
            int session,
            int program,
            String campus_name,
            String department_name,
            String faculty_name,
            int challan_no,
            String challan_date,
            String degree_status

    ){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("student_name", student_name);
        contentValues.put("father_name", father_name);
        contentValues.put("gender", gender);
        contentValues.put("marital_status", marital_status);
        contentValues.put("religion", religion);
        contentValues.put("blood_group", blood_group);
        contentValues.put("cnic_no", cnic_no);
        contentValues.put("address", address);
        contentValues.put("ptcl_no", ptcl_no);
        contentValues.put("cell_no", cell_no);
        contentValues.put("uog_email", uog_email);
        contentValues.put("personal_email", personal_email);
        contentValues.put("degree_title", degree_title);
        contentValues.put("address", address);
        contentValues.put("roll_no", roll_no);
        contentValues.put("registration_no", registration_no);
        contentValues.put("session", session);
        contentValues.put("program", program);
        contentValues.put("campus_name", campus_name);
        contentValues.put("department_name", department_name);
        contentValues.put("faculty_name", faculty_name);
        contentValues.put("challan_no", challan_no);
        contentValues.put("challan_date", challan_date);
        contentValues.put("degree_status", degree_status);



        //MyDB.insert("FormDetails", null, contentValues);
        long result = MyDB.insert("StudentDetails", null, contentValues);
        Log.d("data-1", "ininsert: " +result);
        Log.d("data-1", "ininsert: " +contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

//    public boolean updateUserData(String Name, String SoORdo, String RegistrationNo, String RollNo,
//                                  String Department, String Program, String DegreeStatus, String CGPA,
//                                  String InstituteWhereStudied, String InstituteMigratedTo, String NocDepositedFee, String ChallanNo,
//                                  String DepositDate,String Address,String MobileNo,String LandlineOrPTCl,String MobileOfGuardian, String  ModeOfReceive){
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//
//        contentValues.put("Name", Name);
//        contentValues.put("SoORdo", SoORdo);
//        contentValues.put("RegistrationNo", RegistrationNo);
//        contentValues.put("RollNo", RollNo);
//        contentValues.put("Department", Department);
//        contentValues.put("Program", Program);
//        contentValues.put("DegreeStatus", DegreeStatus);
//        contentValues.put("CGPA", CGPA);
//        contentValues.put("InstituteWhereStudied", InstituteWhereStudied);
//        contentValues.put("InstituteMigratedTo", InstituteMigratedTo);
//        contentValues.put("NocDepositedFee", NocDepositedFee);
//        contentValues.put("ChallanNo", ChallanNo);
//        contentValues.put("DepositDate", DepositDate);
//        contentValues.put("Address", Address);
//        contentValues.put("MobileNo", MobileNo);
//        contentValues.put("LandlineOrPTCl", LandlineOrPTCl);
//        contentValues.put("MobileOfGuardian", MobileOfGuardian);
//        contentValues.put("ModeOfReceive", ModeOfReceive);
//
//        Cursor cursor = MyDB.rawQuery("Select * from FormDetails where RollNo = ?", new String[] {RollNo});
//
//        if (cursor.getCount() > 0) {
//            long result = MyDB.update("FormDetails", contentValues, "RollNo=?", new String[]{RollNo});
//            if (result == -1)
//                return false;
//            else
//                return true;
//        }else {
//            return false;
//        }
//    }

    public boolean deleteUserData(String rollNotodel){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from StudentDetails where roll_no = ?", new String[] {rollNotodel});

        if (cursor.getCount() > 0) {
            Log.d("data-1", "onCreate: " +"enter del sql method");
            long result = MyDB.delete("StudentDetails", "roll_no=?", new String[] {rollNotodel});
            Log.d("data-1", "onCreate: " +"executed del sql method");
            if (result == -1)
                return false;
            else
                return true;
        }else {
            return false;
        }
    }


    public Cursor viewUserData(){
        SQLiteDatabase MyDB = this.getWritableDatabase();

        Cursor cursor = MyDB.rawQuery("Select * from StudentDetails", null);
        return cursor;
    }


//    public List<Student> ToObject(Cursor cursor){
//        List<Student> mylist = new ArrayList<>();
//        while (cursor.moveToNext()){
//            Student obj = new Student(
//                    cursor.getString(0),
//                    cursor.getString(1),
//                    cursor.getInt(2),
//                    cursor.getInt(3),
//                    cursor.getInt(4),
//                    cursor.getInt(5),
//                    cursor.getString(6),
//                    cursor.getString(7),
//                    cursor.getString(8),
//                    cursor.getString(9),
//                    cursor.getString(10),
//                    cursor.getString(11),
//                    cursor.getString(12),
//                    cursor.getString(13),
//                    cursor.getString(14),
//                    cursor.getInt(15),
//                    cursor.getInt(16),
//                    cursor.getString(17),
//                    cursor.getString(18),
//                    cursor.getString(19),
//                    cursor.getInt(20),
//                    cursor.getString(21),
//                    cursor.getString(22));
//
//
//
//            mylist.add(obj);
//
//        }
//        return mylist;
//    }
}
