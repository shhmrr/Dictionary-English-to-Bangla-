package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ///Initialize Variable
    DrawerLayout drawerLayout;
    LinearLayout toolbarLayout1,toolbarLayout2;
    EditText enterWord, enterWordHome;
    String word = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Assign Variable
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbarLayout1 = findViewById(R.id.initialToolbar);
        toolbarLayout2 = findViewById(R.id.searchToolbar);
        toolbarLayout1.setVisibility(View.VISIBLE);
        toolbarLayout2.setVisibility(View.GONE);

        enterWord = findViewById(R.id.enterWord);
        enterWord.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    word = enterWord.getText().toString();
                    System.out.println(word);
                    Intent i = new Intent(getApplicationContext(), Word.class);
                    i.putExtra("word", word);
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });

        //Enter word from home
        enterWordHome = findViewById(R.id.enterWordHome);
        enterWordHome.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    word = enterWordHome.getText().toString();
                    System.out.println(word);
                    Intent i = new Intent(getApplicationContext(), Word.class);
                    i.putExtra("word", word);
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });

        setupUI(findViewById(R.id.drawer_layout));
    }

    public void setupUI(View view) {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(MainActivity.this);
                    toolbarLayout1.setVisibility(View.VISIBLE);
                    enterWord.setText("");
                    enterWordHome.setCursorVisible(false);
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

    public void ClickMenu(View view)
    {
        //Open Drawer

        toolbarLayout1.setVisibility(View.VISIBLE);
        enterWord.setText("");
        openDrawer(drawerLayout);

    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open Drawer Layout

        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickBackDrawer(View view)
    {
        //Close Drawer

        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        //Close Drawer Layout
        //Check Condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            //When Drawer is open
            //Close Drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickSearch(View view)
    {
        enterWordOpens();
    }
    private void enterWordOpens() {
        toolbarLayout1.setVisibility(View.GONE);
        toolbarLayout2.setVisibility(View.VISIBLE);
        enterWord.setFocusableInTouchMode(true);
        enterWord.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(enterWord, InputMethodManager.SHOW_IMPLICIT);
    }
    public void ClickSearchWordHome(View view)
    {
        enterWordHomeOpens();
    }
    private void enterWordHomeOpens() {

        enterWordHome.setFocusableInTouchMode(true);
        enterWordHome.setCursorVisible(true);
        enterWordHome.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(enterWordHome, InputMethodManager.SHOW_IMPLICIT);
    }

    // About of Home
    public void ClickAboutHome(View view)
    {
        openAbout();
    }
    private void openAbout()
    {
        startActivity(new Intent(MainActivity.this, About.class));
    }

    // About of Navigation Drawer
    public void ClickAboutNav(View view)
    {
        openAboutNav();
    }
    private void openAboutNav()
    {
        startActivity(new Intent(MainActivity.this, About.class));
    }

    // Home of Navigation Drawer
    public void ClickHomeNav(View view)
    {
        openHomeNav();
    }
    private void openHomeNav()
    {
        startActivity(new Intent(MainActivity.this, MainActivity.class));
    }



    public void ClickExit(View view)
    {
        logout(this);
    }
    private static void logout(Activity activity)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Exit");
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