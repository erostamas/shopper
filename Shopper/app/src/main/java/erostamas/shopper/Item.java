package erostamas.shopper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by etamero on 2016.03.20..
 */
public class Item {

    private String _name;
    private String _comment;
    private float _quantity;
    private String _unit;
    private boolean _done;

    Item (String name) {
        _name = name;
        _comment = "";
        _quantity = 1;
        _unit = "darab";
        _done = false;
    }

    public void setName (String name) {_name = name;}
    public void setComment (String comment) {_comment = comment;}
    public void setQuantity (float quantity) {_quantity = quantity;}
    public void setUnit (String unit) {_unit = unit;}
    public void setDone (boolean done) {_done = done;}

    public String getName() {return _name;}
    public String getComment() {return _comment;}
    public float getQuantity() {return _quantity;}
    public String getUnit() {return _unit;}
    public boolean getDone() {return _done;}

    @Override
    public String toString() {
        return (_name + " " + _quantity + " " + _unit + "           " + _done);
    }


}
