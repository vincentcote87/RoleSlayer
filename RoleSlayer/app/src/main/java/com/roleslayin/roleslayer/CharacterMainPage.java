package com.roleslayin.roleslayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharacterMainPage extends AppCompatActivity {

    Button basicsBtn;
    Button statsBtn;
    Button skillsBtn;
    Button advDisadvBtn;
    Button inventoryBtn;
    Button notesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_main_page);

        //PASS PLAYERCHARACTER OBJECT
        String savedExtra = getIntent().getStringExtra("name");
        TextView myText = (TextView) findViewById(R.id.mainPageCharName);
        myText.setText(savedExtra);

        basicsBtn = (Button)findViewById(R.id.basicsBtn);
        statsBtn = (Button)findViewById(R.id.statsBtn);
        skillsBtn = (Button)findViewById(R.id.skillsBtn);
        advDisadvBtn = (Button)findViewById(R.id.advDisadvBtn);
        inventoryBtn = (Button)findViewById(R.id.inventoryBtn);
        notesBtn = (Button)findViewById(R.id.notesBtn);

        basicsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterMainPage.this, CharacterBasics.class);
                startActivity(intent);
            }
        });
    }
}
