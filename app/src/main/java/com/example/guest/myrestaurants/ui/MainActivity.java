
package com.example.guest.myrestaurants.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.myrestaurants.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mFindRestaurantsButton;
    private EditText mLocationEditText;
    private TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);

        Typeface font1 = Typeface.createFromAsset(getAssets(), "font1.ttf");
        mAppNameTextView.setTypeface(font1);

        mLocationEditText = (EditText) findViewById(R.id.locationEditText);
        mLocationEditText.setTypeface(font1);

        mFindRestaurantsButton = (Button) findViewById(R.id.findRestaurantButton);
        mFindRestaurantsButton.setTypeface(font1);

        mFindRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String location = mLocationEditText.getText().toString();
        if (location.equals("")) {
            Toast toast = Toast.makeText(MainActivity.this, "Please input a location", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 500);
            toast.show();
        } else {
            Intent intent = new Intent(MainActivity.this, RestaurantsActivity.class);
            intent.putExtra("location", location);
            mLocationEditText.setText("");
            startActivity(intent);
        }
    }
}
