package com.angrybirds.Screens;

import com.angrybirds.BirdTypes.Birds;
import com.angrybirds.BirdTypes.BlackBird;
import com.angrybirds.BirdTypes.RedBird;
import com.angrybirds.BirdTypes.YellowBird;
import com.angrybirds.PigTypes.*;
import com.angrybirds.StructureTypes.GlassStructure;
import com.angrybirds.StructureTypes.RockStructure;
import com.angrybirds.StructureTypes.Structures;
import com.angrybirds.StructureTypes.WoodStructure;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
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

    private List<Birds> birds;
    private List<Structures> structures;
    private List<Pigs> pigs;
    private Texture slingshotTexture;
    private float slingshotX = 150; // Adjusted for larger screen
    private float slingshotY = 200; // Adjusted for larger screen
    private float slingshotWidth = 100;  // Increased size for slingshot
    private float slingshotHeight = 180; // Increased size for slingshot

    private boolean isPaused;
    private boolean levelInitialized = false;
    private int level;

    public LevelScreen(Game game, int level) {
        this.game = game;
        this.level = level;
        birds = new ArrayList<>();
        structures = new ArrayList<>();
        pigs = new ArrayList<>();
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT);
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        stage = new Stage(viewport, batch);
        Gdx.input.setInputProcessor(stage);

        skin = new Skin(Gdx.files.internal("uiskin.json"));
        backgroundTexture = new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\levelScreen.jpg"));
        slingshotTexture = new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\slingshot.png"));

        if (!levelInitialized) {
            initializeLevel();
            levelInitialized = true;
        }
        setupPauseButton();
    }

    private void initializeLevel() {
        switch (level) {
            case 1:
                birds.add(new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png"))));
                birds.get(0).setPosition(slingshotX + slingshotWidth / 2 - 30, slingshotY + slingshotHeight / 2 + 20);

                structures.add(new GlassStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\glass.png")), 1300, 200));
                structures.add(new GlassStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\glass.png")), 1335, 200));
                pigs.add(new MediumPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\mediumPig.png")), 1300, 275));
                pigs.add(new SmallPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\smallPig.png")), 1350,275 ));
                break;

            case 2:
                birds.add(new BlackBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\blackAngryBird.png"))));
                birds.add(new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png"))));
                birds.get(0).setPosition(slingshotX + slingshotWidth / 2 - 30, slingshotY + slingshotHeight / 2 + 20);
                birds.get(1).setPosition(slingshotX - 40 , slingshotY);

                structures.add(new WoodStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\wood.png")), 1300, 200));
                structures.add(new WoodStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\wood.png")), 1350, 200));
                structures.add(new WoodStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\wood.png")), 1400, 200));
                structures.add(new WoodStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\wood.png")), 1450, 200));
                pigs.add(new MediumPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\mediumPig.png")), 1310, 290));
                pigs.add(new MediumPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\mediumPig.png")), 1470, 290));
                pigs.add(new LargePig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\largePig.png")), 1360, 280));
                break;

            case 3:
                birds.add(new YellowBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\yellowAngryBird.png"))));
                birds.add(new BlackBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\blackAngryBird.png"))));
                birds.add(new RedBird(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\redAngryBird.png"))));
                birds.get(0).setPosition(slingshotX + slingshotWidth / 2 - 30, slingshotY + slingshotHeight / 2 + 20);
                birds.get(1).setPosition(slingshotX - 30 , slingshotY);
                birds.get(2).setPosition(slingshotX - 90 , slingshotY + 10);

                structures.add(new RockStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\rock.png")), 1300, 200));
                structures.add(new RockStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\rock.png")), 1360, 200));
                structures.add(new RockStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\rock.png")), 1420, 200));
                structures.add(new RockStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\rock.png")), 1480, 200));
                structures.add(new WoodStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\wood.png")), 1310, 300));
                structures.add(new WoodStructure(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\wood.png")), 1480, 300));
                pigs.add(new LargePig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\largePig.png")), 1310, 380));
                pigs.add(new LargePig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\largePig.png")), 1480, 380));
                pigs.add(new BossPig(new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\bossPig.png")), 1370, 300));
                break;

            default:
                System.out.println("Invalid level selected.");
                break;
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
        // Update logic for birds, pigs, and structures.
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
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        backgroundTexture.dispose();
        slingshotTexture.dispose();
    }
}
