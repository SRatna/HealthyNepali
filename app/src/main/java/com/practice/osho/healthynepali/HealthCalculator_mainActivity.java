package com.practice.osho.healthynepali;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;

public class HealthCalculator_mainActivity extends AppCompatActivity {

    private int weight_kg4bim;
    private float height_meter4bim;
    private String sex4bmr;
    private int weight_kg4bmr;
    private float height_meter4bmr;
    private int age4bmr;
    private String sex4ibm;
    private float height_inch4ibm;
    private int ageofbaby;
    private int ageofkid;
    private String date4tv;
    private int average_days;
    private int days;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_calculator_activity_main);


    }

    public void onBMIClick(View view) {

        View bmi_layout = getLayoutInflater().inflate(R.layout.health_calculator_bmi_layout,null);
        Spinner spinner_sex = (Spinner) bmi_layout.findViewById(R.id.spinner_sex);
        ArrayAdapter<CharSequence> adapter4sexSpinner = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this, R.array.sex, android.R.layout.simple_spinner_item);
        adapter4sexSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sex.setAdapter(adapter4sexSpinner);
        spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        NumberPicker np_weight = (NumberPicker)bmi_layout.findViewById(R.id.np_weight);
        np_weight.setMaxValue(120);
        np_weight.setMinValue(30);
        np_weight.setWrapSelectorWheel(true);
        weight_kg4bim =np_weight.getValue();
        np_weight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                weight_kg4bim = numberPicker.getValue();

            }
        });



        Spinner spinner_height = (Spinner)bmi_layout.findViewById(R.id.spinner_height);
        ArrayAdapter<CharSequence> adapter4height = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this,R.array.Height,android.R.layout.simple_spinner_item);
        adapter4height.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_height.setAdapter(adapter4height);
        spinner_height.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {

                    case "4\' 7\"":
                        height_meter4bim = (float) ((4 * 12 + 7) * 0.0254);
                        break;
                    case "4\' 8\"":
                        height_meter4bim = (float) ((4 * 12 + 8) * 0.0254);
                        break;
                    case "4\' 9\"":
                        height_meter4bim = (float) ((4 * 12 + 9) * 0.0254);
                        break;
                    case "5\'":
                        height_meter4bim = (float) ((5 * 12) * 0.0254);
                        break;
                    case "5\' 1\"":
                        height_meter4bim = (float) ((5 * 12 + 1) * 0.0254);
                        break;
                    case "5\' 2\"":
                        height_meter4bim = (float) ((5 * 12 + 2) * 0.0254);
                        break;
                    case "5\' 3\"":
                        height_meter4bim = (float) ((5 * 12 + 3) * 0.0254);
                        break;
                    case "5\' 4\"":
                        height_meter4bim = (float) ((5 * 12 + 4) * 0.0254);
                        break;
                    case "5\' 5\"":
                        height_meter4bim = (float) ((5 * 12 + 5) * 0.0254);
                        break;
                    case "5\' 6\"":
                        height_meter4bim = (float) ((5 * 12 + 6) * 0.0254);
                        break;
                    case "5\' 7\"":
                        height_meter4bim = (float) ((5 * 12 + 7) * 0.0254);
                        break;
                    case "5\' 8\"":
                        height_meter4bim = (float) ((5 * 12 + 8) * 0.0254);
                        break;
                    case "5\' 9\"":
                        height_meter4bim = (float) ((5 * 12 + 9) * 0.0254);
                        break;
                    case "6\'":
                        height_meter4bim = (float) ((6 * 12) * 0.0254);
                        break;
                    case "6\' 1\"":
                        height_meter4bim = (float) ((6 * 12 + 1) * 0.0254);
                        break;
                    case "6\' 2\"":
                        height_meter4bim = (float) ((6 * 12 + 2) * 0.0254);
                        break;
                    case "6\' 3\"":
                        height_meter4bim = (float) ((6 * 12 + 3) * 0.0254);
                        break;
                    case "6\' 4\"":
                        height_meter4bim = (float) ((6 * 12 + 4) * 0.0254);
                        break;
                    case "6\' 5\"":
                        height_meter4bim = (float) ((6 * 12 + 5) * 0.0254);
                        break;
                    case "6\' 6\"":
                        height_meter4bim = (float) ((6 * 12 + 6) * 0.0254);
                        break;
                    case "6\' 7\"":
                        height_meter4bim = (float) ((6 * 12 + 7) * 0.0254);
                        break;
                    case "6\' 8\"":
                        height_meter4bim = (float) ((6 * 12 + 8) * 0.0254);
                        break;
                    case "6\' 9\"":
                        height_meter4bim = (float) ((6 * 12 + 9) * 0.0254);
                        break;
                    case "7\'":
                        height_meter4bim = (float) ((7 * 12) * 0.0254);
                        break;
                    default:
                        height_meter4bim = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        AlertDialog.Builder dlg4bim = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg4bim.setTitle("Your Body Mass Index");
        dlg4bim.setView(bmi_layout);
        dlg4bim.setPositiveButton("Calculate NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                calculateBMI();
            }
        });
        dlg4bim.show();
    }

    private void calculateBMI() {
        float bmi = weight_kg4bim /(height_meter4bim * height_meter4bim);
        View dlg_view = getLayoutInflater().inflate(R.layout.health_calculator_dlg4bim_layout,null);
        TextView tv_bmi=(TextView)dlg_view.findViewById(R.id.tv_bmi);
        TextView tv_result = (TextView)dlg_view.findViewById(R.id.tv_result);
        tv_bmi.setText(String.format("%.2f",bmi));
        if(bmi<18.5) tv_result.setText("Oops! You are UnderWeight!");
        else if(bmi>=18.5&&bmi<24.9) tv_result.setText("Wow! You are Normal!");
        else if(bmi>=24.9&&bmi<29.9) tv_result.setText("You are overweight!");
        else tv_result.setText("My God! You are Obese");

        AlertDialog.Builder dlg4bim = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg4bim.setTitle("Result");
        dlg4bim.setView(dlg_view);
        dlg4bim.setPositiveButton("OK",null);
        dlg4bim.show();

    }

    public void onBMRClick(View view) {

        View bmr_layout = getLayoutInflater().inflate(R.layout.health_calculator_bmr_layout,null);
        Spinner spinner_sex = (Spinner) bmr_layout.findViewById(R.id.spinner_sex);
        ArrayAdapter<CharSequence> adapter4sexSpinner = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this, R.array.sex, android.R.layout.simple_spinner_item);
        adapter4sexSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sex.setAdapter(adapter4sexSpinner);
        spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sex4bmr=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner_height = (Spinner)bmr_layout.findViewById(R.id.spinner_height);
        ArrayAdapter<CharSequence> adapter4height = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this,R.array.Height,android.R.layout.simple_spinner_item);
        adapter4height.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_height.setAdapter(adapter4height);
        spinner_height.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {

                    case "4\' 7\"":
                        height_meter4bmr = (float) ((4 * 12 + 7) * 0.0254);
                        break;
                    case "4\' 8\"":
                        height_meter4bmr = (float) ((4 * 12 + 8) * 0.0254);
                        break;
                    case "4\' 9\"":
                        height_meter4bmr = (float) ((4 * 12 + 9) * 0.0254);
                        break;
                    case "5\'":
                        height_meter4bmr = (float) ((5 * 12) * 0.0254);
                        break;
                    case "5\' 1\"":
                        height_meter4bmr = (float) ((5 * 12 + 1) * 0.0254);
                        break;
                    case "5\' 2\"":
                        height_meter4bmr = (float) ((5 * 12 + 2) * 0.0254);
                        break;
                    case "5\' 3\"":
                        height_meter4bmr = (float) ((5 * 12 + 3) * 0.0254);
                        break;
                    case "5\' 4\"":
                        height_meter4bmr = (float) ((5 * 12 + 4) * 0.0254);
                        break;
                    case "5\' 5\"":
                        height_meter4bmr = (float) ((5 * 12 + 5) * 0.0254);
                        break;
                    case "5\' 6\"":
                        height_meter4bmr = (float) ((5 * 12 + 6) * 0.0254);
                        break;
                    case "5\' 7\"":
                        height_meter4bmr = (float) ((5 * 12 + 7) * 0.0254);
                        break;
                    case "5\' 8\"":
                        height_meter4bmr = (float) ((5 * 12 + 8) * 0.0254);
                        break;
                    case "5\' 9\"":
                        height_meter4bmr = (float) ((5 * 12 + 9) * 0.0254);
                        break;
                    case "6\'":
                        height_meter4bmr = (float) ((6 * 12) * 0.0254);
                        break;
                    case "6\' 1\"":
                        height_meter4bmr = (float) ((6 * 12 + 1) * 0.0254);
                        break;
                    case "6\' 2\"":
                        height_meter4bmr = (float) ((6 * 12 + 2) * 0.0254);
                        break;
                    case "6\' 3\"":
                        height_meter4bmr = (float) ((6 * 12 + 3) * 0.0254);
                        break;
                    case "6\' 4\"":
                        height_meter4bmr = (float) ((6 * 12 + 4) * 0.0254);
                        break;
                    case "6\' 5\"":
                        height_meter4bmr = (float) ((6 * 12 + 5) * 0.0254);
                        break;
                    case "6\' 6\"":
                        height_meter4bmr = (float) ((6 * 12 + 6) * 0.0254);
                        break;
                    case "6\' 7\"":
                        height_meter4bmr = (float) ((6 * 12 + 7) * 0.0254);
                        break;
                    case "6\' 8\"":
                        height_meter4bmr = (float) ((6 * 12 + 8) * 0.0254);
                        break;
                    case "6\' 9\"":
                        height_meter4bmr = (float) ((6 * 12 + 9) * 0.0254);
                        break;
                    case "7\'":
                        height_meter4bmr = (float) ((7 * 12) * 0.0254);
                        break;
                    default:
                        height_meter4bmr = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        NumberPicker np_age = (NumberPicker)bmr_layout.findViewById(R.id.np_age4bmr);
        np_age.setMaxValue(100);
        np_age.setMinValue(18);
        np_age.setWrapSelectorWheel(true);
        age4bmr =np_age.getValue();
        np_age.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                age4bmr = numberPicker.getValue();

            }
        });

        NumberPicker np_weight = (NumberPicker)bmr_layout.findViewById(R.id.np_weight);
        np_weight.setMaxValue(120);
        np_weight.setMinValue(30);
        np_weight.setWrapSelectorWheel(true);
        weight_kg4bmr =np_weight.getValue();
        np_weight.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                weight_kg4bmr = numberPicker.getValue();

            }
        });



        AlertDialog.Builder dlg4bmr = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg4bmr.setTitle("Your Basal Metabolic Rate");
        dlg4bmr.setView(bmr_layout);
        dlg4bmr.setPositiveButton("Calculate NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                calculateBMR();
            }
        });
        dlg4bmr.show();


    }

    private void calculateBMR() {
        int bmr;
        if(sex4bmr.equals("Male")){
            bmr= (int) (10*weight_kg4bmr+625*height_meter4bmr-5*age4bmr+5);
        }else bmr= (int) (10*weight_kg4bmr+625*height_meter4bmr-5*age4bmr-161);

        AlertDialog.Builder dlg = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg.setTitle("Result");
        dlg.setMessage("Your Estimated BMR is " + String.valueOf(bmr) +" kcal/day");
        dlg.setPositiveButton("OK",null);
        dlg.show();
    }

    public void onIBWClick(View view) {

        View ibm_layout = getLayoutInflater().inflate(R.layout.health_calculator_ibm4a_layout,null);
        Spinner spinner_sex = (Spinner) ibm_layout.findViewById(R.id.spinner_sex);
        ArrayAdapter<CharSequence> adapter4sexSpinner = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this, R.array.sex, android.R.layout.simple_spinner_item);
        adapter4sexSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sex.setAdapter(adapter4sexSpinner);
        spinner_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sex4ibm=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner spinner_height = (Spinner)ibm_layout.findViewById(R.id.spinner_height);
        ArrayAdapter<CharSequence> adapter4height = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this,R.array.Height,android.R.layout.simple_spinner_item);
        adapter4height.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_height.setAdapter(adapter4height);
        spinner_height.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {

                    case "4\' 7\"":
                        height_inch4ibm = (float) ((4 * 12 + 7) );
                        break;
                    case "4\' 8\"":
                        height_inch4ibm = (float) ((4 * 12 + 8) );
                        break;
                    case "4\' 9\"":
                        height_inch4ibm = (float) ((4 * 12 + 9) );
                        break;
                    case "5\'":
                        height_inch4ibm = (float) ((5 * 12) );
                        break;
                    case "5\' 1\"":
                        height_inch4ibm = (float) ((5 * 12 + 1) );
                        break;
                    case "5\' 2\"":
                        height_inch4ibm = (float) ((5 * 12 + 2) );
                        break;
                    case "5\' 3\"":
                        height_inch4ibm = (float) ((5 * 12 + 3) );
                        break;
                    case "5\' 4\"":
                        height_inch4ibm = (float) ((5 * 12 + 4) );
                        break;
                    case "5\' 5\"":
                        height_inch4ibm = (float) ((5 * 12 + 5) );
                        break;
                    case "5\' 6\"":
                        height_inch4ibm = (float) ((5 * 12 + 6) );
                        break;
                    case "5\' 7\"":
                        height_inch4ibm = (float) ((5 * 12 + 7) );
                        break;
                    case "5\' 8\"":
                        height_inch4ibm = (float) ((5 * 12 + 8) );
                        break;
                    case "5\' 9\"":
                        height_inch4ibm = (float) ((5 * 12 + 9) );
                        break;
                    case "6\'":
                        height_inch4ibm = (float) ((6 * 12) );
                        break;
                    case "6\' 1\"":
                        height_inch4ibm = (float) ((6 * 12 + 1) );
                        break;
                    case "6\' 2\"":
                        height_inch4ibm = (float) ((6 * 12 + 2) );
                        break;
                    case "6\' 3\"":
                        height_inch4ibm = (float) ((6 * 12 + 3) );
                        break;
                    case "6\' 4\"":
                        height_inch4ibm = (float) ((6 * 12 + 4) );
                        break;
                    case "6\' 5\"":
                        height_inch4ibm = (float) ((6 * 12 + 5) );
                        break;
                    case "6\' 6\"":
                        height_inch4ibm = (float) ((6 * 12 + 6) );
                        break;
                    case "6\' 7\"":
                        height_inch4ibm = (float) ((6 * 12 + 7) );
                        break;
                    case "6\' 8\"":
                        height_inch4ibm = (float) ((6 * 12 + 8) );
                        break;
                    case "6\' 9\"":
                        height_inch4ibm = (float) ((6 * 12 + 9) );
                        break;
                    case "7\'":
                        height_inch4ibm = (float) ((7 * 12) );
                        break;
                    default:
                        height_inch4ibm = 0;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        AlertDialog.Builder dlg4ibm = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg4ibm.setTitle("Your Ideal Body Weight");
        dlg4ibm.setView(ibm_layout);
        dlg4ibm.setPositiveButton("Calculate NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                calculateIBM();
            }
        });
        dlg4ibm.show();
    }

    private void calculateIBM() {
        float ibm;
        if(sex4ibm.equals("Male")) ibm= (float) (50+2.3*(height_inch4ibm-60));
        else ibm= (float) (45.5+2.3*(height_inch4ibm-60));
        AlertDialog.Builder dlg = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg.setTitle("Result");
        dlg.setMessage("Your Ideal Weight is " + String.format("%.2f", ibm) + " kg");
        dlg.setPositiveButton("OK",null);
        dlg.show();


    }

    public void onIBW4babyClick(View view) {
        final View layout4ibmbaby = getLayoutInflater().inflate(R.layout.health_calculator_ibm4baby_layout,null);
        Spinner spinner_age = (Spinner) layout4ibmbaby.findViewById(R.id.spinner_age);
        ArrayAdapter<CharSequence> adapter4ageSpinner = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this, R.array.ageOfBaby, android.R.layout.simple_spinner_item);
        adapter4ageSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter4ageSpinner);
        spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {
                    case "1 month":
                        ageofbaby = 1;
                        break;
                    case "2 months":
                        ageofbaby = 2;
                        break;
                    case "3 months":
                        ageofbaby = 3;
                        break;
                    case "4 months":
                        ageofbaby = 4;
                        break;
                    case "5 months":
                        ageofbaby = 5;
                        break;
                    case "6 months":
                        ageofbaby = 6;
                        break;
                    case "7 months":
                        ageofbaby = 7;
                        break;
                    case "8 months":
                        ageofbaby = 8;
                        break;
                    case "9 months":
                        ageofbaby = 9;
                        break;
                    case "10 months":
                        ageofbaby = 10;
                        break;
                    case "11 months":
                        ageofbaby = 11;
                        break;
                    case "12 months":
                        ageofbaby = 12;
                        break;
                    default:
                        ageofbaby = 0;
                        break;

                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btn_calculateNow = (Button)layout4ibmbaby.findViewById(R.id.btn_calculateNow);
        btn_calculateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float babyWt = (float) (0.5 * ageofbaby + 4);
                TextView tv_result = (TextView) layout4ibmbaby.findViewById(R.id.tv_resultOfibm4baby);
                tv_result.setText("Your Baby may be around " + String.format("%.1f", babyWt) + " kg");
            }
        });

        AlertDialog.Builder dlg = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg.setTitle("Your Baby\'s Ideal Weight");
        dlg.setView(layout4ibmbaby);
        dlg.setPositiveButton("OK", null);
        dlg.show();
    }

    public void onIBW4kidsClick(View view) {
        final View layout4ibmkid = getLayoutInflater().inflate(R.layout.health_calculator_ibm4kid_layout,null);
        Spinner spinner_age = (Spinner) layout4ibmkid.findViewById(R.id.spinner_age);
        ArrayAdapter<CharSequence> adapter4ageSpinner = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this, R.array.ageofkids, android.R.layout.simple_spinner_item);
        adapter4ageSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_age.setAdapter(adapter4ageSpinner);
        spinner_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()) {
                    case "1 year":
                        ageofkid=1;
                        break;
                    case "2 years":
                        ageofkid=2;break;
                    case "3 years":ageofkid=3;break;
                    case "4 years":ageofkid=4;break;
                    case "5 years":ageofkid=5;break;
                    case "6 years":ageofkid=6;break;
                    case "7 years":ageofkid=7;break;
                    case "8 years":ageofkid=8;break;
                    case "9 years":ageofkid=9;break;
                    case "10 years":ageofkid=10;break;
                    case "11 years":ageofkid=11;break;
                    case "12 years":ageofkid=12;break;
                    case "13 years":ageofkid=13;break;
                    case "14 years":ageofkid=14;break;
                    default:ageofkid=0;break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Button btn_calculateNow = (Button)layout4ibmkid.findViewById(R.id.btn_calculateNow);
        btn_calculateNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float babyWt = (float) (9.5 + 2*(ageofkid - 1));
                TextView tv_result = (TextView) layout4ibmkid.findViewById(R.id.tv_resultOfibm4baby);
                tv_result.setText("Your kid may be around " + String.format("%.1f", babyWt) + " kg");
            }
        });

        AlertDialog.Builder dlg = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg.setTitle("Your kid\'s Ideal Weight");
        dlg.setView(layout4ibmkid);
        dlg.setPositiveButton("OK", null);
        dlg.show();
    }

    public void onOEClick(View view) {

        final Calendar calendar;

        View layout4oe=getLayoutInflater().inflate(R.layout.health_calculator_oe_layout,null);
        View layout4dlg=getLayoutInflater().inflate(R.layout.health_calculator_dlg4oe_layout,null);
        final Spinner spinner_days = (Spinner) layout4oe.findViewById(R.id.spinner4OE);
        ArrayAdapter<CharSequence> adapter4daysSpinner = ArrayAdapter.createFromResource(HealthCalculator_mainActivity.this, R.array.averageDays, android.R.layout.simple_spinner_item);
        adapter4daysSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_days.setAdapter(adapter4daysSpinner);
        spinner_days.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                days = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
                Log.e("days", String.valueOf(days));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        DatePicker datePicker=(DatePicker)layout4oe.findViewById(R.id.dp4OE);
        calendar=Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(i, i1, i2);
            }
        });



        AlertDialog.Builder dlg4oe = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg4oe.setTitle("Your Most Fertile Period");
        dlg4oe.setView(layout4oe);
        dlg4oe.setPositiveButton("Calculate NOW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                average_days = (days / 2)+1;
                Log.e("avdays", String.valueOf(average_days));
                calendar.add(Calendar.DATE,average_days);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                date4tv=simpleDateFormat.format(calendar.getTime());
                Log.e("date", date4tv);
                showdlg4oe();
            }
        });
        dlg4oe.show();

    }
    public void showdlg4oe(){
        final View layout4dlg=getLayoutInflater().inflate(R.layout.health_calculator_dlg4oe_layout,null);
        TextView tv_date=(TextView)layout4dlg.findViewById(R.id.tv_date);
        tv_date.setText(date4tv);
        AlertDialog.Builder dlg = new AlertDialog.Builder(HealthCalculator_mainActivity.this);
        dlg.setTitle("Result");
        dlg.setView(layout4dlg);
        dlg.setPositiveButton("Ok", null);
        dlg.show();

    }
}
