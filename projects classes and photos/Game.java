/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author abdel
 */
public class Game 
{
    GUI gui = new GUI();
    Player [] player = new Player[4];
    int index = 0 ;
    public Card [] card = new Card [52];
    public static int vali = 0 ;
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    
  public void updatescore()
    {
         for (int p = 0 ; p< 3 ;p ++)
         {    
             if((player[p].getScore()<=21)&&(vali<=21)&&(player[p].getScore()>=vali))
             {
                 
                vali = player[p].getScore();
             }
             else if(player[p].getScore()>21)
                     {
                     player[p].setAlready_exist(false);
                     }

             }
         if ((player[0].getScore()>21)&&(player[1].getScore()>21)&&(player[2].getScore()>21)&&(player[3].getScore()>21))
         {
             vali = 0 ;
         }
    }
      public void update_score()
    {
         for (int p = 0 ; p< 4 ;p ++)
         {    
             if((player[p].getScore()<=21)&&(vali<=21)&&(player[p].getScore()>=vali))
             {
                 
                vali = player[p].getScore();
             }
             else if(player[p].getScore()>21)
                     {
                     player[p].setAlready_exist(false);
                     }

             }
         if ((player[0].getScore()>21)&&(player[1].getScore()>21)&&(player[2].getScore()>21)&&(player[3].getScore()>21))
         {
             vali = 0 ;
         }
    }  
        
  public void  generate_cards ()
    { 
     for(int x = 0 ; x < 4; x++){
        if (x==0)
        {
            int gg = 1 ;
            int n =0 ;
            for (int i = 0  ; i<=12 ;i++)
            {
              if(i>9)
              {
                  card[i]= new Card(0,n,10);
                  n=n+1;
              }
              else 
              {               
                  card[i]= new Card(0,n,gg);
                  gg = gg + 1 ;
                  n=n+1;
              }
            }  
        }
       if (x==1)
        {
           int ggg =1 ;
           int nn =0 ;
            for (int i = 13  ; i<=25 ;i++)
            {
             if(i>22)
              {
                  card[i]= new Card(1,nn,10);
                  nn = nn+1 ;
              }
              else 
              {           
                  card[i]= new Card(1,nn,ggg);
              ggg = ggg +1 ;
                                nn = nn+1 ;
              }
            }          
        } 
        if (x==2)
        {
            int g = 1 ;
            int nnn = 0 ;
            for (int i = 26  ; i<=38 ;i++)
            {
             if(i>35)
              {
                  card[i]= new Card(2,nnn,10);
                  nnn = nnn+1 ;
              }
              else 
              {              
                  card[i]= new Card(2,nnn,g);
                  g = g +1 ;
                                    nnn = nnn+1 ;
              }
            }
        }
        if (x==3)
        {
            int gggg = 1 ;
            int nnnn =  0;
            for (int i = 39  ; i<=51 ;i++)
            {
             if(i>48)
              {
                  card[i]= new Card(3,nnnn,10);
                                    nnnn = nnnn+1 ;
              }
              else 
              {              
                  card[i]= new Card(3,nnnn,gggg);
                  gggg = gggg + 1 ;
                                    nnnn = nnnn+1 ;
              }
            }
        }
    }      
    }
        
        
  public void draw_card_random()
    {    
       for(int y = 0 ; y<3 ;y++)
        {
              if(player[y].isAlready_exist()==false)
               {
                System.out.println("He is out As He exceeded 21 !");
                continue;
               }
                 int inde=2;
                 boolean p = true ;
                 while(p)
               {  
              if(player[y].getScore()>21)
              {
                 System.out.println(player[y].getName() +"  is out As He exceeded 21 !");
                 
              }
                  System.out.println("Player number " + (y+1) +" His name "+ player[y].getName() );
                  System.out.println("Type 1 for  \"Hit\"  or Type 2 for \"Stand\" :");
                  int l = input.nextInt();
              if (l==1){
                     p = true;   
                     boolean n =true;
               while(n)
               {
                   int random_choic = rand.nextInt(52);
                   if(card[random_choic]==null)
               {
                    n=true;
                    continue;
                }
                else
               { 
           
                   Card  c_random = new Card(card[random_choic]);
                   player[y].sscore(c_random.getValue());
                   player[y].addcard(c_random);
                   card[random_choic] = null ;
                   System.out.println(player[y].getName() +" His score =  " + player[y].getScore());
//                 update_score();
                   n=false;
                   gui.updatePlayerHand(c_random, y);
                   inde++ ;
                     }
                }
            }
                else if (l==2)
                {
                    break;
                }
          }
               System.out.println("  ----------------------------------------------------     ");
        }
                   int fa = 2 ;
                   updatescore();    
                   boolean  m=true ;
                     if(player[3].getScore()<=vali)
                  {
                   while(m)
                  {
                  
                        m = true;
                         int random_choic = rand.nextInt(52);
                    if(card[random_choic]==null)
                     {
                        continue;
                       }
                    else
                        { 
                             Card  c_random = card[random_choic];
                             player[3].sscore(c_random.getValue());
                             player[3].addcard(c_random);
                             gui.updateDealerHand( c_random,card );
                             card[random_choic] = null ;
                             System.out.println(player[3].getName() +" His score =  " + player[3].getScore());
                            // update_score();
                            if(player[3].getScore()>21)
                             {
                               System.out.println(player[3].getName() +"  is out As He exceeded 21 !");
                 
                             }
                             if((player[3].getScore()>vali && vali <=21)|| player[3].getScore()==21 )
                             {
                                 break ;
                             }
                             fa ++ ;
                         }
                   }
                      System.out.println("-----------------");
                  }
                    else if(player[3].getScore()>vali||player[3].getScore()==21)
                 {
                    
         }
    }

    public void set_information ()
    {
      for (int i = 0 ; i < 4 ; i++)
      {
          boolean n = true ;
          player [i] = new Player();
            System.out.println("please Enter Name Of Player "  + (i+1));
            String name = input.next(); 
             player[i].setName(name);
          for(int y = 0 ; y < 2 ; y++)
          {  
             do {
                       int random_choic = rand.nextInt(52);
                if(card[random_choic]==null)
                {
                       n=true;
                       continue ;
                }
                else{
                       Card  c_random = new Card(card[random_choic]);
                       card[random_choic] = null ;
                       n=false;
                       player[i].addcard(c_random);
                       player[i].sscore(player[i].getCards()[y].getValue());
//                     player[i].cards[y] = new Card(c_random);
//                     player[i].sscore(player[i].cards[y].getValue());
               if(i == 3 && y == 1)
                  {    }
               else
                     {
                        System.out.println(player[i].getName() +" His score =  " + player[i].getScore());
                     }
             }
            }
                while(n);
          }
                 System.out.println("  ----------------------------------------------------     ");
       }
    }    
              
      
  public void the_Winner()
    {
        System.out.println("  ----------------------------------------------------   ");
        update_score();
        if(vali==0)
        {
            System.out.println("PUSH ! NO Winner All Exceeded 21");
        }
        else
        {
                  System.out.println("  ----------------------------------------------------  \n   ");
                  System.out.println("The Result :");
                  int p = 0;
                  update_score();
        for(int u = 0 ; u<4 ;u++)
            {
              if(player[u].getScore()>=vali&&player[u].getScore()<=21)
              {
               p = u ;
              }
            }    
      if (p == 0)
      {
          if(player[0].getScore()==player[1].getScore()||player[0].getScore()==player[2].getScore()||player[0].getScore()==player[3].getScore())
          {
              System.out.println("PUSH !");
          }
          else
          {
            System.out.println("The winner is Player Number " +(p+1)+" \""+ player[p].getName()+"\""+" And his score = " +player[p].getScore());

          }
      }else if (p==1)
      {
           if(player[1].getScore()==player[0].getScore()||player[1].getScore()==player[2].getScore()||player[1].getScore()==player[3].getScore())
          {
              System.out.println("PUSH !");
          }
          else
          {
            System.out.println("The winner is Player Number " +(p+1)+" \""+ player[p].getName()+"\""+" And his score = " +player[p].getScore());

          }
      }
      else if (p==2)
      {
           if(player[2].getScore()==player[0].getScore()||player[2].getScore()==player[1].getScore()||player[2].getScore()==player[3].getScore())
          {
              System.out.println("PUSH !");
          }
          else
          {
            System.out.println("The winner is Player Number " +(p+1)+" \""+ player[p].getName()+"\""+" And his score = " +player[p].getScore());

          }
      }else if (p==3)
      {
           if(player[3].getScore()==player[0].getScore()||player[3].getScore()==player[1].getScore()||player[3].getScore()==player[2].getScore())
          {
              System.out.println("PUSH !");
          }
          else
          {
            System.out.println("The winner is Player Number " +(p+1)+" \""+ player[p].getName()+"\""+" And his score = " +player[p].getScore());

          }
      }
    }}
}
    

