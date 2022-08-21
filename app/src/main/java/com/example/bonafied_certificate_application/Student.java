package com.example.bonafied_certificate_application;

import java.util.Date;

public class Student {
    public String student_name;
    public String father_name;
    public int gender;
    public int marital_status;
    public int religion;
    public int blood_group;
    public String cnic_no;
    public String address;
    public String ptcl_no;
    public String cell_no;
    public String uog_email;
    public String personal_email;
    public String degree_title;
    public String roll_no;
    public String registration_no;

    public String getRoll_no() {
        return roll_no;
    }

    public int session;
    public int program;
    public String campus_name;
    public String department_name;
    public String faculty_name;
    public int challan_no;
    public String challan_date;
    public String degree_status;

    public Student(
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


    ) {

        this.student_name = student_name;
        this.father_name = father_name;
        this.gender = gender;
        this.marital_status = marital_status;
        this.religion = religion;
        this.blood_group = blood_group;
        this.cnic_no = cnic_no;
        this.address = address;
        this.ptcl_no = ptcl_no;
        this.cell_no = cell_no;
        this.uog_email = uog_email;
        this.personal_email = personal_email;
        this.degree_title = degree_title;
        this.roll_no = roll_no;
        this.registration_no = registration_no;
        this.session = session;
        this.program = program;
        this.campus_name = campus_name;
        this.department_name = department_name;
        this.faculty_name = faculty_name;
        this.challan_no = challan_no;
        this.challan_date = challan_date;
        this.degree_status = degree_status;

    }

    @Override
    public String toString() {
        return "Student{" +
                "student_name='" + student_name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", gender='" + gender + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", religion='" + religion + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", cnic_no='" + cnic_no + '\'' +
                ", address='" + address + '\'' +
                ", ptcl_no='" + ptcl_no + '\'' +
                ", cell_no='" + cell_no + '\'' +
                ", uog_email='" + uog_email + '\'' +
                ", personal_email='" + personal_email + '\'' +
                ", degree_title='" + degree_title + '\'' +
                ", roll_no='" + roll_no + '\'' +
                ", registration_no='" + registration_no + '\'' +
                ", session='" + session + '\'' +
                ", program='" + program + '\'' +
                ", campus_name='" + campus_name + '\'' +
                ", department_name='" + department_name + '\'' +
                ", faculty_name='" + faculty_name + '\'' +
                ", challan_no='" + challan_no + '\'' +
                ", challan_date='" + challan_date + '\'' +
                ", degree_status='" + degree_status + '\'' +
                '}';
    }
}
