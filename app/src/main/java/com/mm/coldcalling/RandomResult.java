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

public class RandomResult extends AppCompatActivity {

  private ImageView mImg;
  private TextView mFullName;
  private Button mBackBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_random_result);

    this.mImg = findViewById(R.id.student_image);
    this.mFullName = findViewById(R.id.full_name);
    this.mBackBtn = findViewById(R.id.back_btn);

    Student student = this.pickRandomStudent();
    student.callOn();

    // set information
    this.mFullName.setText(student.getFullName());
    Glide.with(this).load(student.getImage()).into(this.mImg);

    MainActivity.uncalledStudents.remove(student);
    MainActivity.calledStudents.add(student);

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