package com.example.miyagisrezepteecke;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button BtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnMove = findViewById(R.id.button4);
        BtnMove = findViewById(R.id.button2);
        BtnMove.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                moveToAddRecipe();
                moveToEinkaufsliste();
            }
        });
}
    private void moveToAddRecipe() {
        Intent intent = new Intent(MainActivity.this, AddRecipe.class);
        startActivity(intent);
    }

    private void moveToEinkaufsliste() {
        Intent intent = new Intent(MainActivity.this, Einkaufsliste.class);
        startActivity(intent);
    }
}