package com.example.laarnio.sqlite_h5_h6;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editName, editSurname, editPoints;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);

        editName = findViewById(R.id.editName);
        editSurname = findViewById(R.id.editSurname);
        editPoints = findViewById(R.id.editPoints);
        btn_add = findViewById(R.id.btn_add);
        AddData();
        viewAll();
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
    public void viewAll() {
        ListView lvItems = findViewById(R.id.lvItems);

        Cursor res = myDB.getAllData();
        UserCursorAdapter userAdapter = new UserCursorAdapter(this, res);
        lvItems.setAdapter(userAdapter);

    }
}
