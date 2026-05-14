package kr.ac.waltdev29.a16_tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView((R.layout.activity_main));
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpecCat = tabHost.newTabSpec("Cat").setIndicator("Cat");
        tabSpecCat.setContent(R.id.img_cat);
        tabHost.addTab(tabSpecCat);

        TabHost.TabSpec tabSpecFrog = tabHost.newTabSpec("Frog").setIndicator("Frog");
        tabSpecFrog.setContent(R.id.img_frog);
        tabHost.addTab(tabSpecFrog);

        TabHost.TabSpec tabSpecGoat = tabHost.newTabSpec("Goat").setIndicator("Goat");
        tabSpecGoat.setContent(R.id.img_goat);
        tabHost.addTab(tabSpecGoat);

        TabHost.TabSpec tabSpecDonkey = tabHost.newTabSpec("Donkey").setIndicator("Donkey");
        tabSpecDonkey.setContent(R.id.img_donkey);
        tabHost.addTab(tabSpecDonkey);
    }
}