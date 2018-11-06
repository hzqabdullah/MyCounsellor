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

public class SectionB8 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, result4, result5, result6,result7,result8, desc1, desc2, desc3, desc4, desc5, desc6, desc7, desc8;
    int q71,q72,q73,q74,q75,q76,q77,q78,q79,q80,total;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_b8);

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

        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
        desc4 = intent.getStringExtra(UserConfig.DESC4);
        desc5 = intent.getStringExtra(UserConfig.DESC5);
        desc6 = intent.getStringExtra(UserConfig.DESC6);
        desc7 = intent.getStringExtra(UserConfig.DESC7);

    }



    public void selectAnswerq71(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb71Y:
                if (checked)

                    q71 = 1;

                break;

            case R.id.rb71T:
                if(checked)

                    q71 = 0;

                break;




        }
    }

    public void selectAnswerq72(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb72Y:
                if (checked)

                    q72 = 1;

                break;

            case R.id.rb72T:
                if(checked)

                    q72 = 0;

                break;




        }
    }

    public void selectAnswerq73(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb73Y:
                if (checked)

                    q73 = 1;

                break;

            case R.id.rb73T:
                if(checked)

                    q73 = 0;

                break;




        }
    }

    public void selectAnswerq74(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb74Y:
                if (checked)

                    q74 = 1;

                break;

            case R.id.rb74T:
                if(checked)

                    q74 = 0;

                break;




        }
    }

    public void selectAnswerq75(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb75Y:
                if (checked)

                    q75 = 1;

                break;

            case R.id.rb75T:
                if(checked)

                    q75 = 0;

                break;




        }
    }

    public void selectAnswerq76(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb76Y:
                if (checked)

                    q76 = 1;

                break;

            case R.id.rb76T:
                if(checked)

                    q76 = 0;

                break;




        }
    }

    public void selectAnswerq77(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb77Y:
                if (checked)

                    q77 = 1;

                break;

            case R.id.rb77T:
                if(checked)

                    q77 = 0;

                break;




        }
    }

    public void selectAnswerq78(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb78Y:
                if (checked)

                    q78 = 1;

                break;

            case R.id.rb78T:
                if(checked)

                    q78 = 0;

                break;




        }
    }

    public void selectAnswerq79(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb79Y:
                if (checked)

                    q79 = 1;

                break;

            case R.id.rb79T:
                if(checked)

                    q79 = 0;

                break;




        }
    }

    public void selectAnswerq80(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb80Y:
                if (checked)

                    q80 = 1;

                break;

            case R.id.rb80T:
                if(checked)

                    q80 = 0;

                break;
        }
    }

    public void btnNextB8(View view){

        total = q71+q72+q73+q74+q75+q76+q77+q78+q79+q80;

        if (total >= 8)
        {

            desc8 = "Major";
            Toast.makeText(SectionB8.this,"Major dalam kategori muzikal",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc8 = "Minor";
            Toast.makeText(SectionB8.this,"Minor dalam kategori muzikal",Toast.LENGTH_LONG).show();
        }

        result8 = Integer.toString(total);

        Intent intent = new Intent(this, SectionB9.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC, sic);
        bundle.putString(UserConfig.DSID, sid);

        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.RESULT3, result3);
        bundle.putString(UserConfig.RESULT4, result4);
        bundle.putString(UserConfig.RESULT5, result5);
        bundle.putString(UserConfig.RESULT6, result6);
        bundle.putString(UserConfig.RESULT7, result7);
        bundle.putString(UserConfig.RESULT8, result8);

        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);
        bundle.putString(UserConfig.DESC4, desc4);
        bundle.putString(UserConfig.DESC5, desc5);
        bundle.putString(UserConfig.DESC6, desc6);
        bundle.putString(UserConfig.DESC7, desc7);
        bundle.putString(UserConfig.DESC8, desc8);

        intent.putExtras(bundle);

        startActivity(intent);
    }

}




