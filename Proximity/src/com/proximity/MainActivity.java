package com.proximity;

import android.app.Activity;
 import android.hardware.Sensor;
 import android.hardware.SensorEvent;
 import android.hardware.SensorEventListener;
 import android.hardware.SensorManager;
 import android.os.Bundle;
 import android.widget.TextView;


 public class MainActivity extends Activity implements SensorEventListener {
  
  private SensorManager mSensorManager;
   private Sensor mProximity;
   private TextView myProximity;
    
  
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main); 
         
         myProximity = (TextView) this.findViewById(R.id.textProximity);
                        
         mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
      mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);    
      
        
     }


     


  @Override
  public void onSensorChanged(SensorEvent event) {
   // TODO Auto-generated method stub
   myProximity.setText(Float.toString(event.values[0]));
   
  }


  @Override
  public void onAccuracyChanged(Sensor sensor, int accuracy) {
   // TODO Auto-generated method stub
   
  }
  
  protected void onResume() {
         super.onResume();
         mSensorManager.registerListener(this, mProximity, SensorManager.SENSOR_DELAY_NORMAL);
     }

    protected void onPause() {
         super.onPause();
         mSensorManager.unregisterListener(this);
     }

}
