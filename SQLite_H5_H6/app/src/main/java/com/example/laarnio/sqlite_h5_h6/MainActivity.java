package com.example.laarnio.sqlite_h5_h6;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editName, editSurname, editPoints;
    Button btn_add, btn_viewData, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editPoints = findViewById(R.id.editPoints);
        btn_add = findViewById(R.id.btn_add);
        btn_viewData = findViewById(R.id.btn_viewData);
        btn_delete = findViewById(R.id.btn_delete);
        AddData();
        viewData();
    }

    public void AddData() {
        btn_add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDB.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editPoints.getText().toString());
                        if(isInserted)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void viewData() {
        btn_viewData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick (
                            View view) {
                        viewAll();
                    }
                }
        );
    }
    public void viewAll() {


        Cursor res = myDB.getAllData();
        ArrayList<User> arrayOfUsers = new ArrayList<User>();
        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
        ListView lvItems = findViewById(R.id.lvItems);
        lvItems.setAdapter(adapter);
        List<User> userList = new ArrayList<User>();

        if (res.moveToFirst()) {
            do {
                User user = new User(res.getString(0), res.getString(1), res.getString(2), res.getString(3));

                // Adding contact to list
                userList.add(user);
            } while (res.moveToNext());
        }
        adapter.addAll(userList);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = ((User) adapterView.getItemAtPosition(i));

                Log.d("YES", "onItemClick: You clicked on " + user.name );
                Intent editScreenIntent = new Intent(MainActivity.this, EditDataActivity.class);
                editScreenIntent.putExtra("id", user.id);
                editScreenIntent.putExtra("name", user.name);
                editScreenIntent.putExtra("surname", user.surname);
                editScreenIntent.putExtra("points", user.points);
                startActivity(editScreenIntent);
            }
        });


    }
}