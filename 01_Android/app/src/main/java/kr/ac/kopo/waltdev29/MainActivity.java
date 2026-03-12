package kr.ac.kopo.waltdev29;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);  // 작성한 activity_main.xml를 이 파일에 붙임
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ============ 설정한 id값으로 위젯 연결 ============
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);

        // ============ 이벤트 리스너 연결 ============
        btn.setOnClickListener(btnListener);
        rg.setOnCheckedChangeListener(rgListener);
    }



    // ============ 이벤트 리스너 정의 ============
    // 람다식으로 해봄. (인터페이스에 메서드가 하나만 있을 경우 람다식으로 줄일 수 있음)
    View.OnClickListener btnListener = v -> {
        Toast toast = Toast.makeText(MainActivity.this, "버튼이 클릭되었습니다.", Toast.LENGTH_SHORT);
        toast.show();
    };

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
            String text = "";
            if (checkedId == R.id.rb_rice) text = "밥";
            else if (checkedId == R.id.rb_bread) text = "빵";
            else if (checkedId == R.id.rb_noodle) text = "면";

            Toast toast = Toast.makeText(MainActivity.this, text + " 체크됨", Toast.LENGTH_SHORT);
            toast.show();
        }
    };

}