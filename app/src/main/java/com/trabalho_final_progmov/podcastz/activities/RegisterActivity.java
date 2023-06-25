package com.trabalho_final_progmov.podcastz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.trabalho_final_progmov.podcastz.R;

public class RegisterActivity extends AppCompatActivity {

  private FirebaseAuth auth;
  private EditText inputFirstName, inputLastName, inputEmail, inputPassword, inputConfirmPassword;
  private Button buttonRegister;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

    // Iniciando Firebase Auth
    auth = FirebaseAuth.getInstance();

    // Toolbar para o botão de voltar
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    // Iniciando componentes
    inputFirstName = findViewById(R.id.input_first_name);
    inputLastName = findViewById(R.id.input_last_name);
    inputEmail = findViewById(R.id.input_email);
    inputPassword = findViewById(R.id.input_password);
    inputPassword = findViewById(R.id.input_password);
    buttonRegister = findViewById(R.id.button_register);

    // Botão de voltar
    toolbar.setNavigationOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          Intent intent = new Intent(
            RegisterActivity.this,
            LoginActivity.class
          );
          startActivity(intent);
          finish();
        }
      }
    );

    // Botão de registro
    buttonRegister.setOnClickListener(
      new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          String email = inputEmail.getText().toString().trim();
          String password = inputPassword.getText().toString().trim();

          if (TextUtils.isEmpty(email)) {
            Toast
              .makeText(
                getApplicationContext(),
                "Por favor, insira um email!",
                Toast.LENGTH_SHORT
              )
              .show();
            return;
          }

          if (TextUtils.isEmpty(password)) {
            Toast
              .makeText(
                getApplicationContext(),
                "Por favor, insira uma senha!",
                Toast.LENGTH_SHORT
              )
              .show();
            return;
          }

          if (password.length() < 6) {
            Toast
              .makeText(
                getApplicationContext(),
                "A senha é muito curta, deve ter pelo menos 6 caracteres!",
                Toast.LENGTH_SHORT
              )
              .show();
            return;
          }

          createAccount(email, password);
        }
      }
    );
  }

  // Criando conta
  private void createAccount(String email, String password) {
    auth
      .createUserWithEmailAndPassword(email, password)
      .addOnCompleteListener(
        this,
        task -> {
          if (task.isSuccessful()) {
            Toast
              .makeText(
                RegisterActivity.this,
                "Registro bem-sucedido!",
                Toast.LENGTH_SHORT
              )
              .show();
            Intent intent = new Intent(
              RegisterActivity.this,
              LoginActivity.class
            );
            startActivity(intent);
            finish();
          } else {
            Toast
              .makeText(
                RegisterActivity.this,
                "Registro falhou! Por favor, tente novamente.",
                Toast.LENGTH_SHORT
              )
              .show();
          }
        }
      );
  }
}
