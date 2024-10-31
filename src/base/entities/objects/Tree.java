package base.entities.objects;

import base.entities.Entity;

public class Tree extends Entity {
    private String sprite = "\uD83C\uDF32";

    @Override
    public String getSprite() {
        return sprite;
    }
}
