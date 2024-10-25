package com.angrybirds.BirdTypes;

import com.angrybirds.PigTypes.Pigs;
import com.angrybirds.StructureTypes.Structures;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Birds {
    protected Vector2 position;
    protected Vector2 velocity;
    protected Texture texture;
    protected boolean launched;

    public Birds(Texture texture) {
        this(texture, 0, 0); // Default position set to (0, 0)
    }

    public Birds(Texture texture, float x, float y) {
        this.texture = texture;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.launched = false; // Initially, the bird is not launched
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, 50, 50); // Adjust size for the bird
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(position.x, position.y, 50, 50); // Adjust size for collision detection
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }

    public boolean isLaunched() {
        return launched;
    }

    public void launch() {
        this.launched = true; // Bird is launched
        // Add logic to set the initial velocity of the bird here, if required.
    }

    public void update(float delta) {
        if (launched) {
            // Update the bird's position based on velocity, gravity, or any other physics.
            position.add(velocity.cpy().scl(delta));
        }
    }

    public void setVelocity(float x, float y) {
        this.velocity.set(x, y);
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public abstract void hitStructure(Structures structure);

    public abstract void hitPig(Pigs pig);
}
