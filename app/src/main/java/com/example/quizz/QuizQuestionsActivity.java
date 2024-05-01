package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizQuestionsActivity extends AppCompatActivity {

    TextView questionTextView;
    Button option1Button, option2Button, option3Button,submit;
    RadioGroup optionGroup;
    String getoption;
    int currentQuestion = 0;
    int score = 0;
    private int currentQuestionIndex = 0;
    private Question[] questions = {
            new Question("1. If the price of a book is increased by 20%, by what percentage should the sales price be decreased to bring it back to the original price?", "16%", "20%", "25%", "16%"),
            new Question("2. If 15% of a number is 45, what is 30% of that number?", "90", "60", "30", "90"),
            new Question("3. A TV was originally priced at $800. It is now being sold at a discount of 20%. What is the discounted price?","720","640","860","640"),
            new Question("4.  The average age of a family of four is 28 years. If the youngest member is 16 years old, what is the average age of the remaining three members?","30","34","32","32"),
            new Question("5. If the ratio of boys to girls in a classroom is 4:5, and there are 36 boys, how many girls are there in the classroom?","20", "25","45","45"),
            new Question("6. The ratio of the lengths of two rectangles is 3:4. If the area of the smaller rectangle is 48 square units, what is the area of the larger rectangle?","64 square units", "72 square units","96 square units","96 square units"),
            new Question("7. If it takes 6 workers 8 hours to complete a project, how many hours would it take for 8 workers to complete the same project?","4 hours", "6 hours","8 hours" ," 6 hours"),
            new Question("8. A shopkeeper purchased a shirt for $40 and sold it for $60. What is the profit percentage?","20%", "33.33%","50%","50%"),
            new Question("9. If a bookshop sells a book at a loss of 10%, and the cost price of the book is $50, what is the selling price of the book?","$45","$50","$55","45%"),
            new Question("10. What is the HCF of 36 and 48?","6","12","18","12"),
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
            Intent intent = new Intent(QuizQuestionsActivity.this, ResultActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }
}

