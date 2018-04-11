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
//    private final String[] nameArray;
//    private final String[] infoArray;
    private final ArrayList<String> nameArray = new ArrayList<>();
    private final ArrayList<String> infoArray = new ArrayList<>();

    public ListAdapter(Activity context, ArrayList<String> nameArrayParam, ArrayList<String> infoArrayParam) {
        super(context, R.layout.character_list_view, nameArrayParam);

        this.context = context;

        this.nameArray.addAll(nameArrayParam);
        this.infoArray.addAll(infoArrayParam);
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.character_list_view, null, true);

        TextView nameTextField = (TextView)
                rowView.findViewById(R.id.nameTextView);
        TextView inforTextField = (TextView)
                rowView.findViewById(R.id.infoTextView);

        nameTextField.setText(nameArray.get(position));
        inforTextField.setText(infoArray.get(position));

        return rowView;
    };
};