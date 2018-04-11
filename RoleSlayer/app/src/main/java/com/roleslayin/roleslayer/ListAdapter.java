package com.roleslayin.roleslayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] nameArray;
    private final String[] infoArray;

    public ListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam) {
        super(context, R.layout.character_list_view, nameArrayParam);

        this.context = context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.character_list_view, null, true);

        TextView nameTextField = (TextView)
                rowView.findViewById(R.id.nameTextView);
        TextView inforTextField = (TextView)
                rowView.findViewById(R.id.infoTextView);

        nameTextField.setText(nameArray[position]);
        inforTextField.setText(infoArray[position]);

        return rowView;
    };
};
