package base.entities.utils;

public class Health {
    int maxHP;
    int curHP;

    public Health(int hp){
        this.maxHP = hp;
    }

    public int getCurHP() {
        return curHP;
    }

    public void setCurHP(int curHP) {
        this.curHP = curHP;
    }
}
