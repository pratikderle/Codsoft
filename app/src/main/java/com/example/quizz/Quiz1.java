package com.example.quizz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Quiz1 extends AppCompatActivity {

    TextView questionTextView;
    RadioGroup optionGroup;
    Button option1Button, option2Button, option3Button, submit;
    String getoption;
    int currentQuestion = 0;
    int score = 0;
    private int currentQuestionIndex = 0;
    private Question[] questions = {
            new Question("1. What is the name of the weak zone of the earth’s crust?","Seismic","Cosmic","Formic","Seismic"),
            new Question("2. Where was India’s first national Museum opened?", "Delhi", "Hyderabad", "Mumbai", "Mumbai"),
            new Question("3. In 2019, Which popular singer was awarded the Bharat Ratna award?", "Lata Mangeshkar", "Asha Bhosle", "Bhupen Hazarika", " Bhupen Hazarika"),
            new Question("4. The world’s nation 5G mobile network was launched by which country?", "Japan", "South Korea", "Asia", "South Korea"),
            new Question("5. The green planet in the solar system is?", "Mars", "Uranus", "Earth", "Uranus"),
            new Question("6. The father of Indian missile technology is _________________?", "Dr Homi Bhabha", "Dr Chidambaram", "Dr A.P.J. Abdul Kalam", "Dr A.P.J. Abdul Kalam"),
            new Question("7. The largest public sector undertaking in the country is?", "Railways", "Airways", "Roadways", "Railways"),
            new Question("8. At which place on earth are there days & nights of equal length always?", "Equator", "Poles", "Nowhere", "Equator"),
            new Question("9. In 2017, Who was appointed as the new Brand Ambassador for Swachh Bharat Mission?", "Kangana Ranaut", "Anushka Sharma", "Shilpa Shetty", "Shilpa Shetty"),
            new Question("10. The study of Heavenly bodies is Known as _________?", "Astrophysics", "Astronomy", "Astrology", "Astronomy"),

    };
    @SuppressLint("MissingInflatedId")
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
            Intent intent = new Intent(Quiz1.this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }
}

