public class Tailoring {    // khayati
    private final int COST = 400;
    private final int UPCOST = 300;
    public int unit = 0;
    int unitTime = 6;
    public static boolean exist = false;
    boolean x2 = false; // for upgrade

    public Tailoring(){
        if(main.coin >= COST){
            main.coin -= COST;
            exist = true;
        }
    }

    public void run(){
        if(x2 && Storage.fabric >= 2){
            Storage.fabric -= 2;

            unit += 2;
        }
        else if(Storage.fabric >= 1){
            Storage.fabric -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            Storage.pick("cloths",n);
            return true;
        }
        else
            return false;
    }

    public void upgrade(int mode){
        if(main.coin >= UPCOST){
            main.coin -= UPCOST;
            if(mode == 1)
                unitTime /= 2;
            if(mode == 2)
                x2 = true;
        }
    }
}
