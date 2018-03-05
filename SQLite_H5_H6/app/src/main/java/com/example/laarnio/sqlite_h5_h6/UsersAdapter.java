package com.example.laarnio.sqlite_h5_h6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by laarnio on 5.3.2018.
 */

public class UsersAdapter extends ArrayAdapter<User> {
    public UsersAdapter(Context context, ArrayList<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_users, parent, false);
        }
        // Lookup view for data population
        TextView tvId = (TextView) convertView.findViewById(R.id.tvId);
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvSurname = (TextView) convertView.findViewById(R.id.tvSurname);
        TextView tvPoints = (TextView) convertView.findViewById(R.id.tvPoints);

        // Populate the data into the template view using the data object
        tvId.setText(user.id);
        tvName.setText(user.name);
        tvSurname.setText(user.surname);
        tvPoints.setText(user.points);
        // Return the completed view to render on screen
        return convertView;
    }
}
