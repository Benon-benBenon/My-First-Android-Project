package com.example.benon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butt= findViewById(R.id.button3);

        butt.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();

            }
        });


    }

    public void openActivity2(){
        Intent intent=new Intent(this,Activity2.class);
        startActivity(intent);
    }
}