package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.Random;
import java.util.Calendar;
import java.util.Date;

public class RandomResult extends AppCompatActivity {

  private ImageView mImg;
  private TextView mFullName;
  private TextView mWarning;
  private TextView mNumberOfTimes;
  private Button mBackBtn;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_random_result);

    this.mImg = findViewById(R.id.student_image);
    this.mFullName = findViewById(R.id.full_name);
    this.mBackBtn = findViewById(R.id.back_btn);
    this.mWarning = findViewById(R.id.warning);
    this.mNumberOfTimes = findViewById(R.id.numberOfTimes);

    Student student = this.pickRandomStudent();
    student.callOn();

    // set information
    this.mFullName.setText(student.getFullName());
    Glide.with(this).load(student.getImage()).into(this.mImg);
    this.mNumberOfTimes.setText("Number of times called on: " + student.getCalledOnCount());


    if(MainActivity.calledStudents.contains(student) && student.getLastCalled().toString() != null){
      //find time diff
      String curr = Calendar.getInstance().getTime().toString();
      String lastCalled = student.getLastCalled().toString();
      //math using the strings ind 14 15 --> where the minutes are

      //I am assuming the app will only be used for one period so only the minutes will be subtracted
      long minCurr = (curr.charAt(14) - '0') * 10 + (curr.charAt(15) - '0');
      long minPast = (lastCalled.charAt(14) - '0') * 10 + (lastCalled.charAt(15) - '0');

      if(minCurr - minPast <= 40){
        mWarning.setText("This student has been called on in the last 40 minutes");
        MainActivity.uncalledStudents.remove(student);

      }

    } else {
      MainActivity.calledStudents.add(student);
    }



    this.saveData();

    this.mBackBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }

  private Student pickRandomStudent() {
    Random random = new Random();
    int randomIndex = random.nextInt(MainActivity.uncalledStudents.size());

    return MainActivity.uncalledStudents.get(randomIndex);
  }

  public void saveData() {
    SharedPreferences.Editor prefsEditor = MainActivity.appSharedPrefs.edit();
    Gson gson = new Gson();
    String json = gson.toJson(MainActivity.students);
    prefsEditor.putString(MainActivity.KEY, json);
    prefsEditor.commit();

    Log.d("OK", "Save data");
  }

}