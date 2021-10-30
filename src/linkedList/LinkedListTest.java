package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args){
        var a = new LinkedList<String>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        var b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Glorai");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();
        /**
         * |ACE |BDFG -> A|CE  |BDFG -> AB|CE B|DFG
         * -> ABC|E B|DFG -> ABCD|E BD|FG
         * -> ABCDE| BD|FG -> ABCDEF| BDF|G
         */
        while(bIter.hasNext()){
            if(aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();
        /**
         * |BDFG -> B|DFG -> BD|FG -> B|FG -> BF|G -> BFG| -> BF
         */
        while(bIter.hasNext()){
            bIter.next();
            if(bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
    }
}
