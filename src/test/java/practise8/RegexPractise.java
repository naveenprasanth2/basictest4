package practise8;

public class RegexPractise {
    public static void main(String[] args) {
        String name = " = xpath : \n =xpath : \n= xpath : \n=xpath :\n = xpath: ";
        System.out.println(name);
        String newName = name.replaceAll("\\s*=\\s*xpath\\s*:\\s*", "=xpath:");
        System.out.println(newName);
    }
}
