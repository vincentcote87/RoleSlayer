package com.roleslayin.roleslayer;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Vincent", "Graham", "Jace"};
    String[] infoArray = {"Male 30", "Male 27", "Male 22"};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     ListAdapter myList = new ListAdapter(this, nameArray, infoArray);

     listView = (ListView) findViewById(R.id.characterListView);
     listView.setAdapter(myList);

    }
}
