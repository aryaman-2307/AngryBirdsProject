package com.angrybirds.BirdTypes;

import com.angrybirds.PigTypes.Pigs;
import com.angrybirds.StructureTypes.Structures;
import com.badlogic.gdx.graphics.Texture;

public class BlackBird extends Birds {
    public BlackBird(Texture texture) {
        super(texture); // Use the default constructor
    }

    public BlackBird(Texture texture, float x, float y) {
        super(texture, x, y); // Set position during creation
    }

    @Override
    public void hitStructure(Structures structure) {
        structure.takeDamage(2.0f); // More impact for the BlackBird
    }

    @Override
    public void hitPig(Pigs pig) {
        pig.takeDamage(2.0f); // More impact for the BlackBird
    }
}
