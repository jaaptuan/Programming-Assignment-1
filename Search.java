/*
 * Ranticha Chumjai SID : 672115042
 * Program for to Programming Assignment 1
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner ;
import java.util.StringTokenizer;
import java.util.Vector ;

public class Search {
    public static void main(String[] args) throws  FileNotFoundException {

        Scanner input = new Scanner(System.in) ;

        Vector<String> temp = new Vector<String>() ;
        String userInput = "" ;
        String choice = "" ;
        String fileName = "" ;
        String nameUser = "" ;

        System.out.println("(-n) Student Number \n(-f) Student FirstName \n(-l) Student LastName \n(-s) UserName " );
        System.out.println("You can copy flie here >> class_roaster67.csv ");
        System.out.print("choose :");
        userInput = input.nextLine() ;
        StringTokenizer userInputStringTokenizer = new StringTokenizer( userInput.trim() , " ") ;
        choice = userInputStringTokenizer.nextToken() ;

        if(choice.toLowerCase().equals("s")) {
            nameUser = userInputStringTokenizer.nextToken() ;
            fileName = userInputStringTokenizer.nextToken() ;
        }
        else {
            fileName = userInputStringTokenizer.nextToken() ;
        }

        //read file

        File list = new File(fileName) ;
        Scanner file = new Scanner(list) ;

        for (int i = 0; i < 7; i++) {
            input.nextLine() ;
        }

        Vector<Listname> name = new Vector<Listname>() ;

        while(input.hasNextLine()) {
            String line = input.nextLine() ;
            StringTokenizer space = new StringTokenizer(line.trim() , ",") ;
            space.nextToken() ;
            name.addElement(new Listname(space.nextToken(), space.nextToken(), space.nextToken())) ; 
        }
        
        // choice 

        switch (choice.toLowerCase()) {
            case "-n" :
                for(int i = 0 ; i < name.size() ; i++ ) {
                    temp.addElement(name.elementAt(i).getSID());
                }
                sorted(name, temp) ;
                break ;

            case "-f" :
                for(int i = 0 ; i < name.size() ; i++ ) {
                    temp.addElement(name.elementAt(i).getFirstName());
                }
                sorted(name, temp) ;
                break ;

            case "-l" :
                for(int i = 0 ; i < name.size() ; i++ ) {
                    temp.addElement(name.elementAt(i).getLastName());
                }
                sorted(name, temp) ;
                break ;

            case "-s" :
                int indexUser = linearSearch(name, nameUser) ;
                if(indexUser != -1) {
                    System.out.println(nameUser + " found at index :" + indexUser);
                }
                else {
                    System.out.println(nameUser + " index not found");
                }
                break;

            default :
                System.out.println("Worng Input!!");
                break ;
        }
    }

    // sort data

    public static void sorted(Vector<Listname> name , Vector<String> temp) {
        String sort ;

        for(int i = 0 ; i < name.size()-1 ; i++ ) {
            for(int j = 0 ; j < name.size()-1-i ; j++) {
                if(temp.elementAt(j).compareTo(temp.elementAt(j+1)) > 0) {
                    Listname tempListname = name.elementAt(j) ;
                    name.set(j, name.elementAt(j+1)) ;
                    name.set(j, tempListname) ;
                    
                    sort = temp.elementAt(j) ;
                    temp.set(j, temp.elementAt(j+1)) ;
                    temp.set(j+1, sort) ;

                }
            }
        }

        for(Listname i : name) {
            System.out.println(i);
        }

        System.out.println();
    }

    // Search Student

    public static int linearSearch(Vector<Listname> name , String user) {
        int index = -1 ;

        for (int i = 0 ; i < name.size() ; i++) {
            if(user.toLowerCase().trim().equals(name.elementAt(i).getFirstName().toLowerCase().trim())) {
                index = i ;
            }
        }
        return index ;
    }
}

