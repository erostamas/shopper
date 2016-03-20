package erostamas.shopper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Shopper", "Started");
        Shopping shopping = new Shopping();
        ShoppingList list = new ShoppingList();
        Item item1 = new Item("ïtem1name");
        Item item2 = new Item("ïtem2name");
        Item item3 = new Item("ïtem3name");
        list.addItem(item1);
        list.addItem(item2);
        list.addItem(item3);
        shopping.addShoppingList(list);

        for (int i = 0; i < shopping.getStoreList().size(); i++) {
            ShoppingList current_shopping_list = shopping.getStoreList().get(i);
            Log.i("Shopper", "Store");
            for (int j = 0; j < current_shopping_list.getList().size(); j++) {

                Log.i("Shopper", "Item");

            }

        }

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
}
