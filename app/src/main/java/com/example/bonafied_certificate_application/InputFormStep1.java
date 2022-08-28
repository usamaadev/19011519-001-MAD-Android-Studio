package com.example.bonafied_certificate_application;

import android.annotation.SuppressLint;
import android.content.Context;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InputFormStep1 extends AppCompatActivity {

    Button save_record, add_dummy;
    EditText student_name, father_name, cnic_no, address,
            ptcl_no, cell_no, uog_email, personal_email, degree_title, roll_no, registration_no, session,
            campus_name, department_name, faculty_name, challan_no, challan_date, degree_status;
    int pos = -1;

    @SuppressLint("ResourceType")
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
        add_dummy = findViewById(R.id.button_dummy_data);
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
//                Student newStudent = new Student(
//                        student_name.getText().toString(),
//                        father_name.getText().toString(),
//                        dropdown_gender.getSelectedItemPosition(),
//                        dropdown_marital_status.getSelectedItemPosition(),
//                        dropdown_religion.getSelectedItemPosition(),
//                        dropdown_blood_group.getSelectedItemPosition(),
//                        cnic_no.getText().toString(),
//                        address.getText().toString(),
//                        ptcl_no.getText().toString(),
//                        cell_no.getText().toString(),
//                        uog_email.getText().toString(),
//                        personal_email.getText().toString(),
//                        degree_title.getText().toString(),
//                        roll_no.getText().toString(),
//                        registration_no.getText().toString(),
//                        Integer.parseInt(session.getText().toString()),
//                        dropdown_program.getSelectedItemPosition(),
//                        campus_name.getText().toString(),
//                        department_name.getText().toString(),
//                        faculty_name.getText().toString(),
//                        Integer.parseInt(challan_no.getText().toString()),
//                        challan_date.getText().toString(),
//                        degree_status.getText().toString()
//                );

                Intent intent = new Intent();
//                intent.putExtra("newStudentObject", newStudent);
//
                intent.putExtra("student_name", student_name.getText().toString());
                intent.putExtra("father_name", father_name.getText().toString());
                intent.putExtra("gender", String.valueOf(dropdown_gender.getSelectedItemPosition()));
                intent.putExtra("marital_status", String.valueOf(dropdown_marital_status.getSelectedItemPosition()));
                intent.putExtra("religion", String.valueOf(dropdown_religion.getSelectedItemPosition()));
                intent.putExtra("blood_group", String.valueOf(dropdown_blood_group.getSelectedItemPosition()));
                intent.putExtra("cnic_no", cnic_no.getText().toString());
                intent.putExtra("address", address.getText().toString());
                intent.putExtra("ptcl_no", ptcl_no.getText().toString());
                intent.putExtra("cell_no", cell_no.getText().toString());
                intent.putExtra("uog_email", uog_email.getText().toString());
                intent.putExtra("personal_email", personal_email.getText().toString());
                intent.putExtra("degree_title", degree_title.getText().toString());
                intent.putExtra("roll_no", roll_no.getText().toString());
                intent.putExtra("registration_no", registration_no.getText().toString());
                intent.putExtra("session", session.getText().toString());
                intent.putExtra("program", String.valueOf(dropdown_program.getSelectedItemPosition()));
                intent.putExtra("campus_name", campus_name.getText().toString());
                intent.putExtra("department_name", department_name.getText().toString());
                intent.putExtra("faculty_name", faculty_name.getText().toString());
                intent.putExtra("challan_no", challan_no.getText().toString());
                intent.putExtra("challan_date", challan_date.getText().toString());
                intent.putExtra("degree_status", degree_status.getText().toString());

                InputFormStep1.this.setResult(RESULT_OK, intent);
                InputFormStep1.this.finish();
            }
        });


//        dummy inserter
        add_dummy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                student_name.setText("Student-Name");
                father_name.setText("Fname");
                cnic_no.setText("3430125874458");
                address.setText("Gujrat,Punjab");
                ptcl_no.setText("042158415");
                cell_no.setText("0300241564");
                uog_email.setText("email@uog.com");
                personal_email.setText("email@gmail.com");
                degree_title.setText("Degree");
                roll_no.setText("19011519-001");
                registration_no.setText("ds01254");
                session.setText("2023");
                campus_name.setText("HH");
                department_name.setText("CS");
                faculty_name.setText("CS&IT");
                challan_no.setText("2124");
                challan_date.setText("10/10/2019");
                degree_status.setText("Cont.");

            }
        });


//        Student stuData = getIntent().getParcelableExtra("data");
        pos = getIntent().getIntExtra("pos",-1);


        if(pos!=-1){
            Toast.makeText(InputFormStep1.this, "Data got!", Toast.LENGTH_SHORT).show();

            String estudent_name = getIntent().getStringExtra("student_name");
            String efather_name = getIntent().getStringExtra("father_name");
            int egender = getIntent().getIntExtra("gender",0);
            int emarital_status = getIntent().getIntExtra("marital_status",0);
            int ereligion = getIntent().getIntExtra("religion",0);
            int eblood_group = getIntent().getIntExtra("blood_group",0);
            String ecnic_no = getIntent().getStringExtra("cnic_no");
            String eaddress = getIntent().getStringExtra("address");
            String eptcl_no = getIntent().getStringExtra("ptcl_no");
            String ecell_no = getIntent().getStringExtra("cell_no");
            String euog_email = getIntent().getStringExtra("uog_email");
            String epersonal_email = getIntent().getStringExtra("personal_email");
            String edegree_title = getIntent().getStringExtra("degree_title");
            String eroll_no = getIntent().getStringExtra("roll_no");
            String eregistration_no = getIntent().getStringExtra("registration_no");
            int esession = getIntent().getIntExtra("session",0);
            int eprogram = getIntent().getIntExtra("program",0);
            String ecampus_name = getIntent().getStringExtra("campus_name");
            String edepartment_name = getIntent().getStringExtra("department_name");
            String efaculty_name = getIntent().getStringExtra("faculty_name");
            int echallan_no = getIntent().getIntExtra("challan_no",0);
            String echallan_date = getIntent().getStringExtra("challan_date");
            String edegree_status = getIntent().getStringExtra("degree_status");

//

            student_name.setText(estudent_name);
            father_name.setText(efather_name);
            cnic_no.setText(ecnic_no);
            address.setText(eaddress);
            ptcl_no.setText(eptcl_no);
            cell_no.setText(ecell_no);
            uog_email.setText(euog_email);
            personal_email.setText(epersonal_email);
            degree_title.setText(edegree_title);
            roll_no.setText(eroll_no);
            registration_no.setText(eregistration_no);
            session.setText(esession);
            campus_name.setText(ecampus_name);
            department_name.setText(edepartment_name);
            faculty_name.setText(efaculty_name);
            challan_no.setText(echallan_no);
            challan_date.setText(echallan_date);
            degree_status.setText(edegree_status);

            dropdown_gender.setSelection(egender);
            dropdown_blood_group.setSelection(eblood_group);
            dropdown_program.setSelection(eprogram);
            dropdown_marital_status.setSelection(emarital_status);
            dropdown_religion.setSelection(ereligion);


        }

    }




}