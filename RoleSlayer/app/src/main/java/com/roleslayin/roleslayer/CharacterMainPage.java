package com.roleslayin.roleslayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharacterMainPage extends AppCompatActivity {

    private Integer index;
    protected Intent savedExtra;
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
//        String savedExtra = getIntent().getStringExtra("myChar");
//        savedExtra = getIntent();
        index = getIntent().getIntExtra("index", 0);
        setText();
//        final PlayerCharacter playerChar = savedExtra.getParcelableExtra("myChar");


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
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });

        inventoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CharacterMainPage.this, CharacterInventoryPage.class);
                intent.putExtra("index", index);
                startActivity(intent);
            }
        });
    }

    private void passIntent(Class x, PlayerCharacter pc) {
        Intent intent = new Intent(CharacterMainPage.this, x);
        intent.putExtra("myChar", pc);
        startActivity(intent);
    }

    private void setText() {
        TextView myText = (TextView) findViewById(R.id.mainPageCharName);
        myText.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getName());
    }

    @Override
    protected void onResume() {
        super.onResume();
        setText();
    }
}
