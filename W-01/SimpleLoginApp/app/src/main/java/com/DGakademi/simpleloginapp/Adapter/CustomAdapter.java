package com.DGakademi.simpleloginapp.Adapter;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.DGakademi.simpleloginapp.R;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private final Context context;
    private final ArrayList<FactoryList> factoryLists;

    public CustomAdapter(Context context, ArrayList<FactoryList> factoryLists) {
        this.context = context;
        this.factoryLists = factoryLists;
    }

    @Override
    public int getCount() {
        return factoryLists.size();
    }

    @Override
    public Object getItem(int position) {
        return factoryLists.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        }else {
            holderView = (HolderView) convertView.getTag();
        }

        FactoryList list = factoryLists.get(position);
        holderView.iconList.setImageResource(list.getFactoryIcon());
        holderView.factoryName.setText(list.getFactoryName());
        holderView.producedDoor.setText("Amount of Door produced : " + list.getProducedDoor());
        holderView.producedEngines.setText("Amount of Engine produced : " + list.getProducedEngines());
        holderView.producedWheels.setText("Amount of Wheels produced : " + list.getProducedWheels());

        return convertView;
    }

    private static class HolderView{
        private final ImageView iconList;
        private final TextView factoryName;
        private final TextView producedDoor;
        private final TextView producedEngines;
        private final TextView producedWheels;

        public HolderView(View view){
            iconList = view.findViewById(R.id.factory_Image);
            factoryName = view.findViewById(R.id.factory_name);
            producedDoor = view.findViewById(R.id.factory_Door);
            producedEngines = view.findViewById(R.id.factory_Engine);
            producedWheels = view.findViewById(R.id.factory_Wheels);
        }

    }
}
