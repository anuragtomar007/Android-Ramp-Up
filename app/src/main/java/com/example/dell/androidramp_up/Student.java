package com.example.dell.androidramp_up;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {
    String name;
    int marks;

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    protected Student(Parcel in) {
        name = in.readString();
        marks = in.readInt();
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(marks);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
