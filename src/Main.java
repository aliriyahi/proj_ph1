import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //--------------------- logger
        Date date = new Date();
        File log = new File("log.txt");

        Scanner sc = new Scanner(System.in);
        Scanner fileReader;
        String username = null , password = null , menu = null ,logSign1;
        int logSign = 0 , level = 1;
        int startLevel , previousCoin = 0;
        int prizeCheck = 0;
        File users = new File("users.txt");
        try {
            PrintWriter printWriter1 = new PrintWriter(new FileWriter(users, true));
            PrintWriter logger = new PrintWriter(new FileWriter(log , true));
        }catch (Exception e){
            System.out.println(e);
        }



        boolean Return = true;
        boolean b = true;
        while (b) {

            if(Return) {
                System.out.println("1 - LOG IN\n2 - SIGN UP");
                logSign1 = sc.next();
                if (logSign1.toUpperCase().equals("EXIT"))
                    System.exit(0);
                else
                    logSign = Integer.parseInt(logSign1);

                if (logSign == 1) {
                    //b = false;

                    try {
                        boolean temp = true;


                        while (temp) {
                            fileReader = new Scanner(users);

                            System.out.println("Enter USERNAME :");
                            username = sc.next();
                            while (fileReader.hasNextLine()) {
                                if (fileReader.nextLine().split("\\s")[0].equals(username)) {
                                    temp = false;
                                    break;
                                }
                                else {
                                    try {
                                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                                        logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG USERNAME");
                                        logger.println();
                                        logger.close();
                                    }catch (Exception e){
                                        System.out.println(e);
                                    }
                                }
                            }
                            fileReader.close();

                        }

                        temp = true;
                        while (temp) {
                            fileReader = new Scanner(users);

                            System.out.println("Enter PASSWORD :");
                            password = sc.next();
                            while (fileReader.hasNextLine()) {
                                if (fileReader.nextLine().split("\\s")[1].equals(password)) {
                                    temp = false;
                                    break;
                                }
                                else {
                                    try {
                                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                                        logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG PASSWORD");
                                        logger.println();
                                        logger.close();
                                    }catch (Exception e){
                                        System.out.println(e);
                                    }
                                }
                            }
                            fileReader.close();
                        }

                        temp = true;
                        while (temp) {
                            fileReader = new Scanner(users);

                            while (fileReader.hasNextLine()) {           //     ----------      ----  hasnext az aval miad?
                                String temp1 = fileReader.nextLine();
                                if (temp1.contains(username)) {
                                    level = Integer.parseInt(temp1.split("\\s")[2]);
                                    previousCoin = Integer.parseInt(temp1.split("\\s")[3]);
                                    temp = false;
                                    break;
                                }
                            }
                            fileReader.close();
                        }

                            PrintWriter logger = new PrintWriter(new FileWriter(log , true));
                            logger.append("Header");
                            logger.println();
                            logger.append("2. "+username);
                            logger.println();
                            logger.println("3. last modified "+date.toLocaleString());
                            logger.close();

                        //-------------------------------------------------
                    } catch (Exception e) {
                        System.out.println(e);
                    }


                } else if (logSign == 2) {
                    //b = false;

                    try {
                        boolean temp = true;


                        while (temp) {
                            fileReader = new Scanner(users);

                            System.out.println("Enter USERNAME :");
                            temp = false;
                            username = sc.next();
                            while (fileReader.hasNextLine()) {
                                if (fileReader.nextLine().split("\\s")[0].equals(username)) {
                                    System.out.println("This USERNAME is already taken");
                                    temp = true;
                                    break;
                                }
                            }
                            fileReader.close();
                        }


                        System.out.println("Enter PASSWORD :");
                        password = sc.next();
                        PrintWriter printWriter = new PrintWriter(new FileWriter(users, true));
                        printWriter.append(username + " " + password + " " + "1 0");
                        printWriter.println();
                        printWriter.close();
                        try {
                            PrintWriter logger = new PrintWriter(new FileWriter(log , true));
                            logger.append("Header");
                            logger.println();
                            logger.append("1. "+ date.toLocaleString());
                            logger.println();
                            logger.append("2. "+username);
                            logger.println();
                            logger.println("3. "+date.toLocaleString());
                            logger.close();

                        }catch (Exception e){
                            System.out.println(e);
                        }


                    } catch (Exception e) {
                        System.out.println(e);
                    }

                } else {
                    System.out.println("Wrong Input");
                    continue;
                }
            }


            //----------------------------------------------------------------------------
            if(prizeCheck != 0)
                previousCoin = Manager.prize;

            System.out.println("Menu :\nSTART [level]\nLOG OUT\nSETTINGS");


            menu = sc.nextLine();
            menu = sc.nextLine();

                if (menu.toUpperCase().contains("START") ) {
                    prizeCheck++;

                    if (menu.split("\\s").length==2){
                         startLevel = Integer.parseInt(menu.split("\\s")[1]);
                        if (startLevel <= level) {
                            try {
                                PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                                logger.append("[INFO] ,"+date.toLocaleString()+",ENTERED THE GAME");
                                logger.println();
                                logger.close();
                            }catch (Exception e){
                                System.out.println(e);
                            }
                            Manager manager = new Manager(startLevel);
                            manager.username = username;
                            manager.password = password;
                            manager.previousCoin = previousCoin;
                            System.out.println("RUNNING the ADVENTURES ...");
                            manager.filereader();
                            manager.run();

                            if(manager.maxLevel > level) {
                                level++;
                                Return = false;
                            }else
                                System.out.println("EXCELLENT you have reached the MAX");

                        } else {
                            System.out.println("You did not reach this level ... \nEnter level again :");
                            startLevel = sc.nextInt();
                            if (startLevel <= level) {
                                try {
                                    PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                                    logger.append("[INFO] ,"+date.toLocaleString()+",ENTERED THE GAME");
                                    logger.println();
                                    logger.close();
                                }catch (Exception e){
                                    System.out.println(e);
                                }
                                Manager manager = new Manager(startLevel);
                                manager.username = username;
                                manager.password = password;
                                manager.previousCoin = previousCoin;
                                System.out.println("RUNNING the ADVENTURES ...");
                                manager.filereader();
                                manager.run();
                                if(manager.maxLevel > level) {
                                    level++;
                                    Return = false;
                                }else
                                    System.out.println("EXCELLENT you have reached the MAX");
                            }
                        }
                    }else{
                        System.out.println("wrong input!");
                    }

                }
             else if (menu.toUpperCase().contains("LOG OUT")) {
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",LOGED OUT THE GAME");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                continue;

            } else if (menu.toUpperCase().contains("SETTING")) {

            } else if (menu.toUpperCase().contains("EXIT")) {
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[INFO] ,"+date.toLocaleString()+",EXITED THE GAME");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                System.exit(0);
            } else {
                System.out.println("Wrong Input");
                    try {
                        PrintWriter logger  = new PrintWriter(new FileWriter(log , true));
                        logger.append("[ERROR] ,"+date.toLocaleString()+",WRONG INPUT");
                        logger.println();
                        logger.close();
                    }catch (Exception e){
                        System.out.println(e);
                    }
                continue;
            }
        }

    }
}
