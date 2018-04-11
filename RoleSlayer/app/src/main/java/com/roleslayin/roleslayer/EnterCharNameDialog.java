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

public class EnterCharNameDialog extends AppCompatDialogFragment {

    private EditText editTextCharacterName;
    private EditText editTextCharacterInfo;
    private EnterNewCharListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_add_new_character, null);

        builder.setView(view)
                .setTitle("Add new character").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String name = editTextCharacterName.getText().toString();
                String info = editTextCharacterInfo.getText().toString();
                listener.passText(name, info);
            }
        });

        editTextCharacterName = view.findViewById(R.id.editNewCharName);
        editTextCharacterInfo = view.findViewById(R.id.editNewCharInfo);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (EnterNewCharListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement EnterNewCharacterListener");
        }
    }

    public interface EnterNewCharListener {
        void passText(String name, String info);
    }
}
