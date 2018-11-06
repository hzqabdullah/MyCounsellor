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

public class SectionB9 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, result4, result5, result6,result7,result8,result9,
            desc1, desc2, desc3, desc4, desc5, desc6, desc7, desc8, desc9;
    int q81,q82,q83,q84,q85,q86,q87,q88,q89,q90,total;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_b9);

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

        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
        desc4 = intent.getStringExtra(UserConfig.DESC4);
        desc5 = intent.getStringExtra(UserConfig.DESC5);
        desc6 = intent.getStringExtra(UserConfig.DESC6);
        desc7 = intent.getStringExtra(UserConfig.DESC7);
        desc8 = intent.getStringExtra(UserConfig.DESC8);

    }

    public void btnNextB9(View view){

        total = q81+q82+q83+q84+q85+q86+q87+q88+q89+q90;

        if (total >= 8)
        {

            desc9 = "Major";
            Toast.makeText(SectionB9.this,"Major dalam kategori eksistensial",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc9 = "Minor";
            Toast.makeText(SectionB9.this,"Minor dalam kategori eksistensial",Toast.LENGTH_LONG).show();
        }

        result9 = Integer.toString(total);

        Intent intent = new Intent(this, Result.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID, sid);

        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.RESULT3, result3);
        bundle.putString(UserConfig.RESULT4, result4);
        bundle.putString(UserConfig.RESULT5, result5);
        bundle.putString(UserConfig.RESULT6, result6);
        bundle.putString(UserConfig.RESULT7, result7);
        bundle.putString(UserConfig.RESULT8, result8);
        bundle.putString(UserConfig.RESULT9, result9);

        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);
        bundle.putString(UserConfig.DESC4, desc4);
        bundle.putString(UserConfig.DESC5, desc5);
        bundle.putString(UserConfig.DESC6, desc6);
        bundle.putString(UserConfig.DESC7, desc7);
        bundle.putString(UserConfig.DESC8, desc8);
        bundle.putString(UserConfig.DESC9, desc9);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void selectAnswerq81(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb81Y:
                if (checked)

                    q81 = 1;

                break;

            case R.id.rb81T:
                if(checked)

                    q81 = 0;

                break;


        }
    }

    public void selectAnswerq82(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb82Y:
                if (checked)

                    q82 = 1;

                break;

            case R.id.rb82T:
                if(checked)

                    q82 = 0;

                break;

        }
    }

    public void selectAnswerq83(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb83Y:
                if (checked)

                    q83 = 1;

                break;

            case R.id.rb83T:
                if(checked)

                    q83 = 0;

                break;
        }
    }

    public void selectAnswerq84(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb84Y:
                if (checked)

                    q84 = 1;

                break;

            case R.id.rb84T:
                if(checked)

                    q84 = 0;

                break;

        }
    }

    public void selectAnswerq85(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb85Y:
                if (checked)

                    q85 = 1;

                break;

            case R.id.rb85T:
                if(checked)

                    q85 = 0;

                break;

        }
    }

    public void selectAnswerq86(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb86Y:
                if (checked)

                    q86 = 1;

                break;

            case R.id.rb86T:
                if(checked)

                    q86 = 0;

                break;
        }
    }


    public void selectAnswerq87(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb87Y:
                if (checked)

                    q87 = 1;

                break;

            case R.id.rb87T:
                if(checked)

                    q87 = 0;

                break;


        }
    }

    public void selectAnswerq88(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb88Y:
                if (checked)

                    q88 = 1;

                break;

            case R.id.rb88T:
                if(checked)

                    q88 = 0;

                break;


        }
    }

    public void selectAnswerq89(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb89Y:
                if (checked)

                    q89 = 1;

                break;

            case R.id.rb89T:
                if(checked)

                    q89 = 0;

                break;

        }
    }

    public void selectAnswerq90(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb90Y:
                if (checked)

                    q90 = 1;

                break;

            case R.id.rb90T:
                if(checked)

                    q90 = 0;

                break;

        }
    }
}

