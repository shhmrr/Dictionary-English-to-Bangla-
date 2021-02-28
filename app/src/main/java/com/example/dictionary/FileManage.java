package com.example.dictionary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.*;
import java.util.Scanner;

public class FileManage extends AppCompatActivity {

    private int fileIdentifier = 0;
    private String file_string = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
    }

    private void readFile(int fileIdentifier){



    }

    public String getString()
    {
        return file_string + "qwe ";
    }
    // get fileIdentifier
    public int getFileIdentifier()
    {
        return fileIdentifier;
    }

    // Constructor
    public FileManage(int fileIdentifier)
    {
    this.fileIdentifier = fileIdentifier;
    readFile(this.fileIdentifier);
    }
}
