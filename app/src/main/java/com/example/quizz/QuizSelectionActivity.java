package com.example.quizz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizSelectionActivity extends AppCompatActivity {

    ListView listView;
    String[] quizList = {"Mathematics Quizz", "General Awareness", "Intrnational Current Affairs", "Quiz 4", "Quiz 5", "Quiz 6", "Quiz 7", "Quiz 8", "Quiz 9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_selection);

        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, quizList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position==0){
                    Intent intent = new Intent(QuizSelectionActivity.this, QuizQuestionsActivity.class);
                    intent.putExtra("quizNumber", position + 1);
                    startActivity(intent);
                } else if (position==1) {
                    Intent intent = new Intent(QuizSelectionActivity.this, Quiz1.class);
                    intent.putExtra("quizNumber", position + 1);
                    startActivity(intent);
                } else if (position==2) {
                    Intent intent = new Intent(QuizSelectionActivity.this, Quiz2.class);
                    intent.putExtra("quizNumber", position + 1);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(getApplicationContext(), com.example.quizz.Unavailable.class);
                    startActivity(intent);
                }

            }
        });
    }
}
