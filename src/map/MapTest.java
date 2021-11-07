package map;

import clone.Employee;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args){
        var staff = new HashMap<String, Employee>();
        staff.put("144-35-5464",new Employee("Amy Lee",123));
        staff.put("567-24-2546", new Employee("Harry Hacker",123));
        staff.put("157-62-7935", new Employee("Gary Cooper",123));
        staff.put("456-62-5527", new Employee("Francesca Cruz",123));

        System.out.println(staff);

        staff.remove("567-24-2546");

        staff.put("456-62-5527", new Employee("Francesca Miller",123));

        System.out.println(staff.get("157-62-7935"));

        staff.forEach((k,v) ->
                System.out.println("key=" + k + ", value=" + v));
    }
}