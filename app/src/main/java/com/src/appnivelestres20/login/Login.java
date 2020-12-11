package com.src.appnivelestres20.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.src.appnivelestres20.MainActivity;
import com.src.appnivelestres20.R;


public class Login extends AppCompatActivity {
    private EditText correo, password;
    private Button login, regis;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
        correo=(EditText)findViewById(R.id.etUsuario);
        password=(EditText)findViewById(R.id.etContra);
        login=(Button)findViewById(R.id.btnLogin);
        regis=(Button)findViewById(R.id.btnRegistrate);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = correo.getText().toString();
                String pass = password.getText().toString();
                if(email.equals("")||pass.equals(""))
                    Toast.makeText(Login.this, "Por favor ingrese los campos requeridos", Toast.LENGTH_SHORT).show();
                else {
                    String nombre= DB.userpass(email, pass);
                    if (nombre==""){
                        Toast.makeText(Login.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(Login.this, "Bienvenido "+nombre, Toast.LENGTH_SHORT).show();
                        Intent i= new Intent(getApplicationContext(), MainActivity.class);//Quitar Register.class va la clase luego de logearte
                        startActivity(i);
                    }
                }
            }
        });
        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), Register.class);

                startActivity(i);

            }
        });
    }
}