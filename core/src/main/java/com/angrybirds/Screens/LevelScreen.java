package com.angrybirds.Screens;

import com.angrybirds.BirdTypes.Birds;
import com.angrybirds.BirdTypes.BlackBird;
import com.angrybirds.BirdTypes.RedBird;
import com.angrybirds.BirdTypes.YellowBird;
import com.angrybirds.PigTypes.*;
import com.angrybirds.StructureTypes.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.ArrayList;
import java.util.List;

public class LevelScreen implements Screen {

    private static final float WORLD_WIDTH = 1920;
    private static final float WORLD_HEIGHT = 1080;

    private Game game;
    private Stage stage;
    private Skin skin;
    private SpriteBatch batch;
    private Texture backgroundTexture;
    private Viewport viewport;
    private OrthographicCamera camera;
    private Music levelMusic;

    private List<Birds> birds;
    private List<Structures> structures;
    private List<Pigs> pigs;
    private Birds slingshotBird;
    private Texture slingshotTexture;
    private final float slingshotX = 200;
    private final float slingshotY = 290;
    private final float slingshotWidth = 100;
    private final float slingshotHeight = 180;

    private boolean isPaused;
    private boolean levelInitialized = false;
    private int level;
    private final SpriteMaker spriteMaker;

    public LevelScreen(Game game, int level) {
        this.game = game;
        this.level = level;
        birds = new ArrayList<>();
        structures = new ArrayList<>();
        pigs = new ArrayList<>();
        spriteMaker = new SpriteMaker();
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);
        String musicPath = "C:\\Projects\\core\\assets\\music\\level" + level + "_sound.mp3";
        levelMusic = Gdx.audio.newMusic(Gdx.files.internal(musicPath));
        levelMusic.setLooping(true);
        levelMusic.setVolume(0.5f);
        levelMusic.play();
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        backgroundTexture = new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\levelScreen.png"));
        slingshotTexture = new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\slingshot.png"));
        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                resetBirdIdleTimers();
                return true;
            }
        });
        if (!levelInitialized) {
            initializeLevel();
            levelInitialized = true;
        }
        setupPauseButton();
    }

    private void resetBirdIdleTimers() {
        for (Birds bird : birds) {
            bird.resetIdleTimer();
        }
    }

    private void initializeLevel() {
        try{
        switch (level) {
            case 1:
                slingshotBird = new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png")));
                slingshotBird.setPosition(slingshotX + slingshotWidth / 2 - 30, slingshotY + slingshotHeight / 2 + 30);
                birds.add(slingshotBird);

                Birds groundBird1 = new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png")));
                Birds groundBird2 = new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png")));
                groundBird1.setPosition(slingshotX + slingshotWidth / 2 - 100, 145);
                groundBird2.setPosition(slingshotX + slingshotWidth / 2 - 160, 145);
                birds.add(groundBird1);
                birds.add(groundBird2);

                structures.add(spriteMaker.woodlogMed(1200, 360, 90));
                structures.add(spriteMaker.woodlogMed(1350, 360, 90));
                structures.add(spriteMaker.woodlogMed(1275, 450, 0));
                structures.add(spriteMaker.woodlogMed(1230, 540, 90));
                structures.add(spriteMaker.woodlogMed(1320, 540, 90));
                structures.add(spriteMaker.woodlogShort(1320, 630, 0));
                structures.add(spriteMaker.woodlogVShort(1340, 660, 90));
                structures.add(spriteMaker.woodlogShort(1320, 295, 0));
                structures.add(spriteMaker.woodlogShort(1320, 395, 0));
                structures.add(spriteMaker.glassLogShort(1290, 345, 90));
                structures.add(spriteMaker.glassLogShort(1350, 345, 90));

                pigs.add(new MediumPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\mediumPig.png")), 1335, 470));
                break;

            case 2:
                birds.add(new BlackBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\blackAngryBird.png"))));
                birds.getFirst().setPosition(slingshotX + slingshotWidth / 2 - 30, slingshotY + slingshotHeight / 2 + 30);

                // Level 2 Structures and Pigs
                structures.add(spriteMaker.woodlogMed(500, 100, 15));
                structures.add(spriteMaker.woodlogthick(600, 100, -10));
                structures.add(spriteMaker.woodbox(650, 100, 5));
                pigs.add(new MediumPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\mediumPig.png")), 505, 155));
                pigs.add(new LargePig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\largePig.png")), 550, 155));
                break;

            case 3:
                birds.add(new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png"))));
                birds.add(new YellowBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\yellowAngryBird.png"))));
                birds.getFirst().setPosition(slingshotX + slingshotWidth / 2 - 30, slingshotY + slingshotHeight / 2 + 30);
                birds.get(1).setPosition(slingshotX + slingshotWidth / 2 - 80, slingshotY + slingshotHeight / 2 - 90);
                // Level 3 Structures and Pigs
                structures.add(spriteMaker.stoneLogMed(500, 100, 0));
                structures.add(spriteMaker.glassLogShort(550, 100, -5));
                structures.add(spriteMaker.stoneBox(600, 100, 10));
                pigs.add(new MediumPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\mediumPig.png")), 510, 210));
                pigs.add(new BossPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\bossPig.png")), 540, 155));
                break;

            default:
                System.out.println("Invalid level selected.");
                break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void setupPauseButton() {
        TextButton pauseButton = createStyledButton("Pause");
        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                isPaused = true;
                game.setScreen(new PauseScreen(game, LevelScreen.this));
            }
        });

        Table table = new Table();
        table.top().left();
        table.setFillParent(true);
        table.add(pauseButton).pad(20).width(100).height(50);
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
        return getBitmapFont(fontPath, size);
    }

    static BitmapFont getBitmapFont(String fontPath, int size) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(fontPath));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = size;
        parameter.color = Color.WHITE;
        BitmapFont font = generator.generateFont(parameter);
        generator.dispose();
        return font;
    }

    public Texture getBackgroundTexture() {
        return backgroundTexture;
    }

    public void renderBackground(SpriteBatch batch) {
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        if (!isPaused) {
            updateGame(delta);
        }

        renderBackground(batch);
        drawSlingshot();
        drawGameObjects();
        stage.act(delta);
        stage.draw();
    }

    private void drawSlingshot() {
        batch.begin();
        batch.draw(slingshotTexture, slingshotX, slingshotY, slingshotWidth, slingshotHeight);
        batch.end();
    }

    private void drawGameObjects() {
        batch.begin();
        for (Structures structure : structures) {
            if (structure instanceof GlassStructure) {
                structure.draw(batch, 70, 80); // Larger size for glass structures
            } else if (structure instanceof WoodStructure) {
                structure.draw(batch, 80, 90); // Larger size for wood structures
            } else if (structure instanceof RockStructure) {
                structure.draw(batch, 90, 100); // Larger size for rock structures
            }
        }
        for (Pigs pig : pigs) {
            if (pig.isAlive()) {
                if (pig instanceof BossPig) {
                    pig.draw(batch, 125, 125); // Increase size for the boss pig
                } else if (pig instanceof LargePig) {
                    pig.draw(batch, 100, 100); // Increase size for the large pig
                } else if (pig instanceof MediumPig){
                    pig.draw(batch, 50, 50); // Default size for other pigs
                } else if (pig instanceof SmallPig) {
                    pig.draw(batch, 30, 30);
                }
            }
        }
        for (Birds bird : birds) {
            if (bird instanceof RedBird) {
                bird.draw(batch, 60, 60); // Make the RedBird larger
            } else if (bird instanceof YellowBird) {
                bird.draw(batch, 65, 65); // Make the YellowBird even larger
            } else if (bird instanceof BlackBird) {
                bird.draw(batch, 65, 80); // Adjust size for BlackBird
            } else {
                bird.draw(batch);
            }
        }
        batch.end();
    }

    private void setupInputListeners() {
        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                for (Birds bird : birds) {
                    if (bird.getBoundingBox().contains(x, y)) {
                        game.setScreen(new WinScreen(game));
                        return true; // Stop checking other birds if one is clicked
                    }
                }

                for (Pigs pig : pigs) {
                    if (pig.getBoundingBox().contains(x, y)) {
                        game.setScreen(new LoseScreen(game));
                        return true; // Stop checking other pigs if one is clicked
                    }
                }
                return false;
            }
        });
    }

    private void updateGame(float delta) {
        for (Birds bird : birds) {
            // Skip updating the slingshot bird's jumping behavior
            if (bird == slingshotBird) continue;

            bird.update(delta);
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        camera.setToOrtho(false, width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {
        if (levelMusic != null) {
            levelMusic.stop();
            levelMusic.dispose();
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        backgroundTexture.dispose();
        slingshotTexture.dispose();
        if (levelMusic != null) {
            levelMusic.dispose();
        }
    }
}
