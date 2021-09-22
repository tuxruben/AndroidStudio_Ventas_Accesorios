package com.example.lenovo.ventas_accesorios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    static String NAME = "min";
    static String PASS = "123";
    static String NOMBREUSUARIO;
    //Elementos layout
    String nombre, pass;
    EditText editName,editPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.edtNombre);
        editPass = (EditText) findViewById(R.id.edtPassword);
        Button btnLogin= (Button) findViewById(R.id.myButton);
    }
    public void IniciarSesion(View view){
        nombre=editName.getText().toString();
        pass=editPass.getText().toString();
        Intent intent = new Intent(this,pedido.class);
//intent = new Intent(this, Pedido.class);
        intent.putExtra(NOMBREUSUARIO,nombre);
        if(nombre.equals(NAME) && pass.equals(PASS)){
            startActivity(intent);
        }else {
//display in long period of time
            Toast.makeText(getApplicationContext(), "El usuario introducido no es correcto",
                    Toast.LENGTH_LONG).show();
        }
    }
}
