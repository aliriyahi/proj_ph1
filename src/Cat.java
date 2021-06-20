import java.util.Random;

public class Cat {
    Random rand = new Random();

    public String name;
    public int price=150;
    public int xposision= Math.abs(rand.nextInt()%6);
    public int yposision= Math.abs(rand.nextInt()%6);
    public int speed=1;
    public void animalmove(int[][][] homeproduct){
        double temp = 50;
        int x=0;
        int y=0;
        boolean b=false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 12; k++) {
                    if (homeproduct[i][j][k]!=0){
                        b=true;
                        if (Math.sqrt((j-this.xposision)*(j-this.xposision)+(i-this.yposision)*(i-this.yposision))<temp){
                            temp=Math.sqrt((j-this.xposision)*(j-this.xposision)+(i-this.yposision)*(i-this.yposision));
                            x=j;
                            y=i;
                        }
                    }
                }
            }
        }
        if (b){
            if (xposision>x)
                xposision-=speed;
            else if (xposision<x)
                xposision+=speed;
            else if (xposision==x){
                if (yposision>y)
                    yposision-=speed;
                else if (yposision<y)
                    yposision+=speed;
            }
        }
        else {
            int random= Math.abs(rand.nextInt()%2);
            if (random==0)
                random=1;
            else if (random==1)
                random=-1;
            int move=random*this.speed;
            int random1= Math.abs(rand.nextInt()%2);

            if (random1==0){
                if (this.xposision+move<=5 && this.xposision+move>=0){
                    this.xposision+=move;
                }else {
                    move *= -1;
                    this.xposision += move;
                }

            }

            else if (random1==1){
                if (this.yposision+move<=5 && this.yposision+move>=0){
                    this.yposision+=move;
                }else {
                    move *= -1;
                    this.yposision += move;
                }

            }
        }

    }
    //public int[][] nearestprod(int[][][] homeproduct ){

    //}


}
