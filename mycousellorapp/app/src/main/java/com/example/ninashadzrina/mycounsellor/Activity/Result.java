package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import java.util.HashMap;

public class Result extends AppCompatActivity {
    String sic, sid, result1,result2,result3,result4,result5,result6,result7,result8,result9, total,
            desc1, desc2, desc3, desc4, desc5, desc6, desc7, desc8, desc9;
    int resultTotal1,resultTotal2,resultTotal3,resultTotal4,resultTotal5,resultTotal6,resultTotal7,resultTotal8,resultTotal9, totalAll;

    ProgressDialog progressDialog;

    TextView textViewResultAnalisis1,textViewResultAnalisis2,textViewResultAnalisis3,textViewResultAnalisis4,
            textViewResultAnalisis5,textViewResultAnalisis6,textViewResultAnalisis7,textViewResultAnalisis8,textViewResultAnalisis9, textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        textViewResult = findViewById(R.id.textviewResult);
        textViewResultAnalisis1 = findViewById(R.id.textviewResultAnalisis1);
        textViewResultAnalisis2 = findViewById(R.id.textviewResultAnalisis2);
        textViewResultAnalisis3 = findViewById(R.id.textviewResultAnalisis3);
        textViewResultAnalisis4 = findViewById(R.id.textviewResultAnalisis4);
        textViewResultAnalisis5 = findViewById(R.id.textviewResultAnalisis5);
        textViewResultAnalisis6 = findViewById(R.id.textviewResultAnalisis6);
        textViewResultAnalisis7 = findViewById(R.id.textviewResultAnalisis7);
        textViewResultAnalisis8 = findViewById(R.id.textviewResultAnalisis8);
        textViewResultAnalisis9 = findViewById(R.id.textviewResultAnalisis9);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);

        result1 = intent.getStringExtra(UserConfig.RESULT1);
        result2 = intent.getStringExtra(UserConfig.RESULT2);
        result3 = intent.getStringExtra(UserConfig.RESULT3);
        result4 = intent.getStringExtra(UserConfig.RESULT4);
        result5 = intent.getStringExtra(UserConfig.RESULT5);
        result6 = intent.getStringExtra(UserConfig.RESULT6);
        result7 = intent.getStringExtra(UserConfig.RESULT7);
        result8 = intent.getStringExtra(UserConfig.RESULT8);
        result9 = intent.getStringExtra(UserConfig.RESULT9);

        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
        desc4 = intent.getStringExtra(UserConfig.DESC4);
        desc5 = intent.getStringExtra(UserConfig.DESC5);
        desc6 = intent.getStringExtra(UserConfig.DESC6);
        desc7 = intent.getStringExtra(UserConfig.DESC7);
        desc8 = intent.getStringExtra(UserConfig.DESC8);
        desc9 = intent.getStringExtra(UserConfig.DESC9);

        resultTotal1 = Integer.parseInt(result1);
        resultTotal2 = Integer.parseInt(result2);
        resultTotal3 = Integer.parseInt(result3);
        resultTotal4 = Integer.parseInt(result4);
        resultTotal5 = Integer.parseInt(result5);
        resultTotal6 = Integer.parseInt(result6);
        resultTotal7 = Integer.parseInt(result7);
        resultTotal8 = Integer.parseInt(result8);
        resultTotal9 = Integer.parseInt(result9);

        totalAll = resultTotal1 + resultTotal2 + resultTotal3 + resultTotal4 + resultTotal5 + resultTotal6 + resultTotal7 + resultTotal8 + resultTotal9;
        total = Integer.toString(totalAll);

        textViewResult.setText(total);
        textViewResultAnalisis1.setText(desc1);
        textViewResultAnalisis2.setText(desc2);
        textViewResultAnalisis3.setText(desc3);
        textViewResultAnalisis4.setText(desc4);
        textViewResultAnalisis5.setText(desc5);
        textViewResultAnalisis6.setText(desc6);
        textViewResultAnalisis7.setText(desc7);
        textViewResultAnalisis8.setText(desc8);
        textViewResultAnalisis9.setText(desc9);

    }

    public void btnSaveResult(View view){


        class addresult extends AsyncTask<Void, Void, String>
        {
            @Override
            protected void onPreExecute() {
                progressDialog = ProgressDialog.show(Result.this, "Loading Data...", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                if(s.equalsIgnoreCase("The result has been save into the database"))
                {
                    Toast.makeText(Result.this, s, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent (getApplicationContext(), ViewResult.class);
                    finish();

                    Bundle bundle = new Bundle();
                    bundle.putString(UserConfig.SIC, sic);
                    bundle.putString(UserConfig.DSID, sid);

                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Result.this, s, Toast.LENGTH_LONG).show();
                }

            }

            @Override
            protected String doInBackground(Void... v) {

                HashMap<String, String> params = new HashMap<>();

                params.put(UserConfig.RESULT1, result1);
                params.put(UserConfig.RESULT2, result2);
                params.put(UserConfig.RESULT3, result3);
                params.put(UserConfig.RESULT4, result4);
                params.put(UserConfig.RESULT5, result5);
                params.put(UserConfig.RESULT6, result6);
                params.put(UserConfig.RESULT7, result7);
                params.put(UserConfig.RESULT8, result8);
                params.put(UserConfig.RESULT9, result9);

                params.put(UserConfig.DESC1, desc1);
                params.put(UserConfig.DESC2, desc2);
                params.put(UserConfig.DESC3, desc3);
                params.put(UserConfig.DESC4, desc4);
                params.put(UserConfig.DESC5, desc5);
                params.put(UserConfig.DESC6, desc6);
                params.put(UserConfig.DESC7, desc7);
                params.put(UserConfig.DESC8, desc8);
                params.put(UserConfig.DESC9, desc9);
                params.put(UserConfig.DSID, sid);

                params.put(UserConfig.TOTAL, total);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(UserConfig.ADDRESULT, params);
                return res;

            }

        }

        addresult ar = new addresult();
        ar.execute();

    }
    

}
