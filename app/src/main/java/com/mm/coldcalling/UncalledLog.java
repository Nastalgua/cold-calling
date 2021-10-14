package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;



public class UncalledLog extends AppCompatActivity {

  private ListView studentsListView;
  Button backBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_uncalled_log);

    this.studentsListView = findViewById(R.id.student_list);
    this.backBtn = findViewById(R.id.back_btn);
    // create adapter
    CustomAdapter customAdapter = new CustomAdapter(this, MainActivity.uncalledStudents);
    // set adapter
    this.studentsListView.setAdapter(customAdapter);

    this.backBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(UncalledLog.this, MainActivity.class);
        startActivity(i);
      }
    });

  }
}