package shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args){
        var number = new ArrayList<Integer>();
        for(int i = 1; i < 49; i++){
            number.add(i);
        }

        //混排
        Collections.shuffle(number);
        //子范围
        List<Integer> winningCombination = number.subList(0,6);
        //归并排序  对子范围进行对操作，也会反映到原始列表中
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}
