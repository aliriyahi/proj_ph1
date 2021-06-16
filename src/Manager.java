import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.SortedMap;

public class Manager {
    int turn = 0;
    int level = 0;
    int startCoin;
    String tasks;
    String wildanimals;
    int timeprize;
    int prize;
    public Manager(int level){
        this.level = level;

    }
    public void filereader(){
        try {
            File missions = new File("missions.txt");
            Scanner s = new Scanner(missions);
            while (s.hasNextLine()){
                String temp = s.nextLine();
                if (temp.contains("level "+this.level)){
                    this.startCoin=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.tasks=s.nextLine().substring(6);
                    this.wildanimals=s.nextLine().substring(8);
                    this.timeprize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.prize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    break;

                }
            }

            
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void run(){
        ArrayList<DomesticAnimal> domanimals = new ArrayList();
        ArrayList<WildAnimal> wildAnimals = new ArrayList();
        ArrayList<Dog> dogs = new ArrayList();
        ArrayList<Cat> cats = new ArrayList();
        Car car;
        Mill mill;
        Bakery bakery;
        PackMilk packMilk;
        IceStore iceStore;
        Tailoring tailoring;
        ProdFabric prodFabric;
        Well well=new Well();
        int[][][] homeProduct=new int[6][6][6];
        int[][] grass=new int[6][6];

        Scanner sc = new Scanner(System.in);
        String command = null;

        while (!command.contains("EXIT")){
            command=sc.nextLine();
            if (command.toUpperCase().startsWith("BUY")){
                if (command.toLowerCase().contains("cat")){
                    Cat cat = new Cat();
                    cats.add(cat);
                }
                else if (command.toLowerCase().contains("dog")){
                    Dog dog = new Dog();
                    dogs.add(dog);

                }
                else if (command.toLowerCase().contains("chicken")){
                    DomesticAnimal domesticAnimal = new DomesticAnimal();
                    domesticAnimal.animalName="chicken";
                    domesticAnimal.animalPrice=100;
                    domesticAnimal.product="egg";
                    domesticAnimal.timeToProduce=2;
                    domanimals.add(domesticAnimal);

                }
                else if (command.toLowerCase().contains("turkey")){
                    DomesticAnimal domesticAnimal = new DomesticAnimal();
                    domesticAnimal.animalName="turkey";
                    domesticAnimal.animalPrice=200;
                    domesticAnimal.product="feather";
                    domesticAnimal.timeToProduce=3;
                    domanimals.add(domesticAnimal);

                }
                else if (command.toLowerCase().contains("buffalo")){
                    DomesticAnimal domesticAnimal = new DomesticAnimal();
                    domesticAnimal.animalName="buffalo";
                    domesticAnimal.animalPrice=400;
                    domesticAnimal.product="milk";
                    domesticAnimal.timeToProduce=5;
                    domanimals.add(domesticAnimal);

                }

            }
            else if (command.toUpperCase().startsWith("PICKUP")){
                int x= Integer.parseInt(command.split("\\s")[1]);
                int y= Integer.parseInt(command.split("\\s")[2]);
                boolean error=true;
                for (int i = 0; i < 6; i++) {
                    if (homeProduct[y][x][i]>0){
                        error=false;
                        int temp = homeProduct[y][x][i];
                        if (temp/10==1){
                            Storage.add("egg",temp%10);
                        }
                        else if (temp/10==2){
                            Storage.add("feather",temp%10);
                        }
                        else if (temp/10==3){
                            Storage.add("milk",temp%10);
                        }
                        else if (temp==4){
                            Storage.add("loin",1);
                        }
                        else if (temp==5){
                            Storage.add("bear",1);
                        }
                        else if (temp==6){
                            Storage.add("tiger",1);
                        }


                    }
                }
                if (error==true)
                    System.out.println("there is no product here!");

            }
            else if (command.toUpperCase().startsWith("WELL")){
                well.water=5;
            }
            else if (command.toUpperCase().startsWith("PLANT")){
                int x=Integer.parseInt(command.split("\\s")[1]);
                int y=Integer.parseInt(command.split("\\s")[2]);
                grass[y][x]+=1;
            }
            else if (command.toUpperCase().startsWith("WORK")){
                if (command.toLowerCase().contains("mill")){
                    if (Storage.egg==0)
                        System.out.println("there is no egg in the storage!");

                }
                else if (command.toLowerCase().contains("bakery")){
                    if (Storage.flour==0)
                        System.out.println("there is no flour in the storage!");

                }
                else if (command.toLowerCase().contains("packmilk")){
                    if (Storage.milk==0)
                        System.out.println("there is no milk in the storage!");

                }
                else if (command.toLowerCase().contains("prodfabric")){
                    if (Storage.fabric==0)
                        System.out.println("there is no fabric in the storage!");

                }
                else if (command.toLowerCase().contains("icestore")){
                    if (Storage.packMilk==0)
                        System.out.println("there ");

                }
                else if (command.toLowerCase().contains("tailoring")){

                }

            }
            else if (command.toUpperCase().startsWith("CAGE")){

            }
            else if (command.toUpperCase().startsWith("BUILD")){
                if (command.toLowerCase().contains("mill")){
                    mill = new Mill();
                    if (mill.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("bakery")){
                    bakery = new Bakery();
                    if (bakery.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("packmilk")){
                    packMilk=new PackMilk();
                    if (packMilk.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("prodfabric")){
                    prodFabric=new ProdFabric();
                    if (prodFabric.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("icestore")){
                    iceStore = new IceStore();
                    if (iceStore.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("tailoring")){
                    tailoring = new Tailoring();
                    if (tailoring.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }

            }
            else if (command.toUpperCase().startsWith("TRUCK LOAD")){

            }
            else if (command.toUpperCase().startsWith("TRUCK UNLOAD")){

            }
            else if (command.toUpperCase().startsWith("TRUCK GO")){

            }
            else if (command.toUpperCase().startsWith("inquiry")){

            }
            else if (command.toUpperCase().startsWith("TURN")){

            }

        }

//        //DomesticAnimal[] domesticAnimal = new DomesticAnimal[30];
//        //domesticAnimal = new DomesticAnimal[1];
//        domesticAnimal[0] = new DomesticAnimal();
//        domesticAnimal[1] = new DomesticAnimal();
//        domesticAnimal[0].animalHealth = 2;
//        //domesticAnimal = new DomesticAnimal[1];
//        domesticAnimal[0].animalName = "d";
//        domesticAnimal[1].animalName = "k";
//        System.out.println(domesticAnimal[0].animalName);

    }

}
