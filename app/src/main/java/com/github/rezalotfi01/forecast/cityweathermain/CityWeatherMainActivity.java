package com.github.rezalotfi01.forecast.cityweathermain;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.rezalotfi01.forecast.R;
import com.github.rezalotfi01.forecast.cityweatherfavorite.view.CityWeatherFavoriteFragment;
import com.github.rezalotfi01.forecast.cityweathersearch.view.CityWeatherSearchFragment;
import com.github.rezalotfi01.forecast.common.BaseToolbarActivity;

import butterknife.BindView;


public class CityWeatherMainActivity extends BaseToolbarActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String BOTTOM_BAR_TAG = "bottom_bar_tag";

    @BindView(R.id.rootCoordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_citiyweathermain;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // Set default selected item
        selectFragmentForMenuItemId(R.id.action_search);
    }

    @Override
    protected void onDestroy() {
        bottomNavigationView.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        selectFragmentForMenuItemId(item.getItemId());
        return true;
    }

    public void selectFragmentForMenuItemId(@IdRes int itemId) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment;

        switch (itemId) {

            case R.id.action_search:
                fragment = CityWeatherSearchFragment.newInstance();
                break;
            case R.id.action_favorites:
                fragment = CityWeatherFavoriteFragment.newInstance();
                break;
            case R.id.action_nearby:
                // TODO: Implement this feature
                fragment = CityWeatherSearchFragment.newInstance();
                Toast.makeText(this, "This feature is not yet implemented", Toast.LENGTH_SHORT).show();
                break;
            default:
                fragment = CityWeatherSearchFragment.newInstance();
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.bottom_bar_fragment_container,
                fragment, BOTTOM_BAR_TAG).commit();
    }
}