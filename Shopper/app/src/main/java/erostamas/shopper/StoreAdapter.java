package erostamas.shopper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import erostamas.shopper.Item;
import erostamas.shopper.R;
import erostamas.shopper.Store;

/**
 * Created by etamero on 2016.03.26..
 */
public class StoreAdapter extends ArrayAdapter<Store> {
    Context context;
    int layoutResourceId;
    ArrayList<Store> stores = null;

    StoreAdapter(Context context, int layoutResourceId, ArrayList<Store> stores) {
        super(context, layoutResourceId, stores);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.stores = stores;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        StoreHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new StoreHolder();
            holder.store_name = (TextView)row.findViewById(R.id.store_name);
            holder.unDoneCounter = (TextView)row.findViewById(R.id.store_undone);

            row.setTag(holder);
        }
        else
        {
            holder = (StoreHolder)row.getTag();
        }

        Store store = stores.get(position);
        holder.store_name.setText(store.getStoreName());
        holder.unDoneCounter.setText("" + store.countUnDone());
        return row;
    }

    static class StoreHolder{
        TextView store_name;
        TextView unDoneCounter;
    }
}
