package Tugas;

public class JumpingZombie extends Zombie {

    public JumpingZombie(int health, int level) {
        this.health = health;
        this.level = level;
    }

    @Override
    public void heal() {
        switch (level) {
            case 1:
                this.health += (this.health * 0.3); // 30%
                break;
            case 2:
                this.health += (this.health * 0.4); // 40%
                break;
            case 3:
                this.health += (this.health * 0.5); // 50%
                break;
        }
    }

    @Override
    public void destroyed() {
        this.health -= (this.health * 0.10);
    }

    @Override
    public String getZombieInfo() {
        return "Jumping Zombie Data =" + super.getZombieInfo();
    }
}