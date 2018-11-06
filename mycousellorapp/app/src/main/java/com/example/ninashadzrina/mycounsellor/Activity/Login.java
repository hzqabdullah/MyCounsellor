package com.example.ninashadzrina.mycounsellor.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ninashadzrina.mycounsellor.Configuration.RequestHandler;
import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    EditText icnumtxt, passwordtxt;
    private String ic;
    private String password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        icnumtxt = (EditText)findViewById(R.id.icnumtxt);
        passwordtxt = (EditText)findViewById(R.id.passwordtxt);

    }



    public void btnClear(View view)
    {
        icnumtxt.setText("");
        passwordtxt.setText("");
    }

    public void btnLogin(View view) {
        ic = icnumtxt.getText().toString();
        password = passwordtxt.getText().toString();

        if (TextUtils.isEmpty((CharSequence) ic)) {
            icnumtxt.setError("IC required");
            icnumtxt.requestFocus();
            return;
        }

        if (TextUtils.isEmpty((CharSequence) password)) {
            passwordtxt.setError("Password required");
            passwordtxt.requestFocus();
            return;
        }

        class login extends AsyncTask<Void, Void, String> {

            //FIRST
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            //THIRD
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                if (s.equalsIgnoreCase("You have been successfully logged in")) {
                    Toast.makeText(Login.this, s, Toast.LENGTH_LONG).show();

                    Intent intent = new Intent (Login.this, Home.class);
                    finish();
                    Bundle bundle = new Bundle();
                    bundle.putString(UserConfig.SIC,ic);

                    intent.putExtras(bundle);
                    startActivity(intent);

                } else {
                    Toast.makeText(Login.this, s, Toast.LENGTH_LONG).show();
                }
            }


            //SECOND
            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put(UserConfig.SIC, ic);
                params.put(UserConfig.SPASSWORD, password);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(UserConfig.LOGIN, params);
                return res;

            }
        }

        login lgn = new login();
        lgn.execute();

    }
}




