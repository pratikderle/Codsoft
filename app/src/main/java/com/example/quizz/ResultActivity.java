package com.example.quizz;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultTextView = findViewById(R.id.resultTextView);
        progressBar = findViewById(R.id.progressBar1);

        int score = getIntent().getIntExtra("score", 0);
        progressBar.setProgress(score);
        resultTextView.setText("Your score: " + score+"/10");
    }
}
