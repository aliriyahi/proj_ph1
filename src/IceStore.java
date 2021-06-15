public class IceStore {
    private final int COST = 550;
    private final int UPCOST = 400;
    public int unit = 0;
    int unitTime = 7;
    public static boolean exist = false;
    boolean x2 = false; // for upgrade

    public IceStore(){
        if(main.coin >= COST){
            main.coin -= COST;
            exist = true;
        }
    }

    public void run(){
        if(x2 && Storage.packMilk >= 2){
            Storage.packMilk -= 2;

            unit += 2;
        }
        else if(Storage.packMilk >= 1){
            Storage.packMilk -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            Storage.pick("icecream",n);
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
