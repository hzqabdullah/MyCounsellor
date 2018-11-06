package com.example.ninashadzrina.mycounsellor.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

public class SectionA3 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, desc1, desc2, desc3;
    int q21,q22,q23,q24,q25,q26,q27,q28,q29,q30,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_a3);

        Intent intent = getIntent();

        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        result1 = intent.getStringExtra(UserConfig.RESULT1);
        result2 = intent.getStringExtra(UserConfig.RESULT2);
        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);

    }



    public void selectAnswerq21(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb21Y:
                if (checked)

                    q21 = 1;

                break;

            case R.id.rb20T:
                if(checked)

                    q21 = 0;

                break;




        }
    }

    public void selectAnswerq22(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb22Y:
                if (checked)

                    q22 = 1;

                break;

            case R.id.rb22T:
                if(checked)

                    q22 = 0;

                break;




        }
    }

    public void selectAnswerq23(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb23Y:
                if (checked)

                    q23 = 1;

                break;

            case R.id.rb23T:
                if(checked)

                    q23 = 0;

                break;




        }
    }

    public void selectAnswerq24(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb24Y:
                if (checked)

                    q24 = 1;

                break;

            case R.id.rb24T:
                if(checked)

                    q24 = 0;

                break;




        }
    }

    public void selectAnswerq25(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb25Y:
                if (checked)

                    q25 = 1;

                break;

            case R.id.rb25T:
                if(checked)

                    q25 = 0;

                break;




        }
    }

    public void selectAnswerq26(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb26Y:
                if (checked)

                    q26 = 1;

                break;

            case R.id.rb26T:
                if(checked)

                    q26 = 0;

                break;




        }
    }

    public void selectAnswerq27(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb27Y:
                if (checked)

                    q27 = 1;

                break;

            case R.id.rb27T:
                if(checked)

                    q27 = 0;

                break;

        }
    }

    public void selectAnswerq28(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb28Y:
                if (checked)

                    q28 = 1;

                break;

            case R.id.rb28T:
                if(checked)

                    q28 = 0;

                break;




        }
    }

    public void selectAnswerq29(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb29Y:
                if (checked)

                    q29 = 1;

                break;

            case R.id.rb29T:
                if(checked)

                    q29 = 0;

                break;




        }
    }

    public void selectAnswerq30(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb30Y:
                if (checked)

                    q30 = 1;

                break;

            case R.id.rb20T:
                if(checked)

                    q30 = 0;

                break;




        }
    }

    public void btnNextA3(View view){

        total = q21+q22+q23+q24+q25+q26+q27+q28+q29+q30;

        if (total >= 8)
        {

            desc3 = "Major";
            Toast.makeText(SectionA3.this,"Major dalam kategori intrapersonal",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc3 = "Minor";
            Toast.makeText(SectionA3.this,"Minor dalam kategori intrapersonal",Toast.LENGTH_LONG).show();
        }

        result3 = Integer.toString(total);

        Intent intent = new Intent(this, SectionA4.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID, sid);
        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.RESULT3, result3);
        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}