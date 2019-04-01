package com.example.ahsannaveed.sharedpreferencespractice;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    public static final String DEFAULT="N/A";
    TextView userNameTextView;
    TextView phoneNoTextView;
    Button loadButton;
    Button prevButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //init
        setContentView(R.layout.activity_second);
        userNameTextView=findViewById(R.id.textview3);
        phoneNoTextView=findViewById(R.id.textview4);
        loadButton=findViewById(R.id.load);
        prevButton=findViewById(R.id.previous);
    }


    //onload
    public void load(View view){

        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName",DEFAULT);
        String phoneNo = sharedPreferences.getString("phoneNo",DEFAULT);
        if(userName.equals(DEFAULT) || phoneNo.equals(DEFAULT)){
            Toast.makeText(this,"No data found",Toast.LENGTH_LONG).show();
        }else{

            Toast.makeText(this,"Data Loaded Successfully",Toast.LENGTH_LONG).show();
            userNameTextView.setText(userName);
            phoneNoTextView.setText(phoneNo);
        }

    }

    //on previous
    public void previous(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Previous",Toast.LENGTH_LONG).show();
    }
}
