package kr.ac.waltdev29.a26_implicit_intent;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button[] btnList;

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

        btnList = new Button[]{
                findViewById(R.id.btnDial),
                findViewById(R.id.btnWeb),
                findViewById(R.id.btnGoogle),
                findViewById(R.id.btnSearch),
                findViewById(R.id.btnSms),
                findViewById(R.id.btnPhoto),
                findViewById(R.id.btnFinish)
        };

        for (Button btn : btnList) {
            btn.setOnClickListener(onClickListener);
        }

        Log.i("로그확인", "onCreate() Called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("로그확인", "onStart() Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("로그확인", "onResume() Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("로그확인", "onPause() Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("로그확인", "onStop() Called");
    }

    // 액티비티가 다른 화면에 가려졌다가 다시 나타날 때
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("로그확인", "onRestart() Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("로그확인", "onDestroy() Called");
    }

    View.OnClickListener onClickListener = v -> {
        Intent intent = null;
        Uri uri;
        if (v.getId() == R.id.btnDial) {
            uri = Uri.parse("tel:01012345678");
            intent = new Intent(Intent.ACTION_DIAL, uri);
        } else if (v.getId() == R.id.btnWeb) {
            uri = Uri.parse("https://www.naver.com");
            intent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (v.getId() == R.id.btnGoogle) {
            uri = Uri.parse("https://maps.google.co.kr/maps?q=37.5225822,126.9795332&z=15");
            intent = new Intent(Intent.ACTION_VIEW, uri);
        } else if (v.getId() == R.id.btnSearch) {
            intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "국립중앙박물관");
        } else if (v.getId() == R.id.btnSms) {
            intent = new Intent(Intent.ACTION_SENDTO);
            intent.putExtra("sms_body", "안녕하세요!");
            uri = Uri.parse("smsto:01012345678");
            intent.setData(uri);
        } else if (v.getId() == R.id.btnPhoto) {
            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        }

        if (v.getId() == R.id.btnFinish) {
            finish();
        } else startActivity(intent);
    };
}