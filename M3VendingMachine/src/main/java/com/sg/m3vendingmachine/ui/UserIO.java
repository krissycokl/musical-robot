package com.sg.m3vendingmachine.ui;

import java.time.LocalDate;

public interface UserIO {
    public int getInt(String prompt);
    public int getInt(String prompt, int min, int max);
    public String getString(String prompt);
    public float getFloat(String prompt);
    public float getFloat(String prompt, float min, float max);
    public double getDouble(String prompt);
    public double getDouble(String prompt, double min, double max);
    public LocalDate getDate(String prompt, String otherwise);
    public void print(String prompt);
}
