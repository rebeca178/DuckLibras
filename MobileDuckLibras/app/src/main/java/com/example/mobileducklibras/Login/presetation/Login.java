package com.example.mobileducklibras.Login.presetation;

import static android.view.View.GONE;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mobileducklibras.Login.data.SignIn;
import com.example.mobileducklibras.Login.utils.SingInLibs;
import com.example.mobileducklibras.R;

public class Login extends AppCompatActivity {
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
        String issue="*";
        String usernameOrEmail = edit_Email.getText().toString();
        String pass = edit_senha.getText().toString();
        if(usernameOrEmail.isEmpty()) issue += "Campo Usuario/email é Obrigatorio\n";
        if (pass.isEmpty()) issue += "Campo Senha é Obrigatoria\n";
        if(issue.equals("*"));
    }
    {
        SingInLibs libs = new SingInLibs();
        SignIn signIn = new SignIn();
        signIn.setUsernameOrEmail(UsernameOrEmail);
    }


}