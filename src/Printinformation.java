import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    public void domAnimal(ArrayList<DomesticAnimal> animals){
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).animalName+ " " + animals.get(i).animalHealth+ " " + "["+ animals.get(i).xposision + " "+ animals.get(i).yposision+"]");
        }
    }
    public void wildAnimal(ArrayList<WildAnimal> animals){
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).animalname + " " + animals.get(i).cages + "["+animals.get(i).xposision +" "+ animals.get(i).yposision+ "]");
        }
    }
    public void dog(ArrayList<Dog> animals){
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).name+" "+"["+animals.get(i).xposision+" "+animals.get(i).yposision+"]");

        }
    }
    public void cat(ArrayList<Cat> animals){
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i).name+" "+"["+animals.get(i).xposision+" "+animals.get(i).yposision+"]");

        }
    }
    public void homeProduct(int[][][] homeProduct){
        int temp=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 12; k++) {
                    if(homeProduct[i][j][k] != 0){
                        temp = homeProduct[i][j][k]/10;
                        if(temp == 1)
                            System.out.println("Egg ["+j+" "+i+"]");
                        else if(temp == 2)
                            System.out.println("Feather ["+j+" "+i+"]");
                        else if(temp == 3)
                            System.out.println("Milk ["+j+" "+i+"]");
                        else if(temp == 4)
                            System.out.println("Flour ["+j+" "+i+"]");
                        else if(temp == 5)
                            System.out.println("Fabric ["+j+" "+i+"]");
                        else if(temp == 6)
                            System.out.println("PackMilk ["+j+" "+i+"]");
                        else if(temp == 7)
                            System.out.println("Bread ["+j+" "+i+"]");
                        else if(temp == 8)
                            System.out.println("Cloths ["+j+" "+i+"]");
                        else if(temp == 9)
                            System.out.println("Icecream ["+j+" "+i+"]");
                    }

                }

            }

        }
    }


    public void task(int level , ArrayList<DomesticAnimal> domesticAnimals){
        String tasks = null;
        int chicken =0,turkey=0,buffalo=0;
        for (int i = 0; i < domesticAnimals.size(); i++) {
            if(domesticAnimals.get(i).animalName.equals("chicken")){
                chicken ++;
            }else if(domesticAnimals.get(i).animalName.equals("turkey")){
                turkey ++;
            } else if(domesticAnimals.get(i).animalName.equals("buffalo")){
                buffalo ++;
            }
        }




        try {
            File missions = new File("missions.txt");
            Scanner s = new Scanner(missions);
            while (s.hasNextLine()){
                String temp = s.nextLine();
                if (temp.contains("level "+ level)){
                    tasks=s.nextLine().substring(6);
                    tasks=s.nextLine().substring(6);
                }

            }
            s.close();
        }catch (Exception e){
            System.out.println(e);
        }

        String[] task1 = tasks.split("\\s");
        for (int i = 0; i < task1.length; i++) {
            if(task1[i].equals("egg")){
                System.out.println("Egg : "+Storage.totalegg+"/"+task1[i-1]);
            }
            else if(task1[i].equals("feather")){
                System.out.println("Feather : "+Storage.totalfeather+"/"+task1[i-1]);
            }
            else if(task1[i].equals("milk")){
                System.out.println("Milk : "+Storage.totalmilk+"/"+task1[i-1]);
            }
            else if(task1[i].equals("flour")){
                System.out.println("Flour : "+Storage.totalflour+"/"+task1[i-1]);
            }
            else if(task1[i].equals("fabric")){
                System.out.println("Fabric : "+Storage.totalfabric+"/"+task1[i-1]);
            }
            else if(task1[i].equals("packmilk")){
                System.out.println("PackMilk : "+Storage.totalpackmilk+"/"+task1[i-1]);
            }
            else if(task1[i].equals("bread")){
                System.out.println("Bread : "+Storage.totalbread+"/"+task1[i-1]);
            }
            else if(task1[i].equals("cloths")){
                System.out.println("Cloths : "+Storage.totalcloths+"/"+task1[i-1]);
            }
            else if(task1[i].equals("icecream")){
                System.out.println("Icecream : "+Storage.totalicecream+"/"+task1[i-1]);
            }
            else if(task1[i].equals("coin")){
                System.out.println("Coin : "+Storage.coin+"/"+task1[i-1]);
            }
            else if(task1[i].equals("chicken")){

                System.out.println("Chicken : "+chicken+"/"+task1[i-1]);
            }
            else if(task1[i].equals("turkey")){
                System.out.println("Turkey : "+turkey+"/"+task1[i-1]);
            }
            else if(task1[i].equals("buffalo")){
                System.out.println("Buffalo : "+buffalo+"/"+task1[i-1]);
            }
        }
    }



}
