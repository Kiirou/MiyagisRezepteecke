package com.example.miyagisrezepteecke;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button button4;
    public Button button2;

    public void btn4() {
        button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent but4 = new Intent(MainActivity.this, AddRecipe.class);
                startActivity(but4);
            }
        });
    }

    public void btn2() {
        button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent but2 = new Intent(MainActivity.this, Einkaufsliste.class);
                startActivity(but2);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn4();
        btn2();
            }

}
