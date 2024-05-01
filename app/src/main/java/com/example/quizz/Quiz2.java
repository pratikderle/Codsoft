package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz2 extends AppCompatActivity {

    TextView questionTextView;
    Button option1Button, option2Button, option3Button,submit;
    RadioGroup optionGroup;
    String getoption;

    int currentQuestion = 0;
    int score = 0;
    private int currentQuestionIndex = 0;
    private Question[] questions = {
            new Question("1. The US and which country agreed on new immigration policies to prevent illegal border crossing?", "Canada", "Mexico", "Cuba", "Mexico"),
            new Question("2. Which space agency launched the ‘Meteosat-12’ weather satellite?", "ISRO", "NASA", "ESA", "ESA"),
            new Question("3. Which country launched the ‘Spitzer Space Telescope?", "India", "Russia", "USA", "USA"),
            new Question("4. What is Hvaldimir, which is being suspected of being a Russian spy?", "Robot", "Whale", "Eagle", "Eagle"),
            new Question("5. Which country passed the Bill 490, which restricts the new recognition of ancestral land of indigenous people?", "USA", "Russia", "Brazil", "Brazil"),
            new Question("6. Which country signed a deal to export hydropower to Bangladesh through Indian territory?", "Sri Lanka", "Afghanistan", "Nepal", "Nepal"),
            new Question("7. Which neighbouring country recorded an annual inflation rate of 37.97% in May 2023?", "Pakistan", "Afghanistan", "Nepal", "Pakistan"),
            new Question("8. Which country is set to deploy a satellite constellation called “Silent Barker”?", "Russia", "Ukraine", "USA", "USA       "),
            new Question("9. Which country introduced a category-based selection for Express Entry immigration management program?", "USA", "Canada", "Australia", "Canada"),
            new Question("10. Which country has announced for investing more than 100 million US Dollars in the Caribbean region?", "India", "Japan", "USA", "USA"),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);

        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        submit = findViewById(R.id.submit);
        optionGroup = findViewById(R.id.optionGroup);

        displayQuestion();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(getoption);
                optionGroup.clearCheck();
            }
        });
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getoption=option1Button.getText().toString();
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getoption=option2Button.getText().toString();
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getoption=option3Button.getText().toString();
            }
        });
    }
    private void displayQuestion() {
        Question currentQuestion = questions[currentQuestionIndex];
        questionTextView.setText(currentQuestion.getQuestion());
        option1Button.setText(currentQuestion.getOption1());
        option2Button.setText(currentQuestion.getOption2());
        option3Button.setText(currentQuestion.getOption3());
    }

    private void checkAnswer(String selectedOption) {
        Question currentQuestion = questions[currentQuestionIndex];
        if (selectedOption.equals(currentQuestion.getCorrectAnswer())) {
            score++;
        }
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            displayQuestion();
        } else {
            Intent intent = new Intent(Quiz2.this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }
}

