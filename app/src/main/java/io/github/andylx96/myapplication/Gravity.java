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

public class Gravity extends AppCompatActivity implements SensorEventListener {



    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    private TextView textView;
    private SensorManager sm;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("users")
                .child(firebaseUser.getUid()).child("Gravity");


        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        textView = (TextView) findViewById(R.id.gravityViews);

        if(sensor != null) {
            sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else{
            Toast.makeText(this, "Sensor Not Found", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onSensorChanged(SensorEvent event) {


//        Toast.makeText(this, String.valueOf(event.values[0]), Toast.LENGTH_LONG).show();

        textView.setText("Gravity: " + String.valueOf(event.values[0]) + "\n" +
                String.valueOf(event.values[1]) + "\n" + String.valueOf(event.values[2]));
        mDatabase.child("X").push().setValue(event.values[0]);
        mDatabase.child("Y").push().setValue(event.values[1]);
        mDatabase.child("Z").push().setValue(event.values[2]);


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
