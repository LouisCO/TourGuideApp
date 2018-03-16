package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 *  Created by Lenovo on 15/03/2018.
 */

public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private ClickListener ClickListener1;
    private GestureDetector gestureDetector;

    RecyclerTouchListener(Context context, final RecyclerView recyclerView, ClickListener clickListener) {
        ClickListener1=clickListener;
        gestureDetector=new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                View child=recyclerView.findChildViewUnder(e.getX(), e.getY());
                if (child != null && ClickListener1 != null) {
                    ClickListener1.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                }
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child=rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && ClickListener1 != null && gestureDetector.onTouchEvent(e)) {
            ClickListener1.onClick(child, rv.getChildAdapterPosition(child));
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }
}