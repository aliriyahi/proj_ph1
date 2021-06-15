import com.sun.tools.javac.Main;

public class Car {
    private final int SPACE = 15;
    int useSpace = 0;
    private final int time=10;
    int price = 0;

    public boolean load(String name , int n){

        if(name.equals("egg")){
            if(n + useSpace <= SPACE){
                useSpace += n;
                price += 15*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("feather")){
            if(n + useSpace <= SPACE){
                useSpace += n;
                price += 20*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("milk")){
            if(n + useSpace <= SPACE){
                useSpace += n;
                price += 25*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("flour")){
            if(2*n + useSpace <= SPACE){
                useSpace += 2*n;
                price += 40*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("fabric")){
            if(2*n + useSpace <= SPACE){
                useSpace += 2*n;
                price += 50*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("packMilk")){
            if(2*n + useSpace <= SPACE){
                useSpace += 2*n;
                price += 60*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("bread")){
            if(4*n + useSpace <= SPACE){
                useSpace += 4*n;
                price += 80*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("cloths")){
            if(4*n + useSpace <= SPACE){
                useSpace += 4*n;
                price += 100*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("icecream")){
            if(4*n + useSpace <= SPACE){
                useSpace += 4*n;
                price += 120*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("lion")){
            if(15*n + useSpace <= SPACE){
                useSpace += 15*n;
                price += 300*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("bear")){
            if(15*n + useSpace <= SPACE){
                useSpace += 15*n;
                price += 400*n;
                Storage.remove(name , n);
                return true; }
        }else if(name.equals("tiger")){
            if(15*n + useSpace <= SPACE){
                useSpace += 15*n;
                price += 500*n;
                Storage.remove(name , n);
                return true; }
        }

        return false;
    }

    public boolean unload(String name , int n){
        if(name.equals("egg")){
            if(useSpace - n >= 0){
                useSpace -= n;
                price -= 15*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("feather")){
            if(useSpace - n >= 0){
                useSpace -= n;
                price -= 20*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("milk")){
            if(useSpace - n >= 0){
                useSpace -= n;
                price -= 25*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("flour")){
            if(useSpace - 2*n >= 0){
                useSpace -= 2*n;
                price -= 40*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("fabric")){
            if(useSpace - 2*n >= 0){
                useSpace -= 2*n;
                price -= 50*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("packMilk")){
            if(useSpace - 2*n >= 0){
                useSpace -= 2*n;
                price -= 60*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("bread")){
            if(useSpace - 4*n >= 0){
                useSpace -= 4*n;
                price -= 80*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("cloths")){
            if(useSpace - 4*n >= 0){
                useSpace -= 4*n;
                price -= 100*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("icecream")){
            if(useSpace - 4*n >= 0){
                useSpace -= 4*n;
                price -= 120*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("lion")){
            if(useSpace - 15*n >= 0){
                useSpace -= 15*n;
                price -= 300*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("bear")){
            if(useSpace - 15*n >= 0){
                useSpace -= 15*n;
                price -= 400*n;
                Storage.add(name , n);
                return true; }
        }else if(name.equals("tiger")){
            if(useSpace - 15*n >= 0){
                useSpace -= 15*n;
                price -= 500*n;
                Storage.add(name , n);
                return true; }
        }
        return false;
    }

    public void sell(){
        Storage.coin += price;
        price = 0;

    }

}