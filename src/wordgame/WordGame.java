/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordgame;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vladimir
 */
public class WordGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int x,y;
        System.out.println("Firstly, introduce the lenghts of the two dimensions of the array!");
        Scanner scan = new Scanner(System.in);
        System.out.print("x = ");
        x = scan.nextInt();
        System.out.print("y = ");
        y = scan.nextInt();
        char[][] crossword = new char[x][y];
        String word;
        int wordOccurance = 0;
        char a;
        
        System.out.print("Insert the elements of the matrix: ");
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                crossword[i][j] = scan.next().charAt(0);
            }
        }
        System.out.println("Introduce the word, we are going to look for in the matrix: ");
        int maxLengthOfTheWord = x;
        if(maxLengthOfTheWord<y) {
            maxLengthOfTheWord = y;
        } else {
            maxLengthOfTheWord = x;
        }
        word = scan.next();
        if(word.length()>maxLengthOfTheWord) {
            System.out.println("The word is too long. Please write a new word, which has maximum "
                    +maxLengthOfTheWord+ "characters");
            word=scan.next();
        }
        ArrayList<String> results = new ArrayList<>();
        String temp = "";
        for(int i=0; i<x; i++) {
            for(int j=0; j<y; j++) {
                temp = temp + crossword[i][j];
            }
            temp = temp + "/";
        }
        results.add(temp);
        temp = "";
        for(int i=0; i<x; i++) {
            for(int j=y-1; j>=0; j--) {
                temp = temp + crossword[i][j];
            }
            temp = temp + "/";
        }
        results.add(temp);
        temp = "";
        for(int j=0; j<y; j++) {
            for(int i=0; i<x; i++) {
                temp = temp+crossword[i][j];
            }
            temp = temp+"/";
        }
        results.add(temp);
        temp = "";
        for(int j=0; j<y; j++) {
            for(int i=x-1; i>=0; i--) {
                temp = temp+crossword[i][j];
            }
            temp = temp+"/";
        }
        results.add(temp);
        temp = "";
        int i=0;
        int j=0;
        while(i<x&&j<y) {
            int tempI = i, tempJ = j;
            while(tempJ<y&&tempI<x) {
                temp = temp+crossword[tempI][tempJ];
                tempI++;
                tempJ++;
            }
            temp=temp+"/";
            if(i==0&&j<y-1) {j++;}
            else if(i==0&&j==y-1) {i=1; j=0;}
            else if(i!=0&&j==0) {i++;}
        }
        results.add(temp);
        temp="";
        i=0;
        j=0;
        while(i<x&&j<y) {
            int tempI = i, tempJ = j;
            while(tempJ<y&&tempI<x&&tempJ>=0) {
                temp = temp+crossword[tempI][tempJ];
                tempI++;
                tempJ--;
            }
            temp=temp+"/";
            if(i==0&&j<y-1) {j++;}
            else if((i==0&&j==y-1)||(i!=0&&j==y-1)) {i++;}
        }
        results.add(temp);
        temp = null;
        int temporaryVar = 0;
        for(i=0; i<results.size(); i++) {
            temporaryVar = results.get(i).split(word).length-1;
            wordOccurance = wordOccurance + temporaryVar;
        }
        System.out.println("The word "+word+" appears "+wordOccurance+" times in the matrix");
    }
    
}
