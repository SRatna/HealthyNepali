package com.practice.osho.healthynepali;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class PostedQueriesActivity extends AppCompatActivity {

    ListView lv_postedQueries;
    ArrayList<ParseObject> postedQueries;
    PostedQueriesArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posted_queries);

        lv_postedQueries = (ListView)findViewById(R.id.lv_postedQueries);
        postedQueries = new ArrayList<ParseObject>();

        populateArrayList();

        lv_postedQueries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final View layout = PostedQueriesActivity.this.getLayoutInflater().inflate(R.layout.health_tip_popup, null);
                final TextView tv_answer = (TextView) layout.findViewById(R.id.tv_tip);


                final AlertDialog.Builder dlg_answer = new AlertDialog.Builder(PostedQueriesActivity.this);
                dlg_answer.setView(layout);
                dlg_answer.setTitle("Expert's Reply");
                dlg_answer.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                String reply = postedQueries.get(i).getString("answers");

                if (reply == null || reply.equals("")) {
                    tv_answer.setText("Sorry! Your query hasn't been replied yet.Please wait till you are notified.");

                } else {
                    tv_answer.setText(reply);

                }
                dlg_answer.show();

            }
        });






    }

    private void populateArrayList(){

        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("postedQueries");
        parseQuery.whereEqualTo("user", ParseUser.getCurrentUser().getUsername());
        parseQuery.addDescendingOrder("createdAt");

        final ProgressDialog progressDialog = new ProgressDialog(PostedQueriesActivity.this);
        progressDialog.setMessage("Loading your Posted Queries....");
        progressDialog.show();

        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if(e==null){
                    if(objects.size()==0){
                        Toast.makeText(PostedQueriesActivity.this,"No Posted Queries found",Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                    } else {
                        for(int i=0;i < objects.size();i++) postedQueries.add(objects.get(i));

                        adapter=new PostedQueriesArrayAdapter(PostedQueriesActivity.this,postedQueries);
                        lv_postedQueries.setAdapter(adapter);
                        progressDialog.dismiss();
                    }

                } else {
                    Toast.makeText(PostedQueriesActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_posted_queries, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
