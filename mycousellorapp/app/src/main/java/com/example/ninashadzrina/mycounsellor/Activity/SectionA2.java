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

public class SectionA2 extends AppCompatActivity {
    String sic, sid, result1, result2, desc1, desc2;
    int q11,q12,q13,q14,q15,q16,q17,q18,q19,q20,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_a2);

        Intent intent = getIntent();

        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        result1 = intent.getStringExtra(UserConfig.RESULT1);
        desc1 = intent.getStringExtra(UserConfig.DESC1);

    }



    public void selectAnswerq11(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb11Y:
                if (checked)

                    q11 = 1;

                break;

            case R.id.rb11T:
                if(checked)

                    q11 = 0;

                break;

        }
    }

    public void selectAnswerq12(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb12Y:
                if (checked)

                    q12 = 1;

                break;

            case R.id.rb12T:
                if(checked)

                    q12 = 0;

                break;




        }
    }

    public void selectAnswerq13(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb13Y:
                if (checked)

                    q13 = 1;

                break;

            case R.id.rb13T:
                if(checked)

                    q13 = 0;

                break;




        }
    }

    public void selectAnswerq14(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb14Y:
                if (checked)

                    q14 = 1;

                break;

            case R.id.rb14T:
                if(checked)

                    q14 = 0;

                break;




        }
    }

    public void selectAnswerq15(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb15Y:
                if (checked)

                    q15 = 1;

                break;

            case R.id.rb15T:
                if(checked)

                    q15 = 0;

                break;




        }
    }

    public void selectAnswerq16(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb16Y:
                if (checked)

                    q16 = 1;

                break;

            case R.id.rb16T:
                if(checked)

                    q16 = 0;

                break;




        }
    }

    public void selectAnswerq17(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb17Y:
                if (checked)

                    q17 = 1;

                break;

            case R.id.rb17T:
                if(checked)

                    q17 = 0;

                break;




        }
    }

    public void selectAnswerq18(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb18Y:
                if (checked)

                    q18 = 1;

                break;

            case R.id.rb12T:
                if(checked)

                    q18 = 0;

                break;




        }
    }

    public void selectAnswerq19(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb19Y:
                if (checked)

                    q19 = 1;

                break;

            case R.id.rb19T:
                if(checked)

                    q19 = 0;

                break;




        }
    }

    public void selectAnswerq20(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb20Y:
                if (checked)

                    q20 = 1;

                break;

            case R.id.rb20T:
                if(checked)

                    q20 = 0;

                break;




        }
    }

    public void btnNextA2(View view){

        total = q11+q12+q13+q14+q15+q16+q17+q18+q19+q20;

        if (total >= 8)
        {
            desc2 = "Major";
            Toast.makeText(SectionA2.this,"Major dalam kategori logikal matematik",Toast.LENGTH_LONG).show();
        }
        else
        {
            desc2 = "Minor";
            Toast.makeText(SectionA2.this,"Minor dalam kategori logikal matematik",Toast.LENGTH_LONG).show();
        }

        result2 = Integer.toString(total);

        Intent intent = new Intent(this, SectionA3.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);
        bundle.putString(UserConfig.RESULT1,result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}

