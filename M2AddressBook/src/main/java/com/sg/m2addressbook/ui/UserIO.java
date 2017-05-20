package com.sg.m2addressbook.ui;

public interface UserIO {
    public int getInt(String prompt);
    public int getInt(String prompt, int min, int max);
    public String getString(String prompt);
    public float getFloat(String prompt);
    public float getFloat(String prompt, float min, float max);
    public double getDouble(String prompt);
    public double getDouble(String prompt, double min, double max);
    public void print(String prompt);
}
