package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import com.company.Player;
/* public class Player {

    ArrayList<String> cards ;
    int cardcount ;
    Player(){
        ArrayList<String> cards = new ArrayList<>();
        cardcount =0;
    }

    void fillhand(String card){
        cards.add(card);
        cardcount++;
    }
}*/
public class CardGame {


    static String[] types = {"Diamond", "Club", "Heart", "Spade"};
    static int[] numbering= {1,2,3,4};

    public static void main(String[] args) {
        ArrayList<String>  cardlist = cardFactory();
        printDeck(cardlist);
        shuffle(cardlist);
        printDeck(cardlist);
       dealCards( 4 , 3 , cardlist); // 9 players ,5 card each
        printDeck(cardlist);
    }

    public static ArrayList<String> cardFactory(){
        ArrayList<String>  cardlist = new ArrayList<>();
        for( String s : types){
            for(int num :  numbering){
                cardlist.add(s+" "+ num);
            }
        }
        return cardlist;
    }
/*
    public static Card cardFactory(){
        ArrayList<String>  cardlist = new ArrayList<>();
        for( String s : types){
            for(int num :  numbering){
                cardlist.add(s+" "+ num);
            }
        }
        return cardlist;
    }
    public static void shuffle(ArrayList<String> cardlist){
        Collections.shuffle(cardlist);
    }*/

    public static void shuffle(ArrayList<String> cardlist){
        for (int i=0;i<cardlist.size() ; i++){
         int randposition =(int) Math.random() % cardlist.size();
         String temp = cardlist.get(i);
         cardlist.remove(temp);
         cardlist.add( i, cardlist.get(randposition));
         cardlist.remove(cardlist.get(randposition));
         cardlist.add( randposition, temp);
        }
    }

    public static void printDeck(ArrayList<String> cardlist){
        System.out.println(Arrays.toString(cardlist.toArray()));
    }

    public static void dealCards(int players, int handsize , ArrayList<String> cardList){
            Player obj = new Player();
            obj.fillhand("sd");
        System.out.println(" card info");
          Player newplayer = new Player();

        Iterator<String> iter = cardList.iterator();
        int repetitions = players*handsize;
        int count=0;
        while (iter.hasNext() && count < repetitions) {
            String str = iter.next();

            System.out.println(str+" card info");
            newplayer.fillhand(str);

            iter.remove();
            count++;
        }



    }

}
