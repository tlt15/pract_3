package com.example.pract_3;

import android.os.Bundle;

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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText nameText = findViewById(R.id.editTextText);
        EditText surnameText = findViewById(R.id.editTextText2);
        EditText ageText = findViewById(R.id.editTextText3);

        Intent intent = getIntent();
        if (intent != null){
            if(intent.getExtras() != null){
                Actor actorGet = (Actor) getIntent().getSerializableExtra("Actor");
                nameText.setText(actorGet.getName());
                surnameText.setText(actorGet.getSurname());
                ageText.setText(String.valueOf(actorGet.getAge()));
            }
        }
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String surname = surnameText.getText().toString();
                int age = Integer.parseInt(ageText.getText().toString());
                onNextActivity(name, surname, age);
            }
        });
    }

    public void onNextActivity(String name, String surname, int age){
        Intent intentNext = new Intent(this, SecondActivity.class);
        Actor actorPut = new Actor(name, surname, age);
        intentNext.putExtra("Actor", actorPut);
        startActivity(intentNext);
    }
}
