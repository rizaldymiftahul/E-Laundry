package com.e_laundry.user.e_laundry;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 01/06/2017.
 */

public class OrderAdapter extends BaseAdapter {
    Activity activity;
    ArrayList listItem;

    public OrderAdapter(Activity activity, ArrayList listItem) {
        this.activity = activity;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int i) {
        return listItem.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_detail, null);

            holder.txtKeahlian = (TextView)view.findViewById(R.id.tempat_nama);
            holder.txtDeskripsi = (TextView)view.findViewById(R.id.tempat_timestamp);
            holder.txtTempat = (TextView)view.findViewById(R.id.tempat_isi);


            view.setTag(holder);
        }else{
            holder = (ViewHolder)view.getTag();
        }

        ListBaruGetSet data = (ListBaruGetSet) getItem(i);
        holder.txtKeahlian.setText(data.getTanggal_ambil());
        holder.txtDeskripsi.setText(data.getTanggal_antar());
        holder.txtTempat.setText(data.getAlamat());
        holder.txtTanggal.setText(data.getCatatan());


        return view;
    }

    static class ViewHolder{
        TextView txtKeahlian, txtDeskripsi, txtTempat, txtTanggal, txtJam;
    }
}
