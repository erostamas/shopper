package erostamas.shopper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Shopping> shoppings;
    private Shopping _currentShopping;
    private Store _currentStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_list_view);
        shoppings = new ArrayList<Shopping>();
        initShoppings();
        showShoppings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initShoppings() {
        Shopping shopping = new Shopping();

        Store list = new Store();

        Item item1 = new Item("ïtem1name");
        Item item2 = new Item("ïtem2name");
        Item item3 = new Item("ïtem3name");
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);

        shopping.addShoppingList(list);
        shopping.setName("Shopping_" + shoppings.size());
        shoppings.add(shopping);
    }

    public void showShoppings() {
        ListView lv = (ListView) findViewById(R.id.shoppingListView);
        ArrayAdapter<Shopping> adapter = new ArrayAdapter<Shopping>(this,
                android.R.layout.simple_list_item_1, shoppings);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parentView, View childView,
                                    int position, long id) {
                showStores(shoppings.get(position));
            }

        });
    }

    public void showStores(final Shopping shopping) {
        _currentShopping = shopping;
        setContentView(R.layout.store_list_view);
        ListView lv = (ListView) findViewById(R.id.storeListView);
        Log.i("Shopper", "" + shopping.getStoreList().size());
        ArrayAdapter<Store> adapter = new ArrayAdapter<Store>(this,
                android.R.layout.simple_list_item_1, shopping.getStoreList());
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parentView, View childView,
                                    int position, long id) {
                showItems(shopping.getStoreList().get(position));
            }

        });
    }

    public void showItems(Store store) {
        _currentStore = store;
        setContentView(R.layout.item_list_view);
        ListView lv = (ListView) findViewById(R.id.itemListView);
        ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
                android.R.layout.simple_list_item_1, store.getList());
        lv.setAdapter(adapter);
    }
}
