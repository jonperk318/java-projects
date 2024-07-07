public class Goose extends Birb{
    public Goose(String name, int cuteness, int capacity, boolean willKillYou) {
        super(name, cuteness, capacity, willKillYou);
    }

    public void makeSound() {
        System.out.println(this.getName() + ": GHHHHOOOONNGKKKKKGKK");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " ate some human flesh!");
        setCapacity(getCapacity()-10);
    }
}
