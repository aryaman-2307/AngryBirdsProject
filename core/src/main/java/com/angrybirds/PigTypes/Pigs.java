package com.angrybirds.PigTypes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Pigs {
    protected Vector2 position;
    protected int health;
    protected Texture texture;
    protected float width;
    protected float height;

    public Pigs(Texture texture, int health, float x, float y, float width, float height) {
        this.texture = texture;
        this.health = health;
        this.position = new Vector2(x, y);
        this.width = width;
        this.height = height;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, width, height);
    }

    public void takeDamage(float amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public Rectangle getBoundingBox() {
        return new Rectangle(position.x, position.y, width, height);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        this.position.set(x, y);
    }

    public void draw(SpriteBatch batch, float width, float height) {
        batch.draw(texture, position.x, position.y, width, height);
    }

}
