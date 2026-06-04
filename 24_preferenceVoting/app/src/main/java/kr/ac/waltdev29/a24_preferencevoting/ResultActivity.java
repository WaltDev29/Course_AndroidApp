package kr.ac.waltdev29.a24_preferencevoting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] charNameArr = intent.getStringArrayExtra("charNameArr");

        int[] textIdArr = {R.id.tvChar1, R.id.tvChar2, R.id.tvChar3, R.id.tvChar4, R.id.tvChar5, R.id.tvChar6, R.id.tvChar7, R.id.tvChar8, R.id.tvChar9};
        int[] ratingIdArr = {R.id.ratingChar1, R.id.ratingChar2, R.id.ratingChar3, R.id.ratingChar4, R.id.ratingChar5, R.id.ratingChar6, R.id.ratingChar7, R.id.ratingChar8, R.id.ratingChar9};

        for (int i = 0; i < charNameArr.length; i++) {
            ((TextView) findViewById(textIdArr[i])).setText(charNameArr[i]);
            ((RatingBar) findViewById(ratingIdArr[i])).setRating(voteCount[i]);
        }

        findViewById(R.id.btnBack).setOnClickListener(v -> {
            finish();
        });
    }
}