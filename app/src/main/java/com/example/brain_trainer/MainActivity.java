package com.example.brain_trainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Integer> answer = new ArrayList<Integer>();
    Button gobutton;
    int locationofcorrectanswer;
    TextView resulttextview;
    int score =0;
    int numberofquetions=0;
    TextView scoretextview;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumtextview;
    TextView timetextview;
    Button playagainbutton;
    ConstraintLayout gamelayout;

    public void playagain(View view)
    {
        score=0;
        numberofquetions=0;
        timetextview.setText("30s");
        newquestion();
        scoretextview.setText(Integer.toString(score)+"/"+Integer.toString(numberofquetions));
        playagainbutton.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100,1000)
        {

            @Override
            public void onTick(long l)
            {
                timetextview.setText(String.valueOf(l/1000)+"s");
            }

            @Override
            public void onFinish()
            {
                resulttextview.setText("Done!");
                playagainbutton.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void chooseanswer(View view)
    {
      if(Integer.toString(locationofcorrectanswer).equals(view.getTag().toString()))
      {
         resulttextview.setText("Correct");
         score++;
      }
      else
          {
              resulttextview.setText("wrong");
          }
      numberofquetions++;
      scoretextview.setText(Integer.toString(score)+"/"+Integer.toString(numberofquetions));
      newquestion();
    }

    public void newquestion()
    {
        Random rand = new Random();

        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        sumtextview.setText(Integer.toString(a)+" + "+Integer.toString(b));
        locationofcorrectanswer = rand.nextInt(4);
        answer.clear();
        for(int i=0;i<4;i++)
        {
            if(i==locationofcorrectanswer)
                answer.add(a+b);
            else
            {
                int wronganswer = rand.nextInt(41);
                while(wronganswer==(a+b))
                {
                    wronganswer = rand.nextInt(41);
                }
                answer.add(wronganswer);
            }
        }

        button0.setText(Integer.toString(answer.get(0)));
        button1.setText(Integer.toString(answer.get(1)));
        button2.setText(Integer.toString(answer.get(2)));
        button3.setText(Integer.toString(answer.get(3)));
    }

    public void start(View view)
    {
        gobutton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);
        playagain(timetextview);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gobutton = findViewById(R.id.gobutton);
        sumtextview= findViewById(R.id.sumtextview);
         button0 = findViewById(R.id.button0);
         button1 = findViewById(R.id.button1);
         button2 = findViewById(R.id.button2);
         button3 = findViewById(R.id.button3);
        resulttextview = findViewById(R.id.resulttextview);
        scoretextview = findViewById(R.id.scoretextview);
        timetextview=findViewById(R.id.timetextview);
        playagainbutton=findViewById(R.id.playagainbutton);
        gamelayout = findViewById(R.id.gamelayout);

        gamelayout.setVisibility(View.INVISIBLE);
        gobutton.setVisibility(View.VISIBLE);





    }
}
