package erostamas.shopper;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by etamero on 2016.03.20..
 */
public class Shopping {
    private ArrayList<ShoppingList> _storeList;

    Shopping () {
        _storeList = new ArrayList<ShoppingList>();
    }
    public ArrayList<ShoppingList> getStoreList() {return _storeList;}
    public void addShoppingList(ShoppingList shopping_list) {
        _storeList.add(shopping_list);
        Log.i("Shopper", "SHopping list added");
    }
}
