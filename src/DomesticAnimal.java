import java.util.Random;

public class DomesticAnimal {
        Random rand = new Random();

        public String animalName;
        public int animalPrice;
        public int animalHealth=100;
        public int timeToProduce;
        public int turnTime;
        public int prodRemoveTime1 = 0;
        public int prodRemoveTime2 = 0;
        public String product;
        public int speed=1;
        public int xposision = Math.abs(rand.nextInt()%6);
        public int yposision = Math.abs(rand.nextInt()%6);

        public void animalmove(){
            int random= Math.abs(rand.nextInt()%2);
            if (random==0)
                random=1;
            else if (random==1)
                random=-1;
            int move=random*this.speed;
            int random1 = Math.abs(rand.nextInt()%2);

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
        public void animalmove(int x , int y){
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
        public int[][] foodneed(int[][] grassposision){
            double temp=50;
            int[][] returnvalue=new int[2][1];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (grassposision[i][j]>0){
                        if (Math.sqrt((j-this.xposision)*(j-this.xposision)+(i-this.yposision)*(i-this.yposision))<temp){
                            temp=Math.sqrt((j-this.xposision)*(j-this.xposision)+(i-this.yposision)*(i-this.yposision));
                            returnvalue[0][0]=j;
                            returnvalue[1][0]=i;
                        }
                    }
                }
            }
            return returnvalue;
        }

    }


