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
        this(texture, 0, 0);
    }

    public Birds(Texture texture, float x, float y) {
        this.texture = texture;
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.launched = false;
    }

    public void draw(SpriteBatch batch) {
        draw(batch, 50, 50); // Default size
    }

    // Overloaded draw method with custom size
    public void draw(SpriteBatch batch, float width, float height) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(position.x, position.y, 50, 50);
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
        this.launched = true;
    }

    public void update(float delta) {
        if (launched) {
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
