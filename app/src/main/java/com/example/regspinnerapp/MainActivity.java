package com.example.regspinnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerSubjects;
    private RadioButton radioButtonStudent;
    private RadioButton radioButtonTeacher;
    private CheckBox checkBoxBachelor;
    private CheckBox checkBoxMaster;
    private CheckBox checkBoxPHD;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerSubjects = findViewById(R.id.spinner_subjects);
        radioButtonStudent = findViewById(R.id.radio_student);
        radioButtonTeacher = findViewById(R.id.radio_teacher);
        checkBoxBachelor = findViewById(R.id.checkbox_bachelor);
        checkBoxMaster = findViewById(R.id.checkbox_master);
        checkBoxPHD = findViewById(R.id.checkbox_phd);
        buttonSubmit = findViewById(R.id.button_submit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.subjects_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubjects.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedSubject = spinnerSubjects.getSelectedItem().toString();

                String selectedSenderType = radioButtonStudent.isChecked() ? "Student" : "Teacher";

                ArrayList<String> selectedQualifications = new ArrayList<>();
                if(checkBoxBachelor.isChecked()){
                    selectedQualifications.add("Bachelor");
                }
                if(checkBoxMaster.isChecked()){
                    selectedQualifications.add("Master");
                }

                if(checkBoxPHD.isChecked()){
                    selectedQualifications.add("PHD");
                }

                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                intent.putExtra("subject", selectedSubject);
                intent.putExtra("senderType", selectedSenderType);
                intent.putStringArrayListExtra("qualifications", selectedQualifications);
                startActivity(intent);


            }
        });
    }
}