package staticInnerClass;

public class StaticInnerClass {
    public static void main(String[] args){
        var value = new double[20];
        for(int i = 0; i < value.length; i++){
            value[i] = 100 * Math.random();
        }
        ArrayAlg.Pair p = ArrayAlg.minmax(value);
        System.out.println("min=" + p.getFirst());
        System.out.println("max= " + p.getSecond());
    }
}

class ArrayAlg{
    //静态内部类
    public static class Pair{
        private double first;
        private double second;

        public Pair(double first,double second){
            this.first = first;
            this.second = second;
        }

        public double getFirst(){
            return first;
        }
        public double getSecond(){
            return second;
        }
    }

    public static Pair minmax(double[] value){
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for(double v : value){
            if(min > v) min = v;
            if(max < v) max = v;
        }
        return new Pair(min,max);
    }
}
