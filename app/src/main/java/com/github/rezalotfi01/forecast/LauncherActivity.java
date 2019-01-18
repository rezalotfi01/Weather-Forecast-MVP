package com.github.rezalotfi01.forecast;

import android.app.Activity;
import android.content.Intent;

import com.github.rezalotfi01.forecast.cityweathermain.CityWeatherMainActivity;

public class LauncherActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart();
        setVisible(true);
        Intent intent = new Intent(this, CityWeatherMainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
