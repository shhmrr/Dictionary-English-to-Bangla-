package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.io.*;



import java.util.Scanner;

public class Word extends AppCompatActivity {

    DrawerLayout drawerLayout1;
    LinearLayout toolbarLayout3,toolbarLayout4;
    EditText enterAnotherWord;

    TextView english, bangla, showWord,showWordBangla;
    private String word = "";
    private String newWord = "";
    private int fileIdentifier = -1;
    private String file_string = "";
    private String file_string_first = "";
    private String file_string_second = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            word = extras.getString("word");



            PerfectHashingWord hashedWord = new PerfectHashingWord(word);
            word = hashedWord.getWord();
            fileIdentifier = hashedWord.getFileIdentifier();
            FileManage manageFile = new FileManage(fileIdentifier);
            //file_string = manageFile.getString();

            // Taking String from file.
            //fileIdentifier = -1; //For now delete this later please
            if (fileIdentifier == -1) {
                // Not added
                openDialog();
                System.out.println("Not found");

            }
            else if(fileIdentifier == -2)
            {
                // Not added Invalid
                openDialog();
                System.out.println("Invalid Character!");

            }
            else if(fileIdentifier == -3 || fileIdentifier == 0)
            {
                // Not added
                fileIdentifier = -1;
                openDialog();
                System.out.println("Not Added!");

            }
            else {
                InputStream is = this.getResources().openRawResource(fileIdentifier);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                if (is != null) {

                    try {

                        file_string_first = reader.readLine();
                        file_string_second = reader.readLine();
                        //System.out.println(file_string);

                        // Write to History File

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //buf.append(str + "\n" );
                }
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                String str1 = word.toLowerCase();
                String str2 = file_string_first.toLowerCase();
                if(str2.equalsIgnoreCase(str1)) {
                    english = findViewById(R.id.english);
                    english.setText("English");
                    showWord = findViewById(R.id.showWord);
                    showWord.setText(file_string_first);
                    bangla = findViewById(R.id.bangla);
                    bangla.setText("Bangla");
                    showWordBangla = findViewById(R.id.showWordBangla);
                    showWordBangla.setText(file_string_second);
                }
                else
                {
                    // Not added
                    fileIdentifier = -1;
                    openDialog();
                }
            }

            /*// Splitting the words
            int count = 0,charCount = 0;
            for(int i=0;i<file_string.length();i++)
            {
              if((file_string.charAt(i) == ' ') && (charCount == 1))
              {
                  count = 1;

              }
              else if(file_string.charAt(i) != ' ')
                  {
              if(count == 0)
              {
                  charCount = 1;
                  file_string_first += file_string.charAt(i);
              }
              else
                  file_string_second += file_string.charAt(i);
              }
            }*/

            //The key argument here must match that used in the other activity



        }
            drawerLayout1 = findViewById(R.id.drawer_layout2);
            toolbarLayout3 = findViewById(R.id.initialToolbar);
            toolbarLayout4 = findViewById(R.id.searchToolbar);
            toolbarLayout3.setVisibility(View.VISIBLE);
            toolbarLayout4.setVisibility(View.GONE);

            enterAnotherWord = findViewById(R.id.enterWord);
            enterAnotherWord.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    // If the event is a key-down event on the "enter" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        // Perform action on key press
                        newWord = enterAnotherWord.getText().toString();
                        System.out.println(newWord + "  124");
                        Intent i = new Intent(getApplicationContext(), Word.class);
                        i.putExtra("word", newWord);
                        startActivity(i);
                        return true;
                    }
                    return false;
                }
            });

        setupUI(findViewById(R.id.drawer_layout2));
    }
    // To close keyboard
    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(Word.this);
                    toolbarLayout3.setVisibility(View.VISIBLE);
                    enterAnotherWord.setText("");
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    public void openDialog()
    {

            Message newMessage = new Message(word, fileIdentifier);
            newMessage.show(getSupportFragmentManager(), "This is a message");


    }
    public void ClickMenu(View view)
    {
        //Open Drawer
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(enterAnotherWord.getWindowToken(), 0);

        toolbarLayout3.setVisibility(View.VISIBLE);
        enterAnotherWord.setText("");
        System.out.println("helpppppp");
        openDrawer(drawerLayout1);

    }

    public static void openDrawer(DrawerLayout drawerLayout2) {
        //Open Drawer Layout

        drawerLayout2.openDrawer(GravityCompat.START);

    }

    public void ClickBackDrawer(View view)
    {
        //Close Drawer

        closeDrawer(drawerLayout1);
    }

    public static void closeDrawer(DrawerLayout drawerLayout2) {
        //Close Drawer Layout
        //Check Condition
        if(drawerLayout2.isDrawerOpen(GravityCompat.START))
        {
            //When Drawer is open
            //Close Drawer
            drawerLayout2.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickSearch(View view)
    {
        //Open Drawer
        enterWordOpens();

    }

    private void enterWordOpens() {
        toolbarLayout3.setVisibility(View.GONE);
        toolbarLayout4.setVisibility(View.VISIBLE);
        enterAnotherWord.setFocusableInTouchMode(true);
        enterAnotherWord.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(enterAnotherWord, InputMethodManager.SHOW_IMPLICIT);
    }

    // About of Navigation Drawer
    public void ClickAboutNav(View view)
    {
        openAboutNav();
    }
    private void openAboutNav()
    {
        startActivity(new Intent(Word.this, About.class));
    }

    // Home of Navigation Drawer
    public void ClickHomeNav(View view)
    {
        openHomeNav();
    }
    private void openHomeNav()
    {
        startActivity(new Intent(Word.this, MainActivity.class));
    }

    public void ClickExit(View view)
    {
        logout(this);
    }
    private static void logout(Activity activity)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Finish Activity
                activity.finishAffinity();
                // Exit App
                System.exit(0);
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Dismiss Dialog
                dialog.dismiss();
            }
        });
        // Show Dialog
        builder.show();
    }

}