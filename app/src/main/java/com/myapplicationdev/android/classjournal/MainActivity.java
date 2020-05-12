package com.myapplicationdev.android.classjournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int requestModuleInfo = 1;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<module> mods;
    ArrayList<String> dailyGrade1;
    ArrayList<String> dailyGrade2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = this.findViewById(R.id.ListViewModules);

        mods = new ArrayList<>();
        dailyGrade1 = new ArrayList<>();
        dailyGrade2 = new ArrayList<>();

        dailyGrade1.add("B");
        dailyGrade1.add("C");
        dailyGrade1.add("A");

        dailyGrade2.add("A");
        dailyGrade2.add("B");
        dailyGrade2.add("C");

        mods.add(new module("Web Services", "C203", dailyGrade1, "jason_lim@rp.edu.sg"));

        mods.add(new module("Android Programming II", "C347", dailyGrade2, "jason_lim@rp.edu.sg"));

        aa = new CAdapter2(this, R.layout.row, mods);
        lv.setAdapter(aa);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, info.class);
                i.putExtra("module", mods.get(position));
                startActivityForResult(i, requestModuleInfo);
            }
        });

    }
}
