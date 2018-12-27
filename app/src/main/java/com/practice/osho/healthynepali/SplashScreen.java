package com.practice.osho.healthynepali;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class SplashScreen extends AppCompatActivity {

    Drawer extraFeatures;
    ImageView drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        drawer=(ImageView)findViewById(R.id.drawer);
        extraFeatures=new DrawerBuilder().withActivity(this)
                .withSelectedItem(-1)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("EXTRA FEATURES").withSelectable(false).withIdentifier(5),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Health Calculator").withSelectable(false).withIcon(FontAwesome.Icon.faw_calculator).withIdentifier(1),
                        new PrimaryDrawerItem().withName("Health Reminder").withSelectable(false).withIdentifier(2).withIcon(R.drawable.alarmm),
                        new PrimaryDrawerItem().withName("Health Quiz").withSelectable(false).withIdentifier(3).withIcon(FontAwesome.Icon.faw_question),
                        new PrimaryDrawerItem().withName("Herbal Help").withSelectable(false).withIdentifier(4).withIcon(FontAwesome.Icon.faw_info_circle)

                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            switch (drawerItem.getIdentifier()) {
                                case 1:
                                    Intent intent = new Intent(SplashScreen.this, HealthCalculator_mainActivity.class);
                                    startActivity(intent);
                                    break;
                                case 2:
                                    Intent intentOfAlarm = new Intent(SplashScreen.this, AlarmListActivity.class);
                                    startActivity(intentOfAlarm);
                                    break;
                                case 3:
                                    Intent intentOfQuiz = new Intent(SplashScreen.this, Quiz_ChooseLevelActivity.class);
                                    startActivity(intentOfQuiz);
                                    break;
                                case 4:
                                    Intent intentOfHerb = new Intent(SplashScreen.this, HerbalHelpMainActivity.class);
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

    public void onSplashClick(View view) {
        if (isNetworkConnected()) {
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(SplashScreen.this);
            builder.setMessage("No Network  Connection! Please Connect to Network!\nYou can use our offline features by swiping the left side of the screen to draw Nav Drawer").setPositiveButton("Done",null).setTitle("Network Unavailable");
            AlertDialog dlg = builder.create();
            dlg.show();
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
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
