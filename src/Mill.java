public class Mill {   // asiab
    private final int COST = 150;
    private final int UPCOST = 100;
    public int unit = 0;
    int unitTime = 4;
    public static boolean exist = false;
    boolean x2 = false; // for upgrade

    public Mill(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){
        if(x2 && Storage.egg >= 2){
            Storage.egg -= 2;

            unit += 2;
        }
        else if(Storage.egg >= 1){
            Storage.egg -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            Storage.add("flour",n);
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
