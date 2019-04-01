package com.example.ahsannaveed.sharedpreferencespractice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editUser ;
    EditText editPhone;
    TextView userText;
    TextView phoneText;
    Button saveButton;
    Button goToButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editUser = findViewById(R.id.edittext1);
        editPhone = findViewById(R.id.edittext2);
        userText = findViewById(R.id.textview1);
        phoneText = findViewById(R.id.edittext2);
        saveButton = findViewById(R.id.save);
        goToButton = findViewById(R.id.gotoB);
    }

    //saveButton
    public void save(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("userName",editUser.getText().toString());
        editor.putString("phoneNo",editPhone.getText().toString());
        editor.commit();
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show();


    }

    //gotoB button
    public void gotoB(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this,"NEXT",Toast.LENGTH_LONG).show();
    }


}
