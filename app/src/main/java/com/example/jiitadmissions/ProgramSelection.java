package com.example.jiitadmissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ProgramSelection extends AppCompatActivity {

    TextView tv_undergrad;
    TextView tv_postgrad;
    TextView tv_doct;

    ListView lv_undergrad;
    ListView lv_postrgrad;
    ListView lv_doct;


    String[] choices1={"JEE Overall Rank based - JIIT / JUIT / JUET / JUJEE Overall Rank based - JIIT / JUIT / JUET / JU",
            "10 + 2 Marks based - JIIT Noida" ,"10 + 2 Marks based - JUIT Waknaghat",
            "10 + 2 Marks based (Only Biotech) - JIIT Noida"};
    String[] choices2={"CAT/MAT/CMAT/XAT/GMAT/ATMA - Jaypee Business School","GATE - JIIT, Noida","PGET - JIIT, Noida"};
    String[] choices3= {"To be announced"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_selection);

        tv_doct= findViewById(R.id.StreamSelection_TextView_Doctorate);
        tv_postgrad= findViewById(R.id.StreamSelection_TextView_PostGrad);
        tv_undergrad= findViewById(R.id.StreamSelection_TextView_Undergrad);
        lv_doct= findViewById(R.id.StreamSelection_ListView_Doct);
        lv_undergrad= findViewById(R.id.StreamSelection_ListView_Undergrad);
        lv_postrgrad= findViewById(R.id.StreamSelection_ListView_Postgrad);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                R.layout.stream_program_list_item, R.id.StreamSelection_ListView_Item,choices1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                R.layout.stream_program_list_item, R.id.StreamSelection_ListView_Item, choices2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                R.layout.stream_program_list_item, R.id.StreamSelection_ListView_Item, choices3);

        lv_postrgrad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nextScreen( "2"+String.valueOf(i));
            }
        });
        lv_undergrad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nextScreen( "1"+String.valueOf(i));
            }
        });
        tv_undergrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_undergrad.setAdapter(adapter1);
            }
        });
        tv_postgrad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_postrgrad.setAdapter(adapter2);
            }
        });
        tv_doct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lv_doct.setAdapter(adapter3);
            }
        });


    }
        public void nextScreen(String str){
            Intent intent= new Intent(this,ProgramInfo.class);
            intent.putExtra("PROGRAM", str);
            startActivity(intent);

    }



}