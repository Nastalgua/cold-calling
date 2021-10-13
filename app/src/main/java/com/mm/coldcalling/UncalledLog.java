package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


public class UncalledLog extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_uncalled_log);

    //set up uncalled log
    LinearLayout uncalledList = findViewById(R.id.uncalledList);

    //adds textviews to the linearlayout
    for(int i = 0; i < MainActivity.uncalledStudents.size(); i++){

      TextView tv = new TextView(this);
      tv.setText(MainActivity.uncalledStudents.get(i).getFullName());
      tv.setId(i);
      WindowManager.LayoutParams textViewLayoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
      tv.setLayoutParams(textViewLayoutParams);
      uncalledList.addView(tv);

    }

  }
}