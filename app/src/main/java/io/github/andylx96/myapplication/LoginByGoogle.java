package io.github.andylx96.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class LoginByGoogle extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener{




    TextView loginStatus;
    SignInButton signInButton;
    Button signOutButton;
    GoogleApiClient mGoogleApiClient;
    private static final String TAG = "SignInActivity";
    private static final  int RC_SIGN_IN = 9001;

    MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_google);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        loginStatus = (TextView) findViewById(R.id.logingStats);
        signInButton = (SignInButton) findViewById(R.id.signInButton);
        signInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signInButton:
                signIn();
                break;
//            case R.id.sig
        }
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//            if (result.isSuccess()) {
//
//                // Google Sign In was successful, authenticate with Firebase
////                GoogleSignInAccount account = result.getSignInAccount();
////                firebaseAuthWithGoogle(account);
//            } else {
//                // Google Sign In failed
//                Log.e(TAG, "Google Sign In failed.");
//            }


            handleSignInResult(result);

        }
    }

    private void handleSignInResult (GoogleSignInResult result){
        Log.d(TAG, "handleSignInRsult:" + result.isSuccess());
        if (result.isSuccess()){

            GoogleSignInAccount acct = result.getSignInAccount();
            loginStatus.setText("Hello "+ acct.getDisplayName());
//            mainActivity.getLoginStatus().setText("Hello "+ acct.getDisplayName());
            Toast.makeText(this, "Hello " + acct.getDisplayName(), Toast.LENGTH_LONG).show();
        }
        else
        {   loginStatus.setText("Error");

//            mainActivity.getLoginStatus().setText("Error");
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
