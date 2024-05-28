public abstract class Birb implements Aminal{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCuteness() {
        return cuteness;
    }

    public void setCuteness(int cuteness) {
        this.cuteness = cuteness;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isWillKillYou() {
        return willKillYou;
    }

    public void setWillKillYou(boolean willKillYou) {
        this.willKillYou = willKillYou;
    }

    private String name;
    private int cuteness;
    private int capacity = 100;
    private boolean willKillYou;
    public Birb(String name, int cuteness, int capacity, boolean willKillYou) {
        this.name = name;
        this.cuteness = cuteness;
        this.capacity = capacity;
        this.willKillYou = willKillYou;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ate some birbseed!");
        capacity -= 25;
        if (capacity <= 0) {
            poop();
        }
    }

    @Override
    public void poop() {
        System.out.println(getName() + " pooped!");
        capacity = 100;
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " died.");
    }

}
