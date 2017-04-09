package com.markojerkic.viewswitch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    float ratingBarResult;
    TextView textView;
    Button switchButton;
    ViewSwitcher viewSwitcher;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchButton = (Button) findViewById(R.id.button);
        viewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        textView = (TextView) findViewById(R.id.textView);

        ratingBar.setMax(10);
        ratingBar.setNumStars(10);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
               setRatingBarResult(v);  //calling the method setRatingBarResult() to set the value
            }
        });

        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewSwitcher.getCurrentView() == ratingBar) {
                    viewSwitcher.showNext();//if the current view is the RatingBar, then show
                                            //the next one, which is the TextView
                    textView.setText(ratingBarResult + " / 10.0");

                }
                else {
                    viewSwitcher.showPrevious();
                }
            }
        });
    }
    public void setRatingBarResult(float l) {
        ratingBarResult = l;
    }
}
