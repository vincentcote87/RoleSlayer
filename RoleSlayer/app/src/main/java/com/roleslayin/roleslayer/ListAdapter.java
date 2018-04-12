package com.roleslayin.roleslayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter {

    private final Activity context;

    private final ArrayList<PlayerCharacter> characterArray = new ArrayList<>();

    public ListAdapter(Activity context, ArrayList<PlayerCharacter> characterArrayParam) {
        super(context, R.layout.character_list_view, characterArrayParam);

        this.context = context;


        this.characterArray.addAll(characterArrayParam);
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.character_list_view, null, true);

        TextView nameTextField = (TextView)
                rowView.findViewById(R.id.nameTextView);
        TextView inforTextField = (TextView)
                rowView.findViewById(R.id.infoTextView);

        nameTextField.setText(characterArray.get(position).getName());
        inforTextField.setText(characterArray.get(position).getInfo());

        return rowView;
    };
};