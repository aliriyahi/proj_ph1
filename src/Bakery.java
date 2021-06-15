public class Bakery {
    private final int COST = 250;
    private final int UPCOST = 200;
    public int unit = 0;
    int unitTime = 5;
    public static boolean exist = false;
    boolean x2 = false; // for upgrade

    public Bakery(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){
        if(x2 && Storage.flour >= 2){
            Storage.flour -= 2;

            unit += 2;
        }
        else if(Storage.flour >= 1){
            Storage.flour -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            Storage.add("bread",n);
            return true;
        }
        else
            return false;
    }

    public void upgrade(int mode){
        if(Storage.coin >= UPCOST){
            Storage.coin -= UPCOST;
            if(mode == 1)
                unitTime /= 2;
            if(mode == 2)
                x2 = true;
        }
    }
}
