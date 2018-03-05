package com.example.laarnio.sqlite_h5_h6;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EditDataActivity extends AppCompatActivity {
    private Button btn_Delete;
    private TextView tvId, tvName, tvSurname, tvPoints;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        btn_Delete = findViewById(R.id.btn_delete);
        tvId = findViewById(R.id.tvEditId);
        tvName = findViewById(R.id.tvEditName);
        tvSurname = findViewById(R.id.tvEditSurname);
        tvPoints = findViewById(R.id.tvEditPoints);
        myDb = new DatabaseHelper(this);

         final Intent receivedIntent = getIntent();

        tvId.setText(receivedIntent.getStringExtra("id"));
        tvName.setText(receivedIntent.getStringExtra("name"));
        tvSurname.setText(receivedIntent.getStringExtra("surname"));
        tvPoints.setText(receivedIntent.getStringExtra("points"));

        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDb.deleteUser(receivedIntent.getStringExtra("id"));
            }
        });
    }


}
