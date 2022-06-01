public class Main {
    public static void main(String[] args) {

        MyHashMap<String> map = new MyHashMap();
        map.add("a1", "first");
        map.add("a2", "second");
        map.add("a2", "SecondReplaced");
        map.add("a4", "Fourth");

        System.out.println(map.get("a1"));
        System.out.println(map.get("a2"));
        System.out.println(map.get("a3"));
        System.out.println(map.get("none"));

    }
}
