package kr.ac.kopo.a10_simple_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    List<Button> btnNums = new ArrayList<>();
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        btnNums.addAll(List.of(
                findViewById(R.id.btnNum0),
                findViewById(R.id.btnNum1),
                findViewById(R.id.btnNum2),
                findViewById(R.id.btnNum3),
                findViewById(R.id.btnNum4),
                findViewById(R.id.btnNum5),
                findViewById(R.id.btnNum6),
                findViewById(R.id.btnNum7),
                findViewById(R.id.btnNum8),
                findViewById(R.id.btnNum9)
        ));

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        textResult = findViewById(R.id.textResult);

        btnAdd.setOnClickListener(calcOnClickListener);
        btnSub.setOnClickListener(calcOnClickListener);
        btnMul.setOnClickListener(calcOnClickListener);
        btnDiv.setOnClickListener(calcOnClickListener);

        for (Button btn : btnNums) btn.setOnClickListener(inputNum);
    }

    View.OnClickListener calcOnClickListener = v -> {
        Button btn = (Button) v;

        String str1 = edit1.getText().toString();
        String str2 = edit2.getText().toString();

        if (str1.isEmpty() || str2.isEmpty()) {
            Toast.makeText(this, "값을 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        int num1 = Integer.parseInt(edit1.getText().toString());
        int num2 = Integer.parseInt(edit2.getText().toString());

        int result = 0;
        if (btn.getId() == R.id.btnAdd) result = num1 + num2;
        else if (btn.getId() == R.id.btnSub) result = num1 - num2;
        else if (btn.getId() == R.id.btnMul) result = num1 * num2;
        else if (btn.getId() == R.id.btnDiv) {
            if (num2 == 0) {
                Toast.makeText(this, "0으로 나눌 수 없습니다", Toast.LENGTH_SHORT).show();
                return;
            }
            result = num1 / num2;
        }

        textResult.setText("계산 결과 : " + result);
    };

    View.OnClickListener inputNum = v -> {
        Button btn = (Button) v;
        EditText target;
        if (edit1.isFocused()) target = edit1;
        else if (edit2.isFocused()) target = edit2;
        else {
            Toast.makeText(this, "입력창을 선택하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        String btnNum = btn.getText().toString();
        int num = Integer.parseInt(target.getText().toString() + btnNum);

        target.setText(String.valueOf(num));
    };
}