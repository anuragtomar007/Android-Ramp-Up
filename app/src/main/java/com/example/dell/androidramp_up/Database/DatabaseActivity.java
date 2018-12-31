package com.example.dell.androidramp_up.Database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.androidramp_up.R;

public class DatabaseActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editTextRoll;
    Button btnAddData;
    Button btnViewAll;
    Button btnDelete;
    Button btnViewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editText_name);
        editSurname = findViewById(R.id.editText_surname);
        editMarks = findViewById(R.id.editText_Marks);
        editTextRoll = findViewById(R.id.editText_roll);
        btnAddData = findViewById(R.id.button_add);
        btnViewAll = findViewById(R.id.button_viewAll);
        btnViewUpdate = findViewById(R.id.button_update);
        btnDelete = findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editTextRoll.getText().toString());
                if (deletedRows > 0)
                    Toast.makeText(DatabaseActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void UpdateData() {
        btnViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateData(editTextRoll.getText().toString(),
                        editName.getText().toString(),
                        editSurname.getText().toString(), editMarks.getText().toString());
                if (isUpdate)
                    Toast.makeText(DatabaseActivity.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this, "Data not Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void AddData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(editName.getText().toString(),
                        editSurname.getText().toString(),
                        editMarks.getText().toString());
                if (isInserted)
                    Toast.makeText(DatabaseActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DatabaseActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void viewAll() {

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing found");
                    return;
                }

                StringBuilder buffer = new StringBuilder();
                while (res.moveToNext()) {
                    buffer.append("Id :").append(res.getString(0)).append("\n");
                    buffer.append("Name :").append(res.getString(1)).append("\n");
                    buffer.append("Surname :").append(res.getString(2)).append("\n");
                    buffer.append("Marks :").append(res.getString(3)).append("\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
