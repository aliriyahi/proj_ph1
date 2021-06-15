import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner fileReader;
        String username = null , password , menu ,logSign1;
        int logSign = 0 , level = 1;
        File users = new File("users.txt");
        int startLevel;


        System.out.println("1 - LOG IN\n2 - SIGN UP");
        logSign1 = sc.next();
        if(logSign1.equals("EXIT"))
            System.exit(0);
        else
            logSign = Integer.parseInt(logSign1);

        if(logSign == 1){

            try {
                boolean temp = true;
                fileReader = new Scanner(users);

                while (temp) {
                    System.out.println("Enter USERNAME :");
                    username = sc.next();
                    while (fileReader.hasNextLine()) {
                        if (fileReader.nextLine().contains(username)) {
                            temp = false;
                            break;
                        }
                    }
                }
                temp = true;
                while (temp) {
                    System.out.println("Enter PASSWORD :");
                    password = sc.next();
                    while (fileReader.hasNextLine()) {
                        if (fileReader.nextLine().contains(password)) {
                            temp = false;
                            break;
                        }
                    }
                }

                temp = true;
                while (temp) {
                    while (fileReader.hasNextLine()) {           //     ----------      ----  hasnext az aval miad?
                        String temp1 = fileReader.nextLine();
                        if (temp1.contains(username)) {
                            level = Integer.parseInt(temp1.split("\\s")[2]);
                            temp = false;
                            break;
                        }
                    }
                }
                fileReader.close();
                //Manager manager = new Manager(level);
                //-------------------------------------------------
            }
            catch (Exception e){
                System.out.println(e);
            }



        }else if(logSign == 2){
            try {
                boolean temp = true;
                fileReader = new Scanner(users);

                while (temp) {
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
                }
                fileReader.close();

                System.out.println("Enter PASSWORD :");
                password = sc.next();
                PrintWriter printWriter = new PrintWriter(new FileWriter(users,true));
                printWriter.append(username +" "+password+" "+"1");
                printWriter.close();

                //Manager manager = new Manager(level);

            }
            catch (Exception e){
                System.out.println(e);
            }

        }else {
            System.out.println("Wrong Input");
        }

        //----------------------------------------------------------------------------
        System.out.println("Menu :\nSTART [level]\nLOG OUT\nSETTINGS");
        menu = sc.nextLine();
        if(menu.contains("START")){
            startLevel = Integer.parseInt(menu.split("\\s")[1]);
            if(startLevel <= level){
                Manager manager = new Manager(startLevel);

            }else {
                System.out.println("You did not reach this level ... \nEnter level again :");
                startLevel = sc.nextInt();
                Manager manager = new Manager(startLevel);
            }
        }else if(menu.contains("LOG OUT")){

        }else if(menu.contains("SETTING")){

        }else if(menu.contains("EXIT")){
            System.exit(0);
        }else {
            System.out.println("Wrong Input");
        }

    }
}
