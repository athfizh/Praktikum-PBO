package Tugas;

public class WalkingZombie extends Zombie {

    public WalkingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        switch (level) {
            case 1:
                this.health += (this.health * 0.1); // 10%
                break;
            case 2:
                this.health += (this.health * 0.3); // 30%
                break;
            case 3:
                this.health += (this.health * 0.4); // 40%
                break;
        }
    }

    @Override
    public void destroyed() {
        this.health -= (this.health * 0.20); 
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data =" + super.getZombieInfo();
    }
}