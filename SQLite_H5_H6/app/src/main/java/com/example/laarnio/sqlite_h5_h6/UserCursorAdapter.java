package com.example.laarnio.sqlite_h5_h6;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;



/**
 * Created by laarnio on 4.3.2018.
 */

public class UserCursorAdapter extends CursorAdapter {
    public UserCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_users, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvId = view.findViewById(R.id.tvId);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvSurname = view.findViewById(R.id.tvSurname);
        TextView tvPoints = view.findViewById(R.id.tvPoints);

        String id = cursor.getString(cursor.getColumnIndexOrThrow("ID"));
        String name = cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
        String surname = cursor.getString(cursor.getColumnIndexOrThrow("SURNAME"));
        String points = cursor.getString(cursor.getColumnIndexOrThrow("POINTS"));

        tvId.setText(id);
        tvName.setText(name);
        tvSurname.setText(surname);
        tvPoints.setText(points);

    }
}
