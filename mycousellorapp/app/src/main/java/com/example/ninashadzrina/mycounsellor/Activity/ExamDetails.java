package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExamDetails extends AppCompatActivity {

    TextView txtbm, txtbi, txtpai, txtmt, txtsc, txtsj, txtgeo, txtkh, txttitle;

    String sic, rid, sid, bm, bi, pai, mt, sc, sj, geo, kh, title;

    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_details);

        txtbm = findViewById(R.id.txtbm);
        txtbi = findViewById(R.id.txtbi);
        txtpai = findViewById(R.id.txtpai);
        txtmt = findViewById(R.id.txtmt);
        txtsc = findViewById(R.id.txtsc);
        txtsj = findViewById(R.id.txtsj);
        txtgeo = findViewById(R.id.txtgeo);
        txtkh = findViewById(R.id.txtkh);

        txttitle = findViewById(R.id.txttitle);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        rid = intent.getStringExtra(UserConfig.R_ID);

        getExam();
    }

    private void getExam() {
        class GetResult extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ExamDetails.this,"Data fetching...", "Please Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showExam(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(UserConfig.EXAMDETAILS, rid);
                return s;

            }
        }
        GetResult gr = new GetResult();
        gr.execute();
    }

    private void showExam(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(UserConfig.JSON_RESULT);
            JSONObject c = result.getJSONObject(0);

            title = c.getString(UserConfig.RTITLE);
            txttitle.setText("Markah "+title);

            bm = c.getString(UserConfig.RBM);
            txtbm.setText(bm);

            bi = c.getString(UserConfig.RBI);
            txtbi.setText(bi);

            pai = c.getString(UserConfig.RPAI);
            txtpai.setText(pai);

            mt = c.getString(UserConfig.RMT);
            txtmt.setText(mt);

            sc = c.getString(UserConfig.RSC);
            txtsc.setText(sc);

            sj = c.getString(UserConfig.RSJ);
            txtsj.setText(sj);

            geo = c.getString(UserConfig.RGEO);
            txtgeo.setText(geo);

            kh = c.getString(UserConfig.RKH);
            txtkh.setText(kh);


        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

    }

    public void btnBack(View view)
    {
        Intent intent = new Intent (this, ViewExam.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }

}
