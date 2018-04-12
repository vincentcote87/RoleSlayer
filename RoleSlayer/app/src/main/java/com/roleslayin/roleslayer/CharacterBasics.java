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
    private TextView race;
    private TextView age;
    private TextView sex;
    private TextView ht;
    private TextView wt;
    private TextView description;
    private Bundle myArgs;
    private String tmpStr;
    private String attribute;



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
//                myArgs = new Bundle();
//                myArgs.putString("header_id", "Edit Character Name");
//                nameField.setArguments(myArgs);
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "name";
            }
        });

        race = findViewById(R.id.raceLabelID);
        race.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "race";
            }
        });

        age = findViewById(R.id.ageLabelID);
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "age";
            }
        });

        sex = findViewById(R.id.sexLabelID);
        sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "sex";
            }
        });

        ht = findViewById(R.id.htLabelID);
        ht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "HT";
            }
        });

        wt = findViewById(R.id.wtLabelID);
        wt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "WT";
            }
        });

        description = findViewById(R.id.descriptionLabelID);
        description.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditField nameField = new EditField();
                nameField.show(getSupportFragmentManager(), "Edit name");
                attribute = "description";
            }
        });
    }

    @Override
    public void passText(String field) {
        tmpStr = field;
        Integer i;
        switch (attribute) {
            case "name" :
                ((MyApplication)getApplicationContext()).characterArray.get(index).setName(tmpStr); break;
            case "race" :
                ((MyApplication)getApplicationContext()).characterArray.get(index).setRace(tmpStr); break;
            case "age" :
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                 ((MyApplication)getApplicationContext()).characterArray.get(index).setAge(i); break;
            case "sex" :
                ((MyApplication)getApplicationContext()).characterArray.get(index).setSex(tmpStr); break;
            case "HT" :
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication)getApplicationContext()).characterArray.get(index).setHT(i); break;
            case "WT" :
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication)getApplicationContext()).characterArray.get(index).setWT(i); break;
            case "description" :
                ((MyApplication)getApplicationContext()).characterArray.get(index).setDescription(tmpStr); break;
        }
        setText();

    }

    private void setText() {
        TextView nameText = (TextView) findViewById(R.id.nameID);
        TextView raceText = (TextView) findViewById(R.id.raceInputID);
        TextView ageText = (TextView) findViewById(R.id.ageInputID);
        TextView sexText = (TextView) findViewById(R.id.sexInputID);
        TextView htText = (TextView) findViewById(R.id.htInputID);
        TextView wtText = (TextView) findViewById(R.id.wtInputID);
        TextView descriptionText = (TextView) findViewById(R.id.descriptionInputID);
        nameText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getName());
        raceText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getRace());
        ageText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getAge().toString());
        sexText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getSex());
        htText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getHT().toString());
        wtText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getWT().toString());
        descriptionText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getDescription());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setText();
    }
}
