package com.angrybirds.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class LoseScreen implements Screen {

    private static final float WORLD_WIDTH = 1920;
    private static final float WORLD_HEIGHT = 1080;

    private Game game;
    private Stage stage;
    private Skin skin;
    private Viewport viewport;
    private SpriteBatch batch;
    private Texture backgroundTexture;

    public LoseScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        backgroundTexture = new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\loseScreen.png"));

        TextButton replayButton = createStyledButton("Replay");
        replayButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new LevelSelectionScreen(game)); // Go back to level selection
            }
        });

        TextButton homeButton = createStyledButton("Home");
        homeButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new HomeScreen(game));
            }
        });

        Table table = new Table();
        table.center();
        table.setFillParent(true);
        table.add(replayButton).pad(10).width(300).height(70).row();
        table.add(homeButton).pad(10).width(300).height(70);
        stage.addActor(table);
    }

    private TextButton createStyledButton(String text) {
        BitmapFont font = generateCustomFont("C:\\Projects\\core\\assets\\angrybirds-regular.ttf", 36);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        style.fontColor = Color.WHITE;

        return new TextButton(text, style);
    }

    private BitmapFont generateCustomFont(String fontPath, int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = Color.YELLOW;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        stage.dispose();
        batch.dispose();
        backgroundTexture.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        backgroundTexture.dispose();
    }
}
