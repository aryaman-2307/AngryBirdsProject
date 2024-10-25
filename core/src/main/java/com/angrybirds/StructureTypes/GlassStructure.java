package com.angrybirds.StructureTypes;

import com.badlogic.gdx.graphics.Texture;

public class GlassStructure extends Structures {
    public GlassStructure(Texture texture, float x, float y) {
        super(texture, 1, x, y); // 1 hit to destroy
    }
}
