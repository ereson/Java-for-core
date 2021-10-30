package treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 树集
 */
public class TreeSetTest {
    public static void main(String[] args){
        var parts = new TreeSet<Item>();
        //默认的比较方法
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widger",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        //定制的比较器
        var sortByDescription = new TreeSet<Item>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
