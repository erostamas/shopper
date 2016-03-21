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

public class DisplayItemsActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_items);
        ListView lv = (ListView) findViewById(R.id.items_list);
        final ArrayAdapter<Item> adapter = new ArrayAdapter<Item>(this,
                android.R.layout.simple_list_item_1, _currentStore.getList());
        lv.setAdapter(adapter);
        final SwipeDetector swipeDetector = new SwipeDetector();
        lv.setOnTouchListener(swipeDetector);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, final int position,
                                    long arg3) {
                if (swipeDetector.swipeDetected()) {
                    if (swipeDetector.getAction() == Action.LR) {
                        Log.i("Shopper", "Left to right!!!!!!! on item" + position);
                        _currentStore.getList().get(position).setDone(true);
                        adapter.notifyDataSetChanged();
                    }
                    if (swipeDetector.getAction() == Action.RL) {
                        Log.i("Shopper", "Right to left!!!!!!! on item" + position);
                        _currentStore.getList().get(position).setDone(false);
                        adapter.notifyDataSetChanged();
                    }
                    if (swipeDetector.getAction() == Action.TB) {
// perform any task
                    }
                    if (swipeDetector.getAction() == Action.BT) {
// perform any task
                    }
                }
            }

            ;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_items, menu);
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
