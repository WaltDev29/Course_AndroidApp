package kr.ac.kopo.a2026_dir_2_3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // 버튼을 관리하기 위한 List 선언
    ArrayList<Button> btn_list = new ArrayList<>();

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

//        버튼 List에 요소 넣기
        btn_list.add(findViewById(R.id.btn_web));
        btn_list.add(findViewById(R.id.btn_call));
        btn_list.add(findViewById(R.id.btn_gallery));
        btn_list.add(findViewById(R.id.btn_close));

//         리스너 등록
        for (Button btn : btn_list) {
            btn.setOnClickListener(btnListener);
        }

    }

    // 클릭 이벤트 정의
    View.OnClickListener btnListener = v -> {
        // 이벤트 위젯 다운 캐스팅
        Button btn = (Button)v;
        // Intent 앱에게 작업을 요청하는 메시지 객체
        Intent intent = null;

        // URI : 자원의 위치를 나타내는 문자열 형식의 주소
        if (btn == btn_list.get(0)) intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/"));
        else if (btn == btn_list.get(1)) intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/010-1234-5678"));
        else if (btn == btn_list.get(2)) intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
        else if (btn == btn_list.get(3)) finish();

        startActivity(intent);
    };
}