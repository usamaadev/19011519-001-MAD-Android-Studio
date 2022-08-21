package com.example.bonafied_certificate_application;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    RecyclerView recycler_view;
    StudentAdapter adapter;
    FloatingActionButton fab;
    DBMS db;
    List<Student> list = new ArrayList<>();
    Button  delete_record;
    EditText txt_roll_no_to_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Cursor cursor = new  DBMS(this).viewUserData();
        db = new DBMS(this);
        while (cursor.moveToNext()){
            Student obj = new Student(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    cursor.getString(13),
                    cursor.getString(14),
                    cursor.getInt(15),
                    cursor.getInt(16),
                    cursor.getString(17),
                    cursor.getString(18),
                    cursor.getString(19),
                    cursor.getInt(20),
                    cursor.getString(21),
                    cursor.getString(22));
            list.add(obj);

        }


        recycler_view = findViewById(R.id.recycler_view);
        setRecyclerView();

        fab = findViewById(R.id.FAB_Add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InputFormStep1.class);
                startActivityForResult(intent,345);

            }
        });

        delete_record = findViewById(R.id.btn_delete);
        txt_roll_no_to_delete = findViewById(R.id.txt_get_roll_no_for_delete);
        delete_record.setOnClickListener(v -> {

            String roll_no_to_delete = txt_roll_no_to_delete.getText().toString();

            int listLenght = list.size();
            for (int i = 0; i < listLenght; i++) {
                if (list.get(i).getRoll_no().contains(roll_no_to_delete)) {



                    Boolean isDeleteSuccess = db.deleteUserData(roll_no_to_delete);
                    if(isDeleteSuccess){
                        list.remove(i);
                        adapter.notifyItemRemoved(i);
                        adapter.notifyItemRangeChanged(i,listLenght);
                        Toast.makeText(HomeActivity.this, "Record deleted!!", Toast.LENGTH_SHORT).show();
                        txt_roll_no_to_delete.setText("");
                    }
                }
            }
        });

    }

    private void setRecyclerView() {
        recycler_view.setHasFixedSize(true);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentAdapter(this, list);
        recycler_view.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 345 )
        {
            if(resultCode != RESULT_CANCELED) {

                String student_name = data.getStringExtra("student_name");
                String father_name = data.getStringExtra("father_name");
                String gender = data.getStringExtra("gender");
                String marital_status = data.getStringExtra("marital_status");
                String religion = data.getStringExtra("religion");
                String blood_group = data.getStringExtra("blood_group");
                String cnic_no = data.getStringExtra("cnic_no");
                String address = data.getStringExtra("address");
                String ptcl_no = data.getStringExtra("ptcl_no");
                String cell_no = data.getStringExtra("cell_no");
                String uog_email = data.getStringExtra("uog_email");
                String personal_email = data.getStringExtra("personal_email");
                String degree_title = data.getStringExtra("degree_title");
                String roll_no = data.getStringExtra("roll_no");
                String registration_no = data.getStringExtra("registration_no");
                String session = data.getStringExtra("session");
                String program = data.getStringExtra("program");
                String campus_name = data.getStringExtra("campus_name");
                String department_name = data.getStringExtra("department_name");
                String faculty_name = data.getStringExtra("faculty_name");
                String challan_no = data.getStringExtra("challan_no");
                String challan_date = data.getStringExtra("challan_date");
                String degree_status = data.getStringExtra("degree_status");

                list.add(new Student(
                         student_name,  father_name
                        ,
                        Integer.parseInt(gender),  Integer.parseInt(marital_status),  Integer.parseInt(religion),  Integer.parseInt(blood_group),  cnic_no,  address,
                         ptcl_no,  cell_no,  uog_email,  personal_email,  degree_title,  roll_no,  registration_no,  Integer.parseInt(session),
                        Integer.parseInt(program),  campus_name,  department_name,  faculty_name,  Integer.parseInt(challan_no),  challan_date,  degree_status


                ));

               Boolean checkInsertData = db.insertUserData(
                        student_name,  father_name,
                       Integer.parseInt(gender),  Integer.parseInt(marital_status), Integer.parseInt(religion),  Integer.parseInt(blood_group),  cnic_no,  address,
                        ptcl_no,  cell_no,  uog_email,  personal_email,  degree_title,  roll_no,  registration_no,   Integer.parseInt(session),
                        Integer.parseInt(program),  campus_name,  department_name,  faculty_name,   Integer.parseInt(challan_no),  challan_date,  degree_status

                );



                Log.d("data-1", "onCreate: " +checkInsertData);

                if (checkInsertData){
                    Toast.makeText(HomeActivity.this, "Data Inserted Successfully!", Toast.LENGTH_SHORT).show();
                }
                if(!checkInsertData) {
                    Toast.makeText(HomeActivity.this, "Data Not Inserted!", Toast.LENGTH_SHORT).show();
                }

                adapter.notifyDataSetChanged();
            }
        }


    }


}
