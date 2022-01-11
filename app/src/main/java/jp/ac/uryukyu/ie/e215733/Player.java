package jp.ac.uryukyu.ie.e215733;

import java.util.ArrayList; 

/**
 * 戦争ゲーム中のプレイヤーの操作、プレイヤーの持つ情報の操作について実装したクラス
 */
public class Player {

    private Card cardInfo; // カード情報
    private int cardIndex; // 使用したカードの枚数
    private int playerNo; // プレイヤーの番号。MyAvatar(自分)＝１、EnemyAvatar（相手）＝２
    private int gamePoint; //プレイヤーの勝ち点
    private int drawPoint; //引き分け回数

    /**
     * コンストラクタ。
     * 自分＝１、相手＝２としてplayerNoをを持つ。
     * プレイヤー情報の初期化。
     */ 
    public Player(int _playerNo){
        this.playerNo = _playerNo;

        cardIndex = 0;
        gamePoint = 0;
        drawPoint = 0;
    }

    /**
     * カードを引き、引いたカードの情報を返すメソッド。
     * @param player プレイヤー。
     * @param playerDeck　プレイヤーの山札。
     */
    public void play(Player player,ArrayList<Integer> playerDeck){
        player.draw(playerDeck);
        int no = player.getNo();
        int suit = player.getSuit();
        if(player.getPlayerNo() == 1){
            System.out.println("あなたのカードは" + suit(suit) + "の" + number(no) + "です。" );
        }
        else if(player.getPlayerNo() == 2){
            System.out.println("相手のカードは" + suit(suit) + "の" + number(no) + "です。" );
        }
    }


    /**
     * Player生成時のplayerNoを用いてプレイヤーの山札を生成するメソッド。
     * @param deck Deck()により生成された山札。
     * @return　プレイヤーの山札。
     */
    public ArrayList<Integer> getDeck(Deck deck){
        return deck.makeDeck(playerNo);
    }

    /**
     * getCardメソッドにより得られたカード情報をcardInfoに保存するメソッド。
     * @param deck プレイヤーの山札。
     */
    public void draw(ArrayList<Integer> deck){
        cardInfo = getCard(deck);
        return;
    }

    /**
     * カードの番号を取得するメソッド。
     * @return カードの番号。
     */
    public int getNo(){
        return cardInfo.no;
    }
    
    /**
     * カードのマークを取得するメソッド。
     * @return カードのマーク。
     */
    public int getSuit(){
        return cardInfo.suit;
    }

    /**
     * プレイヤーのgamePointを取得するメソッド。
     * @return プレイヤーのgamePoint。
     */
    public int getGamePoint(){
        return this.gamePoint;
    }

    /**
     * プレイヤーのgamePointを増加するメソッド。
     * 引き分け回数1回につきポイント増加量も1ずつ増える。
     * @param drawPoint 引き分けた回数。
     */
    public void addGamePoint(int drawPoint){
        for (int i = 0;i<drawPoint;i++){
        gamePoint++;
        }
    }

    /**
     * 引き分け回数を取得するメソッド。
     * @return 引き分け回数を取得。
     */
    public int getDrawPoint(){
        return this.drawPoint;
    }

    /**
     * 引き分け回数を増加するメソッド。
     */
    public void addDrawPoint(){
        drawPoint ++;
    }

    /**
     * 引き分け回数を初期化するメソッド。
     */
    public void initializeDrawPoint(){
        drawPoint = 0;
    }

    /**
     * プレイヤーの番号を返すメソッド。
     * @return プレイヤーの番号
     */
    public int getPlayerNo(){
        return this.playerNo;
    }

    /**
     * 引数より、カードのマークを返すメソッド。
     * @param cardSuitNo getNo()メソッドにより得られるカードマーク番号
     * @return カードのマーク（文字）
     */
    public static String suit(int cardSuitNo){
        String suit = null;
        if(cardSuitNo == 0){
            suit = "♤";
        }
        else if(cardSuitNo == 1){
            suit = "♡";
        }
        else if(cardSuitNo == 2){
            suit = "♢";
        }
        else if(cardSuitNo == 3){
            suit = "♧";
        }
        return suit;
    }

    /**
     * トランプと同様の数字のマークを返すメソッド。
     * 1=A,11=J,112=Q,13=K,それ以外の数字はそのまま返すメソッド。
     * @param card カードの番号
     * @return カードの番号
     */
    public static String number(int card){
        String cardNo = null;
        if(card == 1){
            cardNo = "A";
        }
        else if(card == 11){
            cardNo = "J";
        }
        else if(card == 12){
            cardNo = "Q";
        }
        else if(card == 13){
            cardNo = "K";
        }
        else{
            cardNo = String.valueOf(card);
        }
        return cardNo;
    }

    /**
     * プレイヤーが自分の山札から1枚取り出し、そのカードの数字とマークを返すメソッド。
     * @param deck プレイヤーの山札。
     * @return カード情報（カードの番号・マーク）。
     */
    public Card getCard(ArrayList<Integer> deck){
        // カード情報を作成
        Card cardInfo = new Card();
        // カードナンバーを初期化
        int cardNum = 0;

            cardNum = deck.get(cardIndex);
            cardIndex ++;

        cardInfo.suit = cardNum /13 ;
        cardInfo.no = (cardNum % 13) + 1 ;

        return cardInfo;
    }
}