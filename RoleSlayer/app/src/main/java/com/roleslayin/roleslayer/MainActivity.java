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

    ArrayList<String> nameArray = new ArrayList<>();
    ArrayList<String> infoArray = new ArrayList<>();

    ListView listView;
    Button addNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameArray.add("Mira");
        infoArray.add("Wandering peasant");
        initList();

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, CharacterMainPage.class);
//                String message = nameArray[position];
                String message = nameArray.get(position);
                intent.putExtra("name", message);
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
        ListAdapter myList = new ListAdapter(this, nameArray, infoArray);
        listView = (ListView) findViewById(R.id.characterListView);
        listView.setAdapter(myList);
    }

    public void openDialog() {
        EnterCharNameDialog newCharDialog = new EnterCharNameDialog();
        newCharDialog.show(getSupportFragmentManager(), "Enter character name");
    }

    @Override
    public void passText(String name, String info) {
        //CREATE NEW CHARACTER HERE AND ADD NAME AND INFO
        nameArray.add(name);
        infoArray.add(info);
        initList();
    }
}

