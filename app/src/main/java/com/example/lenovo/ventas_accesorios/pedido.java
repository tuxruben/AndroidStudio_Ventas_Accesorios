package com.example.lenovo.ventas_accesorios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class pedido extends Activity {
    Button btCalcular;
    String pedido="";
    TextView txvTotal;
    Intent intent;
    //codigo de chks
    CheckBox chkUSB8;
    EditText edtUSB8;
    CheckBox chkUSB16;
    EditText edtUSB16;
    CheckBox chkUSB32;
    EditText edtUSB32;
    CheckBox chkSD8;
    EditText edtSD8;
    CheckBox chkSD16;
    EditText edtSD16;
    CheckBox chkSD32;
    EditText edtSD32;
    static String PEDIDO= "";
    //
//variables de valores convertidos
    double USB8;
    double USB16;
    double USB32;
    double SD8;
    double SD16;
    double SD32;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido2);
        // Acceso a botones del layout Pedido
        Button btPedido = (Button) findViewById(R.id.btnPedido);
        Button btCalcular = (Button) findViewById(R.id.btnCalcular);
        TextView resultado = (TextView) findViewById (R.id.textView1);
        intent = getIntent();
        String nombre = intent.getStringExtra(MainActivity.NOMBREUSUARIO);
        resultado.setText("Bienvenido "+nombre);
    }
    public void btnPedidoClick(View view){
        intent = new Intent(this, RevisaPedido.class);
        intent.putExtra(PEDIDO, pedido);
        startActivity(intent);
    }
    public void btnCalcularClick(View view){
        obtenerValores();
//Codigo para el calculo del pedido
        double tot=0;
//calculo para usb
        pedido+="\n Cantidad \tProducto \tSubtotal";
        if(chkUSB8.isChecked())
        {
            USB8=Double.parseDouble(edtUSB8.getText().toString());
            tot+=USB8*100;
//variable que contendra l pedidio y se va al activity pedido
            pedido+="\n"+USB8+"\tMemoria USB 8GB \t"+(USB8*100);
        }
        if(chkUSB16.isChecked())
        {
            USB16=Double.parseDouble(edtUSB16.getText().toString());
            tot+=USB16*120;
//variable que contendra l pedidio y se va al activity pedido
            pedido+="\n"+USB16+"\tMemoria USB 16GB \t"+(USB16*120);
        }
        if(chkUSB32.isChecked())
        {
            USB32=Double.parseDouble(edtUSB32.getText().toString());
            tot+=USB32*120;
//variable que contendra l pedidio y se va al activity pedido
            pedido+="\n"+USB32+"\tMemoria USB 32GB \t"+(USB32*120);
        }
        if(chkSD8.isChecked())
        {
            SD8=Double.parseDouble(edtSD8.getText().toString());
            tot+=SD8*120;
//variable que contendra l pedidio y se va al activity pedido
            pedido+="\n"+SD8+"\tMemoria SD 8GB \t"+(SD8*120);
        }
        if(chkSD16.isChecked())
        {
            SD16=Double.parseDouble(edtSD16.getText().toString());
            tot+=SD16*120;
//variable que contendra l pedidio y se va al activity pedido
            pedido+="\n"+SD16+"\tMemoria SD 16GB \t"+(SD16*120);
        }
        if(chkSD32.isChecked())
        {
            SD32=Double.parseDouble(edtSD32.getText().toString());
            tot+=SD32*120;
//variable que contendra l pedidio y se va al activity pedido
            pedido+="\n"+SD32+"\tMemoria SD 32GB \t"+(SD32*120);
        }

        txvTotal.setText("$ "+tot);
        pedido+="\n$ "+tot;
    }
    public void obtenerValores(){
//obtencion de vistas y conversion de valores
        chkUSB8 = (CheckBox)findViewById(R.id.chk8);
        edtUSB8=(EditText)findViewById(R.id.edt8);
        chkUSB16 = (CheckBox)findViewById(R.id.chk16);
        edtUSB16=(EditText)findViewById(R.id.edt16);
        chkUSB32 = (CheckBox)findViewById(R.id.chk32);
        edtUSB32=(EditText)findViewById(R.id.edt32);
        chkSD8 = (CheckBox)findViewById(R.id.chkM8);
        edtSD8=(EditText)findViewById(R.id.edtM8);
        chkSD16 = (CheckBox)findViewById(R.id.chkM16);
        edtSD16=(EditText)findViewById(R.id.edtM16);
        chkSD32 = (CheckBox)findViewById(R.id.chkM32);
        edtSD32=(EditText)findViewById(R.id.edtM32);
//resultado
        txvTotal=(TextView)findViewById(R.id.tvTotal);
    }
}