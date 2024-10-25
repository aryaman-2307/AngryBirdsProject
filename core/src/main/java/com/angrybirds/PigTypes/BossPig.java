package com.angrybirds.PigTypes;

import com.badlogic.gdx.graphics.Texture;

public class BossPig extends Pigs {
    public BossPig(Texture texture, float x, float y) {
        super(texture, 100, x, y, 80, 80); // Increased size for Boss Pig (80x80)
    }
}
