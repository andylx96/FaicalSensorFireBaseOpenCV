


package io.github.andylx96.myapplication;

        import android.content.Intent;
        import android.hardware.Sensor;
        import android.hardware.SensorManager;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;

public class MainActivity extends AppCompatActivity {


    private SensorManager sm;
    private List<Sensor> ss;
    private TextView sslist;
    private TextView loginStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sslist= (TextView)findViewById(R.id.sensorList);
        sm= (SensorManager)getSystemService(SENSOR_SERVICE);
        ss= sm.getSensorList(Sensor.TYPE_ALL);

        for (Sensor s: ss){
            sslist.append("\n\n" +s.getName());
        }

        loginStatus = (TextView) findViewById(R.id.loginStatusText);

        setupButton();
        authButton();
        emailLogingButton();
    }

    private void setupButton(){
        Button setupButton = (Button) findViewById(R.id.button);
        setupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, Main2Activity.class));



            }
        });


    }


    private void authButton(){
        Button authButton = (Button) findViewById(R.id.signInButton);
        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, LoginByGoogle.class));



            }
        });


    }


    private void emailLogingButton(){
        Button emailButton = (Button) findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( MainActivity.this, "Button Clicked", Toast.LENGTH_LONG).show();

                startActivity(new Intent(MainActivity.this, EmailLogin.class));



            }
        });


    }


    public TextView getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(TextView loginStatus) {
        this.loginStatus = loginStatus;
    }
}




