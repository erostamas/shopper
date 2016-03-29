package erostamas.shopper;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
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

/**
 * Created by etamero on 2016.03.26..
 */
public class ItemAdapter extends ArrayAdapter<Item> {
    Context context;
    int layoutResourceId;
    ArrayList<Item> items = null;

    ItemAdapter(Context context, int layoutResourceId, ArrayList<Item> items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i("Shopper", "" + position);
        View row = convertView;
        ItemHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ItemHolder();
            holder.item_name = (TextView)row.findViewById(R.id.item_name);
            holder.item_quantity = (TextView)row.findViewById(R.id.item_quantity);

            row.setTag(holder);
        }
        else
        {
            holder = (ItemHolder)row.getTag();
        }
        Item item = items.get(position);
        holder.item_name.setText(item.getName());
        holder.item_quantity.setText(item.getQuantity() + " " + item.getUnit());
        if (item.getDone()) {
            row.setBackgroundColor(Color.rgb(18, 201, 42));

        } else {
            row.setBackgroundColor(Color.WHITE);
        }
        return row;
    }

    static class ItemHolder{
        TextView item_name;
        TextView item_quantity;
    }
}
