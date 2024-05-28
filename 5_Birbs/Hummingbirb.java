public class Hummingbirb extends Birb{
    public Hummingbirb(String name, int cuteness, int capacity, boolean willKillYou) {
        super(name, cuteness, capacity, willKillYou);
    }

    public void makeSound() {
        System.out.println(this.getName() + ": tweet i guess idk");
    }
}
