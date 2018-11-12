/*
 * Copyright (C) 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.wearable.wear.alwayson;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensor;
    private TextView acc_x;
    private TextView acc_y;
    private TextView acc_z;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE) ;
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        acc_x=findViewById(R.id.acc_x);
        acc_y=findViewById(R.id.acc_y);
        acc_z=findViewById(R.id.acc_z);
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensor,sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x=sensorEvent.values[0];
        float y=sensorEvent.values[1];
        float z=sensorEvent.values[2];
        acc_x.setText("x轴加速度："+x);
        acc_y.setText("y轴加速度："+y);
        acc_z.setText("z轴加速度："+z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

}
