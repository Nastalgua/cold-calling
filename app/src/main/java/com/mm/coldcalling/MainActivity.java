package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
  public static ArrayList<Student> students = new ArrayList<>();
  public static ArrayList<Student> calledStudents = new ArrayList<>();
  public static ArrayList<Student> uncalledStudents = new ArrayList<>();

  private Button randomBtn, uncalledBtn, calledBtn;
  private ListView studentsListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.studentsListView = findViewById(R.id.student_list);

    // initialize the students
    for (int i = 0; i < 40; i++) {
      Student s = new Student("Matthew Chen", R.drawable.cat, false);
      students.add(s);
    }

    uncalledStudents = (ArrayList<Student>) students.clone();

    // create adapter
    CustomAdapater customAdapater = new CustomAdapater(this, students);
    // set adapter
    this.studentsListView.setAdapter(customAdapater);

    // check if 24 hrs passed to reset calledOnStudents and uncalledStudents

    this.addListeners();
  }

  private void addListeners() {
    this.randomBtn = findViewById(R.id.random_btn);
    this.uncalledBtn = findViewById(R.id.uncalled_log_btn);
    this.calledBtn = findViewById(R.id.called_log_btn);

    this.randomBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, RandomResult.class);
        startActivity(i);
      }
    });

    this.uncalledBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, UncalledLog.class);
        startActivity(i);
      }
    });

    this.calledBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, CalledLog.class);
        startActivity(i);
      }
    });
  }
}
