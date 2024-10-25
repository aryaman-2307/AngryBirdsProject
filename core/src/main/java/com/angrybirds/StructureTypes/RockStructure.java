package com.angrybirds.StructureTypes;

import com.badlogic.gdx.graphics.Texture;

public class RockStructure extends Structures {
    public RockStructure(Texture texture, float x, float y) {
        super(texture, 4, x, y); // 4 hits to destroy
    }
}
