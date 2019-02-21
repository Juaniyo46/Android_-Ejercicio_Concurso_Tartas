package com.example.alumno_fp.ejercicio_concurso_tartas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox check;
    private View nombreC;
    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private EditText sexo;
    private Button fin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se comprueba si estan los edit text vacios o rellenos y se muestra toast

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        edad = (EditText) findViewById(R.id.edad);
        sexo = (EditText) findViewById(R.id.sexo);
        fin = (Button) findViewById(R.id.fin);
        
        /*String edadText = edad.getText().toString();
        final int edadNumber = Integer.parseInt(edadText);*/

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().trim().equalsIgnoreCase("") || apellido.getText().toString().trim().equalsIgnoreCase("") || edad.getText().toString().trim().equalsIgnoreCase("") || sexo.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(MainActivity.this, "Hay algún error en el formulario", Toast.LENGTH_SHORT).show();
                } else if (Integer.parseInt(edad.getText().toString()) < 18) {
                    Toast.makeText(MainActivity.this, "Error: Menor de edad", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Inscripción realizada con Exito", Toast.LENGTH_SHORT).show();
                }
            }
        });



        //Esto muestra el edit text si se marca checbox

        check = (CheckBox) findViewById(R.id.check);
        nombreC = findViewById(R.id.nombreC);

        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                nombreC.setVisibility(isChecked ? View.VISIBLE: View.GONE);
            }
        });
    }
}
