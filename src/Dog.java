public class Dog {
    public String name;
    public int price=100;
    public int xposision=(int)Math.random()%6;
    public int yposision=(int)Math.random()%6;
    public int speed=1;
    public void animalmove(){
        int random= (int) (Math.random()%2);
        if (random==0)
            random=1;
        else if (random==1)
            random=-1;
        int move=random*this.speed;
        int random1=(int)Math.random()%2;

        if (random1==0){
            if (this.xposision+move<=5 && this.xposision+move>=0){
                this.xposision+=move;
            }
            move*=-1;
            this.xposision+=move;

        }

        else if (random1==1){
            if (this.yposision+move<=5 && this.yposision+move>=0){
                this.yposision+=move;
            }
            move*=-1;
            this.yposision+=move;

        }
    }
}
