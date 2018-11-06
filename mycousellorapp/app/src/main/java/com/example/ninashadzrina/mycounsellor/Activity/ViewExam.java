package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ninashadzrina.mycounsellor.Adapter.ExamAdapter;
import com.example.ninashadzrina.mycounsellor.Adapter.ResultAdapter;
import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewExam extends AppCompatActivity implements ListView.OnItemClickListener{

    String sic, sid, JSON_STRING;
    ListView lvExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_exam);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);

        lvExam = (ListView) findViewById(R.id.lvExam);
        lvExam.setOnItemClickListener(this);

        DisplayExam();
    }

    public void btnHome (View view)
    {
        Intent intent = new Intent (this, ManageResult.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID,sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void DisplayExam ()
    {
        class getDisplayResult extends AsyncTask<Void, Void, String> {

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(ViewExam.this,"Data fetching...", "Please Wait...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                progressDialog.dismiss();
                JSON_STRING = s;
                showExam();
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(UserConfig.VIEWEXAM, sid);
                return s;

            }

        }

        getDisplayResult gdr = new getDisplayResult();
        gdr.execute();
    }

    private void showExam(){
        JSONObject jsonObject = null;
        ArrayList<HashMap<String, String>> listExam = new ArrayList<HashMap <String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(UserConfig.JSON_RESULT);

            for (int i = 0; i < result.length(); i ++)
            {
                JSONObject jo = result.getJSONObject(i);

                String rid = jo.getString(UserConfig.RID);
                String rtitle = jo.getString(UserConfig.RTITLE);

                HashMap <String, String> viewexam = new HashMap<>();

                viewexam.put(UserConfig.RID, rid);
                viewexam.put(UserConfig.RTITLE, rtitle);

                listExam.add(viewexam);

            }

        }
        catch(JSONException e){
            e.printStackTrace();
        }

        ExamAdapter examAdapter = new ExamAdapter( this, listExam);
        lvExam.setAdapter(examAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        Intent intent = new Intent(this, ExamDetails.class);
        HashMap<String, String> map = (HashMap)adapterView.getItemAtPosition(i);

        String r_id = map.get(UserConfig.RID).toString();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.R_ID, r_id);
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
