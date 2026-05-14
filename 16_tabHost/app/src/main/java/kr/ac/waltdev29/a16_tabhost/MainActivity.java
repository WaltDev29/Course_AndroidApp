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

        TabHost.TabSpec tabSpecSong = tabHost.newTabSpec("Song").setIndicator("음악");
        tabSpecSong.setContent(R.id.tabSong);
        tabHost.addTab(tabSpecSong);

        TabHost.TabSpec tabSpecArtist = tabHost.newTabSpec("Artist").setIndicator("가수");
        tabSpecArtist.setContent(R.id.tabArtist);
        tabHost.addTab(tabSpecArtist);

        TabHost.TabSpec tabSpecAlbum = tabHost.newTabSpec("Album").setIndicator("앨범");
        tabSpecAlbum.setContent(R.id.tabAlbum);
        tabHost.addTab(tabSpecAlbum);
    }
}