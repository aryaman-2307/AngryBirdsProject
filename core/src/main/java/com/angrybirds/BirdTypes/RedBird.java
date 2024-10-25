package com.angrybirds.BirdTypes;

import com.angrybirds.PigTypes.Pigs;
import com.angrybirds.StructureTypes.Structures;
import com.badlogic.gdx.graphics.Texture;

public class RedBird extends Birds {
    public RedBird(Texture texture) {
        super(texture); // Use the default constructor
    }

    public RedBird(Texture texture, float x, float y) {
        super(texture, x, y); // Set position during creation
    }

    @Override
    public void hitStructure(Structures structure) {
        structure.takeDamage(1.0f); // Adjust impact as needed
    }

    @Override
    public void hitPig(Pigs pig) {
        pig.takeDamage(1.0f); // Adjust impact as needed
    }
}
