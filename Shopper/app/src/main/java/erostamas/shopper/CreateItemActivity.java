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
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CreateItemActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_item);
        Button save_button = (Button) findViewById(R.id.save_btn);
        save_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View childView) {
                TextView new_item_name_text = (TextView) findViewById(R.id.new_name);
                TextView new_item_quantity = (TextView) findViewById(R.id.new_quantity);
                Item new_item = new Item(new_item_name_text.getText().toString());
                new_item.setQuantity(Float.parseFloat(new_item_quantity.getText().toString()));
                _currentStore.addItem(new_item);
                _currentStore.pullUnDoneToFront(_currentStore.getList().size() - 1);
                Intent intent = new Intent(CreateItemActivity.this,
                        DisplayItemsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_item, menu);
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
