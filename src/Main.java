import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Manager m = new Manager(1);
        //m.run();

        Scanner sc = new Scanner(System.in);
        Scanner fileReader;
        String username = null , password = null , menu = null ,logSign1;
        int logSign = 0 , level = 1;
        int startLevel , previousCoin = 0;
        File users = new File("users.txt");
        try {
            PrintWriter printWriter1 = new PrintWriter(new FileWriter(users, true));
        }catch (Exception e){
            System.out.println(e);
        }



        boolean Return = true;
        boolean b = true;
        while (b) {

            if(Return) {
                System.out.println("1 - LOG IN\n2 - SIGN UP");
                logSign1 = sc.next();
                if (logSign1.equals("EXIT"))
                    System.exit(0);
                else
                    logSign = Integer.parseInt(logSign1);

                if (logSign == 1) {
                    b = false;

                    try {
                        boolean temp = true;


                        while (temp) {
                            fileReader = new Scanner(users);

                            System.out.println("Enter USERNAME :");
                            username = sc.next();
                            while (fileReader.hasNextLine()) {
                                if (fileReader.nextLine().contains(username)) {
                                    temp = false;
                                    break;
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

                        //Manager manager = new Manager(level);
                        //-------------------------------------------------
                    } catch (Exception e) {
                        System.out.println(e);
                    }


                } else if (logSign == 2) {
                    b = false;

                    try {
                        boolean temp = true;


                        while (temp) {
                            fileReader = new Scanner(users);

                            System.out.println("Enter USERNAME :");
                            temp = false;
                            username = sc.next();
                            while (fileReader.hasNextLine()) {
                                if (fileReader.nextLine().contains(username)) {
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

                        //Manager manager = new Manager(level);

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                } else {
                    System.out.println("Wrong Input");
                    continue;
                }
            }


            //----------------------------------------------------------------------------
            System.out.println("Menu :\nSTART [level]\nLOG OUT\nSETTINGS");

            menu = sc.nextLine();
            if (menu.contains("START")) {
                startLevel = Integer.parseInt(menu.split("\\s")[1]);
                if (startLevel <= level) {

                    Manager manager = new Manager(startLevel);
                    manager.username = username;
                    manager.password = password;
                    manager.previousCoin = previousCoin;
                    System.out.println("Entering the ADVENTURES ...");
                    manager.filereader();
                    manager.run();
                    level++;
                    Return = false;

                } else {
                    System.out.println("You did not reach this level ... \nEnter level again :");
                    startLevel = sc.nextInt();
                    if (startLevel <= level) {
                        Manager manager = new Manager(startLevel);
                        manager.username = username;
                        manager.password = password;
                        manager.previousCoin = previousCoin;
                        System.out.println("Entering the ADVENTURES ...");
                        manager.filereader();
                        manager.run();
                        level++;
                        Return = false;
                    }
                }
            } else if (menu.contains("LOG OUT")) {
                continue;

            } else if (menu.contains("SETTING")) {

            } else if (menu.contains("EXIT")) {
                System.exit(0);
            } else {
                System.out.println("Wrong Input");
                continue;
            }
        }

    }
}
