package com.example.mobileducklibras.user.presetation;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.mobileducklibras.R; // Certifique-se que este import está correto
import com.example.mobileducklibras.user.data.AlunoEntity; // Importe a entidade do aluno
import com.example.mobileducklibras.user.presetation.ProfileViewModel;

public class ProfileActivity extends AppCompatActivity {

    private ProfileViewModel profileViewModel;
    private TextView nameTextView, emailTextView, scoreTextView;
    private ImageView profileImageView;
    private Button editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Configuração da Toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbarProfile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Habilita o botão de voltar
        getSupportActionBar().setTitle("Meu Perfil"); // Define o título

        // Inicializa as Views
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        profileImageView = findViewById(R.id.profileImageView);
        editProfileButton = findViewById(R.id.editProfileButton);

        // Inicializa o ViewModel
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        // Observa as alterações nos dados do perfil
        profileViewModel.getUserProfile().observe(this, alunoEntity -> {
            if (alunoEntity != null) {
                nameTextView.setText(alunoEntity.getNome());
                emailTextView.setText(alunoEntity.getEmail());
                scoreTextView.setText("Pontuação: " + alunoEntity.getPontuacao());
                // Carregar imagem de perfil se houver URL (usando Glide, se aplicável)
                // if (alunoEntity.getProfileImageUrl() != null && !alunoEntity.getProfileImageUrl().isEmpty()) {
                //     Glide.with(this).load(alunoEntity.getProfileImageUrl()).into(profileImageView);
                // }
            }
        });

        // Observa mensagens de erro
        profileViewModel.getErrorMessage().observe(this, message -> {
            if (message != null && !message.isEmpty()) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        });

        // Carrega os dados do perfil quando a Activity é criada
        profileViewModel.loadUserProfile();

        // Configura o clique do botão "Editar Perfil"
        editProfileButton.setOnClickListener(v -> {
            Toast.makeText(ProfileActivity.this, "Funcionalidade de Edição em breve!", Toast.LENGTH_SHORT).show();
            // Aqui você pode iniciar uma nova Activity para edição de perfil
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Volta para a tela anterior ao clicar no botão de voltar da toolbar
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}