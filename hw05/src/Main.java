public class Main {
    public static void main(String[] args) {
        String a = new String("f");
        ArrayBST<String> e = new ArrayBST<>();
        e.add(new String("c"));
        e.add(new String("d"));
        e.add(new String("a"));
        e.add(new String("b"));
        e.add(a);
        System.out.println(e);


        if(e.contains(a)){
            System.out.println(a + " is found in array");
        }
        /*HeapTree<Student> a = new HeapTree<>();
        a.add(new Student(10));
        a.add(new Student(9));
        a.add(new Student(7));
        a.add(new Student(15));
        a.add(new Student(18));




        System.out.println(a);*/

    }
}
