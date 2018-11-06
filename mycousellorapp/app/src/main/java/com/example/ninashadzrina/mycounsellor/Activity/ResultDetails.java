package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ResultDetails extends AppCompatActivity {

    TextView txtresultA1,txtresultA2,txtresultA3,txtresultA4,txtresultB5,txtresultB6,
            txtresultB7,txtresultB8,txtresultB9, totalresultDetails, txtdescresultA1, txtdescresultA2, txtdescresultA3,
            txtdescresultA4, txtdescresultB5, txtdescresultB6, txtdescresultB7, txtdescresultB8, txtdescresultB9 ;

    String sic, iid, id, sid, resultA1, resultA2, resultA3, resultA4, resultB5, resultB6, resultB7, resultB8, resultB9, itotal,
    desc1, desc2, desc3, desc4, desc5, desc6, desc7, desc8, desc9;

    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_details);

        txtresultA1 = findViewById(R.id.txtresultA1);
        txtresultA2 = findViewById(R.id.txtresultA2);
        txtresultA3 = findViewById(R.id.txtresultA3);
        txtresultA4 = findViewById(R.id.txtresultA4);
        txtresultB5 = findViewById(R.id.txtresultB5);
        txtresultB6 = findViewById(R.id.txtresultB6);
        txtresultB7 = findViewById(R.id.txtresultB7);
        txtresultB8 = findViewById(R.id.txtresultB8);
        txtresultB9 = findViewById(R.id.txtresultB9);
        totalresultDetails = findViewById(R.id.totalresultDetails);
        txtdescresultA1 = findViewById(R.id.txtdescresultA1);
        txtdescresultA2 = findViewById(R.id.txtdescresultA2);
        txtdescresultA3 = findViewById(R.id.txtdescresultA3);
        txtdescresultA4 = findViewById(R.id.txtdescresultA4);
        txtdescresultB5 = findViewById(R.id.txtdescresultB5);
        txtdescresultB6 = findViewById(R.id.txtdescresultB6);
        txtdescresultB7 = findViewById(R.id.txtdescresultB7);
        txtdescresultB8 = findViewById(R.id.txtdescresultB8);
        txtdescresultB9 = findViewById(R.id.txtdescresultB9);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        iid = intent.getStringExtra(UserConfig.I_ID);

        getResult();
    }

    private void getResult() {
        class GetResult extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ResultDetails.this,"Data fetching...", "Please Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showResult(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(UserConfig.RESULTDETAILS, iid);
                return s;

            }
        }
        GetResult gr = new GetResult();
        gr.execute();
    }

    private void showResult(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(UserConfig.JSON_RESULT);
            JSONObject c = result.getJSONObject(0);

            id = c.getString(UserConfig.IID);

            itotal = c.getString(UserConfig.ITOTAL);
            totalresultDetails.setText(itotal);

            resultA1 = c.getString(UserConfig.IRESULT1);
            txtresultA1.setText(resultA1);

            resultA2 = c.getString(UserConfig.IRESULT2);
            txtresultA2.setText(resultA2);

            resultA3 = c.getString(UserConfig.IRESULT3);
            txtresultA3.setText(resultA3);

            resultA4 = c.getString(UserConfig.IRESULT4);
            txtresultA4.setText(resultA4);

            resultB5 = c.getString(UserConfig.IRESULT5);
            txtresultB5.setText(resultB5);

            resultB6 = c.getString(UserConfig.IRESULT6);
            txtresultB6.setText(resultB6);

            resultB7 = c.getString(UserConfig.IRESULT7);
            txtresultB7.setText(resultB7);

            resultB8 = c.getString(UserConfig.IRESULT8);
            txtresultB8.setText(resultB8);

            resultB9 = c.getString(UserConfig.IRESULT9);
            txtresultB9.setText(resultB9);


            desc1 = c.getString(UserConfig.IDESC1);
            txtdescresultA1.setText(desc1);

            desc2 = c.getString(UserConfig.IDESC2);
            txtdescresultA2.setText(desc2);

            desc3 = c.getString(UserConfig.IDESC3);
            txtdescresultA3.setText(desc3);

            desc4 = c.getString(UserConfig.IDESC4);
            txtdescresultA4.setText(desc4);

            desc5 = c.getString(UserConfig.IDESC5);
            txtdescresultB5.setText(desc5);

            desc6 = c.getString(UserConfig.IDESC6);
            txtdescresultB6.setText(desc6);

            desc7 = c.getString(UserConfig.IDESC7);
            txtdescresultB7.setText(desc7);

            desc8 = c.getString(UserConfig.IDESC8);
            txtdescresultB8.setText(desc8);

            desc9 = c.getString(UserConfig.IDESC9);
            txtdescresultB9.setText(desc9);


        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    public void btnDelete(View view)
    {
        confirmDeleteEvent();
    }

    public void btnBack(View view)
    {
        Intent intent = new Intent (this, ViewResult.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void deleteResult(){
        class DeleteResult extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ResultDetails.this, "Updating data...", "Please wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ResultDetails.this, s, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), ViewResult.class);
                finish();

                Bundle bundle = new Bundle();
                bundle.putString(UserConfig.SIC, sic);
                bundle.putString(UserConfig.DSID, sid);
                intent.putExtras(bundle);
                startActivity(intent);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(UserConfig.DELETERESULT, iid);
                return s;
            }
        }

        DeleteResult dr = new DeleteResult();
        dr.execute();
    }

    private void confirmDeleteEvent(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Anda pasti mahu membuang maklumat ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteResult();

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
