package jp.ac.uryukyu.ie.e215733;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    /**
     * トランプゲーム、戦争の山札を作成するクラス。
     */
    public class Deck{

        // カードリスト（山札）に0〜５１の要素を入れ、それぞれマークとカードをを割り振る
        // 0 ～12：スペードA～K 、　13～25：ハートA～K 、 26～38：ダイヤA～K 、 39～51：クラブA～K
        private ArrayList<Integer> cardList;

    
        /**
         * コンストラクタ。
         * cardListを初期化する。
         * cardListの中身をシャッフルする。
         */
        public Deck(){

            // カードを初期化
            cardList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51));
            
            // カードをシャッフルする
            Collections.shuffle(cardList);
        }

        /**
         * cardListを二つのリストに分けてプレイヤー番号によって山札を受けとるメソッド。
         * @param k プレイヤーの番号、自分＝１、相手＝２。
         * @return プレイヤーの山札を返す。
         */
        public ArrayList<Integer> makeDeck(int playerNo){
            
            //トランプの枚数,ジョーカーなし
            final int TOTAL_CARD = 52; 

            // 山札を初期化
            ArrayList<Integer> playerDeck1 = new ArrayList<>();
            ArrayList<Integer> playerDeck2 = new ArrayList<>();

            for (int i = 0; i < TOTAL_CARD; i++) {
                // player1の山札を作成
                if (i < TOTAL_CARD / 2) {
                    playerDeck1.add(cardList.get(i));
                }
                // player2の山札を作成
                else {
                    playerDeck2.add(cardList.get(i));
                }
            }
            List<ArrayList<Integer>> deckList = Arrays.asList(playerDeck1, playerDeck2);

            ArrayList<Integer> playerDeck = deckList.get(playerNo - 1);
            return playerDeck;
        }

        /**
         * カードリスト（山札）を取得するメソッド。
         * @return カードリスト（山札）。
         */
        public ArrayList<Integer> getCardList(){
            return this.cardList;
        }
    }