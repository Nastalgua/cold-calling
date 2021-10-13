package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class CalledLog extends AppCompatActivity {

  private ListView studentsListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_called_log);

    this.studentsListView = findViewById(R.id.student_list);

    // create adapter
    CustomAdapter customAdapter = new CustomAdapter(this, MainActivity.uncalledStudents);
    // set adapter
    this.studentsListView.setAdapter(customAdapter);
  }
}