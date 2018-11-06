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

public class SectionB5 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, result4, result5, desc1, desc2, desc3, desc4, desc5;
    int q41,q42,q43,q44,q45,q46,q47,q48,q49,q50,total;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_b5);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        result1 = intent.getStringExtra(UserConfig.RESULT1);
        result2 = intent.getStringExtra(UserConfig.RESULT2);
        result3 = intent.getStringExtra(UserConfig.RESULT3);
        result4 = intent.getStringExtra(UserConfig.RESULT4);
        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
        desc4 = intent.getStringExtra(UserConfig.DESC4);

    }


    public void selectAnswerq41(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb41Y:
                if (checked)

                    q41 = 1;

                break;

            case R.id.rb41T:
                if(checked)

                    q41 = 0;

                break;




        }
    }

    public void selectAnswerq42(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb42Y:
                if (checked)

                    q42 = 1;

                break;

            case R.id.rb42T:
                if(checked)

                    q42 = 0;

                break;




        }
    }

    public void selectAnswerq43(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb43Y:
                if (checked)

                    q43 = 1;

                break;

            case R.id.rb43T:
                if(checked)

                    q43 = 0;

                break;




        }
    }

    public void selectAnswerq44(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb44Y:
                if (checked)

                    q44 = 1;

                break;

            case R.id.rb44T:
                if(checked)

                    q44 = 0;

                break;




        }
    }

    public void selectAnswerq45(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb45Y:
                if (checked)

                    q45 = 1;

                break;

            case R.id.rb45T:
                if(checked)

                    q45 = 0;

                break;




        }
    }

    public void selectAnswerq46(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb46Y:
                if (checked)

                    q46 = 1;

                break;

            case R.id.rb46T:
                if(checked)

                    q46 = 0;

                break;




        }
    }

    public void selectAnswerq47(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb47Y:
                if (checked)

                    q47 = 1;

                break;

            case R.id.rb47T:
                if(checked)

                    q47 = 0;

                break;




        }
    }

    public void selectAnswerq48(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb48Y:
                if (checked)

                    q48 = 1;

                break;

            case R.id.rb48T:
                if(checked)

                    q48 = 0;

                break;




        }
    }

    public void selectAnswerq49(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb49Y:
                if (checked)

                    q49 = 1;

                break;

            case R.id.rb49T:
                if(checked)

                    q49 = 0;

                break;




        }
    }

    public void selectAnswerq50(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb50Y:
                if (checked)

                    q50 = 1;

                break;

            case R.id.rb50T:
                if(checked)

                    q50 = 0;

                break;

        }
    }

    public void btnNextB5(View view){

        total = q41+q42+q43+q44+q45+q46+q47+q48+q49+q50;

        if (total >= 8)
        {

            desc5 = "Major";
            Toast.makeText(SectionB5.this,"Major dalam kategori naturalisasi",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc5 = "Minor";
            Toast.makeText(SectionB5.this,"Minor dalam kategori naturalisasi",Toast.LENGTH_LONG).show();
        }

        result5 = Integer.toString(total);

        Intent intent = new Intent(this, SectionB6.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID,sid);
        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.RESULT3, result3);
        bundle.putString(UserConfig.RESULT4, result4);
        bundle.putString(UserConfig.RESULT5, result5);
        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);
        bundle.putString(UserConfig.DESC4, desc4);
        bundle.putString(UserConfig.DESC5, desc5);


        intent.putExtras(bundle);

        startActivity(intent);
    }
}
