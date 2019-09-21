package com.example.jsonwithvolley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Base_Adapter extends BaseAdapter {

    Context context;
    List<DataModel>list;
    LayoutInflater inflater;

    public Base_Adapter(Context context, List<DataModel> list) {
        this.context = context;
        this.list = list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=inflater.inflate(R.layout.item,null);
        TextView name=convertView.findViewById(R.id.name);
        TextView email=convertView.findViewById(R.id.email);
        TextView id=convertView.findViewById(R.id.id);
        TextView gender=convertView.findViewById(R.id.gender);
        TextView mo=convertView.findViewById(R.id.mo);


        DataModel model=list.get(position);
        name.setText(model.getName());
        id.setText(model.getId());
        mo.setText(model.getMo());
        gender.setText(model.getGender());
        email.setText(model.getEmail());


        return convertView;
    }
}
