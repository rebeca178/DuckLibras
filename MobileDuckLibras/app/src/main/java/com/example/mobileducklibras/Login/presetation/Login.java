package com.example.mobileducklibras.Login.presetation;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileducklibras.Home.Home;
import com.example.mobileducklibras.Login.data.SignIn;
import com.example.mobileducklibras.Login.data.SignInListener;
import com.example.mobileducklibras.Login.utils.SignInLibs;
import com.example.mobileducklibras.R;

public class Login extends AppCompatActivity implements SignInListener {
    private EditText edit_Email;
    private EditText edit_senha;
    private TextView issue_lb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edit_Email = findViewById(R.id.edit_email);
        edit_senha = findViewById(R.id.edit_senha);
        issue_lb = findViewById(R.id.issue_lb);
        issue_lb.setVisibility(GONE);
    }

    public void singInUser(View view){
        String issue = "*";
        String usernameOrEmail = edit_Email.getText().toString();
        String pass = edit_senha.getText().toString();
        if(usernameOrEmail.isEmpty()) issue += "Campo Usuario/email é Obrigatorio\n";
        if (pass.isEmpty()) issue += "Campo Senha é Obrigatoria\n";
        if(issue.equals("*")) {
            SignInLibs libs = new SignInLibs(this);
            SignIn signin = new SignIn();
            signin.setUsernameOrEmail(usernameOrEmail);
            signin.setPass(pass);
            libs.SignInUser(signin);

        } else {
            issue_lb.setText(issue);
            issue_lb.setVisibility(VISIBLE);
        }
    }

    // Implementação do listener
    @Override
    public void onSignInSucess(String response) {
        Intent intent = new Intent(Login.this, Home.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onSignInFailure(String response) {
        issue_lb.setText(response);
        issue_lb.setVisibility(VISIBLE);
        Toast.makeText(this, response, Toast.LENGTH_LONG).show();
    }
}