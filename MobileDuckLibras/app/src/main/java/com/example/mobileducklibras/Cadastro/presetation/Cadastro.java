package com.example.mobileducklibras.Cadastro.presetation;

import static android.view.View.GONE;

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
import com.example.mobileducklibras.Cadastro.data.SignUpListener;
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

    public void SignUpUser(View view) {


        String username = edit_nome.getText().toString();
        String email = edit_email.getText().toString();
        String pass = edit_senha.getText().toString();
        if (username.isEmpty()) issue += "Campo nome e obrigatorio \n ";
        if (email.isEmpty()) issue += "Campo email e obrigatorio\n ";
        if (pass.isEmpty()) issue += "Campo senha e obrigatorio\n ";
        if (issue.equals("*")) {
            SignUp signup = new SignUp();
            signup.setUsername(username);
            signup.setEmail(email);
            signup.setPass(pass);  // Corrigido para setPassword

            // Implementação correta com listener
            SignUpLibs libs = new SignUpLibs(new SignUpListener() {
                @Override
                public void onSignUpSuccess(String response) {
                    runOnUiThread(() -> {
                        // Atualizar UI com sucesso
                        issue_lb.setText("Cadastro realizado com sucesso!");
                        issue_lb.setVisibility(View.VISIBLE);
                    });
                }

                @Override
                public void onSignUpFailure(String error) {
                    runOnUiThread(() -> {
                        // Mostrar erro para o usuário
                        issue_lb.setText(error);
                        issue_lb.setVisibility(View.VISIBLE);
                    });
                }
            });

            libs.SignupUser(signup);
        }

    }

}
