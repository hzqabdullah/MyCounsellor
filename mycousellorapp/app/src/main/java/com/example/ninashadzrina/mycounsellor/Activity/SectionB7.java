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

public class SectionB7 extends AppCompatActivity {
    String sic, sid, result1, result2, result3, result4, result5, result6,result7, desc1, desc2, desc3, desc4, desc5, desc6, desc7;
    int q61,q62,q63,q64,q65,q66,q67,q68,q69,q70,total;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.section_b7);

        Intent intent = getIntent();
        sic = intent.getStringExtra(UserConfig.SIC);
        sid = intent.getStringExtra(UserConfig.DSID);

        result1 = intent.getStringExtra(UserConfig.RESULT1);
        result2 = intent.getStringExtra(UserConfig.RESULT2);
        result3 = intent.getStringExtra(UserConfig.RESULT3);
        result4 = intent.getStringExtra(UserConfig.RESULT4);
        result5 = intent.getStringExtra(UserConfig.RESULT5);
        result6 = intent.getStringExtra(UserConfig.RESULT6);

        desc1 = intent.getStringExtra(UserConfig.DESC1);
        desc2 = intent.getStringExtra(UserConfig.DESC2);
        desc3 = intent.getStringExtra(UserConfig.DESC3);
        desc4 = intent.getStringExtra(UserConfig.DESC4);
        desc5 = intent.getStringExtra(UserConfig.DESC5);
        desc6 = intent.getStringExtra(UserConfig.DESC6);

    }



    public void selectAnswerq61(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb61Y:
                if (checked)

                    q61 = 1;

                break;

            case R.id.rb61T:
                if(checked)

                    q61 = 0;

                break;




        }
    }

    public void selectAnswerq62(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb62Y:
                if (checked)

                    q62 = 1;

                break;

            case R.id.rb60T:
                if(checked)

                    q62 = 0;

                break;




        }
    }

    public void selectAnswerq63(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb63Y:
                if (checked)

                    q63 = 1;

                break;

            case R.id.rb63T:
                if(checked)

                    q63 = 0;

                break;




        }
    }

    public void selectAnswerq64(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb64Y:
                if (checked)

                    q64 = 1;

                break;

            case R.id.rb64T:
                if(checked)

                    q64 = 0;

                break;




        }
    }

    public void selectAnswerq65(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb65Y:
                if (checked)

                    q65 = 1;

                break;

            case R.id.rb65T:
                if(checked)

                    q65 = 0;

                break;




        }
    }

    public void selectAnswerq66(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb66Y:
                if (checked)

                    q66 = 1;

                break;

            case R.id.rb66T:
                if(checked)

                    q66 = 0;

                break;




        }
    }

    public void selectAnswerq67(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb67Y:
                if (checked)

                    q67 = 1;

                break;

            case R.id.rb67T:
                if(checked)

                    q67 = 0;

                break;




        }
    }

    public void selectAnswerq68(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb68Y:
                if (checked)

                    q68 = 1;

                break;

            case R.id.rb68T:
                if(checked)

                    q68 = 0;

                break;




        }
    }

    public void selectAnswerq69(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb69Y:
                if (checked)

                    q69 = 1;

                break;

            case R.id.rb69T:
                if(checked)

                    q69 = 0;

                break;




        }
    }

    public void selectAnswerq70(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId())
        {
            case R.id.rb70Y:
                if (checked)

                    q70 = 1;

                break;

            case R.id.rb70T:
                if(checked)

                    q70 = 0;

                break;




        }
    }

    public void btnNextB7(View view){

        total = q61+q62+q63+q64+q65+q66+q67+q68+q69+q70;

        if (total >= 8)
        {

            desc7 = "Major";
            Toast.makeText(SectionB7.this,"Major dalam kategori kinestetik",Toast.LENGTH_LONG).show();

        }
        else
        {
            desc7 = "Minor";
            Toast.makeText(SectionB7.this,"Minor dalam kategori kinestetik",Toast.LENGTH_LONG).show();
        }

        result7 = Integer.toString(total);

        Intent intent = new Intent(this, SectionB8.class);
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
        bundle.putString(UserConfig.RESULT7, result7);

        bundle.putString(UserConfig.DESC1, desc1);
        bundle.putString(UserConfig.DESC2, desc2);
        bundle.putString(UserConfig.DESC3, desc3);
        bundle.putString(UserConfig.DESC4, desc4);
        bundle.putString(UserConfig.DESC5, desc5);
        bundle.putString(UserConfig.DESC6, desc6);
        bundle.putString(UserConfig.DESC7, desc7);


        intent.putExtras(bundle);

        startActivity(intent);
    }
}

