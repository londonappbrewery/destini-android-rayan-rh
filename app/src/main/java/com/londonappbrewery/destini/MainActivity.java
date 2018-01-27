package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTop;
    Button mBottom;

    Map<Tuple, Integer> story = new HashMap<Tuple, Integer>();

    int[][] resources = {
            {0,0,0},
            {R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2},
            {R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2},
            {R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2}
    };

    int[] endings = {
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End
    };

    int currState = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        story.put(new Tuple(1,true),3);
        story.put(new Tuple(1,false),2);

        story.put(new Tuple(2,true), 3);
        story.put(new Tuple(2,false), 4);

        story.put(new Tuple(3,true), 6);
        story.put(new Tuple(3,false), 5);



        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTop = (Button) findViewById(R.id.buttonTop);
        mBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateState(true);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateState(false);
            }
        });

    }

    public void updateState(boolean choice) {
        Log.d("Mess", "Calling it on state " + currState + " choice is " + choice);
        int nextState = story.get(new Tuple(currState,choice));
        if(nextState > 3) {
            mTop.setVisibility(View.GONE);
            mBottom.setVisibility(View.GONE);
            mStoryTextView.setText( endings[nextState-4]);
        }
        else {
            mStoryTextView.setText(resources[nextState][0]);
            mTop.setText(resources[nextState][1]);
            mBottom.setText(resources[nextState][2]);
        }
        currState = nextState;

    }
}
