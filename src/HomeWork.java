import java.sql.Date;
import java.sql.Time;

public class HomeWork {

    private static int Time = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Liza", 150, 3);
        cat[1] = new Cat("Semen", 100, 4);
        cat[2] = new Cat("Murka", 30, 1);
        Plate plate = new Plate(600);
        System.out.println("Tri kota " + cat[0].getName() + ", " + cat[1].getName() + " & " + cat[2].getName() + ", kushaut kazhdye  " + cat[0].getSatietyTime() + ", " + cat[1].getSatietyTime() + " & " + cat[2].getSatietyTime() + " chasa.");
        System.out.println("Kto iz nih obzhora, kto net. Seichas v miske " + plate.getFood() + " gr korma.Naskolko ego hvatit.\n");


        do {
            for (Cat i : cat) {

                //esli kot goloden
                if (i.getSatiety() == 0) {

                    //esli v miske net korma,ee dobavyat
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }

                    //kot est
                    i.eat(plate);
                    System.out.println("Kot " + i.getName() + " skushal " + i.getAppetite() + " gr korma & zahochet kushat cherez " + (i.getSatiety()) + " chasa");
                }


                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nС proshlo s kormezhki "+ Time + " chasa. V miske ostalos " + plate.getFood() + " gr korma.\n");;
        } while (Time <= 24);
    }
}

class Plate {

    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += 400;
        System.out.println("V misku dobavili 400 gr");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}

class Cat {

    private String name;
    private int appetite;
    private int satietyTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatietyTime() {
        return satietyTime;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int satietyTime) {

        this.name = name;
        this.appetite = appetite;
        this.satietyTime = satietyTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += satietyTime;




    }
}
