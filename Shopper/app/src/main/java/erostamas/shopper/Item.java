package erostamas.shopper;

import android.util.Log;

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
        Log.i("Shopper", "Item created: " + _name);
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



}
