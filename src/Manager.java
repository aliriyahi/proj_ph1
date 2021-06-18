import javax.swing.*;
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
    String[] wildTn ;



    public Manager(int level){
        this.level = level;

    }




    public void run(){

        ArrayList<DomesticAnimal> domanimals = new ArrayList();
        ArrayList<WildAnimal> wildAnimals = new ArrayList();
        ArrayList<Dog> dogs = new ArrayList();
        ArrayList<Cat> cats = new ArrayList();
        Printinformation printinformation = new Printinformation();
        Car car = new Car();
        Mill mill = new Mill();
        Bakery bakery = new Bakery();
        PackMilk packMilk = new PackMilk();
        IceStore iceStore = new IceStore();
        Tailoring tailoring = new Tailoring();
        ProdFabric prodFabric = new ProdFabric();
        Well well=new Well();
        int[][][] homeProduct=new int[6][6][12];
        int[][] grass=new int[6][6];
        int millTime=0,bakeryTime=0,iceStoreTime=0,tailoringTime=0,packmilkTime=0,prodfabricTime=0;
        int truckTime = 0;
        int chickenTime=0,turkeyTime=0,buffaloTime=0;


        Scanner sc = new Scanner(System.in);
        String command = "a";


        //__________________________________________________________________________
        while (!command.contains("EXIT")){
            command = sc.nextLine();

            if (command.toUpperCase().startsWith("BUY")){
                if (command.toLowerCase().contains("cat")){
                    Cat cat = new Cat();
                    if(cat.price <= Storage.coin){
                        cats.add(cat);
                        Storage.coin -= cat.price;
                        System.out.println("done");
                    }else
                        System.out.println("you dont have enough coin!");

                }
                else if (command.toLowerCase().contains("dog")){
                    Dog dog = new Dog();
                    if(dog.price <= Storage.coin){
                        dogs.add(dog);
                        Storage.coin -= dog.price;
                        System.out.println("done");
                    }else
                        System.out.println("you dont have enough coin!");

                }
                else if (command.toLowerCase().contains("chicken")){
                    if(100 <= Storage.coin) {
                        DomesticAnimal domesticAnimal = new DomesticAnimal();
                        domesticAnimal.animalName = "chicken";
                        domesticAnimal.animalPrice = 100;
                        domesticAnimal.product = "egg";
                        domesticAnimal.timeToProduce = 2;
                        domesticAnimal.turnTime = turn + domesticAnimal.timeToProduce;
                        domanimals.add(domesticAnimal);

                        Storage.coin -= 100;
                        System.out.println("done");
                    }else
                        System.out.println("you dont have enough coin!");
                }
                else if (command.toLowerCase().contains("turkey")){
                    if(200 <= Storage.coin) {
                        DomesticAnimal domesticAnimal = new DomesticAnimal();
                        domesticAnimal.animalName = "turkey";
                        domesticAnimal.animalPrice = 200;
                        domesticAnimal.product = "feather";
                        domesticAnimal.timeToProduce = 3;
                        domesticAnimal.turnTime = turn + domesticAnimal.timeToProduce;
                        domanimals.add(domesticAnimal);
                        Storage.coin -= 200;
                        System.out.println("done");
                    }else
                        System.out.println("you dont have enough coin!");

                }
                else if (command.toLowerCase().contains("buffalo")){
                    if(400 <= Storage.coin) {
                        DomesticAnimal domesticAnimal = new DomesticAnimal();
                        domesticAnimal.animalName = "buffalo";
                        domesticAnimal.animalPrice = 400;
                        domesticAnimal.product = "milk";
                        domesticAnimal.timeToProduce = 5;
                        domesticAnimal.turnTime = turn + domesticAnimal.timeToProduce;
                        domanimals.add(domesticAnimal);
                        Storage.coin -= 400;
                        System.out.println("done");
                    }else
                        System.out.println("you dont have enough coin!");

                }

            }
            //-------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("PICKUP")){
                int x= Integer.parseInt(command.split("\\s")[1])-1;
                int y= Integer.parseInt(command.split("\\s")[2])-1;
                boolean error=true;
                for (int i = 0; i < 12; i++) {
                    if (homeProduct[y][x][i]>0){
                        error=false;
                        int temp = homeProduct[y][x][i];
                        if (temp/10==1){
                            boolean b = Storage.add("egg",temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if (temp/10==2){
                            boolean b = Storage.add("feather",temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if (temp/10==3){
                            boolean b = Storage.add("milk",temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if (temp==4){

                            boolean b = Storage.add("loin",1);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if (temp==5){
                            boolean b = Storage.add("bear",1);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if (temp==6){
                            boolean b = Storage.add("tiger",1);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if(temp/10 == 4){
                             boolean b = mill.pick(temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if(temp/10 == 5){
                            boolean b = prodFabric.pick(temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if(temp/10 == 6){
                            boolean b = packMilk.pick(temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if(temp/10 == 7){
                            boolean b = bakery.pick(temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if(temp/10 == 8){
                            boolean b = tailoring.pick(temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }
                        else if(temp/10 == 9){
                            boolean b = iceStore.pick(temp%10);
                            if(b)
                                homeProduct[y][x][i] = 0;
                            else
                                System.out.println("Storage have not enough space!");
                        }

                    }
                }
                if (error==true)
                    System.out.println("there is no product here!");

            }
            //---------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("WELL")){
                if(well.water == 0)
                    well.water=5;
                else
                    System.out.println("there is still water");
            }
            //---------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("PLANT")){
                int x=Integer.parseInt(command.split("\\s")[1])-1;
                int y=Integer.parseInt(command.split("\\s")[2])-1;
                if(well.water > 0) {
                    grass[y][x] += 1;
                    well.water -= 1;
                }
                else
                    System.out.println("you dont have any water!");
            }
            //---------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("WORK")){
                if (command.toLowerCase().contains("mill")){
                    if (Storage.egg==0)
                        System.out.println("there is no egg in the storage!");
                    else {
                        if(millTime == 0)
                            millTime = turn + mill.unitTime;
                        else
                            System.out.println("Still working...");

                    }

                }
                else if (command.toLowerCase().contains("bakery")){
                    if (Storage.flour==0)
                        System.out.println("there is no flour in the storage!");
                    else {
                        if(bakeryTime == 0)
                            bakeryTime = turn + bakery.unitTime;
                        else
                            System.out.println("Still working...");
                    }

                }
                else if (command.toLowerCase().contains("packmilk")){
                    if (Storage.milk==0)
                        System.out.println("there is no milk in the storage!");
                    else {
                        if(packmilkTime == 0)
                            packmilkTime = turn + packMilk.unitTime;
                        else
                            System.out.println("Still working...");
                    }

                }
                else if (command.toLowerCase().contains("prodfabric")){
                    if (Storage.feather==0)
                        System.out.println("there is no feather in the storage!");
                    else {
                        if(prodfabricTime == 0)
                            prodfabricTime = turn + prodFabric.unitTime;
                        else
                            System.out.println("Still working...");
                    }

                }
                else if (command.toLowerCase().contains("icestore")){
                    if (Storage.packMilk==0)
                        System.out.println("there is no packmilk in the storage!");
                    else {
                        if(iceStoreTime == 0)
                            iceStoreTime = turn + iceStore.unitTime;
                        else
                            System.out.println("Still working...");
                    }

                }
                else if (command.toLowerCase().contains("tailoring")){
                    if (Storage.fabric==0)
                        System.out.println("there is no fabric in the storage!");
                    else {
                        if(tailoringTime == 0)
                            tailoringTime = turn + tailoring.unitTime;
                        else
                            System.out.println("Still working...");
                    }

                }

            }
            //-----------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("UPGRADE")){
                if (command.toLowerCase().contains("mill")){
                    mill.upgrade(Integer.parseInt(command.split("\\s")[2]));
                }
                else if (command.toLowerCase().contains("bakery")){
                    bakery.upgrade(Integer.parseInt(command.split("\\s")[2]));
                }
                else if (command.toLowerCase().contains("packmilk")){
                    packMilk.upgrade(Integer.parseInt(command.split("\\s")[2]));
                }
                else if (command.toLowerCase().contains("prodfabric")){
                    prodFabric.upgrade(Integer.parseInt(command.split("\\s")[2]));
                }
                else if (command.toLowerCase().contains("icestore")){
                    iceStore.upgrade(Integer.parseInt(command.split("\\s")[2]));
                }
                else if (command.toLowerCase().contains("tailoring")){
                    tailoring.upgrade(Integer.parseInt(command.split("\\s")[2]));
                }

            }
            //------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("BUILD")){
                if (command.toLowerCase().contains("mill")){
                    mill.build();
                    if (mill.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("bakery")){
                    bakery.build();
                    if (bakery.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("packmilk")){
                    packMilk.build();
                    if (packMilk.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("prodfabric")){
                    prodFabric.build();
                    if (prodFabric.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("icestore")){
                    iceStore.build();
                    if (iceStore.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }
                else if (command.toLowerCase().contains("tailoring")){
                    tailoring.build();
                    if (tailoring.exist==false)
                        System.out.println("YOU DO NOT HAVE ENOUGH COIN!");

                }

            }
            //--------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("CAGE")){
                int x = Integer.parseInt(command.split("\\s")[1])-1;
                int y = Integer.parseInt(command.split("\\s")[2])-1;
                boolean temp = true;
                for (int i = 0; i < wildAnimals.size(); i++) {
                    if(wildAnimals.get(i).xposision == x && wildAnimals.get(i).yposision == y){
                        temp = false;
                        wildAnimals.get(i).cages +=1;
                        break;
                    }
                }
                if(temp == true)
                    System.out.println("There is no wild animal there!");

            }
            //--------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("TRUCK LOAD")){

                String name = command.toLowerCase().split("\\s")[2];
                if (truckTime==0){
                    boolean temp = car.load(name , 1);
                    if(temp == false)
                        System.out.println("Car does not have space!");
                }


            }
            //--------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("TRUCK UNLOAD")){
                String name = command.toLowerCase().split("\\s")[2];
                if (truckTime==0){
                    boolean temp = car.unload(name , 1);
                    if(temp == false)
                        System.out.println("Car does not have such staff!");
                }


            }
            //--------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("TRUCK GO")){
                if(truckTime == 0)
                    truckTime = turn + car.time;
                else
                    System.out.println("Car is on the road...");

            }
            //--------------------------------------------------------------------------------
            else if (command.toLowerCase().startsWith("inquiry")){
                printinformation.turns(turn);
                printinformation.grass(grass);
                printinformation.domAnimal(domanimals);
                printinformation.wildAnimal(wildAnimals);
                printinformation.cat(cats);
                printinformation.dog(dogs);
                printinformation.homeProduct(homeProduct);
                printinformation.task(level,domanimals);


            }
            //--------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("TURN")){
                int n = Integer.parseInt(command.split("\\s")[1]);

                for (int i = 0; i < n; i++) {
                    turn ++;
                    //--------------------------------------------------------- handling movement

                    for (int j = 0; j < wildAnimals.size(); j++) {
                        wildAnimals.get(i).animalmove();
                    }
                    for (int j = 0; j < cats.size(); j++) {
                        cats.get(i).animalmove(homeProduct);
                    }
                    for (int j = 0; j < dogs.size(); j++) {
                        dogs.get(i).animalmove();
                    }

                    //-------------------------------------------------------- handling products

                    for (int j = 0; j < domanimals.size(); j++) {
                        if(turn >= domanimals.get(i).turnTime){
                            if(domanimals.get(i).animalName.equals("chicken")){
                                domanimals.get(i).turnTime += domanimals.get(i).timeToProduce;
                                if(homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] == 0)
                                    homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] = 11;
                                else
                                    homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] += 1;
                            }else if(domanimals.get(i).animalName.equals("turkey")){
                                domanimals.get(i).turnTime += domanimals.get(i).timeToProduce;
                                if(homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] == 0)
                                    homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] = 21;
                                else
                                    homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] += 1;
                            }else if(domanimals.get(i).animalName.equals("buffalo")){
                                domanimals.get(i).turnTime += domanimals.get(i).timeToProduce;
                                if(homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] == 0)
                                    homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] = 31;
                                else
                                    homeProduct[domanimals.get(i).yposision][domanimals.get(i).xposision][0] += 1;
                            }
                        }
                    }
                    //----------------------------------------------------------- handling wildAnimals
                    for (int j = 0; j < wildTn.length - 1; j++) {
                        if(wildTn[i].toLowerCase().equals("lion")){
                            if(turn >= Integer.parseInt(wildTn[i+1])) {
                                WildAnimal wildAnimal = new WildAnimal();
                                wildAnimal.speed = 1;
                                wildAnimal.maxCage = 3;
                                wildAnimals.add(wildAnimal);
                            }
                        }
                        else if(wildTn[i].toLowerCase().equals("bear")){
                            if(turn >= Integer.parseInt(wildTn[i+1])) {
                                WildAnimal wildAnimal = new WildAnimal();
                                wildAnimal.speed = 1;
                                wildAnimal.maxCage = 4;
                                wildAnimals.add(wildAnimal);
                            }
                        }
                        else if(wildTn[i].toLowerCase().equals("tiger")){
                            if(turn >= Integer.parseInt(wildTn[i+1])) {
                                WildAnimal wildAnimal = new WildAnimal();
                                wildAnimal.speed = 2;
                                wildAnimal.maxCage = 4;
                                wildAnimals.add(wildAnimal);
                            }
                        }
                    }
                    //--------------------------------------------------------------------------handling second products
                    if (turn>= millTime && millTime!=0){
                        mill.run();
                        if (homeProduct[(int)Math.random()%6][(int)Math.random()%6][6]==0)
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][6]=41;
                        else
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][6]++;
                        millTime=0;

                    }
                    if (turn>= prodfabricTime&& prodfabricTime!=0){
                        prodFabric.run();
                        if (homeProduct[(int)Math.random()%6][(int)Math.random()%6][7]==0)
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][7]=51;
                        else
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][7]++;
                        prodfabricTime=0;

                    }
                    if (turn>=packmilkTime  && packmilkTime!=0){
                        packMilk.run();
                        if (homeProduct[(int)Math.random()%6][(int)Math.random()%6][8]==0)
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][8]=61;
                        else
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][8]++;
                        packmilkTime=0;

                    }
                    if (turn>= bakeryTime && bakeryTime!=0){
                        bakery.run();
                        if (homeProduct[(int)Math.random()%6][(int)Math.random()%6][9]==0)
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][9]=71;
                        else
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][9]++;
                        bakeryTime=0;

                    }
                    if (turn>= tailoringTime && tailoringTime!=0){
                        tailoring.run();
                        if (homeProduct[(int)Math.random()%6][(int)Math.random()%6][10]==0)
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][10]=81;
                        else
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][10]++;
                        tailoringTime=0;

                    }
                    if (turn>= iceStoreTime && iceStoreTime!=0){
                        iceStore.run();
                        if (homeProduct[(int)Math.random()%6][(int)Math.random()%6][11]==0)
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][11]=91;
                        else
                            homeProduct[(int)Math.random()%6][(int)Math.random()%6][11]++;
                        iceStoreTime=0;

                    }
                    //------------------------------------------------------------- grass check
                    int grasscheck=0;
                    for (int j = 0; j < 6; j++) {
                        for (int k = 0; k < 6; k++) {
                            if (grass[i][j]!=0)
                                grasscheck=1;
                        }

                    }
                    if (grasscheck==0)
                        System.out.println("there is no grass !");
                    //--------------------------------------------------------------- cage check
                    for (int j = 0; j < 6; j++) {
                        if (wildAnimals.get(j).cages>=wildAnimals.get(j).maxCage){
                            if (wildAnimals.get(j).animalname.equals("loin")){
                                homeProduct[wildAnimals.get(j).yposision][wildAnimals.get(j).xposision][3]=4;
                            }
                            else if (wildAnimals.get(j).animalname.equals("bear")){
                                homeProduct[wildAnimals.get(j).yposision][wildAnimals.get(j).xposision][4]=5;
                            }
                            else if (wildAnimals.get(j).animalname.equals("tiger")){
                                homeProduct[wildAnimals.get(j).yposision][wildAnimals.get(j).xposision][5]=6;
                            }

                        }
                    }
                    //-----------------------------------------------handling truck
                    if (turn>=truckTime && truckTime!=0){
                        car.sell();
                        truckTime=0;
                    }
                    //---------------------------------------------------- health reduce
                    for (int j = 0; j < domanimals.size(); j++) {
                        domanimals.get(j).animalHealth-=10;
                    }
                    //---------------------------------------------------------------- animal move(food need)
                    for (int j = 0; j < domanimals.size(); j++) {
                        if(domanimals.get(j).animalHealth<=50){
                            domanimals.get(j).animalmove(domanimals.get(j).foodneed(grass)[0][0] , domanimals.get(j).foodneed(grass)[1][0]);

                        }
                        else if (domanimals.get(j).animalHealth>50)
                            domanimals.get(j).animalmove();

                    }
                    //------------------------------------------------------ eating grass
                    for (int j = 0; j <domanimals.size(); j++) {
                        if (domanimals.get(j).animalHealth==10){
                            if (grass[domanimals.get(j).yposision][domanimals.get(j).xposision]!=0){
                                domanimals.get(j).animalHealth=100;
                                grass[domanimals.get(j).yposision][domanimals.get(j).xposision]-=1;
                            }
                        }
                        else if (domanimals.get(j).animalHealth==20){
                            if (grass[domanimals.get(j).yposision][domanimals.get(j).xposision]!=0){
                                domanimals.get(j).animalHealth=100;
                                grass[domanimals.get(j).yposision][domanimals.get(j).xposision]-=1;
                            }
                        }
                        else if (domanimals.get(j).animalHealth==30){
                            if (grass[domanimals.get(j).yposision][domanimals.get(j).xposision]!=0){
                                domanimals.get(j).animalHealth=100;
                                grass[domanimals.get(j).yposision][domanimals.get(j).xposision]-=1;
                            }
                        }
                        else if (domanimals.get(j).animalHealth==40){
                            if (grass[domanimals.get(j).yposision][domanimals.get(j).xposision]!=0){
                                domanimals.get(j).animalHealth=100;
                                grass[domanimals.get(j).yposision][domanimals.get(j).xposision]-=1;
                            }
                        }
                        else if (domanimals.get(j).animalHealth==50){
                            if (grass[domanimals.get(j).yposision][domanimals.get(j).xposision]!=0){
                                domanimals.get(j).animalHealth=100;
                                grass[domanimals.get(j).yposision][domanimals.get(j).xposision]-=1;
                            }
                        }

                    }
                    //---------------------------------------------------------------- dog wild killer
                    for (int j = 0; j < dogs.size(); j++) {
                        for (int k = 0; k < wildAnimals.size(); k++) {
                            if (dogs.get(j).xposision==wildAnimals.get(k).xposision && dogs.get(j).yposision==wildAnimals.get(k).yposision){
                                wildAnimals.remove(k);
                                dogs.remove(j);
                            }
                        }
                    }
                    //---------------------------------------------------------------- wild dom killer
                    for (int j = 0; j < domanimals.size(); j++) {
                        for (int k = 0; k < wildAnimals.size(); k++) {
                            if (domanimals.get(j).xposision==wildAnimals.get(k).xposision && domanimals.get(j).yposision==wildAnimals.get(k).yposision){
                                domanimals.remove(j);
                            }
                        }
                    }
                    //----------------------------------------------------------------- kind cat

                    for (int j = 0; j < cats.size(); j++) {
                        for (int k = 0; k < 6; k++) {
                            for (int l = 0; l < 6; l++) {
                                for (int m = 0; m < 12; m++) {
                                    if (cats.get(j).xposision==l && cats.get(j).yposision==k){
                                        boolean z =false;
                                        if (homeProduct[k][l][m]/10==1){
                                            z=Storage.add("egg" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==2){
                                            z=Storage.add("feather" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==3){
                                            z=Storage.add("milk" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==4){
                                            z=Storage.add("flour" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==5){
                                            z=Storage.add("fabric" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==6){
                                            z=Storage.add("packmilk" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==7){
                                            z=Storage.add("bread" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==8){
                                            z=Storage.add("cloths" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                        else if (homeProduct[k][l][m]/10==9){
                                            z=Storage.add("icecream" , homeProduct[k][l][m]%10);
                                            if (z)
                                                homeProduct[k][l][m]=0;

                                        }
                                    }

                                }

                            }

                        }

                    }
                    //-------------------------------------------------------------------- final check
                    if (Storage.coin==)





                    //----------------------------------------------------------------------------------------
                }





                printinformation.turns(turn);
                printinformation.grass(grass);
                printinformation.domAnimal(domanimals);
                printinformation.wildAnimal(wildAnimals);
                printinformation.cat(cats);
                printinformation.dog(dogs);
                printinformation.homeProduct(homeProduct);
                printinformation.task(level,domanimals);
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



    public void filereader(){
        try {
            File missions = new File("missions.txt");
            Scanner s = new Scanner(missions);
            while (s.hasNextLine()){
                String temp = s.nextLine();
                if (temp.contains("level "+this.level)){
                    this.startCoin=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    Storage.coin = startCoin;
                    this.tasks=s.nextLine().substring(6);
                    this.wildanimals=s.nextLine().substring(8);
                    this.wildTn = wildanimals.split("\\s");

                    this.timeprize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.prize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    break;

                }
            }


        }catch (Exception e){
            System.out.println(e);
        }

    }

}
