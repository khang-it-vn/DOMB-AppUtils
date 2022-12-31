package app_utils.ktteam.src.UI.Homes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app_utils.ktteam.src.R;

public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Ánh xạ Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);

        // Set sự kiện
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(Home.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.history:
                        Toast.makeText(Home.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.profile:
                        Toast.makeText(Home.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;


                }
                return false;
            }
        });
    }
}