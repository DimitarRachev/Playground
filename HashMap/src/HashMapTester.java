public class HashMapTester {
    public static void main(String[] args) {

        MyHashMap<Integer, Integer> map = new MyHashMap();
        map.add(1, 1);
        map.add(2, 2);
        map.add(2,22);
        map.add(4, 4);
        map.add(5,5);
        map.add(5,6);
        map.add(5,7);
        map.add(6,9);
        map.add(9,9);
        map.add(456,456); // index 14 to test collision
        map.add(14,14);   //index 14 too, obviously

        map.remove(2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(456));
        System.out.println(map.get(14));


    }
}
