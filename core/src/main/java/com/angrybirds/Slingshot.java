package com.angrybirds;

import com.angrybirds.BirdTypes.Birds;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Slingshot {
    private Vector2 position;
    private Texture texture;

    public Slingshot(Texture texture, float x, float y) {
        this.texture = texture;
        this.position = new Vector2(x, y);
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 80, 160);
    }

    public Vector2 getPosition() {
        return position;
    }

    // Method to launch a bird from the slingshot
    public void launchBird(Birds birds) {
        birds.launch();
    }
}
