package com.company;

import java.util.ArrayList;

public class Player {

    public ArrayList<String> cards ;
    public int cardcount ;

    Player(){
         cards = new ArrayList<>();
        cardcount =0;
    }

    public void fillhand(String card){
        cards.add(card);
        cardcount++;
    }

}
