package com.angrybirds.BirdTypes;

import com.angrybirds.PigTypes.Pigs;
import com.angrybirds.StructureTypes.Structures;
import com.badlogic.gdx.graphics.Texture;

public class YellowBird extends Birds {
    public YellowBird(Texture texture) {
        super(texture); // Use the default constructor
    }

    public YellowBird(Texture texture, float x, float y) {
        super(texture, x, y); // Set position during creation
    }

    @Override
    public void hitStructure(Structures structure) {
        structure.takeDamage(0.5f); // Less impact for the YellowBird
    }

    @Override
    public void hitPig(Pigs pig) {
        pig.takeDamage(0.5f); // Less impact for the YellowBird
    }
}
