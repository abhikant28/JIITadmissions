package com.example.jiitadmissions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class EmailVerify extends AppCompatActivity {

    EditText et_email;
    EditText et_otp1;
    EditText et_otp2;
    EditText et_otp3;
    EditText et_otp4;

    TextView tv_error;
    TextView tv_otpMsg;

    Button b_verify;
    Button b_submit;

    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verify);

        et_email=findViewById(R.id.EmailVerify_EditText_Email);
        et_otp1=findViewById(R.id.EmailVerify_EditText_Otp1);
        et_otp2=findViewById(R.id.EmailVerify_EditText_Otp2);
        et_otp3=findViewById(R.id.EmailVerify_EditText_Otp3);
        et_otp4=findViewById(R.id.EmailVerify_EditText_Otp4);
        tv_error=findViewById(R.id.EmailVerify_TextView_Error);
        tv_otpMsg=findViewById(R.id.EmailVerify_TextView_OTPMsg);
        b_verify=findViewById(R.id.EmailVerify_Button_Verify);
        b_submit=findViewById(R.id.EmailVerify_Button_SubmitEMail);


        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email= et_email.getText().toString().trim().toLowerCase(Locale.ROOT);
                if(emailCheck(email)){
                    et_email.setEnabled(false);
                    et_otp1.isEnabled();
                    et_otp2.isEnabled();
                    et_otp3.isEnabled();
                    et_otp4.isEnabled();
                    b_verify.isEnabled();
                    b_submit.setEnabled(false);
                    //Send for email verification
                }else{
                    email="0";
                    et_email.setError("Invalid Email");
                    et_email.setText("");
                }
            }
        });
         b_verify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(et_otp1.getText().toString().matches("\\d") &&
                         et_otp2.getText().toString().matches("\\d") &&
                         et_otp3.getText().toString().matches("\\d") &&
                         et_otp4.getText().toString().matches("\\d")){
                 int otp=Integer.parseInt(et_otp1.getText().toString()+
                         et_otp2.getText().toString()+et_otp3.getText().toString()+
                         et_otp4.getText().toString());

                 if(checkOTP(otp)){
                     Intent intent =new Intent(getBaseContext(),ConfirmProgram.class);
                     intent.putExtra("CODE", "1");
                 }else{
                     et_otp1.setText("");
                     tv_error.setVisibility(View.VISIBLE);
                     et_otp2.setText("");
                     et_otp3.setText("");
                     et_otp4.setText("");

                 }
                }
             }
         });
    }

    private boolean checkOTP(int otp) {
        return true;
    }

    private boolean emailCheck(String email) {
        return email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }
}