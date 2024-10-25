package com.angrybirds.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
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

public class PauseScreen implements Screen {

    private static final float WORLD_WIDTH = 1920;
    private static final float WORLD_HEIGHT = 1080;

    private Game game;
    private Stage stage;
    private Skin skin;
    private Viewport viewport;
    private SpriteBatch batch;
    private LevelScreen levelScreen;

    public PauseScreen(Game game, LevelScreen levelScreen) {
        this.game = game;
        this.levelScreen = levelScreen;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton resumeButton = createStyledButton("Resume");
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(levelScreen);
            }
        });

        TextButton saveButton = createStyledButton("Save Game");
        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                saveGame();
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
        table.add(resumeButton).pad(10).width(200).height(50).row();
        table.add(saveButton).pad(10).width(200).height(50).row();
        table.add(homeButton).pad(10).width(200).height(50);
        stage.addActor(table);
    }

    private TextButton createStyledButton(String text) {
        BitmapFont font = generateCustomFont("C:\\Projects\\core\\assets\\angrybirds-regular.ttf", 36);
        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = font;
        style.fontColor = Color.WHITE;
        style.over = skin.newDrawable("white", Color.CLEAR); // Background when hovered
        style.down = skin.newDrawable("white", Color.CLEAR); // Background when clicked

        return new TextButton(text, style);
    }

    private BitmapFont generateCustomFont(String fontPath, int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = Color.WHITE;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

    private void saveGame() {
        // Add your save game logic here
        System.out.println("Game Saved!");
    }

    @Override
    public void render(float delta) {
        levelScreen.renderBackground(batch);
        drawPauseOverlay();
        stage.act(delta);
        stage.draw();
    }

    private void drawPauseOverlay() {
        batch.begin();
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        batch.setColor(0, 0, 0, 0.5f);
        batch.draw(levelScreen.getBackgroundTexture(), 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.setColor(Color.WHITE);
        Gdx.gl.glDisable(GL20.GL_BLEND);
        batch.end();
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
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
    }
}
