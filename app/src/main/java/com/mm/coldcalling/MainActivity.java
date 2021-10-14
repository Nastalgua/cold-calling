package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  public static String[] images = {R.drawable.aamir_ali, R.drawable.adrian_yan, R.drawable.alexander_aney, R.drawable.bipra_dey, R.drawable.daniel_dultsin, R.drawable.darren_dong, R.drawable.dhruv_amin, R.drawable.eden_kogan, R.drawable.eli_bui, R.drawable.elie_belkin, R.drawable.evelyn_paskhaver, R.drawable.fardin iqbal, R.drawable.jerry_he, R.drawable.kenny_cao, R.drawable.marc_rosenberg, R.drawable.matthew_chen, R.drawable.michael_wu, R.drawable.ming_lin, R.drawable.mohammed_ithtisham, R.drawable.noam_canter, R.drawable.ralf_pacia, R.drawable.samuel_iskhakov, R.drawable.sean_kerrigan, R.drawable.selina_li, R.drawable.shuyue_chen, R.drawable.tanushri_sundaram, R.drawable.vasu_patel, R.drawable.xinrui_ge, R.drawable.zhen_maysoon };
  public static String[] names = {"aamir ali", "adrian yan", "alexander aney", "bipra dey", "daniel dultsin", "darren dong", "dhruv amin", "eden kogan", "eli bui", "elie belkin", "evelyn paskhaver", "fardin iqbal", "jerry he", "kenny cao", "marc rosenberg", "matthew chen", "michael wu", "ming lin", "mohammed ithtisham", "noam canter", "ralf pacia", "samuel iskhakov", "sean kerrigan", "selina li", "shuyue chen", "tanushri sundaram", "vasu patel", "xinrui ge", "zhen maysoon" };
  public static ArrayList<Student> students = new ArrayList<>();
  public static ArrayList<Student> calledStudents = new ArrayList<>();
  public static ArrayList<Student> uncalledStudents = new ArrayList<>();

  private Button randomBtn, uncalledBtn, calledBtn;
  private ListView studentsListView;

  private TextView mTime;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    this.studentsListView = findViewById(R.id.student_list);
    this.mTime = findViewById(R.id.time);

    this.mTime.setText(Calendar.getInstance().getTime().toString());

    // initialize the students
    for (int i = 0; i < 40; i++) {
      Student s = new Student("Matthew Chen", R.drawable.matthew_chen, false);
      students.add(s);
    }

    //initialize the images

    uncalledStudents = (ArrayList<Student>) students.clone();
    calledStudents = (ArrayList<Student>) students.clone();

    // create adapter
    CustomAdapter customAdapter = new CustomAdapter(this, students);
    // set adapter
    this.studentsListView.setAdapter(customAdapter);

    //set up time
    Thread t = new Thread() {
      @Override
      public void run() {
        try {
          while (!isInterrupted()) {
            Thread.sleep(1000);
            runOnUiThread(new Runnable() {
              @Override
              public void run() {
                TextView tdate = (TextView) findViewById(R.id.time);
                long date = System.currentTimeMillis();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy hh-mm-ss a");
                String dateString = sdf.format(date);
                tdate.setText(dateString);
              }
            });
          }
        } catch (InterruptedException e) {
        }
      }
    };
    t.start();

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
