package com.verma.mobile.android.lib.pin;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by verma on 08-02-2018.
 */

public class ItemSpaceDecoration {


    private final int mHorizontalSpaceWidth;
    private final int mVerticalSpaceHeight;
    private final int mSpanCount;
    private final boolean mIncludeEdge;

    public ItemSpaceDecoration(int horizontalSpaceWidth, int verticalSpaceHeight, int spanCount, boolean includeEdge) {
        this.mHorizontalSpaceWidth = horizontalSpaceWidth;
        this.mVerticalSpaceHeight = verticalSpaceHeight;
        this.mSpanCount = spanCount;
        this.mIncludeEdge = includeEdge;
    }

     public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        int position = parent.getChildAdapterPosition(view);
        int column = position % mSpanCount;

        if (mIncludeEdge) {
            outRect.left = mHorizontalSpaceWidth - column * mHorizontalSpaceWidth / mSpanCount;
            outRect.right = (column + 1) * mHorizontalSpaceWidth / mSpanCount;

            if (position < mSpanCount) {
                outRect.top = mVerticalSpaceHeight;
            }
            outRect.bottom = mVerticalSpaceHeight;
        } else {
            outRect.left = column * mHorizontalSpaceWidth / mSpanCount;
            outRect.right = mHorizontalSpaceWidth - (column + 1) * mHorizontalSpaceWidth / mSpanCount;
            if (position >= mSpanCount) {
                outRect.top = mVerticalSpaceHeight;
            }
        }
    }
}
