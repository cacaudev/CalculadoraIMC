package com.example.alunos.calculadoraimc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class nutritionReport extends AppCompatActivity implements OnClickListener{

    TextView nameSent, ageSent, weightSent, heightSent, imc, classification;
    Button returnPreviousActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("CICLO", getLocalClassName() + " OnResume chamado");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_report);

        // Initialize variables and listeners
        nameSent = findViewById(R.id.nameGot);
        ageSent = findViewById(R.id.ageGot);
        weightSent = findViewById(R.id.weightGot);
        heightSent = findViewById(R.id.heightGot);
        imc = findViewById(R.id.imcResult);
        classification = findViewById(R.id.classificationResult);

        returnPreviousActivity = findViewById(R.id.btn_comeback);
        returnPreviousActivity.setOnClickListener(this);

        Intent formularyValues = getIntent();

        String nameTyped = formularyValues.getStringExtra("name");
        Integer ageTyped = Integer.parseInt(formularyValues.getStringExtra("age"));
        Float weightTyped = Float.valueOf(formularyValues.getStringExtra("weight"));
        Float heightTyped = Float.valueOf(formularyValues.getStringExtra("height"));

        Float calculatedImc = weightTyped / (heightTyped * heightTyped);

        String result = " ";
        if(calculatedImc < 18.5) result = "Abaixo do peso";
        if(calculatedImc > 18.5 && calculatedImc < 24.9) result = "Saudável";
        if(calculatedImc > 25 && calculatedImc < 29.9) result = "Sobrepeso";
        if(calculatedImc > 30 && calculatedImc < 34.9) result = "Obesidade grau I";
        if(calculatedImc > 35 && calculatedImc < 39.9)  result = "Obesidade grau II (severa)";
        if(calculatedImc >= 40) result = "Obesidade grau II (mórbida)";

        nameSent.setText("Nome: " + nameTyped);
        ageSent.setText("Idade: " + ageTyped);
        weightSent.setText("Peso(kg): " + weightTyped);
        heightSent.setText("Altura(m): " + heightTyped);
        imc.setText("IMC: " + calculatedImc);
        classification.setText("Classificação: " + result);

    }

    protected void onStart() {
        super.onStart();
        Log.v("CICLO", getLocalClassName() + " OnStart chamado");
    }

    protected void onRestart() {
        super.onRestart();
        Log.v("CICLO", " OnRestart chamado");
    }

    protected void onResume() {
        super.onResume();
        Log.v("CICLO", getLocalClassName() + " OnResume chamado");
    }

    protected void onPause() {
        super.onPause();
        Log.v("CICLO ", getLocalClassName() + " OnPause chamado");
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
        Intent imcForm = new Intent(getBaseContext(), Formulario.class);
        imcForm.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(imcForm);
        finish();
    }
}
