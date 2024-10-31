package base.entities.objects;

import base.entities.Entity;

public class Rock extends Entity {
    private String sprite = "\uD83E\uDEA8";

    @Override
    public String getSprite() {
        return sprite;
    }
}
