package com.example.slayerinc.roleslayer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CharList extends AppCompatActivity {

    private Button submitName;
    private TextView displayName;
    private EditText nameInput;
    public PlayerCharacter myCharacter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_list);

        submitName = (Button)findViewById(R.id.submitName);
        displayName = (TextView)findViewById(R.id.displayName);
        nameInput = (EditText)findViewById(R.id.nameInput);

        nameInput.setEnabled(false);

        submitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCharacter = new PlayerCharacter();
                myCharacter.setName(String.valueOf(nameInput.getText()));

                displayName.setText(myCharacter.getName());
            }
        });
    }

}
