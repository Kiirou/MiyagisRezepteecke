package com.example.miyagisrezepteecke;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddRecipe extends AppCompatActivity {

    EditText edtRecipesteps, edtName;
    Button btnAdd;

    public static SQLiteHelper sqLiteHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        init();

        sqLiteHelper = new SQLiteHelper(this, "RecipeDB.sqlite", null, 1);

        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS Recipe(Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, recipe VARCHAR)");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    sqLiteHelper.insertData(
                            edtName.getText().toString().trim(),
                            edtRecipesteps.getText().toString().trim()

                    );
                    Toast.makeText(getApplicationContext(), "Added successfully!", Toast.LENGTH_SHORT).show();
                    edtName.setText("");
                    edtRecipesteps.setText("");

                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        
    }

    private void init(){
        edtName = (EditText) findViewById(R.id.edtName);
        edtRecipesteps = (EditText) findViewById(R.id.edtRecipesteps);
        btnAdd = (Button) findViewById(R.id.btnAdd);

    }
}