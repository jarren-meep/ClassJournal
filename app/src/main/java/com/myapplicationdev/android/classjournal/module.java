package com.myapplicationdev.android.classjournal;

import java.io.Serializable;
import java.util.ArrayList;

public class module implements Serializable {
    private String name;
    private String code;
    private ArrayList<String> dailyGrade;
    private String email;

    public module(String name, String code, ArrayList<String> dailyGrade, String email) {
        this.name = name;
        this.code = code;
        this.dailyGrade = dailyGrade;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getDailyGrade() {
        return dailyGrade;
    }

    public void setDailyGrade(ArrayList<String> dailyGrade) {
        this.dailyGrade = dailyGrade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}