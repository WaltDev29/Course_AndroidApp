package kr.ac.kopo.a13_reservation;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button btnStart, btnDone;
    RadioGroup rg;
    RadioButton rbDate, rbTime;
    CalendarView calView;
    TimePicker timePicker;
    TextView textResult;
    int  selectedDay, selectedMonth, selectedYear;
    int selectedHour, selectedMinute;

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

        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnDone = findViewById(R.id.btnDone);

        rg = findViewById(R.id.rg);
        rbDate = findViewById(R.id.rbDate);
        rbTime = findViewById(R.id.rbTime);

        calView = findViewById(R.id.calView);
        timePicker = findViewById(R.id.timePicker);

        textResult = findViewById(R.id.textResult);

        btnStart.setOnClickListener(btnStartListener);
        btnDone.setOnClickListener(btnDoneListener);
        rg.setOnCheckedChangeListener(rgListener);
        calView.setOnDateChangeListener(calListener);

    }

    View.OnClickListener btnStartListener = v -> {
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
        chronometer.setTextColor(Color.RED);
    };

    View.OnClickListener btnDoneListener = v -> {
        chronometer.stop();
        chronometer.setTextColor(Color.BLUE);
        
        selectedHour = timePicker.getHour();
        selectedMinute = timePicker.getMinute();

        String result = selectedYear +  "년 " + selectedMonth + "월 " + selectedDay + "일" + selectedHour +"시 " + selectedMinute + "분에 예약 완료";
        textResult.setText(result);
    };

    RadioGroup.OnCheckedChangeListener rgListener = (v, checkedId) -> {
        calView.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
        if (checkedId == R.id.rbDate) calView.setVisibility(View.VISIBLE);
        else if (checkedId == R.id.rbTime) timePicker.setVisibility(View.VISIBLE);
    };

    CalendarView.OnDateChangeListener calListener = (v,year,month,day) -> {
        selectedDay = day;
        selectedMonth = month+1;
        selectedYear = year;
    };
}