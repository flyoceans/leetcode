class Solution {
    // convert List<Integer> to int[]
    // Java8
    int[] example1 = list.stream().mapToInt(i -> i).toArray();
    int[] example2 = list.stream().mapToInt(Integer::intValue).toArray();

    // convert int[] to List<Integer>
    //List<Integer> list = new ArrayList(Arrays.asList(array)); Cant because Arrays.List no boxiung
    List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
    List<Integer> list2 = new ArrayList<>(array.length);
    for (int i : array) list2.add(i);

    // convert Set<integer> to List<Integer>
    set.stream().collect(Collectors.toList());

    // initial set
    Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    //Arrays in Java are objects and don't override hashCode and equals. To better understand this, take the example below:
    Set<int[]> set = new HashSet<>();
    set.add(new int[] {1, 2});
    System.out.println(set.contains(new int[] {1, 2})); // false

    // Enum
    public enum Camera {
        NONE,
        CAMERA,
        COVERED;
    }

    public Camera foo() {
        return Camera.COVERED;
    }

    // BinarySearch
    int idx = Arrays.binarySearch(array, target);
    if (idx < 0) idx = -idx - 1;

    // HashMap
    Map map = new HashMap<>();
    map.putIfAbsent(key, value);
    map.computeIfAbsent(key, k->new ArrayList<>()).add(foo);
    map.getOrDefault(key, 0);

    // TreeMap
    TreeMap treeMap = new TreeMap<>();
    treeMap.floorKey(target_key); // Greatest key less than or equal to the target key, return null if no such key
    treeMap.floorEntry(target_key);
    treeMao.ceilingKey(target_key); // Least key greater than or equal to the target key, return null if no such key

    Deque<Integer> deque = new ArrayDeque<>();
    deque.poll();
    deque.add();
    deque.peek();

}