package io.github.andylx96.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


//    TextView accelText;
//    SensorManager sm;
//    Sensor accelSensor;

    private Button proxb, accelb, gyrob, pressureb, magnetb, stepb, gpsButton, openCvCamera,
            gravityButton, detectionButton, lightButton, rotationVectorButton, tempButton, humidityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        proxb = (Button) findViewById(R.id.proxSensor);
        proxb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, ProximitySensor.class));
            }
        });

        accelb = (Button) findViewById(R.id.accelSensor);
        accelb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Accelerometer.class));
            }
        });

        gyrob = (Button) findViewById(R.id.gyroSensor);
        gyrob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Gyroscopic.class));
            }
        });

        pressureb = (Button) findViewById(R.id.pressureSensor);
        pressureb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Pressure.class));
            }
        });


        magnetb = (Button) findViewById(R.id.magnetSensor);
        magnetb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Magnetometer.class));
            }
        });


        stepb = (Button) findViewById(R.id.stepSensor);
        stepb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, StepCounter.class));
            }
        });


        gpsButton = (Button) findViewById(R.id.gpsButton);
        gpsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Gps.class));
            }
        });


        openCvCamera = (Button) findViewById(R.id.openCVCamera);
        openCvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, CameraMain.class));
            }
        });


//
        gravityButton = (Button) findViewById(R.id.gravityButton);
        gravityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Gravity.class));
            }
        });



//
        detectionButton = (Button) findViewById(R.id.detectionButton);
        detectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, MotionDection.class));
            }
        });


//
        lightButton = (Button) findViewById(R.id.lightButton);
        lightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Light.class));
            }
        });

//
        rotationVectorButton = (Button) findViewById(R.id.rotationVector);
        rotationVectorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Rotation_Vector.class));
            }
        });
//
        tempButton = (Button) findViewById(R.id.temperatureButton);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Temperature.class));
            }
        });
//
        humidityButton = (Button) findViewById(R.id.humidityButton);
        humidityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Main2Activity.this, "Button Clicked", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Main2Activity.this, Humidity.class));
            }
        });


    }
}





//
//        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
//        accelSensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//        accelText = (TextView) findViewById(R.id.accelSensor);
//        sm.registerListener(this,accelSensor, SensorManager.SENSOR_DELAY_NORMAL);
//
//    }
//
//
//

//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//
//
//        accelText.setText("Proximity Sensor: " + String.valueOf(event.values[0]));
//
//
//    }
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//}
