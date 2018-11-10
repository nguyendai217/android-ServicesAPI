package com.example.dell.servicesapi.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dell.servicesapi.R;

import java.util.ArrayList;
import java.util.List;

public class BatchAdapter extends BaseAdapter {
    List<Batch> data;
    Context context;

    @Override
    public int getCount() {
        return data.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        Batch batch= data.get(position);
        ViewHolder viewHolder;
        if (view==null){
            view= LayoutInflater.from(context).inflate(R.layout.list_batch_item,parent,false);
            viewHolder= new ViewHolder();
            view.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) view.getTag();
        }
        viewHolder.tvCode.setText("Mã Lô"+ batch.getCode());
        return view;
    }
    class ViewHolder{
        TextView tvCode;
    }
}
