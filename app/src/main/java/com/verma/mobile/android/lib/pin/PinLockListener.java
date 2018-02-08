package com.verma.mobile.android.lib.pin;

import android.view.View;

/**
 * Created by verma on 08-02-2018.
 */

public interface PinLockListener {


    /**
     * Triggers when the complete pin is entered,
     * depends on the pin length set by the user
     *
     * @param pin the complete pin
     */
    void onComplete(String pin);


    /**
     * Triggers when the pin is empty after manual deletion
     */
    void onEmpty();

    /**
     * Triggers on a key press on the {@link com.andrognito.pinlockview.PinLockView}
     *
     * @param pinLength       the current pin length
     * @param intermediatePin the intermediate pin
     */
    void onPinChange(int pinLength, String intermediatePin);

    void onPinButtonClick(View view);
}
