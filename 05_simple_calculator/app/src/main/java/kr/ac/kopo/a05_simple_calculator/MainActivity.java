// 2026.03.26
// 간단한 계산기 만들기

package kr.ac.kopo.a05_simple_calculator;

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

    EditText et_num1, et_num2;
    TextView text_result;

    List<Button> btn_list = new ArrayList<>();

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

        et_num1 = findViewById(R.id.et_num1);
        et_num2 = findViewById(R.id.et_num2);
        text_result = findViewById(R.id.text_result);

        btn_list.add(findViewById(R.id.btn_plus));
        btn_list.add(findViewById(R.id.btn_minus));
        btn_list.add(findViewById(R.id.btn_multiply));
        btn_list.add(findViewById(R.id.btn_devide));
        btn_list.add(findViewById(R.id.btn_remain));

        for (Button btn : btn_list) btn.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = v -> {
        float num1, num2;
        float result = 0;

        try {
            num1 = Float.parseFloat(et_num1.getText().toString());
            num2 = Float.parseFloat(et_num2.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "숫자를 입력해주세요!", Toast.LENGTH_SHORT).show();
            return;
        }

        int btn = v.getId();

        if (btn == R.id.btn_plus) result = num1 + num2;
        else if (btn == R.id.btn_minus) result = num1 - num2;
        else if (btn == R.id.btn_multiply) result = num1 * num2;
        else {
            if (num2 == 0) {
                Toast.makeText(this, "0으로 나눌 수 없습니다!", Toast.LENGTH_SHORT).show();
                return;
            }
            else if (btn == R.id.btn_devide) result = num1 / num2;
            else if (btn == R.id.btn_remain) result = num1 % num2;
        }
        text_result.setText(String.format("계산 결과 : %.3f", result));
    };
}