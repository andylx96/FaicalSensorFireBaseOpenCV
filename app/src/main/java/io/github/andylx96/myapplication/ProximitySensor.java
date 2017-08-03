package io.github.andylx96.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ProximitySensor extends AppCompatActivity implements SensorEventListener {



    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;




    TextView proxText;
    SensorManager sm;
    Sensor proxSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);




        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users")
                .child(firebaseUser.getUid()).child("ProximitySensor");





        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        proxSensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        proxText = (TextView) findViewById(R.id.proxSensor);

        if(proxSensor != null) {
            sm.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else{
            Toast.makeText(this, "Sensor Not Found", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {


        proxText.setText("Proximity Sensor: " + String.valueOf(event.values[0]));
        mDatabase.child("X").push().setValue(event.values[0]);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
