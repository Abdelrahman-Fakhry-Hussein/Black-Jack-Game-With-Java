/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;


/**
 *
 * @author abdel
 */
public class Player 
{
    private String Name ;
    private int Score ;  
    private Card [] cards = new Card[11];
    private boolean he_got_blackjack ;
    private boolean already_exist  = true;
    private int index ;

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }
    public void sscore(int scor)
    {
    if(this.Score > 21)
    {
        this.already_exist = false ;
        this.setScore((this.getScore()+scor));
        this.he_got_blackjack = false ;
    }
    else{
        this.setScore((this.getScore()+scor));
    }
      
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    public boolean isHe_got_blackjack() {
        return he_got_blackjack;
    }

    public boolean isAlready_exist() {
        return already_exist;
    }

    public void setHe_got_blackjack(boolean he_got_blackjack) {
        this.he_got_blackjack = he_got_blackjack;
    }

    public void setAlready_exist(boolean already_exist) {
        this.already_exist = already_exist;
    }
    private int i = 0 ;
    public void addcard(Card c )
    {
     this.cards [i]= new Card(c);
     i++;
    }
}
