package kr.ac.kopo.a09_layout;

import android.graphics.Color;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linear = new LinearLayout(this);   // 뷰 생성
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(   // 레이아웃 설정 생성
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        linear.setOrientation(LinearLayout.VERTICAL);   // 정렬 설정
        linear.setBackgroundColor(Color.CYAN);  // 배경색 설정
        setContentView(linear, params); // 뷰 표시 설정

        Button btn = new Button(this);  // 버튼 생성
        btn.setText("Java 코드로 생성한 버튼");
        btn.setBackgroundColor(Color.MAGENTA);
        linear.addView(btn);    // Linear 레이아웃 View에 버튼 추가

        btn.setOnClickListener(v -> {
            Toast.makeText(this, "버튼 클릭됨!", Toast.LENGTH_SHORT).show();
        });
    }
}