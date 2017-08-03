package io.github.andylx96.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginByEmail extends AppCompatActivity implements View.OnClickListener{
//
//    private Button loginViewButton;
//    private EditText loginTextUsername, loginTextPassword;
//    private ProgressDialog progressDialog;
//    private FirebaseAuth firebaseAuth;
//    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        if(firebaseAuth.getCurrentUser() != null){
//            //profile activity here
//            firebaseUser = firebaseAuth.getCurrentUser();
//            finish();
//            Toast.makeText(LoginByEmail.this, "Already Logged In, " + firebaseUser.getEmail() , Toast.LENGTH_LONG);
//
//            startActivity(new Intent(LoginByEmail.this, Main2Activity.class));
//
//
//        }
//
//
//        loginViewButton = (Button) findViewById(R.id.loginViewButton);
//        loginTextPassword = (EditText) findViewById(R.id.loginTextPassword);
//        loginTextUsername = (EditText) findViewById(R.id.loginTextUsername);
//
//        progressDialog = new ProgressDialog(this);
//        loginViewButton.setOnClickListener(this);
//
//    }
//
//
//
//    private void LoginUser() {
//        String email = loginTextUsername.getText().toString().trim();
//        String password = loginTextPassword.getText().toString().trim();
//
//        if (TextUtils.isEmpty(email)) {
//            Toast.makeText(this, "enter email", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        if (TextUtils.isEmpty(password)) {
//            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        //if valid
//        progressDialog.setMessage("Logging In ....");
//        progressDialog.show();
//        firebaseAuth.signInWithEmailAndPassword(email, password)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(LoginByEmail.this, "Logged In Successfully", Toast.LENGTH_SHORT).show();
//                            progressDialog.dismiss();
//
//                            startActivity(new Intent(LoginByEmail.this, Main2Activity.class));
//
//                        } else {
//                            Toast.makeText(LoginByEmail.this, "LoginByEmail Failed", Toast.LENGTH_SHORT).show();
//
//                        }
//                    }
//                });
//
//
    }
//
//
    @Override
    public void onClick(View v) {
//
//        LoginUser();
//
//
    }
}
