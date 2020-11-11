package com.src.pruebanavegaciones;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private EditText nombre, apellido, fecNac, correo, telefono, distrito, password, repassword;
    private RadioGroup rgse;
    private RadioButton rFem, rMas;
    private Button registrarse, cancel;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        nombre = (EditText) findViewById(R.id.edNombre);
        apellido = (EditText) findViewById(R.id.edApellido);
        fecNac = (EditText) findViewById(R.id.edFecNac);
        rgse = (RadioGroup) findViewById(R.id.rbSexo);
        rFem = (RadioButton) findViewById(R.id.rbFemenino);
        rMas = (RadioButton) findViewById(R.id.rbMasculino);
        correo = (EditText) findViewById(R.id.edCorreo);
        telefono = (EditText) findViewById(R.id.edTelefono);
        distrito = (EditText) findViewById(R.id.edDistrito);
        password = (EditText) findViewById(R.id.edContras);
        repassword = (EditText) findViewById(R.id.edReContra);
        registrarse=(Button)findViewById(R.id.btnRegistrarse);
        cancel=(Button)findViewById(R.id.btnCancelar);
        DB = new DBHelper(this);
        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nombre.getText().toString();
                String ap = apellido.getText().toString();
                String fecha = fecNac.getText().toString();
                String sexo = validar();
                String email = correo.getText().toString();
                String tel = telefono.getText().toString();
                String dist = distrito.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();
                if (nom.equals("")||ap.equals("")||fecha.equals("")||sexo.equals("")||email.equals("")||tel.equals("")
                        ||dist.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(Register.this, "Por favor ingrese los campos requeridos", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean user =DB.user(email);
                        if(user==false){
                            Boolean insert = DB.insertData(nom,ap,fecha,sexo,email,tel,dist,pass);
                            if (insert==true){
                                Toast.makeText(Register.this, "Registro exitoso!!!", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(getApplicationContext(),Login.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(Register.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this, "Usuario existente, por favor inicie sesion", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Register.this, "La contraseña no coincide", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

    }
    private String validar(){
        if (rFem.isChecked()==true){
            return "Femenino";
        }else if (rMas.isChecked()==true){
            return "Masculino";
        }else {
            return "";
        }
    }
}