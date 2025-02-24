public class BaseballCard {
    String name; // the name of the player on the card.
    int year; // the year the card was issued.

    public BaseballCard(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return "[name = " + name + ", year = " + year + "]";
    }

    public boolean equals(BaseballCard b) {
        if (this.name.toUpperCase().equals(b.getName().toUpperCase()) && (this.year == b.getYear())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        BaseballCard avi = new BaseballCard("Avi", 2008);
        BaseballCard nikki = new BaseballCard("Nikki", 2010);
        BaseballCard billybob = new BaseballCard("avi", 2008);
        if (avi.equals(nikki) == true) {
            System.out.println("Avi and Nikki cards have the same contents");
        }

        if (avi.equals(billybob) == true) {
            System.out.println("Avi and BillyBob cards have the same contents");
        }

        System.out.println("Avi's toString(): ");
        System.out.println(avi.toString());
        System.out.println("Nikki's toString(): ");
        System.out.println(nikki.toString());
        System.out.println("Billybob's toString(): ");
        System.out.println(billybob.toString());
    }

}