package app_utils.ktteam.src.UI.Homes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app_utils.ktteam.src.R;

public class NavigationMain extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPaperMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        bottomNavigationView = findViewById(R.id.bottomNavigationBar);
        viewPaperMain = findViewById(R.id.viewPaperMain);

        // Set sự kiện
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Toast.makeText(NavigationMain.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        viewPaperMain.setCurrentItem(0);
                        break;
                    case R.id.history:
                        Toast.makeText(NavigationMain.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        viewPaperMain.setCurrentItem(1);
                        break;
                    case R.id.profile:
                        Toast.makeText(NavigationMain.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        viewPaperMain.setCurrentItem(2);
                        break;


                }
                item.setChecked(true);
                return false;
            }
        });

        //set fragment tương ứng với item navigation checked
        setUpViewPaper();
    }

    private void setUpViewPaper()
    {
        ViewPaperAdapter viewPaperAdapter = new ViewPaperAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.viewPaperMain.setAdapter(viewPaperAdapter);

//        this.viewPaperMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                switch (position)
//                {
//                    case 0:
//                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
//                        break;
//                    case 1:
//                        bottomNavigationView.getMenu().findItem(R.id.history).setChecked(true);
//                        break;
//                    case 2:
//                        bottomNavigationView.getMenu().findItem(R.id.profile).setChecked(true);
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }


}