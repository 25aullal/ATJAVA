public class Animal_Demo_Compare {

    public static void main(String[] args) {
        Comparable<Animal> kangarooster = new Animal("Kangarooster", 45.49999999);
        Animal hippopotter = new Animal("Hippopotter", 45.5);

        if (kangarooster.compareTo(hippopotter) == -1) {
            System.out.println("kangarooster is lighter");
        } else if (kangarooster.compareTo(hippopotter) == 1) {
            System.out.println("kangarooster is heavier");
        } else {
            System.out.println("same weight!");
        }
    }

}
