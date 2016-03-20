package erostamas.shopper;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by etamero on 2016.03.20..
 */
public class Shopping {
    private String _name;
    private ArrayList<Store> _storeList;

    Shopping () {
        _storeList = new ArrayList<Store>();
        _name = "Shopping";
    }

    public String getName() {return _name;}
    public ArrayList<Store> getStoreList() {return _storeList;}

    public void setName(String name) {_name = name;}
    public void addShoppingList(Store shopping_list) {
        _storeList.add(shopping_list);
        Log.i("Shopper", "SHopping list added");
    }
    @Override
    public String toString() {
        return this._name;
    }

}
