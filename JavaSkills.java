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
}