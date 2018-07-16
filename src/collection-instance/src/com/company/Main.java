package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // 0x00. Java 实例 - 数组转集合
        int n = 5;
        String[] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = String.valueOf(i);
        }
        List<String> list = Arrays.asList(name);
        System.out.println();
        for (String li : list) {
            System.out.println(li + " ");
        }

        // 0x01. Java 实例 - 集合比较
        String[] coins = {"Penny", "nickel", "dime", "Quarter", "dollar"};
        Set<String> set = new TreeSet<String>();
        for (int i = 0; i < coins.length; i++) {
            set.add(coins[i]);
        }
        System.out.println(Collections.min(set));
        System.out.println(Collections.min(set, String.CASE_INSENSITIVE_ORDER));
        for (int i = 0; i <= 10; i++) {
            System.out.print("-");
        }
        System.out.println("");
        System.out.println(Collections.max(set));
        System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));

        // 0x02. Java 实例 - HashMap遍历
        HashMap<String, String> hMap = new HashMap<String, String>();
        hMap.put("1", "1st");
        hMap.put("2", "2nd");
        hMap.put("3", "3rd");
        Collection cl = hMap.values();
        Iterator itr = cl.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // 0x03. Java 实例 - 集合长度
        HashSet hashSet = new HashSet();
        hashSet.add("Yellow");
        hashSet.add("White");
        hashSet.add("Green");
        hashSet.add("Blue");

        itr = hashSet.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        int size = hashSet.size();
        if (hashSet.isEmpty()) {
            System.out.println("集合是空的");
        } else {
            System.out.println("集合长度：" + size);
        }

        // 0x04. Java 实例 - 集合打乱顺序
        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            intList.add(new Integer(i));
        }
        System.out.println("打乱前：" + intList);
        for (int i = 1; i < 6; i++) {
            Collections.shuffle(intList);
            System.out.println("第 " + i + " 次打乱:" + intList);
        }

        // 0x05. Java 实例 - 集合遍历
        listTest(); // List集合的遍历
        setTest(); // Set集合的遍历

        // 0x06. Java 实例 - 集合反转
        //  Collections.reverse(list);

        // 0x07. Java 实例 - 删除集合中指定元素
        // collection.remove(item);

        // 0x08 Java 实例 - 只读集合
        // Collections.unmodifiableList(list);
        // Collections.unmodifiableMap(map);

        // 0x09. Java 实例 - 集合输出
        // tMap.keySet() 键集合
        // tMap.values() 值集合
        // tMap.get(key) 获取指定键的值
        // tMap.remove(key) 删除指定键值对

        // 0x0a. Java 实例 - 集合转数组
        List<String> list1 = new ArrayList<String>();
        list1.add("蜗");
        list1.add("牛");
        list1.add("研");
        list1.add("发");
        String[] s1 = list1.toArray(new String[0]);
        for (String s : s1) {
            System.out.println(s);
        }

        // 0x0b. Java 实例 - List 循环移动元素
        List list2 = Arrays.asList("one Two three Four five six".split(" "));
        System.out.println("List :" + list2);
        Collections.rotate(list2, 3);
        System.out.println("rotate: " + list2);

        // 0x0c. Java 实例 - 查找 List 中的最大最小值
        System.out.println("最大值: " + Collections.max(list2));
        System.out.println("最小值: " + Collections.min(list2));

        // 0x0d. Java 实例 - 遍历 HashTable 的键值
        Hashtable ht = new Hashtable();
        ht.put("1", "One");
        ht.put("2", "Two");
        ht.put("3", "Three");
        Enumeration e = ht.keys();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }

        // 0x0e. Java 实例 - List 元素替换
        Collections.replaceAll(list2, "one", "hundrea");
        System.out.println("replaceAll: " + list2);
    }

    private static void setTest() {
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("C");
        set.add("C++");
        set.add("JAVA");
        set.add("JAVASCRIPT");

        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void listTest() {
        List<String> list = new ArrayList<String>();
        list.add("蜗");
        list.add("牛");
        list.add("研");
        list.add("发");

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
