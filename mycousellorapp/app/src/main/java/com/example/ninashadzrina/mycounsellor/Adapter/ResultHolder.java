package com.example.ninashadzrina.mycounsellor.Adapter;

import android.view.View;
import android.widget.TextView;

import com.example.ninashadzrina.mycounsellor.R;

public class ResultHolder {
    TextView txtTotal,txtID;


    public ResultHolder (View v){
        txtID = (TextView) v.findViewById(R.id.txtID);
        txtTotal = (TextView) v.findViewById(R.id.txtTotal);
    }
}
