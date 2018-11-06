package com.example.ninashadzrina.mycounsellor.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

public class SectionA1 extends AppCompatActivity {
    String sic, sid, result1, desc1;
    int q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_a1);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);

    }

    public void btnHome (View view){
        Intent intent = new Intent (this, Home.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void selectAnswer(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
                case R.id.rb1Y:
                if (checked)

                q1 = 1;

                break;

                case R.id.rb1T:
                if(checked)

                q1 = 0;

                break;

        }

    }

    public void selectAnswerq2(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb2Y:
                if (checked)

                    q2 = 1;

                break;

            case R.id.rb2T:
                if(checked)

                    q2 = 0;

                break;

        }
    }

    public void selectAnswerq3(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb3Y:
                if (checked)

                    q3 = 1;

                break;

            case R.id.rb3T:
                if(checked)

                    q3 = 0;

                break;

        }
    }

    public void selectAnswerq4(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb4Y:
                if (checked)

                    q4 = 1;

                break;

            case R.id.rb4T:
                if(checked)

                    q4 = 0;

                break;

        }
    }

    public void selectAnswerq5(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb5Y:
                if (checked)

                    q5 = 1;

                break;

            case R.id.rb5T:
                if(checked)

                    q5 = 0;

                break;
        }
    }

    public void selectAnswerq6(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb6Y:
                if (checked)

                    q6 = 1;

                break;

            case R.id.rb6T:
                if(checked)

                    q6 = 0;

                break;
        }
    }

    public void selectAnswerq7(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb7Y:
                if (checked)

                    q7 = 1;

                break;

            case R.id.rb7T:
                if(checked)

                    q7 = 0;

                break;




        }
    }

    public void selectAnswerq8(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb8Y:
                if (checked)

                    q8 = 1;

                break;

            case R.id.rb8T:
                if(checked)

                    q8 = 0;

                break;

        }
    }

    public void selectAnswerq9(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb9Y:
                if (checked)

                    q9 = 1;

                break;

            case R.id.rb9T:
                if(checked)

                    q9 = 0;

                break;
        }
    }

    public void selectAnswerq10(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb10Y:
                if (checked)

                    q10 = 1;

                break;

            case R.id.rb10T:
                if(checked)

                    q10 = 0;

                break;
        }
    }

    public void btnNextA1 (View view){


        total = q1+q2+q3+q4+q5+q6+q7+q8+q9+q10;

        if (total >= 8)
        {

            desc1 = "Major";
            Toast.makeText(SectionA1.this,"Major dalam kategori linguistik",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc1 = "Minor";
            Toast.makeText(SectionA1.this,"Minor dalam kategori linguistik",Toast.LENGTH_LONG).show();
        }

        result1 = Integer.toString(total);

        Intent intent = new Intent(this, SectionA2.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID,sid);
        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.DESC1, desc1);

        intent.putExtras(bundle);

        startActivity(intent);
    }

}
