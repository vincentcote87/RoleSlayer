package com.roleslayin.roleslayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CharacterBasics extends AppCompatActivity implements EditField.EditFieldListener {

    private Integer index;
    protected Intent savedExtra;
    private TextView name;
    private Bundle myArgs;
    private String tmpStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_basics);

//        savedExtra = getIntent();
        index = getIntent().getIntExtra("index", 0);
        setText();
//        final PlayerCharacter playerChar = savedExtra.getParcelableExtra("myChar");


        name = findViewById(R.id.nameID);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                myArgs = new Bundle();
                myArgs.putString("header_id", "Edit Character Name");
                nameField.setArguments(myArgs);
                nameField.show(getSupportFragmentManager(), "Edit name");
            }
        });
    }

    @Override
    public void passText(String field) {
        tmpStr = field;
        ((MyApplication)getApplicationContext()).characterArray.get(index).setName(tmpStr);

        TextView raceView = findViewById(R.id.raceInputID);
        finish();
        startActivity(getIntent());
//        raceView.setText(((MyApplication)this.getApplicationContext()).str);
//        ((MainActivity)getApplicationContext()).characterArray.get(0).setName(tmpStr);

    }

    private void setText() {
        TextView myText = (TextView) findViewById(R.id.nameID);
        myText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setText();
    }
}
