package com.roleslayin.roleslayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CharacterInventoryPage extends AppCompatActivity implements AddItemDialog.addItemListener {

    private Integer index;
    private ListView listView;
    private Button addNew;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_inventory_page);

        index = getIntent().getIntExtra("index", 0);

        initList();

        addNew = findViewById(R.id.newItemBtn);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddItemDialog newItemDialog = new AddItemDialog();
                newItemDialog.show(getSupportFragmentManager(), "Enter item");
            }
        });
    }

    public void initList() {
        InventoryListAdapter myList = new InventoryListAdapter(this,
                ((MyApplication)this.getApplicationContext()).characterArray.get(index).inventory);
        listView = (ListView)findViewById(R.id.inventoryListView);
        listView.setAdapter(myList);
    }

    @Override
    public void passText(String name, String type, String dmg, String weight, String description) {
        Integer tmpDmg;
        Integer tmpWeight;
        try {
            tmpDmg = Integer.parseInt(dmg);
        } catch (NumberFormatException nfe) {
            tmpDmg = 0;
        }
        try {
            tmpWeight = Integer.parseInt(weight);
        } catch (NumberFormatException nfe) {
            tmpWeight = 0;
        }

        ((MyApplication)this.getApplicationContext()).characterArray.get(index).inventory.add(
                new CharacterItem(name, description, type, tmpDmg, tmpWeight)
        );
        initList();
    }
}
