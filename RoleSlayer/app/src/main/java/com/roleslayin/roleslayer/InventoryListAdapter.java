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

public class InventoryListAdapter extends ArrayAdapter {

    private final Activity context;

    private final ArrayList<CharacterItem> itemArray = new ArrayList<>();

    public InventoryListAdapter(Activity context, ArrayList<CharacterItem> itemsArrayParam) {
        super(context, R.layout.inventory_list_view, itemsArrayParam);

        this.context = context;

        this.itemArray.addAll(itemsArrayParam);
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.inventory_list_view, null, true);

        TextView nameTextField = (TextView)
                rowView.findViewById(R.id.itemNameView);
        TextView descrTextField = (TextView)
                rowView.findViewById(R.id.itemDescView);
        TextView typeTextField = (TextView)
                rowView.findViewById(R.id.itemTypeInputView);
        TextView dmgTextField = (TextView)
                rowView.findViewById(R.id.itemDmgInputView);
        TextView weightTextField = (TextView)
                rowView.findViewById(R.id.itemWeightInputView);

        nameTextField.setText(itemArray.get(position).getItemName());
        descrTextField.setText(itemArray.get(position).getItemDescr());
        typeTextField.setText(itemArray.get(position).getItemType());
        dmgTextField.setText(String.valueOf(itemArray.get(position).getItemDmg()));
        weightTextField.setText(String.valueOf(itemArray.get(position).getItemWeight()));

        return rowView;
    };
};