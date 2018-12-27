package com.practice.osho.healthynepali;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    EditText et_Name,et_email,et_signup_password,et_retype_password,et_age;
    Spinner pickBloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_email = (EditText)findViewById(R.id.et_email);
        et_Name= (EditText)findViewById(R.id.et_Name);
        et_retype_password=(EditText)findViewById(R.id.et_retype_password);
        et_signup_password= (EditText)findViewById(R.id.et_Signup_password);
        et_age=(EditText)findViewById(R.id.et_age);
        pickBloodGroup=(Spinner)findViewById(R.id.pickBloodType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SignUpActivity.this,R.array.bloodType,R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pickBloodGroup.setAdapter(adapter);

    }


    public void onSignUpClick(View view) {

        String userName = et_Name.getText().toString();
        String email = et_email.getText().toString();
        String password = et_signup_password.getText().toString();
        String rePassword= et_retype_password.getText().toString();
        int age= Integer.parseInt(et_age.getText().toString());
        String bloodGroup=pickBloodGroup.getSelectedItem().toString();

        if(userName==null||userName.equals("")||email==null||email.equals("")||password==null||password.equals("")||rePassword==null||rePassword.equals(""))
        {
            Toast.makeText(SignUpActivity.this,"Enter all the fields!",Toast.LENGTH_LONG).show();
        } else {
            if(!password.equals(rePassword)){
                Toast.makeText(SignUpActivity.this,"Passwords don't match!",Toast.LENGTH_LONG).show();
            }else {
                final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setMessage("Busy Creating Account....Please Wait....");
                progressDialog.show();

                ParseUser parseUser = new ParseUser();
                parseUser.setEmail(email);
                parseUser.setPassword(password);
                parseUser.setUsername(userName);
                parseUser.put("age",age);
                parseUser.put("bloodGroup",bloodGroup);


                parseUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            progressDialog.dismiss();
                            Toast.makeText(SignUpActivity.this,"Account Created Successfully!",Toast.LENGTH_SHORT).show();
                            ParseUser.logOut();
                            Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                        else {
                            progressDialog.dismiss();
                            Toast.makeText(SignUpActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        }
    }


    public void onCancelBtnClick(View view) {
        Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}
