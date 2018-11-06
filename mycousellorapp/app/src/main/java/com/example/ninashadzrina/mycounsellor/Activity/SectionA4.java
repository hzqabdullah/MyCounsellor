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

public class SectionA4 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, result4, desc1, desc2, desc3, desc4;
    int q31,q32,q33,q34,q35,q36,q37,q38,q39,q40,total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_a4);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);
        result1 = intent.getStringExtra(UserConfig.RESULT1);
        result2 = intent.getStringExtra(UserConfig.RESULT2);
        result3 = intent.getStringExtra(UserConfig.RESULT3);
        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
    }



    public void selectAnswerq31(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb31Y:
                if (checked)

                    q31 = 1;

                break;

            case R.id.rb31T:
                if(checked)

                    q31 = 0;

                break;




        }
    }

    public void selectAnswerq32(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb32Y:
                if (checked)

                    q32 = 1;

                break;

            case R.id.rb32T:
                if(checked)

                    q32 = 0;

                break;




        }
    }

    public void selectAnswerq33(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb33Y:
                if (checked)

                    q33 = 1;

                break;

            case R.id.rb33T:
                if(checked)

                    q33 = 0;

                break;




        }
    }

    public void selectAnswerq34(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb34Y:
                if (checked)

                    q34 = 1;

                break;

            case R.id.rb34T:
                if(checked)

                    q34 = 0;

                break;




        }
    }

    public void selectAnswerq35(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb35Y:
                if (checked)

                    q35 = 1;

                break;

            case R.id.rb35T:
                if(checked)

                    q35 = 0;

                break;




        }
    }

    public void selectAnswerq36(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb36Y:
                if (checked)

                    q36 = 1;

                break;

            case R.id.rb36T:
                if(checked)

                    q36 = 0;

                break;




        }
    }

    public void selectAnswerq37(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb37Y:
                if (checked)

                    q37 = 1;

                break;

            case R.id.rb37T:
                if(checked)

                    q37 = 0;

                break;




        }
    }

    public void selectAnswerq38(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb38Y:
                if (checked)

                    q38 = 1;

                break;

            case R.id.rb38T:
                if(checked)

                    q38 = 0;

                break;




        }
    }

    public void selectAnswerq39(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb39Y:
                if (checked)

                    q39 = 1;

                break;

            case R.id.rb39T:
                if(checked)

                    q39 = 0;

                break;

        }
    }

    public void selectAnswerq40(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb40Y:
                if (checked)

                    q40 = 1;

                break;

            case R.id.rb40T:
                if(checked)

                    q40 = 0;

                break;

        }
    }

    public void btnNextA4(View view){

        total = q31+q32+q33+q34+q35+q36+q37+q38+q39+q40;

        if (total >= 8)
        {

            desc4 = "Major";
            Toast.makeText(SectionA4.this,"Major dalam kategori ruang kecerdasan",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc4 = "Minor";
            Toast.makeText(SectionA4.this,"Minor dalam kategori ruang kecerdasan",Toast.LENGTH_LONG).show();
        }

        result4 = Integer.toString(total);

        Intent intent = new Intent(this, SectionB5.class);
        finish();

        Bundle bundle = new Bundle();
        bundle.putString(UserConfig.SIC,sic);
        bundle.putString(UserConfig.DSID,sid);
        bundle.putString(UserConfig.RESULT1, result1);
        bundle.putString(UserConfig.RESULT2, result2);
        bundle.putString(UserConfig.RESULT3, result3);
        bundle.putString(UserConfig.RESULT4, result4);
        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);
        bundle.putString(UserConfig.DESC4, desc4);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}

