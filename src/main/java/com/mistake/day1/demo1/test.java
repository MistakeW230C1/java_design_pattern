package com.mistake.day1.demo1;

public class test {
    public static void main(String[] args) {
        Algo<Integer> obj = new Algo<>();
        ILess<Integer> cmp = new InteLess();
        Integer a[] = {3, 9, 2, 8};
        Integer max = obj.getMax(a, cmp);
        System.out.println("Integer max:" + max);

        Algo<Student> obj2 = new Algo<>();
        ILess<Student> cmp2 = new StudLess();
        Student s[] = {new Student("li", 70), new Student("liu", 50), new Student("wang", 10)};
        Student max2 = obj2.getMax(s, cmp2);
        System.out.println("student max grade:" + max2.grade);
    }
}
