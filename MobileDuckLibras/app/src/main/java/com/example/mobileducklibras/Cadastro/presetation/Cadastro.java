package com.example.mobileducklibras.Cadastro.presetation;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileducklibras.Cadastro.data.SignUp;
import com.example.mobileducklibras.Cadastro.utils.SignUpLibs;
import com.example.mobileducklibras.R;


public class Cadastro extends AppCompatActivity {


    private EditText edit_nome;
    private EditText edit_email;
    private EditText edit_senha;
    private TextView issue_lb;
    private String issue = "*";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit_nome = findViewById(R.id.edit_nome);
        edit_email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        issue_lb = findViewById(R.id.issue_lb);
        issue_lb.setVisibility(GONE);

     }
    public void SignUpUser(View view)
    {
        String name = edit_nome.getText().toString();
        String email = edit_email.getText().toString();
        String password = edit_senha.getText().toString();
        if (name.isEmpty()) issue += "Campo nome e obrigatorio \n ";
        if (email.isEmpty()) issue += "Campo email e obrigatorio\n ";
        if(password.isEmpty()) issue += "Campo senha e obrigatorio\n ";
        if (issue.equals("*"))
        {
            SignUpLibs libs = new SignUpLibs();
            SignUp signup = new SignUp();
            signup.setName(name);
            signup.setEmail(email);
            signup.setPassword(password);
            issue = libs.SignUpUser(signup);
        }
        issue_lb.setText(issue);
        issue_lb.setVisibility(VISIBLE);
        }
    }
