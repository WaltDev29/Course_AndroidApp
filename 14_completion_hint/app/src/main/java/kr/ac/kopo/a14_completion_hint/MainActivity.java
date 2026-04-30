package kr.ac.kopo.a14_completion_hint;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
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

        // 객체 선언
        AutoCompleteTextView auto = findViewById(R.id.autoCompleteTextView);
        MultiAutoCompleteTextView multi = findViewById(R.id.multiAutoCompleteTextView);

        // 자동 완성 텍스트 배열
        String[] items = { "CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미", "Friends",
                "Fringe", "Lost" };

        // 어댑터 선언
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);

        // 어댑터 설정
        auto.setAdapter(adapter);

        // 토크나이저 선언 및 설정
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);

        // 어댑터 설정
        multi.setAdapter(adapter);
    }
}