package erostamas.shopper;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by etamero on 2016.03.20..
 */
public class Store implements Serializable{
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

    public void pushDoneToBack(int position) {
        if (position == _list.size() - 1) { return; }
        while (!_list.get(position+1).getDone()) {
            Item next_item = _list.get(position+1);
            _list.set(position+1, _list.get(position));
            _list.set(position, next_item);
            position++;
            if (position == _list.size() - 1) { return; }
        }
    }

    public void pullUnDoneToFront(int position) {
        if (position == 0) { return; }
        while (_list.get(position-1).getDone()) {
            Item previous_item = _list.get(position-1);
            _list.set(position-1, _list.get(position));
            _list.set(position, previous_item);
            position--;
            if (position == 0) { return; }
        }
    }

    public int countUnDone() {
        int i = 0;
        int counter = 0;
        for (i = 0; i < _list.size(); i++) {
            if (_list.get(i).getDone()) {break;}
        }
        return i;
    }
    @Override
    public String toString() {
        return this._storeName;
    }

}
