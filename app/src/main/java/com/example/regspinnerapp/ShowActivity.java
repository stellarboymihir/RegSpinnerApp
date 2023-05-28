package com.example.regspinnerapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    private TextView textViewSubject;
    private TextView textViewSenderType;
    private TextView textViewQualifications;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        textViewSubject = findViewById(R.id.text_subject);
        textViewSenderType = findViewById(R.id.text_sender_type);
        textViewQualifications = findViewById(R.id.text_qualifications);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String subject = extras.getString("subject");
            String senderType = extras.getString("senderType");

            ArrayList<String> qualifications = extras.getStringArrayList("qualifications");

            textViewSubject.setText((subject));
            textViewSenderType.setText(senderType);
            textViewQualifications.setText(qualifications.toString());
        }


    }
}
