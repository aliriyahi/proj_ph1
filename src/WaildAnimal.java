public class WaildAnimal {
    public String animalname;
    private int speed;
    public int xposision;
    public int yposision;
    public int cages;
    private void animalmove(){
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
}
