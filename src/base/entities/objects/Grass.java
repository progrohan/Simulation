package base.entities.objects;

import base.entities.Entity;

public class Grass extends Entity {
    private final String sprite = "\uD83C\uDF3F";

    @Override
    public String getSprite() {
        return sprite;
    }
}
