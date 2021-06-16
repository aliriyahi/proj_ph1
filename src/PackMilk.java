public class PackMilk {
    private final int COST = 400;
    private final int UPCOST = 300;
    public int unit = 0;
    int unitTime = 6;
    public  boolean exist = false;
    boolean x2 = false; // for upgrade

    public PackMilk(){
        if(Storage.coin >= COST){
            Storage.coin -= COST;
            exist = true;
        }
    }

    public void run(){
        if(x2 && Storage.milk >= 2){
            Storage.milk -= 2;

            unit += 2;
        }
        else if(Storage.milk >= 1){
            Storage.milk -= 1;

            unit ++; // handle time unit
        }
    }

    public boolean pick(int n){
        if(n <= unit){
            unit -= n;
            Storage.add("packMilk",n);
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
