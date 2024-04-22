package com.example.asp_12spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Referenciamos los objetos
    public TextView tv1, tv2, tv3;
    public EditText et1, et2;
    public Spinner spinner1;
    private String[] operadores = {"sumar", "restar", "dividir", "multiplicar"};
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

        // Asiganmos valores
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.ed2);

        spinner1 = findViewById(R.id.spinner1);
        // Llenar el snipper;
        // Creamos un array no se que
        ArrayAdapter<String> operador1 = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, operadores);
        spinner1.setAdapter(operador1);

    }

    public void btnOperar(View v){
        //Evento del boton operar

        // Obtener los valores de los et//
        int numero1 = Integer.parseInt(et1.getText().toString());
        int numero2 = Integer.parseInt(et2.getText().toString());

        // Obtenemos el valor del snipper
        String seleccion = spinner1.getSelectedItem().toString();

        if(seleccion.equals("sumar")){
          int suma = numero1 + numero2;
          tv3.setText("La suma es : "+suma+"");
        }

        if(seleccion.equals("restar")){
            int suma = numero1 - numero2;
            tv3.setText("La resta es : "+suma+"");
        }
        if(seleccion.equals("dividir")){
            int suma = numero1 / numero2;
            tv3.setText("La division es : "+suma+"");
        }
        if(seleccion.equals("multiplicar")){
            int suma = numero1 * numero2;
            tv3.setText("La multiplicacion es : "+suma+"");
        }
    }


}