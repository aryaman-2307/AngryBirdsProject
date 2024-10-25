package com.angrybirds;

import com.angrybirds.Screens.HomeScreen;
import com.badlogic.gdx.Game;

public class Main extends Game {
    @Override
    public void create() {
        setScreen(new HomeScreen(this));
    }
}
