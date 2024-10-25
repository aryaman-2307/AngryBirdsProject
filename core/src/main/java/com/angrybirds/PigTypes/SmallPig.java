package com.angrybirds.PigTypes;

import com.badlogic.gdx.graphics.Texture;

public class SmallPig extends Pigs {
    public SmallPig(Texture texture, float x, float y) {
        super(texture, 1, x, y, 30,30); // 1 hit to destroy
    }
}
