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

public class ResultAdapter extends BaseAdapter{

    Context context;
    ArrayList<HashMap<String, String>> listResult;
    LayoutInflater inflater;

    public ResultAdapter (Context context, ArrayList<HashMap<String, String>> data){
        this.context = context;
        this.listResult = data;


    }

    @Override
    public int getCount() {
        return listResult.size();
    }

    @Override
    public Object getItem(int i) {
        return listResult.get(i);
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
            convertview = inflater.inflate(R.layout.displayresult, viewGroup, false);
        }


        ResultHolder holder = new ResultHolder(convertview);

        holder.txtID.setText("#"+listResult.get(i).get(UserConfig.IID));
        holder.txtTotal.setText(listResult.get(i).get(UserConfig.ITOTAL)+"/90");


        return convertview;
    }
}
