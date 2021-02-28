package com.example.dictionary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class About extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_window);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*1), (int)(height*1));
    }

    public void ClickBackAbout(View view)
    {
        openMainActivity();
    }
    private void openMainActivity()
    {
        startActivity(new Intent(About.this, MainActivity.class));
    }

}
