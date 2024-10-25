package com.angrybirds.PigTypes;

import com.badlogic.gdx.graphics.Texture;

public class MediumPig extends Pigs {
    public MediumPig(Texture texture, float x, float y) {
        super(texture, 2, x, y,40,40); // 2 hits to destroy
    }
}
