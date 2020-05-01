package com.example.tute04ans;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DBHandler;

public class MainActivity extends AppCompatActivity {

    EditText eName,ePassword;
    Button bSelect,bAdd,bSignin,bDelete,bUpdate;

    Database.DBHandler mydb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.eName);
        ePassword = findViewById(R.id.ePassword);
        bSelect = findViewById(R.id.bSelect);
        bAdd = findViewById(R.id.bAdd);
        bSignin = findViewById(R.id.bSignin);
        bDelete = findViewById(R.id.bDelete);
        bUpdate = findViewById(R.id.bUpdate);
    }

    public void onResume() {
        super.onResume();

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.addInfo(eName.getText().toString(), ePassword.getText().toString());
            }
        });


        bSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor newRowId = (Cursor) mydb.readAllInfo();
                if(newRowId!= null) {
                    while (newRowId.moveToNext()) {
                        Log.d("User record", "User" + newRowId.getString(2) + newRowId.getString(2));
                    }

                }else
                    showMessage();
            }

        });


    }

    private void showMessage() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Error");
        builder.setMessage("No user available");
        builder.show();
    }



}
