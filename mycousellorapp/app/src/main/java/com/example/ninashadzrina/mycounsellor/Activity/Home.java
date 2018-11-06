package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ninashadzrina.mycounsellor.R;

import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.squareup.picasso.Picasso;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;

public class Home extends AppCompatActivity {

    TextView txtprofilename,txtclass,txtage,txtaddress,txtphone,display;
    String sic, sid, firstname, lastname, profilename, classname, studentage, studentimage, studentaddress, studentphone;
    ProgressDialog loading;
    ImageView studentPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        display = findViewById(R.id.display);
        txtprofilename = findViewById(R.id.txtprofilename);
        txtaddress = findViewById(R.id.txtaddress);
        txtphone = findViewById(R.id.txtphone);
        txtprofilename = findViewById(R.id.txtprofilename);
        txtclass = findViewById(R.id.txtclass);
        txtage = findViewById(R.id.txtage);
        studentPhoto = findViewById(R.id.studentPhoto);


        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);

        getStudentIC();

    }

    private void getStudentIC(){
        class GetStudent extends AsyncTask<Void, Void, String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Home.this,"Data fetching...", "Please Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showStudent(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(UserConfig.HOME,sic);
                return s;
            }
        }
        GetStudent gs = new GetStudent();
        gs.execute();
    }


    public void showStudent(String json){

        try
        {
            JSONObject jsonObject= new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(UserConfig.JSON_RESULT);
            JSONObject c = result.getJSONObject(0);

            sid = c.getString(UserConfig.DSID);

            firstname = c.getString(UserConfig.DSFIRSTNAME);
            lastname = c.getString(UserConfig.DSLASTNAME);

            profilename = firstname+" "+lastname;

            display.setText("Selamat Datang, "+firstname+"!");
            txtprofilename.setText(profilename);

            classname = c.getString(UserConfig.DSCLASS);
            txtclass.setText(classname);

            studentage = c.getString(UserConfig.DSAGE);
            txtage.setText(studentage);

            studentaddress = c.getString(UserConfig.DSADDRESS);
            txtaddress.setText(studentaddress);

            studentphone = c.getString(UserConfig.DSPHONE);
            txtphone.setText(studentphone);

            studentimage = c.getString(UserConfig.DSPHOTO);

            String studenturl = "http://www.findmyustaz.com/mycounsellor/counsellor/student/photo/"+studentimage;

            if(studenturl.isEmpty())
            {
                Picasso.with(this)
                        .load(R.drawable.avatar)
                        .placeholder(R.drawable.avatar)
                        .error(R.drawable.avatar)
                        .into(studentPhoto);

            }
            else
            {
                Picasso.with(this)
                        .load(studenturl)
                        .placeholder(R.drawable.avatar)
                        .error(R.drawable.avatar)
                        .into(studentPhoto);
            }


        }
        catch (JSONException e){
            e.printStackTrace();
        }

    }

    public void btnAttempt(View view)
    {
        Intent intent = new Intent(this, SectionA1.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void btnResult(View view)
    {
        Intent intent = new Intent(this, ManageResult.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void Logout(View view)
    {
        confirmLogout();
    }

    private void confirmLogout(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Adakah anda pasti untuk log keluar?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Toast.makeText(getApplicationContext(), "Anda telah berjaya log keluar!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        finish();
                        startActivity(intent);

                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
