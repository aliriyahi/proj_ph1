import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Manager {

    Random rand = new Random();
    int turn = 0;
    int level = 0;
    int startCoin;
    String tasks;
    String wildanimals;
    int timeprize;
    static int prize;
    int maxLevel;
    String[] wildTn ;
    String username , password;
    int previousCoin;
    File log = new File("log.txt");
    Date date = new Date();

    public Manager(int level){
        this.level = level;

    }




    public void run(){

        ArrayList<DomesticAnimal> domanimals = new ArrayList();
        ArrayList<WildAnimal> wildAnimals = new ArrayList();
        ArrayList<Dog> dogs = new ArrayList();
        ArrayList<Cat> cats = new ArrayList();
        ArrayList<Product> products = new ArrayList();
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
        int[] lionRemoveTime=new int[3],bearRemoveTime=new  int[3],tigerRemoveTime=new int[3];
        boolean Return = false;

        Scanner sc = new Scanner(System.in);
        String command = "a";



        //__________________________________________________________________________
        while (!command.contains("EXIT")){
            System.out.println("ENTER YOUR COMMAND :");
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
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",CAT BOUGHT SUCCESSFULLY");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }

                }
                else if (command.toLowerCase().contains("dog")){
                    Dog dog = new Dog();
                    if(dog.price <= Storage.coin){
                        dogs.add(dog);
                        Storage.coin -= dog.price;
                        System.out.println("done");
                    }else
                        System.out.println("you dont have enough coin!");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",DOG BOUGHT SUCCESSFULLY");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }

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
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",CHICKEN BOUGHT SUCCESSFULLY");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
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
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",TURKEY BOUGHT SUCCESSFULLY");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }

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
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",BUFFALO BOUGHT SUCCESSFULLY");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }

                }
                else{
                    System.out.println("wrong input!");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG INPUT");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
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
                            boolean b = Storage.add("lion",1);
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
                        try {
                            PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                            logger.append("[INFO] ,"+date.toLocaleString()+", PICKED UP SUCCESSFULLY");
                            logger.println();
                            logger.close();
                        }catch (Exception e){
                            System.out.println(e);
                        }

                    }
                }
                if (error==true){
                    System.out.println("there is no product here!");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[ERROR] ,"+date.toLocaleString()+",PICKUP FAILED");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }


            }
            //---------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("WELL")){
                if(well.water == 0){
                    well.water=5;
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",WELLED SUCCESSFULLY");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }

                else{
                    System.out.println("there is still water");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[ERROR] ,"+date.toLocaleString()+",WELL ERROR");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }

            }
            //---------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("PLANT")){
                if (command.split("\\s").length!=3){
                    System.out.println("wrong input!");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG INPUT");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }

                else {
                    int x=Integer.parseInt(command.split("\\s")[1])-1;
                    int y=Integer.parseInt(command.split("\\s")[2])-1;
                    if (x> 5|| x<0 || y>5 || y<0){
                        System.out.println("wrong input");
                        try {
                            PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                            logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG INPUT");
                            logger.println();
                            logger.close();
                        }catch (Exception e){
                            System.out.println(e);
                        }
                    }

                    else {
                        if(well.water > 0) {
                            grass[y][x] += 1;
                            well.water -= 1;
                            try {
                                PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                                logger.append("[INFO] ,"+date.toLocaleString()+",PLANTED SUCCESSFULLY");
                                logger.println();
                                logger.close();
                            }catch (Exception e){
                                System.out.println(e);
                            }
                        }
                        else
                            System.out.println("you dont have any water!");
                    }

                }

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
                if (command.split("\\s").length==3){
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",UPGRADED A WORKSHOP");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
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
                }else{
                    System.out.println("wrong input!");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG INPUT");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                }


            }
            //------------------------------------------------------------------------------
            else if (command.toUpperCase().startsWith("BUILD")){
                if (command.split("\\s").length==2){

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
                    else
                        System.out.println("wrong input!");
                }
                else
                    System.out.println("wrong input!");


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
                if (car.useSpace==0)
                    System.out.println("You should load the truck first!");
                else {
                    if(truckTime == 0 )
                        truckTime = turn + car.time;
                    else
                        System.out.println("Car is on the road...");
                }


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
                        if (wildAnimals.get(j).cages<wildAnimals.get(j).maxCage)
                            wildAnimals.get(j).animalmove();
                    }
                    for (int j = 0; j < cats.size(); j++) {
                        cats.get(j).animalmove(homeProduct);
                    }
                    for (int j = 0; j < dogs.size(); j++) {
                        dogs.get(j).animalmove();
                    }
                    //------------------------------------------------------- prod remove time
                    for (int j = 0; j < products.size(); j++) {
                        if (products.get(j).removetime <turn){
                            if (homeProduct[products.get(j).yposission][products.get(j).xposission][products.get(j).name]!=0)
                                homeProduct[products.get(j).yposission][products.get(j).xposission][products.get(j).name]--;
                            products.remove(j);
                        }
                    }
                    //-------------------------------------------------------- handling products

                    for (int j = 0; j < domanimals.size(); j++) {
                        if(turn >= domanimals.get(j).turnTime){
                            if(domanimals.get(j).animalName.equals("chicken")){
                                domanimals.get(j).turnTime += domanimals.get(j).timeToProduce;
                                Product product = new Product();
                                product.name=0;
                                product.xposission = domanimals.get(j).xposision;
                                product.yposission = domanimals.get(j).yposision;
                                product.existtime = 4;
                                product.removetime=turn+4;
                                products.add(product);
                                if(homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] == 0){
                                    homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] = 11;
                                }

                                else
                                    homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] += 1;
                            }
                            else if(domanimals.get(j).animalName.equals("turkey")){
                                domanimals.get(j).turnTime += domanimals.get(j).timeToProduce;
                                Product product = new Product();
                                product.name=1;
                                product.xposission = domanimals.get(j).xposision;
                                product.yposission = domanimals.get(j).yposision;
                                product.existtime = 4;
                                product.removetime=turn+4;
                                products.add(product);
                                if(homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] == 0)
                                    homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] = 21;
                                else
                                    homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] += 1;
                            }
                            else if(domanimals.get(j).animalName.equals("buffalo")){
                                domanimals.get(j).turnTime += domanimals.get(j).timeToProduce;
                                Product product = new Product();
                                product.name=2;
                                product.xposission = domanimals.get(j).xposision;
                                product.yposission = domanimals.get(j).yposision;
                                product.existtime = 4;
                                product.removetime=turn+4;
                                products.add(product);
                                if(homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] == 0)
                                    homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] = 31;
                                else
                                    homeProduct[domanimals.get(j).yposision][domanimals.get(j).xposision][0] += 1;
                            }
                        }
                    }
                    //----------------------------------------------------------- handling wildAnimals
                    for (int j = 0; j < wildTn.length - 1; j++) {
                        if(wildTn[j].toLowerCase().equals("lion")){
                            if(turn >= Integer.parseInt(wildTn[j+1])) {
                                WildAnimal wildAnimal = new WildAnimal();
                                wildAnimal.animalname = "lion";
                                wildAnimal.speed = 1;
                                wildAnimal.maxCage = 3;
                                wildAnimals.add(wildAnimal);
                                wildTn[j] = "a";
                            }
                        }
                        else if(wildTn[j].toLowerCase().equals("bear")){
                            if(turn >= Integer.parseInt(wildTn[j+1])) {
                                WildAnimal wildAnimal = new WildAnimal();
                                wildAnimal.animalname = "bear";
                                wildAnimal.speed = 1;
                                wildAnimal.maxCage = 4;
                                wildAnimals.add(wildAnimal);
                                wildTn[j] = "a";
                            }
                        }
                        else if(wildTn[j].toLowerCase().equals("tiger")){
                            if(turn >= Integer.parseInt(wildTn[j+1])) {
                                WildAnimal wildAnimal = new WildAnimal();
                                wildAnimal.animalname = "tiger";
                                wildAnimal.speed = 2;
                                wildAnimal.maxCage = 4;
                                wildAnimals.add(wildAnimal);
                                wildTn[j] = "a";
                            }
                        }
                    }
                    //--------------------------------------------------------------------------handling second products
                    if (turn>= millTime && millTime!=0){
                        mill.run();
                        int t1=Math.abs(rand.nextInt()%6);
                        int t2=Math.abs(rand.nextInt()%6);
                        Product product = new Product();
                        product.name =6;
                        product.xposission=t2;
                        product.yposission=t1;
                        product.existtime=5;
                        product.removetime=turn+product.existtime;
                        products.add(product);


                        if (homeProduct[t1][t2][6]==0)
                            homeProduct[t1][t2][6]=41;
                        else
                            homeProduct[t1][t2][6]++;
                        millTime=0;

                    }
                    if (turn>= prodfabricTime&& prodfabricTime!=0){
                        prodFabric.run();
                        int t1=Math.abs(rand.nextInt()%6);
                        int t2=Math.abs(rand.nextInt()%6);
                        Product product = new Product();
                        product.name =7;
                        product.xposission=t2;
                        product.yposission=t1;
                        product.existtime=5;
                        product.removetime=turn+product.existtime;
                        products.add(product);
                        if (homeProduct[t1][t2][7]==0)
                            homeProduct[t1][t2][7]=51;
                        else
                            homeProduct[t1][t2][7]++;
                        prodfabricTime=0;

                    }
                    if (turn>=packmilkTime  && packmilkTime!=0){
                        packMilk.run();
                        int t1=Math.abs(rand.nextInt()%6);
                        int t2=Math.abs(rand.nextInt()%6);
                        Product product = new Product();
                        product.name =8;
                        product.xposission=t2;
                        product.yposission=t1;
                        product.existtime=5;
                        product.removetime=turn+product.existtime;
                        products.add(product);
                        if (homeProduct[t1][t2][8]==0)
                            homeProduct[t1][t2][8]=61;
                        else
                            homeProduct[t1][t2][8]++;
                        packmilkTime=0;

                    }
                    if (turn>= bakeryTime && bakeryTime!=0){
                        bakery.run();
                        int t1=Math.abs(rand.nextInt()%6);
                        int t2=Math.abs(rand.nextInt()%6);
                        Product product = new Product();
                        product.name =9;
                        product.xposission=t2;
                        product.yposission=t1;
                        product.existtime=6;
                        product.removetime=turn+product.existtime;
                        products.add(product);
                        if (homeProduct[t1][t2][9]==0)
                            homeProduct[t1][t2][9]=71;
                        else
                            homeProduct[t1][t2][9]++;
                        bakeryTime=0;

                    }
                    if (turn>= tailoringTime && tailoringTime!=0){
                        tailoring.run();
                        int t1=Math.abs(rand.nextInt()%6);
                        int t2=Math.abs(rand.nextInt()%6);
                        Product product = new Product();
                        product.name =10;
                        product.xposission=t2;
                        product.yposission=t1;
                        product.existtime=6;
                        product.removetime=turn+product.existtime;
                        products.add(product);
                        if (homeProduct[t1][t2][10]==0)
                            homeProduct[t1][t2][10]=81;
                        else
                            homeProduct[t1][t2][10]++;
                        tailoringTime=0;

                    }
                    if (turn>= iceStoreTime && iceStoreTime!=0){
                        iceStore.run();
                        int t1=Math.abs(rand.nextInt()%6);
                        int t2=Math.abs(rand.nextInt()%6);
                        Product product = new Product();
                        product.name =11;
                        product.xposission=t2;
                        product.yposission=t1;
                        product.existtime=6;
                        product.removetime=turn+product.existtime;
                        products.add(product);
                        if (homeProduct[t1][t2][11]==0)
                            homeProduct[t1][t2][11]=91;
                        else
                            homeProduct[t1][t2][11]++;
                        iceStoreTime=0;

                    }
                    //------------------------------------------------------------- grass check
                    int grasscheck=0;
                    for (int j = 0; j < 6; j++) {
                        for (int k = 0; k < 6; k++) {
                            if (grass[j][k]!=0)
                                grasscheck=1;
                        }

                    }
                    if (grasscheck==0)
                        System.out.println("there is no grass !");
                    //--------------------------------------------------------------- cage check
                    for (int j = 0; j < wildAnimals.size(); j++) {
                        if (wildAnimals.get(j).cages>=wildAnimals.get(j).maxCage){
                            if (wildAnimals.get(j).animalname.equals("lion")){
                                homeProduct[wildAnimals.get(j).yposision][wildAnimals.get(j).xposision][3]=4;
                                lionRemoveTime[1] = wildAnimals.get(j).xposision;
                                lionRemoveTime[2] = wildAnimals.get(j).yposision;

                                wildAnimals.remove(j);
                                lionRemoveTime[0] = turn +5;
                            }
                            else if (wildAnimals.get(j).animalname.equals("bear")){
                                homeProduct[wildAnimals.get(j).yposision][wildAnimals.get(j).xposision][4]=5;
                                bearRemoveTime[1] = wildAnimals.get(j).xposision;
                                bearRemoveTime[2] = wildAnimals.get(j).yposision;
                                wildAnimals.remove(j);
                                bearRemoveTime[0] = turn +5;
                            }
                            else if (wildAnimals.get(j).animalname.equals("tiger")){
                                homeProduct[wildAnimals.get(j).yposision][wildAnimals.get(j).xposision][5]=6;
                                tigerRemoveTime[1] = wildAnimals.get(j).xposision;
                                tigerRemoveTime[2] = wildAnimals.get(j).yposision;
                                wildAnimals.remove(j);
                                tigerRemoveTime[0] = turn +5;
                            }

                        }
                    }
                    //------------------------------------------------------------------
                    if(lionRemoveTime[0] < turn){
                        homeProduct[lionRemoveTime[2]][lionRemoveTime[1]][3]=0;
                    }
                    if(bearRemoveTime[0] < turn){
                        homeProduct[bearRemoveTime[2]][bearRemoveTime[1]][4]=0;
                    }
                    if(tigerRemoveTime[0] < turn){
                        homeProduct[tigerRemoveTime[2]][tigerRemoveTime[1]][5]=0;
                    }
                    //-----------------------------------------------handling truck
                    if (turn>=truckTime && truckTime!=0){
                        car.sell();
                        truckTime=0;
                    }
                    //---------------------------------------------------- health reduce
                    for (int j = 0; j < domanimals.size(); j++) {
                        domanimals.get(j).animalHealth-=10;
                        if(domanimals.get(j).animalHealth == 0){
                            domanimals.remove(j);
                        }
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
                    int chicken =0,turkey=0,buffalo=0;
                    for (int j = 0; j < domanimals.size(); j++) {
                        if(domanimals.get(j).animalName.equals("chicken")){
                            chicken ++;
                        }else if(domanimals.get(j).animalName.equals("turkey")){
                            turkey ++;
                        } else if(domanimals.get(j).animalName.equals("buffalo")){
                            buffalo ++;
                        }
                    }
                    boolean[] b = new boolean[13];
                    for (int j = 0; j < b.length; j++) {
                        b[j] = false;
                    }
                    String[] task1 = tasks.split("\\s");
                    for (int j = 0; j < task1.length; j++) {
                        if(task1[j].equals("egg")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalegg)
                                b[0] = true;
                        }
                        else if(task1[j].equals("feather")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalfeather)
                                b[1] = true;
                        }
                        else if(task1[j].equals("milk")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalmilk)
                                b[2] = true;
                        }
                        else if(task1[j].equals("flour")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalflour)
                                b[3] = true;
                        }
                        else if(task1[j].equals("fabric")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalfabric)
                                b[4] = true;
                        }
                        else if(task1[j].equals("packmilk")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalpackmilk)
                                b[5] = true;
                        }
                        else if(task1[j].equals("bread")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalbread)
                                b[6] = true;
                        }
                        else if(task1[j].equals("cloths")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalcloths)
                                b[7] = true;
                        }
                        else if(task1[j].equals("icecream")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.totalicecream)
                                b[8] = true;
                        }
                        else if(task1[j].equals("coin")){
                            if(Integer.parseInt(task1[j-1]) <= Storage.coin)
                                b[9] = true;
                        }
                        else if(task1[j].equals("chicken")){
                            if(Integer.parseInt(task1[j-1]) <= chicken)
                                b[10] = true;
                        }
                        else if(task1[j].equals("turkey")){
                            if(Integer.parseInt(task1[j-1]) <= turkey)
                                b[11] = true;
                        }
                        else if(task1[j].equals("buffalo")){
                            if(Integer.parseInt(task1[j-1]) <= buffalo)
                                b[12] = true;
                        }
                    }

                    int temp = 0;
                    for (int j = 0; j < b.length; j++) {
                        if(b[j] == true)
                            temp ++;
                    }
                    if(temp == task1.length/2){
                        level++;
                        System.out.println("CONGRATS you have finished this level  :)");
                        try {
                            File users = new File("users.txt");
                            File users1 = new File("users1.txt");
                            Scanner user = new Scanner(users);
                            PrintWriter printWriter = new PrintWriter(users1);
                            Scanner user1 = new Scanner((users1));
                            while (user.hasNextLine()){
                                String line = user.nextLine();
                                if (turn <= timeprize) {
                                    if(line.startsWith(username)) {
                                        printWriter.append(username + " " + password + " " + level +" "+prize);
                                        printWriter.println();
                                    }else {
                                        printWriter.append(line);
                                        printWriter.println();
                                    }

                                }
                                else{
                                    prize = 0;
                                    if(line.startsWith(username)) {
                                        printWriter.append(username + " " + password + " " + level +" 0");
                                        printWriter.println();
                                    }else {
                                        printWriter.append(line);
                                        printWriter.println();
                                    }

                                }
                            }
                            printWriter.close();
                            user.close();
                            PrintWriter printWriter1 = new PrintWriter(users);
                            while (user1.hasNextLine()){
                                printWriter1.append(user1.nextLine());
                                printWriter1.println();
                            }
                            printWriter1.close();
                            user1.close();

                        }
                        catch (Exception e){
                            System.out.println(e);
                        }
                        System.out.println("1 : MENU  ,  2 : EXIT");
                        int m = sc.nextInt();
                        if(m == 2)
                            System.exit(0);
                        else if(m == 1){
                            Return = true;
                        }
                    }





                    //----------------------------------------------------------------------------------------
                }




                if (Return==false){
                    printinformation.turns(turn);
                    printinformation.grass(grass);
                    printinformation.domAnimal(domanimals);
                    printinformation.wildAnimal(wildAnimals);
                    printinformation.cat(cats);
                    printinformation.dog(dogs);
                    printinformation.homeProduct(homeProduct);
                    printinformation.task(level,domanimals);
                }


                if(Return == true)
                    break;
            }
            else
                System.out.println("wrong input ...");

        }



    }



    public void filereader(){
        try {
            File missions = new File("missions.txt");
            Scanner s = new Scanner(missions);
            while (s.hasNextLine()){
                String temp = s.nextLine();
                if(temp.contains("levelsnumber")){
                    maxLevel = Integer.parseInt(s.nextLine());
                }
                if (temp.contains("level "+this.level)){
                    this.startCoin=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    Storage.coin = startCoin + previousCoin;
                    this.tasks=s.nextLine().substring(6);
                    this.wildanimals=s.nextLine().substring(8);
                    this.wildTn = wildanimals.split("\\s");

                    this.timeprize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    this.prize=Integer.parseInt(s.nextLine().split("\\s")[1]);
                    break;

                }

            }
            s.close();


        }catch (Exception e){
            System.out.println(e);
        }

    }

}
