package com.roleslayin.roleslayer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class CharacterInventoryPage extends AppCompatActivity implements AddItemDialog.addItemListener {

    private Integer index;
    private ListView listView;
    private Button addNew;
    private Button deleteItem;
    private ListView listview;


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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Integer pos = position;
                AlertDialog.Builder confirm = new AlertDialog.Builder(CharacterInventoryPage.this).setTitle("Delete item?");
                confirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        removeItem(pos);
                    }
                });
                confirm.create();
                confirm.show();

//                removeItem(position);
            }
        });


//        deleteItem = findViewById(R.id.deleteItemFromListBtn);
//        deleteItem.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    public void removeItem(int position) {
        ((MyApplication)getApplicationContext()).characterArray.get(index).inventory.remove(position);
        initList();
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
