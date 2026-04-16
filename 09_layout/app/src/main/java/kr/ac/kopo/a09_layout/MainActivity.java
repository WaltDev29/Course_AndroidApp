package kr.ac.kopo.a09_layout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearRed, linearGreen;
    Button btnRed, btnGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main11);

        linearRed = findViewById(R.id.linearRed);
        linearGreen = findViewById(R.id.linearGreen);

        btnRed = findViewById(R.id.btnRed);
        btnGreen = findViewById(R.id.btnGreen);

//        LinearLayout linear = new LinearLayout(this);   // 뷰 생성
//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(   // 레이아웃 설정 생성
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//        );
//
//        linear.setOrientation(LinearLayout.VERTICAL);   // 정렬 설정
//        linear.setBackgroundColor(Color.CYAN);  // 배경색 설정
//        setContentView(linear, params); // 뷰 표시 설정
//
//        Button btn = new Button(this);  // 버튼 생성
//        btn.setText("Java 코드로 생성한 버튼");
//        btn.setBackgroundColor(Color.MAGENTA);
//        linear.addView(btn);    // Linear 레이아웃 View에 버튼 추가
//
//        btn.setOnClickListener(v -> {
//            Toast.makeText(this, "버튼 클릭됨!", Toast.LENGTH_SHORT).show();
//        });

        btnRed.setOnClickListener(btnListener);
        btnGreen.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = v -> {
        Button btn = (Button) v;

        if (btn.getId() == btnRed.getId()) {
            linearRed.setVisibility(View.VISIBLE);
            linearGreen.setVisibility(View.INVISIBLE);
        }
        else {
            linearRed.setVisibility(View.INVISIBLE);
            linearGreen.setVisibility(View.VISIBLE);
        }
    };
}