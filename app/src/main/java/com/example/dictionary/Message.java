package com.example.dictionary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Message extends AppCompatDialogFragment {

    private String word;
    private String message;
    private int fileIdentifier;
    

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if(fileIdentifier == -1  || fileIdentifier == -3 || fileIdentifier == 0){
        builder.setTitle("Try Different Word");
        builder.setMessage(word + " is not added in the Dictionary.");
        }
        else
        {
            builder.setTitle("Try Different Word");
            builder.setMessage(word + " is an invalid word!");
        }
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }


    public Message( String word,int fileIdentifier)
    {
        this.word = word;
        this.fileIdentifier = fileIdentifier;

    }
}
