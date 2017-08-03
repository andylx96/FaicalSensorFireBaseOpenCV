package io.github.andylx96.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EmailLogin extends AppCompatActivity implements View.OnClickListener {

    private Button login, buttonRegister;
    private EditText editTextEmail, editTextPassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_login);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        editTextEmail = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        textViewSignin = (TextView) findViewById(R.id.textViewSignin);

        login = (Button) findViewById(R.id.emailViewLogin);


        buttonRegister.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    private void registerUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        //if valid
        progressDialog.setMessage("Registering User....");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(EmailLogin.this, "Registered Successfully", Toast.LENGTH_SHORT);
                            progressDialog.dismiss();



                        } else {
                            Toast.makeText(EmailLogin.this, "Registered Failed", Toast.LENGTH_SHORT);

                        }
                    }
                });


    }

    @Override
    public void onClick(View view) {
        if (view == buttonRegister) {

            registerUser();

        }

        if (view == login) {
            //open signin
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();


            if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        //if valid
        progressDialog.setMessage("Logging In ....");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(EmailLogin.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                            Toast.makeText(EmailLogin.this, " Welcome "+ firebaseAuth.getCurrentUser().getEmail(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(EmailLogin.this, Main2Activity.class));

                        } else {
                            Toast.makeText(EmailLogin.this, "LoginByEmail Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                });







        }
    }
}
