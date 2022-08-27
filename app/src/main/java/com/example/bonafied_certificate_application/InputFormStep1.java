package com.example.bonafied_certificate_application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InputFormStep1 extends AppCompatActivity {

    Button save_record, delete_record;
    EditText  student_name,  father_name,   cnic_no,  address,
     ptcl_no,  cell_no,  uog_email,  personal_email,  degree_title,  roll_no,  registration_no,  session,
      campus_name,  department_name,  faculty_name,  challan_no,  challan_date,  degree_status;
    TextView temp;

//    Spinner gender,  marital_status,  religion,  blood_group, program;

    public static List<Student> student = new ArrayList<>();
    DBMS db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_form_step1);


        //GENDER DROPDOWN
        Spinner dropdown_gender = findViewById(R.id.spinner_gender);
        String[] items_dropdown_gender = new String[]{"MALE", "FEMALE", "Other"};
        ArrayAdapter<String> adapter_dropdown_gender = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items_dropdown_gender);
        dropdown_gender.setAdapter(adapter_dropdown_gender);

        //DROPDOWN MARITAL STATUS
        Spinner dropdown_marital_status = findViewById(R.id.spinner_marital_status);
        String[] items_marital_status = new String[]{"SINGLE", "MARRIED", "Other"};
        ArrayAdapter<String> adapter_marital_status = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items_marital_status);
        dropdown_marital_status.setAdapter(adapter_marital_status);

        //DROPDOWN RELIGION
        Spinner dropdown_religion = findViewById(R.id.spinner_religion);
        String[] items_religion = new String[]{"ISLAM", "CHRIST", "Other"};
        ArrayAdapter<String> adapter_religion = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items_religion);
        dropdown_religion.setAdapter(adapter_religion);

        //DROPDOWN BLOOD GROUP
        Spinner dropdown_blood_group = findViewById(R.id.spinner_blood_group);
        String[] items_blood_group = new String[]{"A-", "A+", "B-", "B+", "O-", "O+", "AB-", "AB+"};
        ArrayAdapter<String> adapter_blood_group = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items_blood_group);
        dropdown_blood_group.setAdapter(adapter_blood_group);

        //DROPDOWN PROGRAM
        Spinner dropdown_program = findViewById(R.id.spinner_program);
        String[] items_program = new String[]{"BS", "MS", "PHD",};
        ArrayAdapter<String> adapter_program = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items_program);
        dropdown_program.setAdapter(adapter_program);

        //
        save_record = findViewById(R.id.btn_save_form);

        student_name = findViewById(R.id.txt_stu_name);
        father_name = findViewById(R.id.txt_father_name);
        cnic_no = findViewById(R.id.txt_cnic_no);
        address = findViewById(R.id.txt_address);
        ptcl_no = findViewById(R.id.txt_ptcl_no);
        cell_no = findViewById(R.id.txt_cell_no);
        uog_email = findViewById(R.id.txt_uog_email);
        personal_email = findViewById(R.id.txt_personal_email);
        degree_title = findViewById(R.id.txt_degree_title);
        roll_no = findViewById(R.id.txt_roll_no);
        registration_no = findViewById(R.id.txt_registration_no);
        session = findViewById(R.id.txt_session);
        campus_name = findViewById(R.id.txt_campus_name);
        department_name = findViewById(R.id.txt_dept_name);
        faculty_name = findViewById(R.id.txt_faculty_name);
        challan_no = findViewById(R.id.txt_challan_no);
        challan_date = findViewById(R.id.txt_challan_date);
        degree_status = findViewById(R.id.txt_degree_status);

        save_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent();

                intent.putExtra("student_name", student_name.getText().toString());
                intent.putExtra("father_name",  father_name.getText().toString());

                intent.putExtra("gender",String.valueOf(dropdown_gender.getSelectedItemPosition()));
                intent.putExtra("marital_status", String.valueOf(dropdown_marital_status.getSelectedItemPosition()));
                intent.putExtra("religion", String.valueOf(dropdown_religion.getSelectedItemPosition()));
                intent.putExtra("blood_group", String.valueOf(dropdown_blood_group.getSelectedItemPosition()));

//                intent.putExtra("gender","0");
//                intent.putExtra("marital_status", "2");
//                intent.putExtra("religion", "2");
//                intent.putExtra("blood_group", "2");

                intent.putExtra("cnic_no",cnic_no.getText().toString());
                intent.putExtra("address",address.getText().toString());
                intent.putExtra("ptcl_no",ptcl_no.getText().toString());
                intent.putExtra("cell_no",cell_no.getText().toString());
                intent.putExtra("uog_email",uog_email.getText().toString());
                intent.putExtra("personal_email",personal_email.getText().toString());
                intent.putExtra("degree_title",degree_title.getText().toString());
                intent.putExtra("roll_no",roll_no.getText().toString());
                intent.putExtra("registration_no",registration_no.getText().toString());
                intent.putExtra("session",session.getText().toString());

//                intent.putExtra("program","2");

                intent.putExtra("program",String.valueOf(dropdown_program.getSelectedItemPosition()));
                intent.putExtra("campus_name",campus_name.getText().toString());
                intent.putExtra("department_name",department_name.getText().toString());
                intent.putExtra("faculty_name",faculty_name.getText().toString());

                intent.putExtra("challan_no",challan_no.getText().toString());

                intent.putExtra("challan_date",challan_date.getText().toString());
                intent.putExtra("degree_status",degree_status.getText().toString());

                InputFormStep1.this.setResult(RESULT_OK, intent);
                InputFormStep1.this.finish();
            }
        });








    }

}
