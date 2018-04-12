package com.roleslayin.roleslayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class CharacterInventoryPage extends AppCompatActivity {

    private Integer index;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_inventory_page);

        index = getIntent().getIntExtra("index", 0);

        initList();
    }

    public void initList() {
        InventoryListAdapter myList = new InventoryListAdapter(this,
                ((MyApplication)this.getApplicationContext()).characterArray.get(index).inventory);
        listView = (ListView)findViewById(R.id.inventoryListView);
        listView.setAdapter(myList);
    }
}
