import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Duck Quackers = new Duck("Quackers III", 999999, 75, false);
        Goose UntitledGoose = new Goose("Harold", 100, 100, true);
        Hummingbirb NoodleHead = new Hummingbirb("Noodle Head", 90, 1, false);
        Emu Dave = new Emu("Dave", -100, 200, true);

        ArrayList<Birb> birbList = new ArrayList<>();
        birbList.add(Quackers);
        birbList.add(UntitledGoose);
        birbList.add(NoodleHead);
        birbList.add(Dave);

        for (Birb birb : birbList) {
            System.out.println("Name: " + birb.getName());
            System.out.println("Cuteness on a scale of 1 to 100: " + birb.getCuteness());
            System.out.println("Birb maximum capacity: " + birb.getCapacity());
            System.out.println("This birb will murder you and your family: " + birb.isWillKillYou());
            System.out.println();
            birb.makeSound();
            birb.eat();
            birb.eat();
            birb.eat();
            birb.poop();
            birb.sleep();
            System.out.println();
            System.out.println();
        }
    }
}