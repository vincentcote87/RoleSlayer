package com.roleslayin.roleslayer;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by vincentcote on 2018-04-12.
 */

public class AddItemDialog extends AppCompatDialogFragment {

    private EditText itemNameField;
    private EditText itemTypeField;
    private EditText itemDmgField;
    private EditText itemWeightField;
    private EditText itemDescriptionField;
    private addItemListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_add_item, null);

        builder.setView(view)
                .setTitle("Add new item").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String itemName = itemNameField.getText().toString();
                String itemType = itemTypeField.getText().toString();
                String itemDescr = itemDescriptionField.getText().toString();
                String itemDmg = itemDmgField.getText().toString();
                String itemWeight = itemWeightField.getText().toString();
                listener.passText(itemName, itemType, itemDmg, itemWeight, itemDescr);
            }
        });

        itemNameField = view.findViewById(R.id.itemNameInputID);
        itemTypeField = view.findViewById(R.id.itemTypeInputID);
        itemDmgField = view.findViewById(R.id.itemDmgInputID);
        itemWeightField = view.findViewById(R.id.itemWeightInputID);
        itemDescriptionField = view.findViewById(R.id.itemDescriptionInputID);



        return builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (addItemListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement addItemListener");
        }
    }

    public interface addItemListener {
        void passText(String name, String type, String dmg, String weight, String description);
    }
}