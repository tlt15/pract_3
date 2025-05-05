package com.example.pract_3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView nameText = findViewById(R.id.textView6);
        TextView surnameText = findViewById(R.id.textView4);
        TextView ageText = findViewById(R.id.textView5);

        Intent intent = getIntent();
        if (intent != null){
            if(intent.getExtras() != null){
                Actor actorGet = (Actor) getIntent().getSerializableExtra("Actor");
                nameText.setText(actorGet.getName());
                surnameText.setText(actorGet.getSurname());
                ageText.setText(String.valueOf(actorGet.getAge()));
            }
        }
        Button back = findViewById(R.id.button4);
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

    public void onLastActivity(String name, String surname, int age){
        Intent intentBack = new Intent(this, ThirdActivity.class);
        Actor actorPut = new Actor(name, surname, age);
        intentBack.putExtra("Actor", actorPut);
        startActivity(intentBack);
    }
}
