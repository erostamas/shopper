package erostamas.shopper;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayItemsActivity extends MainActivity {
    private ItemAdapter _adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_items);
        ListView lv = (ListView) findViewById(R.id.items_list);
        _adapter = new ItemAdapter(this,
                R.layout.item, _currentStore.getList());

        lv.setAdapter(_adapter);
        registerForContextMenu(lv);
        final SwipeDetector swipeDetector = new SwipeDetector();
        lv.setOnTouchListener(swipeDetector);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter_view, View arg1, final int position,
                                    long arg3) {
                if (swipeDetector.swipeDetected()) {
                    if (swipeDetector.getAction() == Action.LR) {
                        _currentStore.getList().get(position).setDone(true);
                        _currentStore.pushDoneToBack(position);
                        _adapter.notifyDataSetChanged();
                    }
                    if (swipeDetector.getAction() == Action.RL) {
                        _currentStore.getList().get(position).setDone(false);
                        _currentStore.pullUnDoneToFront(position);
                        _adapter.notifyDataSetChanged();
                    }
                    if (swipeDetector.getAction() == Action.TB) {
// perform any task
                    }
                    if (swipeDetector.getAction() == Action.BT) {
// perform any task
                    }
                }
            }
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

        if (id == R.id.add_item) {
            Intent intent = new Intent(DisplayItemsActivity.this, CreateItemActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        _adapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==R.id.items_list) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(_currentStore.getList().get(info.position).getName());
            //String[] menuItems = getResources().getStringArray(R.array.menu);
            //for (int i = 0; i<menuItems.length; i++) {
            menu.add(Menu.NONE, 0, 0, "Delete");
            //menu.add(Menu.NONE, i, i, menuItems[i]);
            //}
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        if (menuItemIndex == 0) { // delete
            _currentStore.getList().remove(info.position);
            _adapter.notifyDataSetChanged();
        }
        //String[] menuItems = getResources().getStringArray(R.array.menu);
        //String menuItemName = menuItems[menuItemIndex];
        //String listItemName = Countries[info.position];
        //TextView text = (TextView)findViewById(R.id.footer);
        //text.setText(String.format("Selected %s for item %s", menuItemName, listItemName));
        return true;
    }
}
