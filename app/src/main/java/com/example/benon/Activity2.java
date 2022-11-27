package com.example.benon;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.Buffer;

public class Activity2 extends AppCompatActivity {
    DBhelper mydb;
    EditText editID, editName;
    Button btnButtonn,btnButtonn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        mydb= new DBhelper(this);
        editID=findViewById(R.id.editTextNumber);
        editName=findViewById(R.id.editTextTextPersonName);
        btnButtonn=findViewById(R.id.btn_send);
        btnButtonn2=findViewById(R.id.btn_view);
        addData();
        viewAll();
    }
    public void addData(){
        btnButtonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean isInserted=mydb.insertStatus(editID.getText().toString(),editName.getText().toString());
              if(isInserted==true)
                  Toast.makeText(Activity2.this,"data is inserted",Toast.LENGTH_LONG).show();
              else
                  Toast.makeText(Activity2.this,"data is not inserted",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void viewAll() {
        btnButtonn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res= mydb.getData();
                if(res.getCount()==0){
                    showMessage("error","nothing found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){

                    buffer.append("Id:"+ res.getString(0)+"\n");
                    buffer.append("Name:"+ res.getString(1)+"\n");
                }
                showMessage("data",buffer.toString());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}




