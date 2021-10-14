package com.mm.coldcalling;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Student implements Serializable {
  private String mFullName;
  private int mImage;
  private Date mLastCalled;
  private int mCalledOnCount;

  public Student(String fullName, int image, boolean calledOn) {
    this.mFullName = fullName;
    this.mImage = image;
    this.mCalledOnCount = 0;
  }

  public String getFullName() {
    return this.mFullName;
  }

  public int getImage() { return this.mImage; }

  public int getCalledOnCount() { return mCalledOnCount; }

  public void resetStudent() {
    this.mCalledOnCount = 0;
    this.mLastCalled = null;
  }

  public boolean allowCall() {
    return this.mCalledOnCount < 1;
  }

  public void callOn() {
    this.mCalledOnCount++;
    this.mLastCalled = Calendar.getInstance().getTime();
  }

  public boolean isNewDay() {
    if (this.mLastCalled == null) return false;

    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(this.mLastCalled);

    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(calendar2.getTime());

    return calendar1.get(Calendar.DATE) != calendar2.get(Calendar.DATE);
  }

  @Override
  public boolean equals(Object o) {
    Student s = (Student) o;

    return s.mImage == this.mImage;
  }
}
