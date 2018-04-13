package com.roleslayin.roleslayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class CharacterStats extends AppCompatActivity implements EditField.EditFieldListener {
//
    private TextView st;
    private TextView dx;
    private TextView iq;
    private TextView ht;
    private TextView hp;
    private TextView wil;
    private TextView per;
    private TextView fp;
    private TextView basic_lift;
    private TextView basic_move;
    private TextView basic_speed;
//    private TextView thrust;
//    private TextView swing;
    private Integer index;
    private String tmpStr;
    private String attribute;
//
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_stats);

        index = getIntent().getIntExtra("index", 0);
        setText();

        st = findViewById(R.id.stInputID);
        st.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField stField = new EditField();
                stField.show(getSupportFragmentManager(), "Edit strength");
                attribute = "st";
            }
        });

        dx = findViewById(R.id.dxInputID);
        dx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField dxField = new EditField();
                dxField.show(getSupportFragmentManager(), "Edit dexterity");
                attribute = "dx";
            }
        });

        iq = findViewById(R.id.iqInputID);
        iq.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField iqField = new EditField();
                iqField.show(getSupportFragmentManager(), "Edit intelligence");
                attribute = "iq";
            }
        });

        ht = findViewById(R.id.htInputID);
        ht.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField htField = new EditField();
                htField.show(getSupportFragmentManager(), "Edit health");
                attribute = "ht";
            }
        });

        hp = findViewById(R.id.hpInputID);
        hp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField hpField = new EditField();
                hpField.show(getSupportFragmentManager(), "Edit hit points");
                attribute = "hp";
            }
        });

        wil = findViewById(R.id.wilInputID);
        wil.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField wilField = new EditField();
                wilField.show(getSupportFragmentManager(), "Edit will");
                attribute = "wil";
            }
        });

        per = findViewById(R.id.perInputID);
        per.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField perField = new EditField();
                perField.show(getSupportFragmentManager(), "Edit perception");
                attribute = "per";
            }
        });

        fp = findViewById(R.id.fpInputID);
        fp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField fpField = new EditField();
                fpField.show(getSupportFragmentManager(), "Edit fatigue points");
                attribute = "fp";
            }
        });

        basic_lift = findViewById(R.id.blInputID);

        basic_move = findViewById(R.id.bmInputID);
        basic_move.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField bmField = new EditField();
                bmField.show(getSupportFragmentManager(), "Edit basic move");
                attribute = "bm";
            }
        });

        basic_speed = findViewById(R.id.bsInputID);
        basic_speed.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditField bsField = new EditField();
                bsField.show(getSupportFragmentManager(), "Edit basic speed");
                attribute = "bs";
            }
        });
//
//        thrust = findViewById(R.id.thrustInputID);
//        swing = findViewById(R.id.swingInputID);
//
    }
//
    @Override
    public void passText(String field) {
        tmpStr = field;
        int i;
        switch (attribute) {
            case "st":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setSt(i);
                break;
            case "dx":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setDx(i);
                break;
            case "iq":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setIq(i);
                break;
            case "ht":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setHt(i);
                break;
            case "hp":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setHp(i);
                break;
            case "wil":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setWil(i);
                break;
            case "per":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setPer(i);
                break;
            case "fp":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setFp(i);
                break;
            case "bm":
                try {
                    i = Integer.parseInt(tmpStr);
                } catch (NumberFormatException nfe) {
                    i = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setBasic_move(i);
                break;
            case "bs":
                float f;
                try {
                    f = Float.parseFloat(tmpStr);
                } catch (NumberFormatException nfe) {
                    f = 0;
                }
                ((MyApplication) getApplicationContext()).characterArray.get(index).setBasic_speed(f);
                break;

        }
        setText();
//
    }
//
    private void setText() {
        TextView stText = findViewById(R.id.stInputID);
        TextView dxText = findViewById(R.id.dxInputID);
        TextView iqText = findViewById(R.id.iqInputID);
        TextView htText = findViewById(R.id.htInputID);
        TextView hpText = findViewById(R.id.hpInputID);
        TextView wilText = findViewById(R.id.wilInputID);
        TextView perText = findViewById(R.id.perInputID);
        TextView fpText = findViewById(R.id.fpInputID);
        TextView blText = findViewById(R.id.blInputID);
        TextView bmText = findViewById(R.id.bmInputID);
        TextView bsText = findViewById(R.id.bsInputID);
        TextView thrustText = findViewById(R.id.thrustInputID);
        TextView swingText = findViewById(R.id.swingInputID);

        stText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getSt().toString());
        dxText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getDx().toString());
        iqText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getIq().toString());
        htText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getHt().toString());
        hpText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getHp().toString());
        wilText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getWil().toString());
        perText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getPer().toString());
        fpText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getFp().toString());
        blText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getBasic_lift().toString());
        bmText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getBasic_move().toString());
        bsText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getBasic_move().toString());
        thrustText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getThrust());
        swingText.setText(((MyApplication) this.getApplicationContext()).characterArray.get(index).getSwing());
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        setText();
//    }

}