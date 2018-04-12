package com.roleslayin.roleslayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CharacterNotesPage extends AppCompatActivity {

    private Integer index;
    private TextView myNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_notes_page);

        index = getIntent().getIntExtra("index", 0);

        myNotes = (TextView)findViewById(R.id.notesInputView);
        myNotes.setText(((MyApplication)this.getApplicationContext()).characterArray.get(index).getPlayerNotes());
    }

    @Override
    protected void onPause() {
        super.onPause();
        myNotes = (TextView)findViewById(R.id.notesInputView);
        ((MyApplication)this.getApplicationContext()).characterArray.get(index).setPlayerNotes(String.valueOf(myNotes.getText()));
    }
}
