package com.awol.envelopes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        GameWindow rhs = (GameWindow)getSupportFragmentManager().findFragmentById(R.id.rightHandSide);
        GameWindow lhs = (GameWindow)getSupportFragmentManager().findFragmentById(R.id.leftHandSide);
        rhs.addEnvelope(50f, 50f);
        rhs.addEnvelope(350f, 50f);
        lhs.addEnvelope(50f, 50f);
    }

}
