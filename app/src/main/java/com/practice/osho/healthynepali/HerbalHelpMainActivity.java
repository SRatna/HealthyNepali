package com.practice.osho.healthynepali;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class HerbalHelpMainActivity extends AppCompatActivity {
    Drawer result;
    ImageView welcomeScreen;
    ScrollView cardsContainer;
    ImageView image_card1,image_card2,image_card3;
    TextView title_card1,title_card2,title_card3;
    TextView nepaliTitle_card1,nepaliTitle_card2,nepaliTitle_card3;
    TextView description_card1,description_card2,description_card3;
    Resources resources;
    ImageView drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.herbal_help_activity);
        initialization();
        result =new DrawerBuilder().withActivity(this)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Welcome Screen").withIcon(FontAwesome.Icon.faw_mobile_phone).withIdentifier(1),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("Common Cold").withIdentifier(2),
                        new PrimaryDrawerItem().withName("Fever").withIdentifier(3),
                        new PrimaryDrawerItem().withName("Indigestion").withIdentifier(4),
                        new PrimaryDrawerItem().withName("Pimples").withIdentifier(5),
                        new PrimaryDrawerItem().withName("Diarrhoea").withIdentifier(6),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName("Exit").withIdentifier(7).withIcon(FontAwesome.Icon.faw_stop)
                )
                .withSliderBackgroundColor(getResources().getColor(android.R.color.holo_blue_light))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                        if (iDrawerItem != null) {
                            switch (iDrawerItem.getIdentifier()){
                                case 1:
                                    welcomeScreen.setVisibility(View.VISIBLE);
                                    cardsContainer.setVisibility(View.GONE);
                                    break;
                                case 2:
                                    if(welcomeScreen.getVisibility()==View.VISIBLE) welcomeScreen.setVisibility(View.GONE);
                                    if(cardsContainer.getVisibility()==View.GONE) cardsContainer.setVisibility(View.VISIBLE);
                                    setContextOfCards(HerbalHelpDiseases.commonCold);
                                    break;
                                case 3:
                                    if(welcomeScreen.getVisibility()==View.VISIBLE) welcomeScreen.setVisibility(View.GONE);
                                    if(cardsContainer.getVisibility()==View.GONE) cardsContainer.setVisibility(View.VISIBLE);
                                    setContextOfCards(HerbalHelpDiseases.fever);
                                    break;
                                case 4:
                                    if(welcomeScreen.getVisibility()==View.VISIBLE) welcomeScreen.setVisibility(View.GONE);
                                    if(cardsContainer.getVisibility()==View.GONE) cardsContainer.setVisibility(View.VISIBLE);
                                    setContextOfCards(HerbalHelpDiseases.inDigestion);
                                    break;
                                case 5:
                                    if(welcomeScreen.getVisibility()==View.VISIBLE) welcomeScreen.setVisibility(View.GONE);
                                    if(cardsContainer.getVisibility()==View.GONE) cardsContainer.setVisibility(View.VISIBLE);
                                    setContextOfCards(HerbalHelpDiseases.pimples);
                                    break;
                                case 6:
                                    if(welcomeScreen.getVisibility()==View.VISIBLE) welcomeScreen.setVisibility(View.GONE);
                                    if(cardsContainer.getVisibility()==View.GONE) cardsContainer.setVisibility(View.VISIBLE);
                                    setContextOfCards(HerbalHelpDiseases.diarrhoea);
                                    break;
                                case 7:
                                    Snackbar.make(view, "Exit Now?", Snackbar.LENGTH_LONG)
                                            .setAction("OK", new View.OnClickListener() {
                                                @Override
                                                public void onClick(View view) {
                                                    finish();
                                                }
                                            }).show();
                                    break;
                            }

                        }
                        return false;
                    }
                })
                .build();

        drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.openDrawer();
            }
        });





    }

    private void initialization() {
        drawer=(ImageView)findViewById(R.id.drawer);
        welcomeScreen=(ImageView)findViewById(R.id.bg_image4herbalHelp);
        cardsContainer=(ScrollView)findViewById(R.id.cardsContainer);
        image_card1=(ImageView)findViewById(R.id.image_card1);
        image_card2=(ImageView)findViewById(R.id.image_card2);
        image_card3=(ImageView)findViewById(R.id.image_card3);
        title_card1=(TextView)findViewById(R.id.title_card1);
        title_card2=(TextView)findViewById(R.id.title_card2);
        title_card3=(TextView)findViewById(R.id.title_card3);
        nepaliTitle_card1=(TextView)findViewById(R.id.nepaliTitle_card1);
        nepaliTitle_card2=(TextView)findViewById(R.id.nepaliTitle_card2);
        nepaliTitle_card3=(TextView)findViewById(R.id.nepaliTitle_card3);
        description_card1=(TextView)findViewById(R.id.description_card1);
        description_card2=(TextView)findViewById(R.id.description_card2);
        description_card3=(TextView)findViewById(R.id.description_card3);
        resources=getResources();

    }

    private void setContextOfCards(HerbalHelpDiseases remedies) {
        int[] id4images=remedies.getId4images();
        int[] id4titles=remedies.getId4titles();
        int[] id4nepaliTitles=remedies.getId4nepaliTitles();
        int[] id4description=remedies.getId4descriptions();

        image_card1.setImageResource(id4images[0]);
        image_card2.setImageResource(id4images[1]);
        image_card3.setImageResource(id4images[2]);
        title_card1.setText(id4titles[0]);
        title_card2.setText(id4titles[1]);
        title_card3.setText(id4titles[2]);
        nepaliTitle_card1.setText(id4nepaliTitles[0]);
        nepaliTitle_card2.setText(id4nepaliTitles[1]);
        nepaliTitle_card3.setText(id4nepaliTitles[2]);
        description_card1.setText(id4description[0]);
        description_card2.setText(id4description[1]);
        description_card3.setText(id4description[2]);


    }


    public void onCard1Click(View view) {
        switch (title_card1.getText().toString()){
            case "Cardamom":
                showDlg(resources.getString(R.string.cardamom_how2use));
                break;
            case "Peppermint":
                showDlg(resources.getString(R.string.peppermint_how2use));
                break;
            case "Ginger":
                showDlg(resources.getString(R.string.ginger_how2use));
                break;
            case "Chrysanthemum":
                showDlg(resources.getString(R.string.chrysanthemum_how2use));
                break;
            case "AloeVera":
                showDlg(resources.getString(R.string.aloevera_how2use));
                break;

        }

    }

    public void onCard2Click(View view) {
        switch (title_card2.getText().toString()){
            case "Coriander":
                showDlg(resources.getString(R.string.coriander_how2use));
                break;
            case "Blackberry":
                showDlg(resources.getString(R.string.blackberry_how2use));
                break;
            case "Garlic":
                showDlg(resources.getString(R.string.garlic_how2use));
                break;
            case "Tulsi":
                showDlg(resources.getString(R.string.tulsi_how2use));
                break;
            case "Orange Peel":
                showDlg(resources.getString(R.string.orange_peel_how2use));
                break;
        }


    }

    public void onCard3Click(View view) {
        switch (title_card3.getText().toString()){
            case "Lemon Grass":
                showDlg(resources.getString(R.string.lemon_grass_how2use));
                break;
            case "Lemon":
                showDlg(resources.getString(R.string.lemon_how2use));
                break;
            case "Black Pepper":
                showDlg(resources.getString(R.string.black_pepper_how2use));
                break;
            case "Ecalyptus":
                showDlg(resources.getString(R.string.ecalyptus_how2use));
                break;
            case "Tomato":
                showDlg(resources.getString(R.string.tomato_how2use));
                break;

        }

    }

    public void showDlg(String msg){
        new AlertDialog.Builder(this).setMessage(msg)
                .setPositiveButton("Ok",null)
                .show();
    }
    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


}
