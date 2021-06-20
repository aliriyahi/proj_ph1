import java.util.Random;

public class WildAnimal {
    Random rand = new Random();

    public String animalname;
    public int speed;
    public int xposision = Math.abs(rand.nextInt()%6);
    public int yposision = Math.abs(rand.nextInt()%6);
    public int cages = 0;
    public int maxCage;
    public int removeTime = 0;

    public void animalmove(){
        int random = Math.abs(rand.nextInt()%2);
        if (random==0)
            random=1;
        else if (random==1)
            random=-1;
        int move=random*this.speed;
        int random1 = Math.abs(rand.nextInt()%2);

        if (random1==0){
            if (this.xposision+move<=5 && this.xposision+move>=0){
                this.xposision+=move;
                //System.out.println("??????????????????????????????????????????");
            }else {
                move *= -1;
                this.xposision += move;
            }

        }

        else if (random1==1){
            if (this.yposision+move<=5 && this.yposision+move>=0){
                this.yposision+=move;
                //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            }else {
                move *= -1;
                this.yposision += move;
            }

        }
    }
}
