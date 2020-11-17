package com.example.homework_chapter_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv2 = findViewById(R.id.tv2);
        Button btn2 = findViewById(R.id.btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Main2Activity", " is Clicked");

                btn2.setText("CLICKED");

                Intent intent2 = new Intent(Main2Activity.this, MainActivity.class);

                startActivity(intent2);
            }
        });
    }
}