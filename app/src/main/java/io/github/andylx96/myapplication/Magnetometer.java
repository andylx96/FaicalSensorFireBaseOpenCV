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

public class Magnetometer extends AppCompatActivity implements SensorEventListener {


    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;




    TextView proxText;
        SensorManager sm;
        Sensor proxSensor;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_magnetometer);

            firebaseAuth = FirebaseAuth.getInstance();
            firebaseUser = firebaseAuth.getCurrentUser();
            mDatabase = FirebaseDatabase.getInstance().getReference().child("users")
                    .child(firebaseUser.getUid()).child("Magnetometer");



            sm = (SensorManager)getSystemService(SENSOR_SERVICE);
            proxSensor = sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            proxText = (TextView) findViewById(R.id.magnetometerView);

            if(proxSensor != null) {
                sm.registerListener(this, proxSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
            else{
                Toast.makeText(this, "Sensor Not Found", Toast.LENGTH_LONG).show();
            }

        }


        @Override
        public void onSensorChanged(SensorEvent event) {

            float azimuth = Math.round(event.values[0]);
            float pitch = Math.round(event.values[1]);
            float roll = Math.round(event.values[2]);

            double tesla = Math.sqrt(((azimuth*azimuth)+(pitch*pitch)+(roll * roll)));

            proxText.setText("Magnetometer Sensor: \n Calculated" + String.format("%.0f", tesla)
            + "\n X: " + String.valueOf(event.values[0]) +"\n Y: " +  String.valueOf(event.values[1])
                    +"\n Z: " +  String.valueOf(event.values[2]));



            mDatabase.child("X").push().setValue( String.valueOf(event.values[0]));
            mDatabase.child("Y").push().setValue( String.valueOf(event.values[1]));
            mDatabase.child("Z").push().setValue( String.valueOf(event.values[2]));




        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
