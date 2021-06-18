
    public class DomesticAnimal {
        public String animalName;
        public int animalPrice;
        public int animalHealth=100;
        public int timeToProduce;
        public int turnTime;
        public String product;
        public int speed=1;
        public int xposision=(int)Math.random()%6+1;
        public int yposision=(int)Math.random()%6+1;

        public void animalmove(){
            int random= (int) (Math.random()%2);
            if (random==0)
                random=1;
            else if (random==1)
                random=-1;
            int move=random*this.speed;

            if (this.xposision+move<=6 && this.xposision+move>=1){
                this.xposision+=move;

            }
            else if (this.yposision+move<=6 && this.yposision+move>=1){
                this.yposision+=random;
            }
            else {
                move*=-1;
                if (this.xposision+move<=6 && this.xposision+move>=1){
                    this.xposision+=move;

                }
                else if (this.yposision+move<=6 && this.yposision+move>=1){
                    this.yposision+=random;
                }
            }
        }
        private int[][] foodneed(int[][] grassposision){
            int temp=50;
            int[][] returnvalue=new int[2][1];

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (grassposision[i][j]>0){
                        if (Math.abs(i-this.xposision)+Math.abs(j-this.yposision)<temp){
                            temp=Math.abs(i-this.xposision)+Math.abs(j-this.yposision);
                            returnvalue[0][0]=i;
                            returnvalue[1][0]=j;
                        }


                    }


                }

            }
            return returnvalue;



        }

    }


