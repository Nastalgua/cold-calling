package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class CalledLog extends AppCompatActivity {

  private ListView studentsListView;
  Button backBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_called_log);

    this.studentsListView = findViewById(R.id.student_list);
    this.backBtn = findViewById(R.id.back_btn);

    // create adapter
    if (MainActivity.calledStudents.size() > 0) {
      CustomAdapter customAdapter = new CustomAdapter(this, MainActivity.calledStudents);
      this.studentsListView.setAdapter(customAdapter);
    }

    this.backBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }
}