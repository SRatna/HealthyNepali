package com.practice.osho.healthynepali;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

public class AlarmDetailsActivity extends AppCompatActivity {

    AlarmModel alarmDetails;
    private AlarmDBHelper dbHelper = new AlarmDBHelper(this);

    private Spinner spinner;
    private CheckBox checkBox;
    private TimePicker timePicker;
    private ToggleButton tb_sun;
    private ToggleButton tb_mon;
    private ToggleButton tb_tue;
    private ToggleButton tb_wed;
    private ToggleButton tb_thu;
    private ToggleButton tb_fri;
    private ToggleButton tb_sat;
    private TextView tv_setTone;
    private String alarm_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity_alarm_details);
        initAll();
        tBtnOnCheckColorChange();

        long id= getIntent().getExtras().getLong("id");
        if(id==-1){
            alarmDetails=new AlarmModel();
        }else{
            alarmDetails = dbHelper.getAlarm(id);

            timePicker.setCurrentMinute(alarmDetails.timeMinute);
            timePicker.setCurrentHour(alarmDetails.timeHour);

            spinner.setSelection(((ArrayAdapter<String>) spinner.getAdapter()).getPosition(alarmDetails.name));


            checkBox.setChecked(alarmDetails.repeatWeekly);
            tb_sun.setChecked(alarmDetails.getRepeatingDay(AlarmModel.SUNDAY));
            tb_mon.setChecked(alarmDetails.getRepeatingDay(AlarmModel.MONDAY));
            tb_tue.setChecked(alarmDetails.getRepeatingDay(AlarmModel.TUESDAY));
            tb_wed.setChecked(alarmDetails.getRepeatingDay(AlarmModel.WEDNESDAY));
            tb_thu.setChecked(alarmDetails.getRepeatingDay(AlarmModel.THURSDAY));
            tb_fri.setChecked(alarmDetails.getRepeatingDay(AlarmModel.FRIDAY));
            tb_sat.setChecked(alarmDetails.getRepeatingDay(AlarmModel.SATURDAY));

            tv_setTone.setText(RingtoneManager.getRingtone(this, alarmDetails.alarmTone).getTitle(this));
        }

        LinearLayout ringToneContainer = (LinearLayout)findViewById(R.id.linearlayout_tone);
        ringToneContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
                startActivityForResult(intent, 1);
            }
        });



    }

    private void initAll() {
        spinner=(Spinner)findViewById(R.id.spinner_msg);
        ArrayAdapter<CharSequence> adapter4Spinner = ArrayAdapter.createFromResource(AlarmDetailsActivity.this, R.array.messages, android.R.layout.simple_spinner_item);
        adapter4Spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter4Spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                alarm_msg = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        timePicker=(TimePicker)findViewById(R.id.timepicker);
        checkBox=(CheckBox)findViewById(R.id.checkbox_repeat);
        tb_sun=(ToggleButton)findViewById(R.id.tbtn_sun);
        tb_mon=(ToggleButton)findViewById(R.id.tbtn_mon);
        tb_tue=(ToggleButton)findViewById(R.id.tbtn_tue);
        tb_wed=(ToggleButton)findViewById(R.id.tbtn_wed);
        tb_thu=(ToggleButton)findViewById(R.id.tbtn_thu);
        tb_fri=(ToggleButton)findViewById(R.id.tbtn_fri);
        tb_sat=(ToggleButton)findViewById(R.id.tbtn_sat);
        tv_setTone = (TextView) findViewById(R.id.tv_setAlarm);



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1: {
                    alarmDetails.alarmTone = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);

                    tv_setTone.setText(RingtoneManager.getRingtone(this, alarmDetails.alarmTone).getTitle(this));
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private void tBtnOnCheckColorChange() {
        tb_sun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) tb_sun.setTextColor(Color.parseColor("#6EFF61"));
                else tb_sun.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        tb_mon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) tb_mon.setTextColor(Color.parseColor("#6EFF61"));
                else tb_mon.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        tb_tue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) tb_tue.setTextColor(Color.parseColor("#6EFF61"));
                else tb_tue.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        tb_wed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) tb_wed.setTextColor(Color.parseColor("#6EFF61"));
                else tb_wed.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        tb_thu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) tb_thu.setTextColor(Color.parseColor("#6EFF61"));
                else tb_thu.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        tb_fri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) tb_fri.setTextColor(Color.parseColor("#6EFF61"));
                else tb_fri.setTextColor(Color.parseColor("#ffffff"));
            }
        });
        tb_sat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) tb_sat.setTextColor(Color.parseColor("#6EFF61"));
                else tb_sat.setTextColor(Color.parseColor("#ffffff"));
            }
        });

    }

    public void onCancelClick(View view) {
        finish();
    }

    public void onSaveClick(View view) {

        UpadateModelFromLayout();

        AlarmManagerHelper.cancelAlarms(this);

        if (alarmDetails.id > 0) {
            dbHelper.updateAlarm(alarmDetails);
        } else {
            dbHelper.createAlarm(alarmDetails);
        }

        AlarmManagerHelper.setAlarms(this);

        setResult(RESULT_OK);
        finish();



    }

    public void UpadateModelFromLayout() {

        alarmDetails.name=alarm_msg;

        alarmDetails.timeMinute=timePicker.getCurrentMinute();
        alarmDetails.timeHour=timePicker.getCurrentHour();

        alarmDetails.repeatWeekly=checkBox.isChecked();

        alarmDetails.setRepeatingDay(AlarmModel.SUNDAY,tb_sun.isChecked());

        alarmDetails.setRepeatingDay(AlarmModel.MONDAY,tb_mon.isChecked());

        alarmDetails.setRepeatingDay(AlarmModel.TUESDAY,tb_tue.isChecked());

        alarmDetails.setRepeatingDay(AlarmModel.WEDNESDAY, tb_wed.isChecked());

        alarmDetails.setRepeatingDay(AlarmModel.THURSDAY, tb_thu.isChecked());

        alarmDetails.setRepeatingDay(AlarmModel.FRIDAY, tb_fri.isChecked());

        alarmDetails.setRepeatingDay(AlarmModel.SATURDAY, tb_sat.isChecked());

        alarmDetails.isEnabled=true;
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Save The Alarm")
                .setMessage("Save this alarm?")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        UpadateModelFromLayout();

                        AlarmManagerHelper.cancelAlarms(AlarmDetailsActivity.this);

                        if (alarmDetails.id > 0) {
                            dbHelper.updateAlarm(alarmDetails);
                        } else {
                            dbHelper.createAlarm(alarmDetails);
                        }

                        AlarmManagerHelper.setAlarms(AlarmDetailsActivity.this);

                        setResult(RESULT_OK);
                        finish();


                    }
                }).create().show();
    }

}
