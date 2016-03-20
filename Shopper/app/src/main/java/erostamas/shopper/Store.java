package erostamas.shopper;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by etamero on 2016.03.20..
 */
public class Store {
    private String _storeName;
    private ArrayList<Item> _list;

    Store() {
        _list = new ArrayList<Item>();
        _storeName = "Store";
    }
    public void setStoreName (String store_name) {_storeName = store_name;}

    public String getStoreName() {return _storeName;}
    public ArrayList<Item> getList() {return _list;}

    public void addItem(Item item) {_list.add(item);}
    public void clearList() {_list.clear();}

    @Override
    public String toString() {
        return this._storeName;
    }

}
