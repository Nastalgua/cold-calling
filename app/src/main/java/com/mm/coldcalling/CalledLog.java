package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalledLog extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_called_log);

    //setup for called log
    LinearLayout calledList = findViewById(R.id.calledList);

    for(int i = 0; i < MainActivity.calledStudents.size(); i++){
      TextView tv = new TextView(this);
      tv.setText(MainActivity.calledStudents.get(i).getFullName());
      WindowManager.LayoutParams textViewLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
      tv.setLayoutParams(textViewLayoutParams);
      calledList.addView(tv);

    }
  }
}