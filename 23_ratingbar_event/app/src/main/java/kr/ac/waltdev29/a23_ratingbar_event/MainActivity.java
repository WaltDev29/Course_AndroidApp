package kr.ac.waltdev29.a23_ratingbar_event;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RatingBar rating1, rating2, rating3;
    Button btnInc, btnDec;

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

        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);

        btnInc = findViewById(R.id.btnInc);
        btnDec = findViewById(R.id.btnDec);

        btnInc.setOnClickListener(v -> {
            rating1.setRating(rating1.getRating() + rating1.getStepSize());
            rating2.setRating(rating2.getRating() + rating2.getStepSize());
            rating3.setRating(rating3.getRating() + rating3.getStepSize());
        });

        btnDec.setOnClickListener(v -> {
            rating1.setRating(rating1.getRating() - rating1.getStepSize());
            rating2.setRating(rating2.getRating() - rating2.getStepSize());
            rating3.setRating(rating3.getRating() - rating3.getStepSize());
        });
    }
}