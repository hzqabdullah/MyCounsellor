package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.ninashadzrina.mycounsellor.Adapter.ResultAdapter;
import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewResult extends AppCompatActivity implements ListView.OnItemClickListener{

    String sic, sid, JSON_STRING;
    ListView lvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_result);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);

        lvResult = (ListView) findViewById(R.id.lvResult);
        lvResult.setOnItemClickListener(this);

        DisplayResult();

    }

    public void btnHome (View view){
        Intent intent = new Intent (this, ManageResult.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID,sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void DisplayResult (){
        class getDisplayResult extends AsyncTask<Void, Void, String>{

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(ViewResult.this,"Data fetching...", "Please Wait...", false, false);

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                progressDialog.dismiss();
                JSON_STRING = s;
                showResult();
            }

            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(UserConfig.VIEWRESULT, sid);
                return s;

            }


        }

        getDisplayResult gdr = new getDisplayResult();
        gdr.execute();
    }

    private void showResult(){
        JSONObject jsonObject = null;
        ArrayList<HashMap <String, String>> listResult = new ArrayList<HashMap <String, String>>();

        try {
            jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(UserConfig.JSON_RESULT);

            for (int i = 0; i < result.length(); i ++)
            {
                JSONObject jo = result.getJSONObject(i);

                String iid = jo.getString(UserConfig.IID);
                String itotal = jo.getString(UserConfig.ITOTAL);

                HashMap <String, String> viewresult = new HashMap<>();

                viewresult.put(UserConfig.IID, iid);
                viewresult.put(UserConfig.ITOTAL, itotal);

                listResult.add(viewresult);

            }

        }
        catch(JSONException e){
            e.printStackTrace();
        }

        ResultAdapter resultAdapter = new ResultAdapter( this, listResult);
        lvResult.setAdapter(resultAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        Intent intent = new Intent(this, ResultDetails.class);
        HashMap<String, String> map = (HashMap)adapterView.getItemAtPosition(i);

        String i_id = map.get(UserConfig.IID).toString();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.I_ID, i_id);
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
