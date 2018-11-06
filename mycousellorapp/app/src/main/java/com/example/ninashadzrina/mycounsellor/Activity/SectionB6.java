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

public class SectionB6 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, result4, result5, result6, desc1, desc2, desc3, desc4, desc5, desc6;
    int q51,q52,q53,q54,q55,q56,q57,q58,q59,q60,total;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_b6);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        result1 = intent.getStringExtra(UserConfig.RESULT1);
        result2 = intent.getStringExtra(UserConfig.RESULT2);
        result3 = intent.getStringExtra(UserConfig.RESULT3);
        result4 = intent.getStringExtra(UserConfig.RESULT4);
        result5 = intent.getStringExtra(UserConfig.RESULT5);
        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
        desc4 = intent.getStringExtra(UserConfig.DESC4);
        desc5 = intent.getStringExtra(UserConfig.DESC5);


    }


    public void selectAnswerq51(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb51Y:
                if (checked)

                    q51 = 1;

                break;

            case R.id.rb51T:
                if(checked)

                    q51 = 0;

                break;




        }
    }

    public void selectAnswerq52(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb52Y:
                if (checked)

                    q52 = 1;

                break;

            case R.id.rb52T:
                if(checked)

                    q52 = 0;

                break;




        }
    }

    public void selectAnswerq53(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb53Y:
                if (checked)

                    q53 = 1;

                break;

            case R.id.rb53T:
                if(checked)

                    q53 = 0;

                break;




        }
    }

    public void selectAnswerq54(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb54Y:
                if (checked)

                    q54 = 1;

                break;

            case R.id.rb54T:
                if(checked)

                    q54 = 0;

                break;




        }
    }

    public void selectAnswerq55(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb55Y:
                if (checked)

                    q55 = 1;

                break;

            case R.id.rb55T:
                if(checked)

                    q55 = 0;

                break;




        }
    }

    public void selectAnswerq56(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb56Y:
                if (checked)

                    q56 = 1;

                break;

            case R.id.rb56T:
                if(checked)

                    q56 = 0;

                break;




        }
    }

    public void selectAnswerq57(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb57Y:
                if (checked)

                    q57 = 1;

                break;

            case R.id.rb57T:
                if(checked)

                    q57 = 0;

                break;




        }
    }

    public void selectAnswerq58(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb58Y:
                if (checked)

                    q58 = 1;

                break;

            case R.id.rb58T:
                if(checked)

                    q58 = 0;

                break;




        }
    }

    public void selectAnswerq59(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb59Y:
                if (checked)

                    q59 = 1;

                break;

            case R.id.rb59T:
                if(checked)

                    q59 = 0;

                break;




        }
    }

    public void selectAnswerq60(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb60Y:
                if (checked)

                    q60 = 1;

                break;

            case R.id.rb60T:
                if(checked)

                    q60 = 0;

                break;




        }
    }

    public void btnNextB6(View view){

        total = q51+q52+q53+q54+q55+q56+q57+q58+q59+q60;

        if (total >= 8)
        {

            desc6 = "Major";
            Toast.makeText(SectionB6.this,"Major dalam kategori interpersonal",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc6 = "Minor";
            Toast.makeText(SectionB6.this,"Minor dalam kategori interpersonal",Toast.LENGTH_LONG).show();
        }

        result6 = Integer.toString(total);

        Intent intent = new Intent(this, SectionB7.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID,sid);

        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.RESULT3, result3);
        bundle.putString(UserConfig.RESULT4, result4);
        bundle.putString(UserConfig.RESULT5, result5);
        bundle.putString(UserConfig.RESULT6, result6);

        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);
        bundle.putString(UserConfig.DESC4, desc4);
        bundle.putString(UserConfig.DESC5, desc5);
        bundle.putString(UserConfig.DESC6, desc6);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}

