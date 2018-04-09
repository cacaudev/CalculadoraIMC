package com.example.alunos.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Formulario extends AppCompatActivity implements OnClickListener {

    TextView name, age, weight, height;
    Button makeReport;
    EditText nameField, ageField, weightField, heightField;
    Boolean nameNull = false, ageNull = false, weightNull = false, heightNull = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("CICLO", getLocalClassName() + " OnCreate chamado");
        setContentView(R.layout.activity_formulario);

        // Initialize variables and listeners
        name = findViewById(R.id.name);
        age =  findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);

        nameField = findViewById(R.id.name_field);
        ageField = findViewById(R.id.age_field);
        weightField = findViewById(R.id.weight_field);
        heightField = findViewById(R.id.height_field);

        makeReport = findViewById(R.id.btn_report);
        makeReport.setOnClickListener(this);
    }

    protected void onStart() {
        super.onStart();
        Log.v("CICLO", getLocalClassName() + " OnStart chamado");
    }

    protected void onRestart() {
        super.onRestart();
        Log.v("CICLO", getLocalClassName() + " OnRestart chamado");
    }

    protected void onResume() {
        super.onResume();
        Log.v("CICLO", getLocalClassName() + " OnResume chamado");
    }

    protected void onPause() {
        super.onPause();
        Log.v("CICLO", getLocalClassName() + " OnPause chamado");
    }

    protected void onStop() {
        super.onStop();
        Log.v("CICLO", getLocalClassName() + " OnStop chamado");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.v("CICLO", getLocalClassName() + " OnDestroy chamado");
    }


    @Override
    public void onClick(View view) {
        String nameTyped, ageTyped, weightTyped, heightTyped;

        switch(view.getId()) {
            case R.id.btn_report:
                nameTyped = nameField.getText().toString();
                ageTyped = ageField.getText().toString();
                weightTyped = weightField.getText().toString();
                heightTyped = heightField.getText().toString();

                if (nameTyped.matches("")) {
                    nameNull = true;
                    Toast.makeText(getApplicationContext(),"Nome está em branco",Toast.LENGTH_SHORT).show();
                }
                if(ageTyped.matches("")) {
                    ageNull = true;
                    Toast.makeText(getApplicationContext(),"Idade está em branco",Toast.LENGTH_SHORT).show();
                }
                if(heightTyped.matches("")) {
                    heightNull = true;
                    Toast.makeText(getApplicationContext(),"Altura está em branco",Toast.LENGTH_SHORT).show();
                }
                if(weightTyped.matches("")) {
                    weightNull = true;
                    Toast.makeText(getApplicationContext(),"Peso está em branco",Toast.LENGTH_SHORT).show();
                }

                if(!nameNull && !ageNull && !heightNull && !weightNull) {
                    Intent resultReport = new Intent(getBaseContext(), nutritionReport.class);
                    Bundle values = new Bundle();

                    values.putString("name", nameTyped);
                    values.putString("age", ageTyped);
                    values.putString("weight", weightTyped);
                    values.putString("height", heightTyped);

                    resultReport.putExtras(values);
                    startActivity(resultReport);
                }

                nameNull = false; ageNull = false; weightNull = false; heightNull = false;
        }
    }
}