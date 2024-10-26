package base.entities;

import java.util.Objects;

public abstract class Entity {
    String sprite;
    public String  getType(){
        return this.getClass().getSimpleName();
    }

    public abstract String getSprite();

}
