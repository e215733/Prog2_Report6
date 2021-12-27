package jp.ac.uryukyu.ie.e215733;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 * makeDeck()メソッドのテストを行うクラス。
 */
public class DeckTest {
    
    /**
     * makeDeck()メソッドによりcardListを前後の二つに分けたメソッドがそれぞれcardListの前後の部分の数字に等しいかテストする。
     */
    @Test void makeDeck(){
        Deck deck = new Deck();
        ArrayList<Integer> list1 = deck.makeDeck(1);
        ArrayList<Integer> list2 = deck.makeDeck(2);

        System.out.println(list1);
        System.out.println(deck);

        for(int i = 0;i< 26;i++){
            assertEquals(list1.get(i),deck.getCardList().get(i)) ;
        }

        for(int i = 0;i< 16;i++){
            assertEquals(list2.get(i),deck.getCardList().get(i+26)) ;
        }
    }
}
