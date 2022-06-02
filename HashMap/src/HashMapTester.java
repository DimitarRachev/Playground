public class HashMapTester {
    public static void main(String[] args) {

        MyHashMap<Character, Integer> map = new MyHashMap();
        map.add('1', 1);
        map.add('2', 2);
        map.add('2',22);
        map.add('4', 4);

        System.out.println(map.get('1'));
        System.out.println(map.get('2'));
        System.out.println(map.get('3'));
        System.out.println(map.get('5'));
        System.out.println(map.get('4'));

    }
}
