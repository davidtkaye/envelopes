package com.awol.envelopes;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameWindow extends Fragment implements View.OnTouchListener{

    private float lastPosX;
    private float lastPosY;

    private float DistX;
    private float DistY;

    private View window;
    private int windowWidth;
    private int windowHeight;
    private int windowTop;
    private int windowLeft;


    public GameWindow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_window, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        window = getView().findViewById(R.id.windowView);
        window.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int[] coords=new int[]{0,0};
                windowWidth = window.getWidth();
                windowHeight = window.getHeight();
                window.getLocationOnScreen(coords);
                windowLeft = coords[0];
                windowTop = coords[1];
            }
        });
        getView().findViewById(R.id.envelopeView).setOnTouchListener(this);
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:

                lastPosX = event.getRawX();
                lastPosY = event.getRawY();

                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_MOVE:

                final float x = event.getRawX();
                final float y = event.getRawY();

                if ((v.getX() + v.getWidth() < windowWidth && v.getX()>0) || (x < windowLeft + windowWidth && x > windowLeft + v.getWidth())) {
                    DistX = x - lastPosX;
                    v.setX(v.getX() + DistX);
                    lastPosX = x;
                }

                if ((v.getY() + v.getHeight() < windowHeight && v.getY()>0) || (y < windowTop + windowHeight && y > windowTop +v.getHeight())){
                    DistY = y - lastPosY;
                    v.setY(v.getY() + DistY);
                    lastPosY = y;
                }
                break;
        }
        return true;
    }

}
