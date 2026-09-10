package day_05_basics;

public class textwender {
    public static void main(String[] args) throws Exception {
        String wort = "Ich programmiere gerne";
        for (int i = wort.length() - 1; i >= 0; i--) {
            System.out.print(wort.charAt(i));
        }
    }
}
