package com.practice.osho.healthynepali;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class LoginActivity extends AppCompatActivity {

    EditText et_userName, et_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        ParseUser user = ParseUser.getCurrentUser();

        if (user == null) {

            setContentView(R.layout.activity_login);


            et_userName = (EditText) findViewById(R.id.et_userName);
            et_password = (EditText) findViewById(R.id.et_login_password);
        } else {

            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }

    }

    public void onLoginClick(View view) {

        String userName=et_userName.getText().toString();
        String password=et_password.getText().toString();

        if (userName == null || userName.equals("") || password == null || password.equals("") ) {
            Toast.makeText(LoginActivity.this, "Enter both the fields!", Toast.LENGTH_LONG).show();
        } else {

            final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("Busy Logging....Please Wait....");
            progressDialog.show();

            ParseUser.logInInBackground(userName, password, new LogInCallback() {
                @Override
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        boolean verified = user.getBoolean("emailVerified");
                        if (!verified) {
                            Toast.makeText(LoginActivity.this, "Please verify Your Email First", Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            ParseUser.logOut();
                        } else {
                            ParseInstallation parseInstallation=ParseInstallation.getCurrentInstallation();
                            parseInstallation.put("user",user.getUsername());
                            parseInstallation.saveInBackground();
                            Toast.makeText(LoginActivity.this, "Logged in successfully", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            progressDialog.dismiss();


                        }
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this,"Sorry, unrecognized username or password.", Toast.LENGTH_LONG).show();
                    }

                }

            });
        }
    }


    public void onNoAccountClick(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
    }

    public void onResetClick(View view) {
        final View layout=LoginActivity.this.getLayoutInflater().inflate(R.layout.reset_password_popup, null);
        final EditText et_emailForReset = (EditText)layout.findViewById(R.id.et_emailForReset);


        AlertDialog.Builder dlg_reset = new AlertDialog.Builder(LoginActivity.this);
        dlg_reset.setView(layout);
        dlg_reset.setTitle("Password Reset");
        dlg_reset.setPositiveButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Sending msg to Your EmailID....");
                progressDialog.show();

                ParseUser.requestPasswordResetInBackground(et_emailForReset.getText().toString(), new RequestPasswordResetCallback() {
                    @Override
                    public void done(ParseException e) {

                        if(e==null){
                            Toast.makeText(LoginActivity.this,"Reset Instructions send to your EmailID",Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }else {
                            Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                        }

                    }
                });

            }
        });

        dlg_reset.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginActivity.this,"Cancelled",Toast.LENGTH_SHORT).show();


            }
        });
        dlg_reset.show();

    }



}