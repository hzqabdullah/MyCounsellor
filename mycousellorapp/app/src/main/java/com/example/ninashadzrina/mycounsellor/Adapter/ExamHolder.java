package com.example.ninashadzrina.mycounsellor.Adapter;

import android.view.View;
import android.widget.TextView;

import com.example.ninashadzrina.mycounsellor.R;

public class ExamHolder {
    TextView txtTitle,txtRID;


    public ExamHolder (View v){
        txtRID = (TextView) v.findViewById(R.id.txtRID);
        txtTitle = (TextView) v.findViewById(R.id.txtTitle);
    }
}
