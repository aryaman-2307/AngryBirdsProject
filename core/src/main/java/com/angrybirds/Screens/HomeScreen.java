package com.angrybirds.Screens;

import com.angrybirds.CustomFont;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class HomeScreen implements Screen {

    protected static final float WORLD_WIDTH = 1920;
    protected static final float WORLD_HEIGHT = 1080;

    private Game game;
    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private Texture homeScreenTexture;
    private Viewport viewport;

    public HomeScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        homeScreenTexture = new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\homescreen.png"));

        Table table = new Table();
        table.setFillParent(true);
        table.bottom().padBottom(30);

        TextButton playButton = createStyledButton("Play");
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelSelectionScreen(game));
            }
        });

        TextButton loadGameButton = createStyledButton("Load Game");
        loadGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (isSavedGameAvailable()) {
                    game.setScreen(new LevelScreen(game, getSavedGameLevel()));
                }
            }
        });

        TextButton exitButton = createStyledButton("Exit");
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        table.add(playButton).pad(20).width(300).height(70).row();
        table.add(loadGameButton).pad(20).width(300).height(70).row();
        table.add(exitButton).pad(20).width(300).height(70).row();
        stage.addActor(table);
    }

    private TextButton createStyledButton(String text) {
        BitmapFont font = generateCustomFont("C:\\Projects\\core\\assets\\angrybirds-regular.ttf", 36);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;

        return new TextButton(text, style);
    }

    private BitmapFont generateCustomFont(String fontPath, int size) {
        return CustomFont.generateCustomFont(fontPath, size);
    }

    private boolean isSavedGameAvailable() {
        return true;
    }

    private int getSavedGameLevel() {
        return 1;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        batch.draw(homeScreenTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        stage.dispose();
        batch.dispose();
        homeScreenTexture.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        homeScreenTexture.dispose();
    }
}
