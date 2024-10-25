package com.angrybirds.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.viewport.Viewport;

import static com.angrybirds.Screens.HomeScreen.WORLD_HEIGHT;
import static com.angrybirds.Screens.HomeScreen.WORLD_WIDTH;

public class GameScreen implements Screen {

    private Game game;
    private Screen previousScreen; // Reference to the previous screen to return to
    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private Texture backgroundTexture; // Optional: Semi-transparent background for the pause menu
    private Viewport viewport;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        // Load the skin and (optionally) a semi-transparent background for the pause menu
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        // Create the "Resume" button
        TextButton resumeButton = new TextButton("Resume", skin);
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(previousScreen); // Return to the previous screen
            }
        });

        // Create the "Home" button
        TextButton homeButton = new TextButton("Home", skin);
        homeButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new HomeScreen(game)); // Navigate to the HomeScreen
            }
        });

        // Layout the pause menu buttons using a table
        Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(resumeButton).pad(10).width(200).height(50).row();
        table.add(homeButton).pad(10).width(200).height(50);
        stage.addActor(table);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        batch.dispose();
        stage.dispose();
        skin.dispose();
        backgroundTexture.dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        skin.dispose();
        backgroundTexture.dispose();
    }
}
