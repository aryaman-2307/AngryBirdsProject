package com.angrybirds;

import com.angrybirds.Screens.HomeScreen;
import com.badlogic.gdx.Game;

public class Main extends Game {
    @Override
    public void create() {
        // Set the initial screen when the application starts
        setScreen(new HomeScreen(this));
}
}
