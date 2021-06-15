public class Storage {
    static final int SPACE = 30;
    public static int egg;
    public static int feather; //par
    public static int milk;
    public static int flour; //ard
    public static int fabric; //parcheh
    public static int packMilk;
    public static int bread;
    public static int cloths;
    public static int icecream;
    public static int lion;
    public static int bear;
    public static int tiger;
    static int useSpace = egg+feather+milk+2*flour+2*fabric+2*packMilk+4*bread+4*cloths+4*icecream+15*lion+15*bear+15*tiger;

    public static boolean pick(String name,int n){  // zakhireh dar anbar
        if(name.equals("egg")){
            if(n + useSpace <= SPACE){
                egg += n;
                return true; }
        }else if(name.equals("feather")){
            if(n + useSpace <= SPACE){
                feather += n;
                return true; }
        }else if(name.equals("milk")){
            if(n + useSpace <= SPACE){
                milk += n;
                return true; }
        }else if(name.equals("flour")){
            if(2*n + useSpace <= SPACE){
                flour += n;
                return true; }
        }else if(name.equals("fabric")){
            if(2*n + useSpace <= SPACE){
                fabric += n;
                return true; }
        }else if(name.equals("packMilk")){
            if(2*n + useSpace <= SPACE){
                packMilk += n;
                return true; }
        }else if(name.equals("bread")){
            if(4*n + useSpace <= SPACE){
                bread += n;
                return true; }
        }else if(name.equals("cloths")){
            if(4*n + useSpace <= SPACE){
                cloths += n;
                return true; }
        }else if(name.equals("icecream")){
            if(4*n + useSpace <= SPACE){
                icecream += n;
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

}
