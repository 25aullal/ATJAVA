public class R02A {

    public static boolean isPalindromeEmordnilapSi(String string) {
        string = string.replaceAll("[\\n\\s'\",]", "");
        string = string.toLowerCase();

        if (string.length() <= 1) {
            return true;
        } else if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return isPalindromeEmordnilapSi(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeEmordnilapSi("is isPalindromeEmordnilapSi isPalindromeEmordnilapSi, si"));
    }
}