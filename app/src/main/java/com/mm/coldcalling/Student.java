package com.mm.coldcalling;

public class Student {
  private String mFullName;
  private int mImage;
  private boolean mCalledOn;

  public Student(String fullName, int image, boolean calledOn) {
    this.mFullName = fullName;
    this.mImage = image;
    this.mCalledOn = calledOn;
  }

  public String getFullName() {
    return this.mFullName;
  }

  public boolean isCalledOn() {
    return this.mCalledOn;
  }

  public int getImage() { return this.mImage; }

  @Override
  public boolean equals(Object o) {
    Student s = (Student) o;

    return s.mImage == this.mImage;
  }
}
