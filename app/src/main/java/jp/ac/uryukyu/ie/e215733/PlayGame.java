package jp.ac.uryukyu.ie.e215733;

import java.util.ArrayList; 
import java.util.Scanner;

/**
 * 戦争を行うための勝敗判定、ゲームの流れ等を定義するクラス。
 */
public class PlayGame {

    /**
     * 引数のゲーム回数をもとにゲームを行う。
     * @param matchNum ゲーム回数。最大26回。
     */    
    public static void GamePlay(int matchNum){
        Scanner scan = new Scanner(System.in);

        Player myAvatar = new Player(1) ;
        Player enemyAvatar = new Player(2);
        Deck deck = new Deck();
        ArrayList<Integer> playerDeck = myAvatar.getDeck(deck);
        ArrayList<Integer> enemyDeck = enemyAvatar.getDeck(deck);

        System.out.println("トランプゲーム : 戦争を始めます");

        for(int i = 1; i <= matchNum ;i++){
            scan.nextLine();
            System.out.println("第" + i + "試合");
            myAvatar.play(myAvatar,playerDeck);
            enemyAvatar.play(enemyAvatar,enemyDeck);
            compare(myAvatar,enemyAvatar);
        }
        scan.nextLine();
        judgment(myAvatar,enemyAvatar);

        scan.close();
    }

    /**
     * ２プレイヤーの引いたカードの強さを比較するメソッド。
     * @param player1 プレイヤー（自分）。
     * @param player2 プレイヤー（相手）。
     */
    public static void compare(Player player1,Player player2){ 
    
        
        if(player1.getNo() == player2.getNo()){
            
            System.out.println("引き分け!!次に勝った方が2倍のポイントをもらえます!");
            
            player1.addDrawPoint();
            player2.addDrawPoint();
        }

        // player2のカードがA（１）だった場合
        else if(player2.getNo() == 1){
            player2.addGamePoint(player2.getDrawPoint() + 1); 
            
            player1.initializeDrawPoint(); //drawPointを初期化
            player2.initializeDrawPoint(); //drawPointを初期化
            
            System.out.println("残念!!");
        } 

        // player1のカードの数字がplayer2のカードの数字より大きい、または、player1のカードがA（１）の場合
        else if(player1.getNo() > player2.getNo() || player1.getNo() == 1){

            player1.addGamePoint(player1.getDrawPoint() + 1);

            player1.initializeDrawPoint(); //drawPointを初期化
            player2.initializeDrawPoint(); //drawPointを初期化

            System.out.println("勝利!!");
        }

        //  player2のカードの数字がplayer1のカードの数字より大きい場合
        else if(player1.getNo() < player2.getNo() ){

            player2.addGamePoint(player2.getDrawPoint() + 1); 
            
            player1.initializeDrawPoint(); //drawPointを初期化
            player2.initializeDrawPoint(); //drawPointを初期化
            
            System.out.println("残念!!");
        }

        System.out.println("あなた " + player1.getGamePoint() + " : " + player2.getGamePoint() + " 相手");
    }

    /**
     * 最終的なにプレイヤーのゲームポイント（gamePoint）を比較するメソッド。
     * @param player1 プレイヤー（自分）。
     * @param player2 プレイヤー（相手）。
     */
    public static void judgment(Player player1, Player player2){

        int player1Point = player1.getGamePoint();
        int player2Point = player2.getGamePoint();

        System.out.println("＜最終結果＞");

        if(player1Point > player2Point){
            System.out.println("おめでとうございます!!あなたの勝ちです!");
        }
        else if(player1Point < player2Point){
            System.out.println("残念!!あなたの負けです!");
        }
        else if(player1Point == player2Point){
            System.out.println("引き分けです!!");
        }
        System.out.println("あなた " + player1Point + " : " + player2Point + " 相手");
    }
}