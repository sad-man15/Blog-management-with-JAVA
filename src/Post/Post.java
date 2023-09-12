package Post;

import User.*;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Post extends User {
    public static String tab="\t\t";

    private String title;
    private String details;

    public Post(){
        System.out.println();
    }

    public Post(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void showPost() throws IOException {

        FileInputStream fi=new FileInputStream("Post.txt");
        DataInputStream DI=new DataInputStream(fi);
        Scanner scan=new Scanner(DI);

        int i=0;
        System.out.println(tab+"===============================================================");
        System.out.println(tab+"**                        ALL POST                           **");
        System.out.println(tab+"===============================================================");
        while(scan.hasNextLine()){
            if(i%3==0){
                if(i!=0){
                    System.out.println(tab+"===============================================================");
                }
                System.out.println();
            }
            System.out.println(tab+"\t"+scan.nextLine());

            i++;
        }


        fi.close();
        DI.close();
    }



}
