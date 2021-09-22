package com.example.lenovo.ventas_accesorios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RevisaPedido extends Activity {
    String Pedido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisa_pedido);
        Button btnSalir= (Button)findViewById(R.id.btnSalir);
        Button btnRegresar= (Button) findViewById(R.id.btnRegresar);
        Button btnEnviar= (Button) findViewById(R.id.btnEnviar);
        TextView tvResumen = (TextView) findViewById (R.id.tvInformacion);
        Intent intent = getIntent();
        Pedido = intent.getStringExtra(pedido.PEDIDO);
        tvResumen.setText(Pedido);
    }
    public void btnRegresarClick(View view){
        Intent i=new Intent(this,pedido.class);
        startActivity(i);
    }
    public void btnEnviarClick(View view){
        Intent emailIntent=new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"rubenoctavio@itsn.edu.mx"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Pedido aplicacion ANDROID");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Este es tu pedido"+Pedido);
        emailIntent.setType("text/plain");
        startActivity(emailIntent);
    }
    public void btnSalirClick(View view){
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}