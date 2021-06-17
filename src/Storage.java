public class Storage {
    static final int SPACE = 30;

    public static int coin = 0;

    public static int egg;
    public static int totalegg;
    public static int feather; //par
    public static int totalfeather;
    public static int milk;
    public static int totalmilk;
    public static int flour; //ard
    public static int totalflour;
    public static int fabric; //parcheh
    public static int totalfabric;
    public static int packMilk;
    public static int totalpackmilk;
    public static int bread;
    public static int totalbread;
    public static int cloths;
    public static int totalcloths;
    public static int icecream;
    public static int totalicecream;
    public static int lion;
    public static int bear;
    public static int tiger;
    static int useSpace = egg+feather+milk+2*flour+2*fabric+2*packMilk+4*bread+4*cloths+4*icecream+15*lion+15*bear+15*tiger;

    public static boolean add(String name,int n){  // zakhireh dar anbar
        if(name.equals("egg")){
            if(n + useSpace <= SPACE){
                egg += n;
                totalegg += n;
                return true; }
        }else if(name.equals("feather")){
            if(n + useSpace <= SPACE){
                feather += n;
                totalfeather += n;
                return true; }
        }else if(name.equals("milk")){
            if(n + useSpace <= SPACE){
                milk += n;
                totalmilk += n;
                return true; }
        }else if(name.equals("flour")){
            if(2*n + useSpace <= SPACE){
                flour += n;
                totalflour += n;
                return true; }
        }else if(name.equals("fabric")){
            if(2*n + useSpace <= SPACE){
                fabric += n;
                totalfabric += n;
                return true; }
        }else if(name.equals("packMilk")){
            if(2*n + useSpace <= SPACE){
                packMilk += n;
                totalpackmilk += n;
                return true; }
        }else if(name.equals("bread")){
            if(4*n + useSpace <= SPACE){
                bread += n;
                totalbread += n;
                return true; }
        }else if(name.equals("cloths")){
            if(4*n + useSpace <= SPACE){
                cloths += n;
                totalcloths += n;
                return true; }
        }else if(name.equals("icecream")){
            if(4*n + useSpace <= SPACE){
                icecream += n;
                totalicecream += n;
                return true; }
        }else if(name.equals("lion")){
            if(15*n + useSpace <= SPACE){
                lion += n;
                return true; }
        }else if(name.equals("bear")){
            if(15*n + useSpace <= SPACE){
                bear += n;
                return true; }
        }else if(name.equals("tiger")){
            if(15*n + useSpace <= SPACE){
                tiger += n;
                return true; }
        }
        return false;
    }

    public static boolean remove(String name , int n){
        if(name.equals("egg")){
            if(egg >= n){
                egg -= n;
                return true; }
        }else if(name.equals("feather")){
            if(feather >= n){
                feather -= n;
                return true; }
        }else if(name.equals("milk")){
            if(milk >= n){
                milk -= n;
                return true; }
        }else if(name.equals("flour")){
            if(flour >= n){
                flour -= n;
                return true; }
        }else if(name.equals("fabric")){
            if(fabric >= n){
                fabric -= n;
                return true; }
        }else if(name.equals("packMilk")){
            if(packMilk >= n){
                packMilk -= n;
                return true; }
        }else if(name.equals("bread")){
            if(bread >= n){
                bread -= n;
                return true; }
        }else if(name.equals("cloths")){
            if(cloths >= n){
                cloths -= n;
                return true; }
        }else if(name.equals("icecream")){
            if(icecream >= n){
                icecream -= n;
                return true; }
        }else if(name.equals("lion")){
            if(lion >= n){
                lion -= n;
                return true; }
        }else if(name.equals("bear")){
            if(bear >= n){
                bear -= n;
                return true; }
        }else if(name.equals("tiger")){
            if(tiger >= n){
                tiger -= n;
                return true; }
        }
        return false;
    }

}
