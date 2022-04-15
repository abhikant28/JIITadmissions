package com.example.jiitadmissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProgramInfo extends AppCompatActivity {

    TextView tv_programName;
    TextView tv_selectionMode;
    TextView tv_about;
    TextView tv_ai;
    TextView tv_ap;
    TextView tv_eligibility;
    TextView tv_shortlisting;
    TextView tv_ac;
    TextView tv_eligibility_detail;
    TextView tv_shortlisting_detail;
    Button b_proceed;

    String programName;
    String selectionMode;
    String about;
    String ai;
    String ap;
    String ac;
    String eligibility="The minimum academic qualification for admission to any one of the programs is as laid down by JEE. The candidate should have a pass in the 10+2 or its equivalent (as defined by JEE) with Physics and Mathematics as compulsory subjects and any one of Chemistry, Biology, Biotechnology, and Computer Science as optional subjects.\n" +
            "All candidates who are offered provisional admission will be required to produce proof of having passed the qualifying examination (10+2 or equivalent) to the University authority latest by September 30, 2022 failing which, such provisional admission will stand cancelled. If the results of qualifying examinations are likely to be declared after September 30, 2022 the candidates are advised to seek admission next year as no representations for extension of dates, for any reason whatsoever, shall be entertained.";
    String shortlisting="The merit amongst applications received for admission to Jaypee Institute(s) shall be drawn based only on the overall All India Rank of JEE (Main)2022 examination.\n" +
            "JEE Score /Ranking in any category or state including general etc shall not be taken into account.\n" +
            "The merit list for SC/ST candidates shall be made by applying the cut off 10% below the total rank (in JEE (main)2022 exam) obtained by the candidate, short listed in the general category.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_info);

        tv_about=findViewById(R.id.ProgramInfo_TextView_About);
        tv_ac=findViewById(R.id.ProgramInfo_TextView_Cost);
        tv_ai=findViewById(R.id.ProgramInfo_TextView_Institutes);
        tv_programName=findViewById(R.id.ProgramInfo_TextView_Title);
        tv_ap=findViewById(R.id.ProgramInfo_TextView_AdmissionProcedure);
        tv_eligibility=findViewById(R.id.ProgramInfo_TextView_Eligibility);
        tv_selectionMode=findViewById(R.id.ProgramInfo_TextView_Mode);
        tv_shortlisting=findViewById(R.id.ProgramInfo_TextView_Shortlisting);
        tv_eligibility_detail=findViewById(R.id.ProgramInfo_TextView_Eligibility_Info);
        tv_shortlisting_detail=findViewById(R.id.ProgramInfo_TextView_Shortlisting_Info);
        b_proceed=findViewById(R.id.ProgramInfo_Button_Proceed);


        String program="NONE";
        Intent intent= getIntent();
        program = intent.getStringExtra("PROGRAM");

        if(program.matches("NONE")){
            finish();
        }
        Log.i("INTENT::PROGRAM:::",program);
        switch (program){
            case "10":
                programName="B. TECH";
                selectionMode= "JEE (MAIN) OVERALL RANK BASED";
                about="For Admission To B.Tech Program Through Merit, Drawn On Overall JEE (Main) All India Rank.";
                ap="Click Here";
                ai="JIIT - Noida (U.P.)/JUIT - Waknaghat (H.P.) / JUET - Guna (M.P.) / JU - Anoopshahr (U.P.)";
                ac= "Rs. 1200/-";
                break;
            case "11":
                programName="B. TECH";
                about="For Merit Based Admission To B.Tech And Integrated M.Tech Programs Based On 10+2 Or Equivalent Score.";
                selectionMode= "(10+2 BASED) - JIIT NOIDA";
                ap="Click Here";
                ai="Jaypee Institute of Information Technology";
                ac= "Rs. 1200/-";
                break;
            case "12":
                programName="B. TECH";
                selectionMode= "(10+2 BASED) - JUIT WAKNAGHAT";
                about="For Merit Based Admission To B.Tech Programs Based On 10+2 Or Equivalent Score.";
                ap="Click Here";
                ai="Jaypee Institute of Information Technology";
                ac= "Rs. 1200/-";
                break;
            case "13":
                programName="B. TECH";
                selectionMode= "BIOTECH";
                about="For Merit Based Admission To B.Tech Biotechnology/ 5 Year Integrated M.Tech Biotechnology Programs Based On 10+2 Or Equivalent Score. Only For Non-JEE Based Admissions.";
                ap="Click Here";
                ai="JIIT Noida";
                ac= "Rs. 1200/-";
                break;
            case "20":
                programName="MBA";
                selectionMode= "CAT/MAT/CMAT/XAT/GMAT/ATMA";
                about="2 Year MBA Program";
                ap="Click Here";
                ai="Jaypee Business School - Noida (Constituent of JIIT, Deemed to be University)";
                ac= "Rs. 1000/-";
                break;
            case "21":
                programName="M.TECH";
                selectionMode= "GATE";
                ap="Click Here";
                ai="JIIT - Noida";
                about="For Admission To GATE Programs For Selected Specializations.";
                ac= "Rs. 1000/-";
                break;
            case "23":
                programName="M.TECH";
                selectionMode= "PGET";
                about="For Admission To GATE Programs For Selected Specializations.";
                ap="Click Here";
                ai="JIIT - Noida";
                ac= "Rs. 1000/-";
                break;
            case "31":
                break;
        }

        tv_shortlisting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_shortlisting_detail.setText(shortlisting);
            }
        });
        Log.i("INTENT::PROGRAM:::",programName);
        Log.i("INTENT::PROGRAM:::",ap);
        tv_eligibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_eligibility_detail.setText(eligibility);
            }
        });
        tv_ai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("ONCLIC", "CLICKED_______________");
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.jiit.ac.in/admission-procedures")));
            }
        });
        tv_ap.setText(ap);
        tv_ai.setText(ai);
        tv_selectionMode.setText(selectionMode);
        tv_programName.setText(programName);
        tv_ac.setText(ac);
        tv_about.setText(about);
        b_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), EmailVerify.class);
                startActivity(intent);
            }
        });
    }
}