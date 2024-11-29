package com.angrybirds.StructureTypes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteMaker {
    private final Texture woodStructure;
    private final Texture rockStructure;
    private final Texture glassStructure;

    public SpriteMaker() {
        woodStructure=new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\Wood_Blocks.png"));
        rockStructure=new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\Rock_Blocks.png"));
        glassStructure=new Texture(Gdx.files.internal("C:\\Projects\\core\\assets\\images\\Glass_Blocks.png"));
    }

    //Wood blocks
    public WoodStructure woodlogShort(int x, int y, float rotation) {
        return new WoodStructure(x,y, new Sprite(woodStructure, 288,345,83,20),2,rotation);
    }
    public WoodStructure woodlogVShort(int x, int y, float rotation) {
        return new WoodStructure(x,y, new Sprite(woodStructure, 458,256,41,22),2,rotation);
    }
    public WoodStructure woodlogthick(int x, int y ,float rotation){
        return new WoodStructure(x,y, new Sprite(woodStructure, 246,82,84,42),2,rotation);
    }
    public WoodStructure woodbox(int x, int y, float rotation){
        return new WoodStructure(x,y, new Sprite(woodStructure, 2,337,41,41),2,rotation);
    }
    public WoodStructure woodlogMed(int x, int y, float rotation){
        return new WoodStructure(x,y, new Sprite(woodStructure, 288,279,168,20),2,rotation);
    }

    //Glass Blocks
    public GlassStructure glassLogShort(int x, int y, float rotation) {
        return new GlassStructure(x, y, new Sprite(glassStructure, 288, 345, 83, 20), 1, rotation);
    }
    public GlassStructure glassLogVShort(int x, int y, float rotation) {
        return new GlassStructure(x, y, new Sprite(glassStructure, 458, 256, 41, 22), 1, rotation);
    }
    public GlassStructure glassLogThick(int x, int y, float rotation) {
        return new GlassStructure(x, y, new Sprite(glassStructure, 246, 82, 84, 42), 1, rotation);
    }
    public GlassStructure glassBox(int x, int y, float rotation) {
        return new GlassStructure(x, y, new Sprite(glassStructure, 2, 337, 41, 41), 1, rotation);
    }
    public GlassStructure glassLogMed(int x, int y, float rotation) {
        return new GlassStructure(x, y, new Sprite(glassStructure, 288, 279, 168, 20), 1, rotation);
    }

    //Rock Blocks
    public RockStructure stoneLogShort(int x, int y, float rotation) {
        return new RockStructure(x, y, new Sprite(rockStructure, 288, 345, 83, 20), 4, rotation);
    }
    public RockStructure stoneLogVShort(int x, int y, float rotation) {
        return new RockStructure(x, y, new Sprite(rockStructure, 458, 256, 41, 22), 4, rotation);
    }
    public RockStructure stoneLogThick(int x, int y, float rotation) {
        return new RockStructure(x, y, new Sprite(rockStructure, 246, 82, 84, 42), 4, rotation);
    }
    public RockStructure stoneBox(int x, int y, float rotation) {
        return new RockStructure(x, y, new Sprite(rockStructure, 2, 337, 41, 41), 4, rotation);
    }
    public RockStructure stoneLogMed(int x, int y, float rotation) {
        return new RockStructure(x, y, new Sprite(rockStructure, 288, 279, 168, 20), 4, rotation);
    }

}
