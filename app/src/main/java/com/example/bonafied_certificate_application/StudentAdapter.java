package com.example.bonafied_certificate_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    Context context;
    public List<Student> student_list;

    public StudentAdapter(Context context, List<Student> student_list){
        this.context = context;
        this.student_list = student_list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_record_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        if (student_list != null && student_list.size() > 0) {

            String gender = "";
            int genderInt =   student_list.get(position).gender;
            if(genderInt==0){
                gender = "MALE";
            }else if (genderInt == 1){
                gender = "FEMALE";
            }else if(genderInt == 2){
                gender = "OTHER";
            }

            String marital_status = "";
            int marital_statusInt =   student_list.get(position).marital_status;
            if(marital_statusInt==0){
                marital_status = "SINGLE";
            }else if (marital_statusInt == 1){
                marital_status = "MARRIED";
            }else if(marital_statusInt == 2){
                marital_status = "OTHER";
            }

            String religion = "";
            int religionInt =   student_list.get(position).religion;
            if(religionInt == 0){
                religion = "ISLAM";
            }else if (religionInt == 1){
                religion = "CHRIST";
            }else if(religionInt == 2){
                religion = "OTHER";
            }

            String program = "";
            int programInt =   student_list.get(position).program;
            if(programInt == 0){
                program = "BS";
            }else if (programInt == 1){
                program = "MS";
            }else if(programInt == 2){
                program = "PHD";
            }

            String blood_group = "";
            int blood_groupInt =   student_list.get(position).blood_group;
            if(blood_groupInt == 0){
                blood_group = "A-";
            }else if (blood_groupInt == 1){
                blood_group = "A+";
            }else if(blood_groupInt == 2){
                blood_group = "B-";
            }else if(blood_groupInt == 3){
                blood_group = "B+";
            }else if(blood_groupInt == 4){
                blood_group = "O-";
            }else if(blood_groupInt == 5){
                blood_group = "O+";
            }else if(blood_groupInt == 6){
                blood_group = "AB-";
            }else if(blood_groupInt == 7){
                blood_group = "AB+";
            }

            holder.tv_sr_no.setText(String.valueOf(position));
            holder.tv_roll_no.setText(student_list.get(position).roll_no);
            holder.tv_name.setText(student_list.get(position).student_name);
            holder.tv_father_name.setText(student_list.get(position).father_name);
            holder.tv_registration_no.setText(student_list.get(position).registration_no);

//            holder.tv_gender.setText(String.valueOf(student_list.get(position).gender));
            holder.tv_gender.setText(gender);

            holder.tv_cnic_no.setText(student_list.get(position).cnic_no);
            holder.tv_address.setText(student_list.get(position).address);

//            holder.tv_marital_status.setText(String.valueOf( student_list.get(position).marital_status));
            holder.tv_marital_status.setText(marital_status);

            holder.tv_religion.setText(religion);
//            holder.tv_religion.setText(String.valueOf(student_list.get(position).religion));

//            holder.tv_blood_group.setText(String.valueOf(student_list.get(position).blood_group));
            holder.tv_blood_group.setText(blood_group);

            holder.tv_ptcl_no.setText(student_list.get(position).ptcl_no);
            holder.tv_cell_no.setText(student_list.get(position).cell_no);
            holder.tv_uog_email.setText(student_list.get(position).uog_email);
            holder.tv_personal_email.setText(student_list.get(position).personal_email);
            holder.tv_degree_title.setText(student_list.get(position).degree_title);
            holder.tv_session.setText(String.valueOf( student_list.get(position).session));

            holder.tv_program.setText(program);
//            holder.tv_program.setText(String.valueOf(student_list.get(position).program));

            holder.tv_campus_name.setText(student_list.get(position).campus_name);
            holder.tv_department_name.setText(student_list.get(position).department_name);
            holder.tv_faculty_name.setText(student_list.get(position).faculty_name);
            holder.tv_challan_no.setText(String.valueOf(student_list.get(position).challan_no));
            holder.tv_challan_date.setText(student_list.get(position).challan_date);
            holder.tv_degree_status.setText(student_list.get(position).degree_status);
        } else {
            return;
        }
    }

    @Override
    public int getItemCount() {
        return student_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_sr_no, tv_roll_no, tv_name
                , tv_father_name, tv_registration_no, tv_gender,
                tv_cnic_no, tv_address, tv_marital_status, tv_religion, tv_blood_group,
                tv_ptcl_no, tv_cell_no, tv_uog_email,
                tv_personal_email, tv_degree_title, tv_session, tv_program,
                tv_campus_name, tv_department_name, tv_faculty_name, tv_challan_no, tv_challan_date, tv_degree_status;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            tv_roll_no = itemView.findViewById(R.id.tv_roll_no);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_father_name = itemView.findViewById(R.id.tv_father_name);
            tv_registration_no = itemView.findViewById(R.id.tv_registration_no);
            tv_gender = itemView.findViewById(R.id.tv_gender);
            tv_cnic_no = itemView.findViewById(R.id.tv_cnic_no);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_marital_status = itemView.findViewById(R.id.tv_marital_status);
            tv_religion = itemView.findViewById(R.id.tv_religion);
            tv_blood_group = itemView.findViewById(R.id.tv_blood_group);
            tv_ptcl_no = itemView.findViewById(R.id.tv_ptcl_no);
            tv_cell_no = itemView.findViewById(R.id.tv_cell_no);
            tv_uog_email = itemView.findViewById(R.id.tv_uog_email);
            tv_personal_email = itemView.findViewById(R.id.tv_personal_email);
            tv_degree_title = itemView.findViewById(R.id.tv_degree_title);
            tv_session = itemView.findViewById(R.id.tv_session);
            tv_session = itemView.findViewById(R.id.tv_session);
            tv_program = itemView.findViewById(R.id.tv_program);
            tv_campus_name = itemView.findViewById(R.id.tv_campus_name);
            tv_department_name = itemView.findViewById(R.id.tv_department_name);
            tv_faculty_name = itemView.findViewById(R.id.tv_faculty_name);
            tv_challan_no = itemView.findViewById(R.id.tv_challan_no);
            tv_challan_date = itemView.findViewById(R.id.tv_challan_date);
            tv_degree_status = itemView.findViewById(R.id.tv_degree_status);
        }
    }
}
