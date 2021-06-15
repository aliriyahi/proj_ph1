import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Printinformation {
    public void turns(int turns){
        System.out.println("CURRENT TIME = "+ turns);
    }
    public void grass(int[][] grass){
        for (int i = 0; i <6 ; i++) {
            System.out.print("(");
            for (int j = 0; j < 6; j++) {
                if (j!=5)
                    System.out.print(grass[i][j]+" , ");
                else
                    System.out.print(grass[i][j]);
            }
            System.out.println(")");

        }
    }
    public void domAnimal(DomesticAnimal[] animals){
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].animalName+ " " + animals[i].animalHealth+ " " + "["+ animals[i].xposision + " "+ animals[i].yposision+"]");
        }
    }
    public void wildAnimal(WildAnimal[] animals){
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].animalname + " " + animals[i].cages + "["+animals[i].xposision +" "+ animals[i].yposision+ "]");
        }
    }
    public void dog(Dog[] animals){
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].name+" "+"["+animals[i].xposision+" "+animals[i].yposision+"]");

        }
    }
    public void cat(Cat[] animals){
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].name+" "+"["+animals[i].xposision+" "+animals[i].yposision+"]");

        }
    }
    public void task(int leve,DomesticAnimal[] domanimals){
        try {

            if (leve==1){
                int counter=0;
                System.out.println("Egg : "+Storage.egg+"/2");
                for (int i = 0; i < domanimals.length; i++) {
                    if (domanimals[i].animalName.equals("chicken")){
                        counter++;
                    }

                }
                System.out.println("Chickens : "+ counter+"/2");
                System.out.println("Coins : "+ Storage.coin+"/500");
            }
            else if (leve==2){

            }
            else if (leve==3){

            }
            else if (leve==4){

            }

        }catch (Exception e){
            System.out.println(e);
        }



    }



}
