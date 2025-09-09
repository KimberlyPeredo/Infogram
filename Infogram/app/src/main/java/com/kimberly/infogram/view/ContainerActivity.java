package com.kimberly.infogram.view;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kimberly.infogram.R;
import com.kimberly.infogram.view.fragment.HomeFragment;
import com.kimberly.infogram.view.fragment.ProfileFragment;
import com.kimberly.infogram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.botton_navegation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new  BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment =null;

                        if (R.id.search== item.getItemId()) {
                            selectedFragment = new SearchFragment();
                        }
                        else if (R.id.home== item.getItemId()) {
                            selectedFragment = new HomeFragment();
                        }
                        else if (R.id.profile== item.getItemId()){
                            selectedFragment= new ProfileFragment();

                        }
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_frame, selectedFragment)
                                .commit();

                        return true;
                    }
                }
        );
    }
}