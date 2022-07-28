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
public class BlackJack {

    
    public static Game game = new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generate_cards();
        game.set_information();
        gui.runGUI( game.card , game.player[0].getCards() ,  game.player[1].getCards(),  game.player[2].getCards(),  game.player[3].getCards() );        
        game.draw_card_random();
        game.the_Winner(); 
    }
    
}
