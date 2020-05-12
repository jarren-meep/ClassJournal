package com.myapplicationdev.android.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class info extends AppCompatActivity {
    int requestAdd = 2;
    int requestInternet = 3;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<String> grades;
    Button btnEmail, btnAdd, btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        btnEmail = findViewById(R.id.buttonEmail);
        btnAdd = findViewById(R.id.buttonAdd);
        btnInfo = findViewById(R.id.buttonInfo);

        grades = new ArrayList<>();

        Intent i = getIntent();
        final module a = (module) i.getSerializableExtra("module");
        final ArrayList<String> b = a.getDailyGrade();
        for(int c =0; c < b.size(); c++){
            grades.add(b.get(c));
        }
        lv = this.findViewById(R.id.ListViewDailyGrade);

        aa = new CAdapterInfo(this, R.layout.row, grades);
        lv.setAdapter(aa);

        btnEmail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String gradeComment = "";
                for(int c =0; c < b.size(); c++){
                    gradeComment += "Week " + (c+1) + ": " + b.get(c) + "\n";
                }
                String msg = "Hi faci,\n\nI am ...\nPlease see my remarks so far,thank you!\n\n" + gradeComment;
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{a.getEmail()});
                email.putExtra(Intent.EXTRA_SUBJECT,"Test Email from C347");
                email.putExtra(Intent.EXTRA_TEXT, msg);
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }});

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(info.this, add.class);
                i.putExtra("module", a);
                startActivityForResult(i, requestAdd);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                if(a.getName().equalsIgnoreCase("C347")){
                    i.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C347"));
                }else if(a.getName().equalsIgnoreCase("C203")){
                    i.setData(Uri.parse("https://www.rp.edu.sg/schools-courses/courses/full-time-diplomas/full-time-courses/modules/index/C203"));
                }
                startActivityForResult(i, requestInternet);
            }
        });
    }
}
