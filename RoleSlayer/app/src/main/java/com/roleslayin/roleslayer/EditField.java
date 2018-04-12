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
import android.widget.TextView;
import com.roleslayin.roleslayer.R;

public class EditField extends AppCompatDialogFragment {

    private EditText defaultField;
    private EditFieldListener listener;
    private Bundle myArgs = getArguments();
//    private String defaultHeader = myArgs.getString("header_id");

//    String nn = myArgs.getString("header_id");

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_basics_fill, null);

        builder.setView(view)
                .setTitle("Edit Field").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String field = defaultField.getText().toString();
                listener.passText(field);
            }
        });

        defaultField = view.findViewById(R.id.editDefaultField);

        return builder.create();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (EditFieldListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement EditFieldListener");
        }
    }

    public interface EditFieldListener {
        void passText(String field);
    }
}

