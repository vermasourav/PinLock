package com.verma.mobile.android.pinlock;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.verma.mobile.android.lib.pin.IndicatorDots;
import com.verma.mobile.android.lib.pin.PinLockListener;
import com.verma.mobile.android.lib.pin.PinLockView;

public class LoginActivity extends AppCompatActivity {
//http://www.devexchanges.info/2015/11/android-make-lock-screen-in-application.html
    private PinLockView mPinLockView;
    private IndicatorDots mIndicatorDots;
    private final static String TAG = LoginActivity.class.getSimpleName();
    private final static String TRUE_CODE = "123456";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mPinLockView = (PinLockView) findViewById(R.id.pin_lock_view);
        mIndicatorDots = (IndicatorDots) findViewById(R.id.indicator_dots);


        //attach lock view with dot indicator
        mPinLockView.attachIndicatorDots(mIndicatorDots);
        mPinLockView.enableLayoutShuffling();

        //set lock code length
        mPinLockView.setPinLength(20);
        
       Drawable drawable= this.getResources().getDrawable(R.drawable.custom_button_border);
       mPinLockView.setButtonBackgroundDrawable(drawable);

        //set listener for lock code change
        mPinLockView.setPinLockListener(new PinLockListener() {
            @Override
            public void onComplete(String pin) {
                Log.d(TAG, "lock code: " + pin);

                //User input true code
                if (pin.equals(TRUE_CODE)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    intent.putExtra("code", pin);
                    startActivity(intent);
                 } else {
                    Toast.makeText(LoginActivity.this, "Failed code, try again!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onEmpty() {
                Log.d(TAG, "lock code is empty!");
            }

            @Override
            public void onPinChange(int pinLength, String intermediatePin) {
                Log.d(TAG, "Pin changed, new length " + pinLength + " with intermediate pin " + intermediatePin);

            }

            @Override
            public void onPinButtonClick(final View pView) {
                pView.getAnimation();
                Log.d(TAG, "Pin changed, new length " );
                if(pView==null){
                    return;
                }
                Animation startFadeOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                pView.startAnimation(startFadeOutAnimation);

            }
        });
    }

}
