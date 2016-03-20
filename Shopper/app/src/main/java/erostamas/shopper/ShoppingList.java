package erostamas.shopper;

import java.util.ArrayList;

/**
 * Created by etamero on 2016.03.20..
 */
public class ShoppingList {
    private String _storeName;
    private ArrayList<Item> _list;

    ShoppingList() {
        _list = new ArrayList<Item>();
        _storeName = "Store";
    }
    public void setStoreName (String store_name) {_storeName = store_name;}

    public String getStoreName() {return _storeName;}
    public ArrayList<Item> getList() {return _list;}

    public void addItem(Item item) {_list.add(item);}
    public void clearList() {_list.clear();}

}
