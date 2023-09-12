package Operation;

import Post.Post;
import User.User;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class All{
    public static String tab="\t\t";

    public static void shortCut(String username) throws IOException, InterruptedException {
        Scanner scan4=new Scanner(System.in);
        System.out.println(tab+"===============================================================");
        System.out.print(tab+"\tTo go home page type 'H/h': ");
        String n=scan4.next().substring(0,1);
        if(n.equals("H") || n.equals("h")){
            //login();
            data(username);
        }
        else{
            System.out.println(tab+"==================================");
            System.out.println(tab+"\t\tInput valid character!");
            System.out.println(tab+"==================================");
        }
    }


    public static void data(String username) throws IOException, InterruptedException {
        Scanner scan =new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                       POST SECTION                        **");
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"\t\t1..Create post \n");
        System.out.println(tab+"\t\t2..All post \n");
        System.out.println(tab+"\t\t3..My post\n");
        System.out.println(tab+"\t\t4..Profile\n");
        System.out.println(tab+"\t\t5..Delete Post\n");
        System.out.println(tab+"\t\t6..Home Page\n");
        System.out.println(tab+"\t\t7..Exit\n");
        System.out.println(tab+"===============================================================");
        System.out.print(tab+"\tEnter your option: ");
        int m=scan.nextInt();
        Post p=new Post();
        if(m==1){
            String n[]=createPost(username);
            putData(p,n[0], n[1], n[2]);
            shortCut(username);
        }
        else if(m==2){
            p.showPost();
            shortCut(username);
        }
        else if(m==3){
            myPost(username);
            shortCut(username);
        }
        else if(m==4){
            profile(username);
            shortCut(username);
        }
        else if(m==5){
            deletePost(username);
            shortCut(username);
        }
        else if(m==6){
            home();
        }
        else if(m==7){
            System.exit(0);
        }

    }


    public static void putData(User p , String username, String firstName, String lastName, String email, String phoneNumber, String password, String gender, String age) throws IOException {
        List<String> s= new ArrayList<>();

        FileInputStream fi=new FileInputStream("User.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        while(scan.hasNextLine()){
            while(scan.hasNextLine()){
                s.add(scan.nextLine());
            }
        }

        File user=new File("User.txt");
        FileWriter PostWrite=new FileWriter(user);

        p.setUsername(username);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        p.setPhoneNumber(phoneNumber);
        p.setPassword(password);
        p.setGender(gender);
        p.setAge(age);


        for(int i=0;i<s.size();i++){
            PostWrite.append(s.get(i)+"\n");
        }

        PostWrite.append(p.getUsername()+"\n");
        PostWrite.append(p.getFirstName()+"\n");
        PostWrite.append(p.getLastName()+"\n");
        PostWrite.append(p.getEmail()+"\n");
        PostWrite.append(p.getPhoneNumber()+"\n");
        PostWrite.append(p.getPassword()+"\n");
        PostWrite.append(p.getGender()+"\n");
        PostWrite.append(p.getAge()+"\n");

        fi.close();
        DI.close();
        PostWrite.close();
        System.out.println(tab+"===============================================================");
        System.out.println("\n\t\t\tSuccessfully created an Account!\n");
        System.out.println(tab+"===============================================================");

    }


    public static void putData(Post p , String name, String title, String details) throws IOException {
        List<String> s= new ArrayList<>();

        FileInputStream fi=new FileInputStream("Post.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        while(scan.hasNextLine()){
            while(scan.hasNextLine()){
                s.add(scan.nextLine());
            }
        }

        File post=new File("Post.txt");
//        if(post.exists()){
//            post.createNewFile();
//            System.out.println("exist");
//        }
        FileWriter PostWrite=new FileWriter(post);

        p.setUsername(name);
        p.setTitle(title);
        p.setDetails(details);

        for(int i=0;i<s.size();i++){
            PostWrite.append(s.get(i)+"\n");
        }

        PostWrite.append(p.getUsername()+"\n");
        PostWrite.append(p.getTitle()+"\n");
        PostWrite.append(p.getDetails()+"\n");

        fi.close();
        DI.close();
        PostWrite.close();

    }

    
    public static void deleteUser() throws IOException {

        Scanner scan2=new Scanner(System.in);
        List<String> s= new ArrayList<>();
        FileInputStream fi=new FileInputStream("User.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        while(scan.hasNextLine()){
            while(scan.hasNextLine()){
                s.add(scan.nextLine());
            }
        }
        fi.close();
        DI.close();

        int i=0;
        List<Integer> j=new ArrayList<>();
        List<String> user=new ArrayList<>();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                       DELETE USER                         **");
        System.out.println(tab+"===============================================================");
        for(i=0;i<s.size();i=i+8){
                System.out.println(tab+"\t"+s.get(i));
                j.add(i);
                user.add(s.get(i));
//                System.out.println(tab+"\t"+s.get(i+1));
//                System.out.println(tab+"\t"+s.get(i+2));
                System.out.println(tab+"===============================================================");

        }
        System.out.print(tab+"Which user you want to delete: ");
        int l=user.indexOf(scan2.next())+1;

        int p = 0;
        for(int k : j){
            for(i=0;i<j.size();i++){
                if(l==i+1 && p==i){
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                }
            }

            p++;
        }
        File post=new File("User.txt");
        FileWriter PostWrite=new FileWriter(post);

        for(String q : s){

            PostWrite.append(q+"\n");

        }
        PostWrite.close();
        System.out.println(tab+"Successfully deleted the user!");
    }
    
    

    public static String[] createUser(){

        Scanner scan=new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"||                        USER PANEL                         ||");
        System.out.println(tab+"===============================================================");
        System.out.print("\n"+tab+"\tEnter your username: ");
        String username=scan.next();
        System.out.print("\n"+tab+"\tEnter your first name: ");
        String firsName=scan.next();
        System.out.print("\n"+tab+"\tEnter your last name: ");
        String lastName=scan.next();
        System.out.print("\n"+tab+"\tEnter your email: ");
        String email=scan.next();
        System.out.print("\n"+tab+"\tEnter your Phone number: ");
        String phoneNumber=scan.next();
        System.out.print("\n"+tab+"\tEnter your Password: ");
        String password=scan.next();
        System.out.print("\n"+tab+"\tEnter your gender: ");
        String gender=scan.next();
        System.out.print("\n"+tab+"\tEnter your age: ");
        String age=scan.next();
        System.out.println(tab+"===============================================================");

        return new String[]{username,firsName,lastName,email,phoneNumber,password,gender, String.valueOf(age)};

    }

    public static void login() throws IOException, InterruptedException {

        List<String> u=new ArrayList<>();

        Scanner scan=new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                        USER PANEL                         **");
        System.out.println(tab+"===============================================================");
        System.out.print("\n"+tab+"\t\tEnter your username: ");
        String username=scan.next();
        System.out.print("\n"+tab+"\t\tEnter your Password: ");
        String password=scan.next();
        System.out.println(tab+"===============================================================");

        FileInputStream fi=new FileInputStream("User.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan2=new Scanner(DI);

        while(scan2.hasNextLine()){
            while(scan2.hasNextLine()){
                u.add(scan2.nextLine());
            }
        }
        fi.close();
        DI.close();

        for (int i=0;i<u.size();i=i+8){

            if(u.get(i).equals(username) && u.get(i+5).equals(password)){
                data(username);
                break;
            }
            if(i>=u.size()-8) {
                System.out.println("\n"+tab+"\t\tnot found!\n");
                //Thread.sleep(2000);
                System.out.println(tab+"===============================================================");
                System.out.print("\n"+tab+"\t\t1..Try to login again");
                System.out.print("\n"+tab+"\t\t2..Main page");
                System.out.println("\n"+tab+"===============================================================");
                System.out.print(tab+"\tChoose an option: ");
                int option=scan.nextInt();
                if(option==1){
                    login();
                }
                else if(option==2){
                    home();
                }
            }

        }

    }



    public static String[] createPost(String username){

        Scanner scan2=new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                       CREATE POST                         **");
        System.out.println(tab+"===============================================================");
//        System.out.print("Enter your username: ");
//        String username=scan2.next();
//        scan2.nextLine();
        System.out.print(tab+"\tEnter your post title: ");
        String title=scan2.nextLine();
        System.out.print(tab+"\tEnter your post details: ");
        String details= scan2.nextLine();
        System.out.println(tab+"===============================================================");

        return new String[]{username, title, details};

    }

    public static void myPost(String username) throws IOException {
        List<String> s= new ArrayList<>();
        FileInputStream fi=new FileInputStream("Post.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        while(scan.hasNextLine()){
            while(scan.hasNextLine()){
                s.add(scan.nextLine());
            }
        }
        fi.close();
        DI.close();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                         MY POST                           **");
        System.out.println(tab+"===============================================================");
        for(int i=0;i<s.size();i=i+3){
            if(s.get(i).equals(username)){
                System.out.println(tab+"\t"+s.get(i));
                System.out.println(tab+"\t"+s.get(i+1));
                System.out.println(tab+"\t"+s.get(i+2));
                System.out.println(tab+"===============================================================");

            }

        }

    }

    public static void profile(String username) throws IOException {
        List<String> s= new ArrayList<>();
        Scanner scan2=new Scanner(System.in);

        FileInputStream fi=new FileInputStream("User.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        while(scan.hasNextLine()){
            while(scan.hasNextLine()){
                s.add(scan.nextLine());
            }
        }
        fi.close();
        DI.close();

        for(int i=0;i<s.size();i=i+8){
            if(s.get(i).equals(username)){
                System.out.println(tab+"===============================================================");
                System.out.println(tab+"**                          PROFILE                          **");
                System.out.println(tab+"===============================================================");
                System.out.println(tab+"\tUsername      : "+s.get(i));
                System.out.println(tab+"\tFull Name     : "+s.get(i+1)+" "+s.get(i+2));
                System.out.println(tab+"\tEmail         : "+s.get(i+3));
                System.out.println(tab+"\tMobile Number : "+s.get(i+4));
                System.out.println(tab+"\tPassword      : "+s.get(i+5));
                System.out.println(tab+"\tGender        : "+s.get(i+6));
                System.out.println(tab+"\tAge           : "+s.get(i+7));
                System.out.println(tab+"===============================================================");
                System.out.println();
            }
        }
    }

    public static void home() throws IOException, InterruptedException {
        Scanner scan=new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                        USER PANEL                         **");
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**"+"\t\t1. Login");
        System.out.println(tab+"**"+"\t\t2. Registration");
        System.out.println(tab+"**"+"\t\t3. Main Page");
        System.out.println(tab+"===============================================================");
        System.out.print(tab+"Choose an option: ");
        int n=scan.nextInt();

        if(n==1){
            login();
        }
        else if(n==2){
            User user=new User();
            String u[]=createUser();
            putData(user,u[0],u[1],u[2],u[3],u[4],u[5],u[6],u[7]);
            home();
        }
        else if(n==3){
            mainPage();
        }

    }

    public static void deletePost(String username) throws IOException {

        Scanner scan2=new Scanner(System.in);
        List<String> s= new ArrayList<>();
        FileInputStream fi=new FileInputStream("Post.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        while(scan.hasNextLine()){
            while(scan.hasNextLine()){
                s.add(scan.nextLine());
            }
        }
        fi.close();
        DI.close();

        int i=0;
        List<Integer> j=new ArrayList<>();
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                       DELETE POST                         **");
        System.out.println(tab+"===============================================================");
        for(i=0;i<s.size();i=i+3){
            if(s.get(i).equals(username)){

                System.out.println(tab+"\t"+s.get(i));
                j.add(i);
                System.out.println(tab+"\t"+s.get(i+1));
                System.out.println(tab+"\t"+s.get(i+2));
                System.out.println(tab+"===============================================================");
            }

        }
        System.out.print(tab+"Which post do you want to delete (enter in number format) : ");
        int l=scan2.nextInt();

        int p = 0;
        for(int k : j){
            for(i=0;i<j.size();i++){
                if(l==i+1 && p==i){
                    s.remove(k);
                    s.remove(k);
                    s.remove(k);
                }
            }

            p++;
        }
        File post=new File("Post.txt");
        FileWriter PostWrite=new FileWriter(post);

        for(String q : s){

            PostWrite.append(q+"\n");

        }
        PostWrite.close();
    }



    public static void adminSection(String username,String password) throws IOException, InterruptedException {
        Scanner scan=new Scanner(System.in);
        FileInputStream fi=new FileInputStream("Admin.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan2=new Scanner(DI);
        if(username.equals(scan2.nextLine())){
            if(password.equals(scan2.nextLine())){

//                System.out.println("Option: ");
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println(tab+"===============================================================");
                System.out.println(tab+"**                   Welcome To our blog                     **");
                System.out.println(tab+"===============================================================");
                System.out.println(tab+"\t\t1..All post");
                System.out.println(tab+"\t\t2..User details");
                System.out.println(tab+"\t\t3..Delete user");
                System.out.println(tab+"\t\t4..Main Page");
                System.out.println(tab+"===============================================================");
                System.out.print(tab+"Choose an option:");
                int option=scan.nextInt();

                if(option==1){
                    //post
                    Post p=new Post();
                    p.showPost();
                    System.out.println();
                    System.out.println(tab+"===============================================================");
                    System.out.println(tab+"Do you want to go back Main Admin section");
                    System.out.print(tab+"if yes write 'y' if no write 'n' : ");
                    String option2=scan.next();
                    if(option2.equals("y")){
                        adminSection(username,password);
                    }
                    else {
                    	System.exit(0);
                    }
                }
                if(option==2){
                    //details
                    List<String> s=new ArrayList<>();
                    FileInputStream fi2=new FileInputStream("User.txt");
                    DataInputStream DI2=new DataInputStream(fi2);
                    Scanner scan3=new Scanner(DI2);

                    while(scan3.hasNextLine()){
                        s.add(scan3.nextLine());
                    }
                    System.out.println(tab+"===============================================================");
                    System.out.print(tab);
                    for (int i=0;i<s.size();i=i+8){
                        System.out.print("|| "+s.get(i)+" ");
                    }System.out.println("\n"+tab+"===============================================================");

                    System.out.print("\n\n"+tab+"Write down a name to see his full details: ");
                    String name=scan.next();
                    profile(name);
                    System.out.println();
                    System.out.println(tab+"Do you want to go back Main Admin section");
                    System.out.print(tab+"if yes write 'y' if no write 'n' : ");
                    String option2=scan.next();
                    if(option2.equals("y")){
                        adminSection(username,password);
                    }
                    else {
                    	System.exit(0);
                    }
                }
                else if(option==3) {
                	deleteUser();
                	System.out.println();
                    System.out.println(tab+"Do you want to go back Main Admin section");
                    System.out.print(tab+"if yes write 'y' if no write 'n' : ");
                    String option2=scan.next();
                    if(option2.equals("y")){
                        adminSection(username,password);
                    }
                    else {

                    }
                }
                if(option==4){
                    mainPage();
                }

            }
            else{

                System.out.println(tab+"\t\tYou are not the main Admin\n");

                System.out.println(tab+"===============================================================");
                System.out.print("\n"+tab+"\t\t1..Try to login again");
                System.out.print("\n"+tab+"\t\t2..Main page");
                System.out.println("\n"+tab+"===============================================================");
                System.out.print(tab+"\tChoose an option: ");
                int option=scan.nextInt();
                if(option==1){
                    admin();;
                }
                else if(option==2){
                    mainPage();
                }
            }
        }
        else{
            System.out.println(tab+"\t\tYou are not the main Admin\n");

            System.out.println(tab+"===============================================================");
            System.out.print("\n"+tab+"\t\t1..Try to login again");
            System.out.print("\n"+tab+"\t\t2..Main page");
            System.out.println("\n"+tab+"===============================================================");
            System.out.print(tab+"\tChoose an option: ");
            int option=scan.nextInt();
            if(option==1){
                admin();
            }
            else if(option==2){
                mainPage();
            }

        }
    }

    public static void admin() throws IOException, InterruptedException {
        Scanner scan=new Scanner(System.in);


        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                   Welcome To our blog                     **");
        System.out.println(tab+"===============================================================");
        System.out.print(tab+"\t\tEnter Your username: ");
        String username=scan.next();
        System.out.print(tab+"\t\tEnter your password: ");
        String password=scan.next();
        System.out.println(tab+"===============================================================");
        adminSection(username,password);


    }

    public static void mainPage() throws IOException, InterruptedException {
        Scanner scan=new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(tab+"==================================================================================================");
        System.out.println(tab+" \\\\                  //  ||======   ||           /--\\     //- -\\\\   ||\\\\    //||   ||======          ");
        System.out.println(tab+"  \\\\                //   ||         ||          /        //     \\\\  || \\\\  // ||   ||       ");
        System.out.println(tab+"   \\\\              //    ||======   ||         /        //       \\\\ ||  \\\\//  ||   ||======        ");
        System.out.println(tab+"    \\\\    //\\\\    //     ||         ||         \\        \\\\       // ||        ||   ||       ");
        System.out.println(tab+"     \\\\  //  \\\\  //      ||         ||          \\        \\\\     //  ||        ||   ||       ");
        System.out.println(tab+"      \\\\//    \\\\//       ||======   ||========   \\--      \\\\- -//   ||        ||   ||======      ");
        System.out.println(tab+"==================================================================================================");
        System.out.println();
        System.out.println();
        System.out.println(tab+"===========================             ===============================");
        System.out.println(tab+"||  Welcome To our blog  ||             ||          CONTRIBUTOR       ||");
        System.out.println(tab+"===========================             ===============================");
        System.out.println();
        System.out.println(tab+"**\t1..User Panel    **             ||  1>>Nafisa Hossain        || ");
        System.out.println(tab+"**\t2..Admin Panel   **             ||  2>>Tanjib Rubayat Bristy ||");
        System.out.println(tab+"===========================             ||  3>>K M Sadman Akib       || ");
        System.out.print(tab+"Choose an option: ");
        int n=scan.nextInt();

        if(n==1){
            home();
        }
        if(n==2){
            admin();
        }

    }
}