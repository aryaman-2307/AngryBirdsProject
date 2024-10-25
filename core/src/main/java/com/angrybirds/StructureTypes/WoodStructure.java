package com.angrybirds.StructureTypes;

import com.badlogic.gdx.graphics.Texture;

public class WoodStructure extends Structures {
    public WoodStructure(Texture texture, float x, float y) {
        super(texture, 2, x, y); // 2 hits to destroy
    }
}
