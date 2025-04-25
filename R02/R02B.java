public class R02B {

    public static boolean isPalindromeEmordnilapSi(String string) {
        string = string.replaceAll("[\\n\\s'\",]", "");
        string = string.toLowerCase();
        int n;

        while (true) {
            n = string.length();
            if (n <= 1) {
                return true;
            } else if (string.charAt(0) == string.charAt(string.length() - 1)) {
                string = string.substring(1, n - 1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeEmordnilapSi("eeeereeee"));
    }
}