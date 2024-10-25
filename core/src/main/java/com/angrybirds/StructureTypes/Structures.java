package com.angrybirds.StructureTypes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Structures {
    protected Vector2 position;
    protected int health;
    protected Texture texture;

    public Structures(Texture texture, int health, float x, float y) {
        this.texture = texture;
        this.health = health;
        this.position = new Vector2(x, y);
    }

    public void draw(SpriteBatch batch) {
        draw(batch, 50, 60); // Default size for structures
    }

    // Overloaded draw method with custom size
    public void draw(SpriteBatch batch, float width, float height) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    public void takeDamage(float amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isDestroyed() {
        return health <= 0;
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(position.x, position.y, 50, 60);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }
}
