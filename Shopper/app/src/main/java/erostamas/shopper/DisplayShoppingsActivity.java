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

public class DisplayShoppingsActivity extends MainActivity {
    private ArrayAdapter<Shopping> _adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Shopper", "DisplayShoppings activity created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_shoppings);
        ListView lv = (ListView) findViewById(R.id.shoppings_list);
        _adapter = new ArrayAdapter<Shopping>(this,
                android.R.layout.simple_list_item_1, _shoppings);

        lv.setAdapter(_adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parentView, View childView,
                                    int position, long id) {
                _currentShopping = _shoppings.get(position);
                Intent intent = new Intent(DisplayShoppingsActivity.this, DisplayStoresActivity.class);
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_shoppings, menu);
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

        if (id == R.id.add_shopping) {
            Intent intent = new Intent(DisplayShoppingsActivity.this, CreateShoppingActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        _adapter.notifyDataSetChanged();
        Log.i("Shopper", "&&&&&&&&&&&&&&&&&&&&&&&&&");
        super.onResume();
    }
}
