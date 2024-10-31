package base.entities;


public abstract class Entity {
    public String  getType(){
        return this.getClass().getSimpleName();
    }

}
