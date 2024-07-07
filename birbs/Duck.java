public class Duck extends Birb{
    public Duck(String name, int cuteness, int capacity, boolean willKillYou) {
        super(name, cuteness, capacity, willKillYou);
    }

    public void makeSound() {
        System.out.println(this.getName() + ": quack quack quack qauck quak qakuc qu ack");
    }
}
