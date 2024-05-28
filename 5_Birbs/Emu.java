public class Emu extends Birb{

    public Emu(String name, int cuteness, int capacity, boolean willKillYou) {
        super(name, cuteness, capacity, willKillYou);
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + ": cockadoodledoo!");
    }

}
