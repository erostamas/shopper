package erostamas.shopper;

import android.content.Intent;
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

    public static ArrayList<Shopping> _shoppings;
    public static Shopping _currentShopping;
    public static Store _currentStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        _shoppings = new ArrayList<Shopping>();
        initShoppings();
        //showShoppings();
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
        Shopping shopping1 = new Shopping();
        Shopping shopping2 = new Shopping();

        Store list = new Store();
        list.setStoreName("Spar");
        Store list2 = new Store();
        list2.setStoreName("Piac");

        Item item1 = new Item("kenyér");
        Item item2 = new Item("liszt");
        Item item3 = new Item("paprika");
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);
        list2.addItem(item2);
        list2.addItem(item1);

        shopping1.addShoppingList(list);
        shopping1.setName("Shopping_" + _shoppings.size());
        _shoppings.add(shopping1);

        shopping2.addShoppingList(list);
        shopping2.addShoppingList(list2);
        shopping2.setName("Shopping_" + _shoppings.size());
        _shoppings.add(shopping2);
    }

    public void onShowShoppingsButtonClicked () {
        Intent intent = new Intent(this, DisplayShoppingsActivity.class);
        startActivity(intent);
    }

    public void init () {
        findViewById(R.id.show_shoppings_btn).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onShowShoppingsButtonClicked();
            }
        });
    }
}
