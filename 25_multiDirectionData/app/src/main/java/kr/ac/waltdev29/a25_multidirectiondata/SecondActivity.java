package kr.ac.waltdev29.a25_multidirectiondata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    TextView tvQuestion;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvQuestion = findViewById(R.id.tvQuestion);

        Intent inIntent = getIntent();
        int num1 = inIntent.getIntExtra("num1", 0);
        int num2 = inIntent.getIntExtra("num2", 0);
        int oper = inIntent.getIntExtra("oper", 0);
        int result;
        String operStr;
        if (oper == R.id.rbSum) {
            result = num1 + num2;
            operStr = "+";
        }
        else if (oper == R.id.rbMinus) {
            result = num1 - num2;
            operStr = "-";
        }
        else if (oper == R.id.rbMulti) {
            result = num1 * num2;
            operStr = "*";
        }
        else {
            if (num2 == 0) result = 0;
            else result = num1 / num2;
            operStr = "/";
        }

        final int hapValue = result;

        String question = num1 + " " + operStr + " " + num2 + " = ?";
        tvQuestion.setText(question);

        btnResult = findViewById(R.id.btnResult);

        btnResult.setOnClickListener(v -> {
            Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
            outIntent.putExtra("hap", hapValue);
            setResult(RESULT_OK, outIntent);
            finish();
        });
    }
}