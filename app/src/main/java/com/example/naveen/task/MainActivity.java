package com.example.naveen.task;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.WindowManager;
import android.widget.Toast;
import android.widget.TextView;
import java.util.Random;


       public class MainActivity extends Activity
 {
    /** Called when the activity is first created. */
          TextView txtCount;
          Button btnCount;
          Button btnreset;
          int count = 0;
          int min=156;
          String saved;
          String s;
          int a;
     @Override
        public void onCreate(Bundle savedInstanceState)
       {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

           btnreset = (Button)findViewById(R.id.button2);
           btnreset.setOnClickListener(new OnClickListener()
           {
                 public void onClick(View arg0) {
                 count=0;
                 a=10;
                 View layoutView = findViewById(R.id.mylayout);
                 layoutView.setBackgroundColor(Color.rgb(200-a,50+a*a,25+a));
                 txtCount.setText(String.valueOf(count) );

            }
        });


           txtCount = (TextView)findViewById(R.id.textView1);
           txtCount.setText(String.valueOf(count));
           btnCount = (Button)findViewById(R.id.button1);
           a=10;
           View layoutView = findViewById(R.id.mylayout);
           layoutView.setBackgroundColor(Color.rgb(200-a,50+a*a,25+a));

        btnCount.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0)
            {
                     count++;
                     txtCount.setText(Integer.toString(count) );
					 Random rnd = new Random();
					 a=rnd.nextInt(6)+min;
					 View layoutView = findViewById(R.id.mylayout);
					 layoutView.setBackgroundColor(Color.rgb(200-a,50+a*a,25+a));
            }
        });
    }
    // saving the state
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        String c = count+" "+a;
		outState.putString(saved,c);
    }

    // restoring the saved state
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
		s =savedInstanceState.getString(saved);
		String[] g=s.split(" ");
		count=Integer.parseInt(g[0]);
        a=Integer.parseInt(g[1]);
        View layoutView = findViewById(R.id.mylayout);
        layoutView.setBackgroundColor(Color.rgb(200-a,50+a*a,25+a));
        txtCount.setText(String.valueOf(count));
    }

 }
