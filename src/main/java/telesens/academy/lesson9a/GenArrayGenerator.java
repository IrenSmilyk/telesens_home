package telesens.academy.lesson9a;

public class GenArrayGenerator {
    public static void main(String[] args) {
        GenArray<Long> longGenArray = new GenArray<>(new Long[20]);
        for(int i=0;i<20;i++){
            longGenArray.set(i,generateNextNumber());
        }
        System.out.println(longGenArray);

    }
    private static long generateNextNumber()    {
        long number = (long) (9990000000L + (Math.random()*9999999L));
        if (number%10 ==0 || number%5 ==0)
            return number;
        else return generateNextNumber();
    }
}
