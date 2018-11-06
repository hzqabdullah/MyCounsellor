package com.example.ninashadzrina.mycounsellor.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.ninashadzrina.mycounsellor.Configuration.UserConfig;
import com.example.ninashadzrina.mycounsellor.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ExamAdapter extends BaseAdapter{

    Context context;
    ArrayList<HashMap<String, String>> listExam;
    LayoutInflater inflater;

    public ExamAdapter (Context context, ArrayList<HashMap<String, String>> data){
        this.context = context;
        this.listExam = data;

    }

    @Override
    public int getCount() {
        return listExam.size();
    }

    @Override
    public Object getItem(int i) {
        return listExam.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        if (inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertview == null)
        {
            convertview = inflater.inflate(R.layout.displayexam, viewGroup, false);
        }


        ExamHolder holder = new ExamHolder(convertview);

        holder.txtRID.setText("#"+listExam.get(i).get(UserConfig.RID));
        holder.txtTitle.setText(listExam.get(i).get(UserConfig.RTITLE));


        return convertview;
    }
}
