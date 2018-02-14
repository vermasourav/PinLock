package com.verma.mobile.android.lib.pin;

import android.view.View;

/**
 * Created by verma on 08-02-2018.
 */

public interface PinLockListener {

    void onComplete(String pin);

    void onEmpty();

    void onPinChange(int pinLength, String intermediatePin);

    void onPinButtonClick(View view);
}
