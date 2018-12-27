package com.practice.osho.healthynepali;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.parse.FindCallback;
import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Drawer extraFeatures;
    ImageView drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=(ImageView)findViewById(R.id.drawer);
        extraFeatures=new DrawerBuilder().withActivity(this)
                .withSelectedItem(-1)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("EXTRA FEATURES").withSelectable(false).withIdentifier(5),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Health Calculator").withSelectable(false).withIcon(FontAwesome.Icon.faw_calculator).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Health Reminder").withSelectable(false).withIcon(R.drawable.alarmm).withIdentifier(2),
                        new PrimaryDrawerItem().withName("Health Quiz").withSelectable(false).withIcon(FontAwesome.Icon.faw_question).withIdentifier(3),
                        new PrimaryDrawerItem().withName("Herbal Help").withSelectable(false).withIcon(FontAwesome.Icon.faw_info_circle).withIdentifier(4)

                        ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                                if (drawerItem != null) {
                                    switch (drawerItem.getIdentifier()) {
                                        case 1:
                                            Intent intent = new Intent(MainActivity.this, HealthCalculator_mainActivity.class);
                                            startActivity(intent);
                                            break;
                                        case 2:
                                            Intent intentOfAlarm = new Intent(MainActivity.this, AlarmListActivity.class);
                                            startActivity(intentOfAlarm);
                                            break;
                                        case 3:
                                            Intent intentOfQuiz = new Intent(MainActivity.this, Quiz_ChooseLevelActivity.class);
                                            startActivity(intentOfQuiz);
                                            break;
                                        case 4:
                                            Intent intentOfHerb = new Intent(MainActivity.this, HerbalHelpMainActivity.class);
                                            startActivity(intentOfHerb);
                                    }
                                }
                                return false;
                            }
                        })

                .withSliderBackgroundColor(getResources().getColor(android.R.color.holo_blue_light))
                .build();

        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extraFeatures.openDrawer();
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            ParseUser.logOut();
            ParseInstallation parseInstallation=ParseInstallation.getCurrentInstallation();
            parseInstallation.put("user", "logged_out");
            parseInstallation.saveInBackground();

            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);


        }

        return super.onOptionsItemSelected(item);
    }



    public void onAskExpertBtnClick(View view) {

        final View layout = MainActivity.this.getLayoutInflater().inflate(R.layout.ask_expert_popup,null);
        final EditText et_askNow = (EditText)layout.findViewById(R.id.et_askNow);
        final Spinner health = (Spinner)layout.findViewById(R.id.spinner_health);
        ArrayAdapter<CharSequence> adapter4health = ArrayAdapter.createFromResource(MainActivity.this, R.array.health_category, android.R.layout.simple_spinner_item);
        adapter4health.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        health.setAdapter(adapter4health);

        final AlertDialog.Builder dlg_askNow = new AlertDialog.Builder(MainActivity.this);
        dlg_askNow.setView(layout);
        dlg_askNow.setTitle("Write your Query Here.");

        dlg_askNow.setPositiveButton("Ask Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (et_askNow.getText().toString() == null || et_askNow.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Nothing To Submit!", Toast.LENGTH_SHORT).show();
                } else {
                    final ProgressDialog pdg = new ProgressDialog(MainActivity.this);
                    pdg.setMessage("Busy Submitting your Query");
                    pdg.show();

                    ParseObject newUser = new ParseObject("postedQueries");
                    newUser.put("questions", et_askNow.getText().toString());
                    newUser.put("user", ParseUser.getCurrentUser().getUsername());
                    newUser.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                Toast.makeText(MainActivity.this, "Query Posted Successfully. You will be notified when expert ansswer you!", Toast.LENGTH_SHORT).show();
                                pdg.dismiss();
                            } else {
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                pdg.dismiss();
                            }
                        }
                    });

                }
            }
        });

        dlg_askNow.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });

        dlg_askNow.show();


    }

    public void onExpertReplyBtnClick(View view) {
        Intent intent = new Intent(MainActivity.this,PostedQueriesActivity.class);
        startActivity(intent);
    }

    public void onHealthTipBtnClick(View view) {

        String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


        final View layout=MainActivity.this.getLayoutInflater().inflate(R.layout.health_tip_popup, null);
        final TextView tv_healthTip = (TextView)layout.findViewById(R.id.tv_tip);


        final AlertDialog.Builder dlg_healthTip = new AlertDialog.Builder(MainActivity.this);
        dlg_healthTip.setView(layout);
        dlg_healthTip.setTitle("Today's Health Tip");
        dlg_healthTip.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        ParseQuery<ParseObject> query = ParseQuery.getQuery("healthTips");
        query.whereEqualTo("date",todayDate);

        final ProgressDialog pdg = new ProgressDialog(MainActivity.this);
        pdg.setMessage("Loading Today's Health Tip....");
        pdg.show();

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> tip, ParseException e) {

                if(e==null){

                    if(tip.size()==0){
                        Toast.makeText(MainActivity.this,"Sorry! No Tip Today",Toast.LENGTH_LONG).show();
                        pdg.dismiss();
                    } else {
                        ParseObject tip1=tip.get(0);
                        tv_healthTip.setText(tip1.getString("healthTips"));
                        pdg.dismiss();
                        dlg_healthTip.show();

                    }
                }else {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    pdg.dismiss();
                }
            }
        });

    }

    public void onEBloodBankClick(View view) {
        final View dlg_EBB = MainActivity.this.getLayoutInflater().inflate(R.layout.blood_bank_pop_up, null);
        SwitchCompat turn_on_off=(SwitchCompat)dlg_EBB.findViewById(R.id.turn_on_off);
        final AlertDialog.Builder dlg_bloodBank=new AlertDialog.Builder(MainActivity.this);
        dlg_bloodBank.setTitle("E-Blood Banking");
        dlg_bloodBank.setPositiveButton("Done", null);
        dlg_bloodBank.setView(dlg_EBB);
        final ParseInstallation parseInstallation=ParseInstallation.getCurrentInstallation();

        if(turn_on_off.isChecked()&&ParseUser.getCurrentUser().getInt("age")>=18){
            parseInstallation.put("bloodGroup",ParseUser.getCurrentUser().getString("bloodGroup"));
            parseInstallation.saveInBackground();
        }

        turn_on_off.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if (ischecked) {
                    if (ParseUser.getCurrentUser().getInt("age") >= 18) {
                        parseInstallation.put("bloodGroup", ParseUser.getCurrentUser().getString("bloodGroup"));
                        parseInstallation.saveInBackground();
                    }
                } else {
                    parseInstallation.put("bloodGroup", "null");
                    parseInstallation.saveInBackground();
                }
            }
        });

        final EditText phoneNo=(EditText)dlg_EBB.findViewById(R.id.et_phoneNo);
        final Spinner pickBloodGroup=(Spinner)dlg_EBB.findViewById(R.id.pickBloodType);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.bloodType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pickBloodGroup.setAdapter(adapter);

        final ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Sending Message.....");

        Button sendMsg=(Button)dlg_EBB.findViewById(R.id.btn_sendMessage);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phoneNo.getText().toString() == null || phoneNo.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please Enter Your Phone Number", Toast.LENGTH_SHORT).show();
                } else {
                    String bloodGroup = pickBloodGroup.getSelectedItem().toString();
                    long phoneNumber = Long.parseLong(phoneNo.getText().toString());
                    progressDialog.show();
                    /*ParseQuery pushQuery=ParseInstallation.getQuery();
                    JSONObject json_data = null;
                    try {
                        json_data = new JSONObject("{\"title\": \"I need blood(" + bloodGroup + ")\",\"alert\": \"If u can help, please! contact me on " + phoneNumber +"\"" +",\"uri\": \"tel:"+String.valueOf(phoneNumber).trim()+"\"}");
                        //json_data = new JSONObject("{\"title\": \"I need blood(" + bloodGroup + ")\",\"alert\": \"If u can help, please! contact me on " + phoneNumber +"\"" +"}");


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    pushQuery.whereEqualTo("bloodGroup", bloodGroup);
                    ParsePush parsePush = new ParsePush();
                    parsePush.setQuery(pushQuery);
                    parsePush.setData(json_data);
                    //parsePush.setMessage("I need blood(" + bloodGroup + "), so if u can help, please! contact me on " + phoneNumber);
                    parsePush.sendInBackground(new SendCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, "Successfully Sent Your Message!", Toast.LENGTH_SHORT).show();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/
                    HashMap<String, Object> params = new HashMap<String, Object>();
                    params.put("bloodGroup", bloodGroup);
                    params.put("phoneNumber", phoneNumber);
                    ParseCloud.callFunctionInBackground("sendPushToUser", params, new FunctionCallback<String>() {
                        @Override
                        public void done(String object, ParseException e) {
                            if (e == null) {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, "Successfully Sent Your Message!", Toast.LENGTH_SHORT).show();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
        dlg_bloodBank.show();

    }

    @Override
    public void onBackPressed() {
        if (extraFeatures != null && extraFeatures.isDrawerOpen()) {
            extraFeatures.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
