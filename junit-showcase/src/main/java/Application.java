public class Application {
    public static void main(String[] args) {
        String name = "sonnb";
        System.out.println(greeting(name));;
    }

    public static String greeting() {
        return "Hello world!";
    }

    public static String greeting(String name) {
        return String.format("Hello %s!", name);
    }
}
