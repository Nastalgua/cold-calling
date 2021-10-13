package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;



public class UncalledLog extends AppCompatActivity {

  private ListView studentsListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_uncalled_log);

    this.studentsListView = findViewById(R.id.student_list);

    // create adapter
    CustomAdapater customAdapater = new CustomAdapater(this, MainActivity.uncalledStudents);
    // set adapter
    this.studentsListView.setAdapter(customAdapater);

  }
}