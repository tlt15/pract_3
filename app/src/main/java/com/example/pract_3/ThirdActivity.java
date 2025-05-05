package com.example.pract_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText nameText = findViewById(R.id.editTextText7);
        EditText surnameText = findViewById(R.id.editTextText8);
        EditText ageText = findViewById(R.id.editTextText9);


        Button next = findViewById(R.id.button3);
        Button back = findViewById(R.id.button5);

        Actor actorGet = (Actor) getIntent().getSerializableExtra("Actor");
        nameText.setText(actorGet.getName());
        surnameText.setText(actorGet.getSurname());
        ageText.setText(String.valueOf(actorGet.getAge()));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String surname = surnameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                onNextActivity(name, surname, age);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String surname = surnameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                onLastActivity(name, surname, age);
            }
        });
    }

    public void onNextActivity(String name, String surname, int age){
        Intent intentNext = new Intent(this, FourthActivity.class);
        Actor actorPut = new Actor(name, surname, age);
        intentNext.putExtra("Actor", actorPut);
        startActivity(intentNext);
    }

    public void onLastActivity(String name, String surname, int age){
        Intent intentLast = new Intent(this, SecondActivity.class);
        Actor actorPut = new Actor(name, surname, age);
        intentLast.putExtra("Actor", actorPut);
        startActivity(intentLast);
    }
}
