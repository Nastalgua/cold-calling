package com.mm.coldcalling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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

    // set information
    this.mFullName.setText(student.getFullName());
    Picasso.with(this).load(student.getImage()).into(this.mImg);

//    MainActivity.uncalledStudents.remove(student);
//    MainActivity.calledStudents.add(student);

    this.mBackBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        Intent i = new Intent(RandomResult.this, MainActivity.class);
//        startActivity(i);
        finish();
      }
    });
  }

  private Student pickRandomStudent() {
    Random random = new Random();
    int randomIndex = random.nextInt(MainActivity.uncalledStudents.size());

    return MainActivity.uncalledStudents.get(randomIndex);
  }
}