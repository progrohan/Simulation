package base.entities;


public abstract class Entity {
    private String sprite;
    public String  getType(){
        return this.getClass().getSimpleName();
    }

    public abstract String getSprite();

}
