package com.example.ninashadzrina.mycounsellor.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

public class ManageResult extends AppCompatActivity {

    String sic, sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_result);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
    }

    public void btnHome (View view){
        Intent intent = new Intent (this, Home.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void intelligenceButton (View view){
        Intent intent = new Intent (this, ViewResult.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void examButton (View view){
        Intent intent = new Intent (this, ViewExam.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
