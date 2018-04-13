package com.roleslayin.roleslayer;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements EnterCharNameDialog.EnterNewCharListener {

    ListView listView;
    Button addNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ((MyApplication)this.getApplicationContext()).characterArray.add(new PlayerCharacter());
//        ((MyApplication)this.getApplicationContext()).characterArray.get(0).setName("Austenberger");
//        ((MyApplication)this.getApplicationContext()).characterArray.get(0).setInfo("Warrior");
//        ((MyApplication)this.getApplicationContext()).characterArray.get(0).addItem(new CharacterItem(
//                "The Destroyer", "Kills things", "Weapon", 120, 15));
//        ((MyApplication)this.getApplicationContext()).characterArray.get(0).addItem(new CharacterItem(
//                "Postion of Swiftness", "Makes you swifty", "Potion", 0, 1));

        initList();

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CharacterMainPage.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });

        addNew = (Button) findViewById(R.id.addCharacterBtn);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void initList() {
        ListAdapter myList = new ListAdapter(this, ((MyApplication)this.getApplicationContext()).characterArray);
        listView = (ListView) findViewById(R.id.characterListView);
        listView.setAdapter(myList);
    }

    public void openDialog() {
        EnterCharNameDialog newCharDialog = new EnterCharNameDialog();
        newCharDialog.show(getSupportFragmentManager(), "Enter character name");
    }

    @Override
    public void passText(String name, String info) {
        PlayerCharacter tmpChar = new PlayerCharacter();
        tmpChar.setName(name);
        tmpChar.setInfo(info);
        ((MyApplication)this.getApplicationContext()).characterArray.add(tmpChar);
        initList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initList();
    }

}

