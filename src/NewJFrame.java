import java.util.Random;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import javax.swing.JOptionPane;
//combine counter and numBet
public class NewJFrame extends javax.swing.JFrame 
{   
    /**
     * Video Poker Game 
     * By: Niraj Pant 
     */
    Random num = new Random(); 
    ArrayList<Card> startDeck = new ArrayList<>();
    ArrayList<Card> shuffleDeck = new ArrayList<>();
    int[] card = new int[5];
    Card card1, card2, card3, card4, card5, card6, card7, card8, card9, card10;
    double dollars; 
    int playCredits = 40; 
    int initialCredits = 0; 
    int counter = 1; //Counter that shows the # of times a player hits the bet one button. 
    boolean bet = false; //Boolean that shows if the player has bet yet
    int numBet = 0; //Takes the amount a player has bet
    int pointsAdded = 0; //Multiplies the value of the hand by how much player has bet.
    boolean play = false; //Boolean that shows if the player meets the precondition to get a hand dealt
    boolean deal = false; /Boolean that shows if the hand has been dealt yet
    boolean holdCard1 = false;
    boolean holdCard2 = false;
    boolean holdCard3 = false;
    boolean holdCard4 = false; 
    boolean holdCard5 = false;
    boolean flush; 
    boolean straight; 
    boolean fullHouse;
    int pairs = 0;
    int consecutive = 0;
    
    /**
     * Values of Poker Hands (multiplier)
     */
     
    private static final int ONE_PAIR = 1; 
    private static final int TWO_PAIR = 2;
    private static final int THREE_OF_KIND = 3;
    private static final int STRAIGHT = 4;
    private static final int FLUSH = 5;
    private static final int FULL_HOUSE = 9;
    private static final int FOUR_OF_KIND = 4;
    private static final int STRAIGHT_FLUSH = 50;
    private static final int ROYAL_FLUSH = 250; 
    
    public NewJFrame() 
    {                   //To do: do random tips
        initComponents();
        randCard();
        
        JOptionPane.showMessageDialog(null, "Welcome to Video Poker.\n "
                + "Created by Niraj Pant.");
        JOptionPane.showMessageDialog(null, "The instructions are as follows:\n" //To do: implement instructions
                + "1. To hold a card, click on the image of the card you want to hold.\n"
                + "2. You must bet before you see your hand (by clicking load deck)\n"
                + "3. When you have held your desired cards, click deal to see the value of your hand and the points your receive.\n"
                + "4. \n");
        
        ImageIcon x = new ImageIcon("resources/BACK-1.jpg"); 
        
        /**
        * The following lines set all the slots to show the back of a card
        */
        slot1.setIcon(x); 
        slot2.setIcon(x);
        slot3.setIcon(x);
        slot4.setIcon(x);
        slot5.setIcon(x);
        
        credits.setText("Credits: " + " " + playCredits); 
        
        ImageIcon table = new ImageIcon("resources/payTable.PNG"); 
        payTable.setIcon(table); 
        
        hold1.setVisible(false);
        hold2.setVisible(false);
        hold3.setVisible(false);
        hold4.setVisible(false);
        hold5.setVisible(false);
        initialCredits = playCredits;
        
    }
    
  
    @SuppressWarnings("unchecked")
   
     private void initComponents() {

        dealButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        slot1 = new javax.swing.JLabel();
        slot2 = new javax.swing.JLabel();
        slot3 = new javax.swing.JLabel();
        slot4 = new javax.swing.JLabel();
        slot5 = new javax.swing.JLabel();
        credits = new javax.swing.JLabel();
        betOne = new javax.swing.JButton();
        betMax = new javax.swing.JButton();
        hold1 = new javax.swing.JLabel();
        hold2 = new javax.swing.JLabel();
        hold3 = new javax.swing.JLabel();
        hold4 = new javax.swing.JLabel();
        hold5 = new javax.swing.JLabel();
        addTwentyFive = new javax.swing.JButton();
        addTen = new javax.swing.JButton();
        javax.swing.JLabel addMoney = new javax.swing.JLabel();
        payTable = new javax.swing.JLabel();
        javax.swing.JButton addFive = new javax.swing.JButton();
        javax.swing.JButton addOne = new javax.swing.JButton();
        betNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Video Poker");
        setBackground(new java.awt.Color(51, 255, 255));
        setFont(new java.awt.Font("Calibri", 0, 90)); // NOI18N
        setForeground(new java.awt.Color(0, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        dealButton.setText("Deal");
        dealButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dealButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Exit");
        exitButton.setToolTipText("");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        loadButton.setText("Load Deck");
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });

        slot1.setText("label1");
        slot1.setToolTipText("");
        slot1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slot1MouseClicked(evt);
            }
        });

        slot2.setText("label2");
        slot2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slot2MouseClicked(evt);
            }
        });

        slot3.setText("label3");
        slot3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slot3MouseClicked(evt);
            }
        });

        slot4.setText("label4");
        slot4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slot4MouseClicked(evt);
            }
        });

        slot5.setText("label5");
        slot5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                slot5MouseClicked(evt);
            }
        });

        credits.setText("Credits: 0");
        credits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creditsMouseClicked(evt);
            }
        });

        betOne.setText("Bet One");
        betOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betOneActionPerformed(evt);
            }
        });

        betMax.setText("Bet Max");
        betMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betMaxActionPerformed(evt);
            }
        });

        hold1.setText("Hold");

        hold2.setText("Hold");

        hold3.setText("Hold");

        hold4.setText("Hold");

        hold5.setText("Hold");

        addTwentyFive.setText("$25");
        addTwentyFive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTwentyFiveMouseClicked(evt);
            }
        });

        addTen.setText("$10");
        addTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTenMouseClicked(evt);
            }
        });

        addMoney.setText("Add Money");

        payTable.setText("jLabel1");

        addFive.setText("$5");
        addFive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFiveMouseClicked(evt);
            }
        });

        addOne.setText("$1");
        addOne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addOneMouseClicked(evt);
            }
        });

        betNumber.setText("Bet: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(slot1)
                            .addComponent(hold1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slot2)
                                    .addComponent(hold2))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(slot3)
                                    .addComponent(hold3))
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hold4)
                                    .addComponent(slot4))
                                .addGap(88, 88, 88))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(loadButton)
                                .addGap(46, 46, 46)
                                .addComponent(dealButton)
                                .addGap(81, 81, 81)
                                .addComponent(betOne)
                                .addGap(18, 18, 18)
                                .addComponent(betMax)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(265, 265, 265)
                                .addComponent(payTable))
                            .addComponent(exitButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(credits)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(slot5)
                                        .addComponent(hold5)
                                        .addComponent(betNumber))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addMoney)
                                        .addGap(1, 1, 1)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addOne, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addFive, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addTen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addTwentyFive))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(credits)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(betNumber)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hold1)
                            .addComponent(hold2)
                            .addComponent(hold3)
                            .addComponent(hold4)
                            .addComponent(hold5))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(slot1)
                    .addComponent(slot2)
                    .addComponent(slot3)
                    .addComponent(slot4)
                    .addComponent(slot5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dealButton)
                            .addComponent(loadButton)
                            .addComponent(betOne)
                            .addComponent(betMax))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(payTable)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addOne)
                            .addComponent(addFive))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addTen)
                            .addComponent(addTwentyFive))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitButton))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void randCard() 
    {
        for (int i = 2; i <= 14; i++) 
        {
            startDeck.add(new Card("H" + i)); 
        }

        for (int i = 2; i <= 14; i++) 
        
            startDeck.add(new Card("C" + i)); 
        }
        
        for (int i = 2; i <= 14; i++) 
        {
            startDeck.add(new Card("S" + i)); 
        }
        
        for (int i = 2; i <= 14; i++) 
        {
            startDeck.add(new Card("D" + i)); 
        }

        for (int i = 0; i < 52; i++) 
        {
            shuffleDeck.add(startDeck.get(i)); 
        }
        
        int rand = num.nextInt(52); 
        card1 = shuffleDeck.remove(rand); 
        
        rand = num.nextInt(51); 
        card2 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(50);
        card3 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(49);
        card4 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(48);
        card5 = shuffleDeck.remove(rand);
       
        rand = num.nextInt(47);
        card6 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(46);
        card7 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(45);
        card8 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(44);
        card9 = shuffleDeck.remove(rand);
        
        rand = num.nextInt(43);
        card10 = shuffleDeck.remove(rand);
        
        card[0] = card1.getCNum(); 
        card[1] = card2.getCNum(); 
        card[2] = card3.getCNum();
        card[3] = card4.getCNum(); 
        card[4] = card5.getCNum(); 
    }
    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(!play)
        {
            JOptionPane.showMessageDialog(null, "You must bet first!");
        }
        
        if(play && playCredits>0)  
        {   //to do: seperate playCredits
            //to do: Implement way to not go into negatives in credits (boolean)
            //To do: work on splitting numbers and suits to eval. hand
            
            for (int i = 0; i < 5; i++) 
            {
                switch(i) 
                {
                    case 0:
                        ImageIcon a = new ImageIcon(card1.getCPath());
                        slot1.setIcon(a);
                        break;
                    case 1:
                        ImageIcon b = new ImageIcon(card2.getCPath());
                        slot2.setIcon(b);

                        break;
                    case 2:
                        ImageIcon c = new ImageIcon(card3.getCPath());
                        slot3.setIcon(c);

                        break;
                    case 3:
                        ImageIcon d = new ImageIcon(card4.getCPath());
                        slot4.setIcon(d);

                        break;
                    case 4:
                        ImageIcon e = new ImageIcon(card5.getCPath());
                        slot5.setIcon(e);
                        break;
                }
            }
            deal = true;
        }   
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void dealButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(!play) 
        {
            JOptionPane.showMessageDialog(null, "You must bet first!");
        }
        if(deal) 
        {
            if(!holdCard1) 
            {
                ImageIcon y = new ImageIcon(card6.getCPath());
                slot1.setIcon(y);
                card[0] = card6.getCNum(); 
            }
            
            if(!holdCard2) 
            {
                ImageIcon y = new ImageIcon(card7.getCPath());
                slot2.setIcon(y);
                card[1] = card7.getCNum();
            }
            
            if(!holdCard3) 
            {
                ImageIcon y = new ImageIcon(card8.getCPath());
                slot3.setIcon(y);
                card[2] = card8.getCNum();
            }
            
            if(!holdCard4) 
            {
                ImageIcon y = new ImageIcon(card9.getCPath());
                slot4.setIcon(y);
                card[3] = card9.getCNum();
            }
            
            if(!holdCard5) 
            {
                ImageIcon y = new ImageIcon(card10.getCPath());
                slot5.setIcon(y);
                card[4] = card10.getCNum();
            }
            evaluateHand();
        }
    
    private void evaluateHand() 
    {
    
        if (bet) 
        {
            if (card1.getCSuit().equals(card2.getCSuit()) && card2.getCSuit().equals(card3.getCSuit()) && card3.getCSuit().equals(card4.getCSuit())
                    && card4.getCSuit().equals(card5.getCSuit()))
            {
                JOptionPane.showMessageDialog(null, "You got a flush!");
                flush = true;
                points(FLUSH)
                nextHand();
            }
            checkStraight();
            flush();
            checkPairs();
            nextHand();
         }
    }
    
    private void checkStraight() 
    {
        for (int i = 0; i < 4; i++) 
        {
            if (card[i] == card[i + 1] - 1) 
            {
                consecutive++; 
            }
        }

        if (card[3] == card[4] - 1) 
        {
            consecutive++;
        

        if (consecutive == 5) 
        {
            straight = true;
            JOptionPane.showMessageDialog(null, "You got a straight!");
            points(STRAIGHT); 
        }
    }
    
    private void flush() 
    {
        if ((straight) && (flush)) 
        {
            if (card[0] == 10 && card[1] == 11 && card[2] == 12 && card[3] == 13 && card[4] == 14) 
            {
                JOptionPane.showMessageDialog(null, "You got a royal flush, aces high! Congratulations!"); //Tests if cards are in order: A 10 J Q K 
                points(ROYAL_FLUSH); //Calls points class with explicit variable flush denoting that the points must be calculated as a straight
            } 
            else if (card[0] == 14 && card[1] == 10 && card[2] == 11 && card[3] == 12 && card[4] == 13) 
            {
                JOptionPane.showMessageDialog(null, "You got a royal flush, aces low! Congratulations!");
                points(ROYAL_FLUSH); //Calls points class with explicit variable flush denoting that the points must be calculated as a straight
            } 
            else //If its not either of the royal flushes it must be a straight flush
            {
                JOptionPane.showMessageDialog(null, "You got a straight flush!");
                points(STRAIGHT_FLUSH); //Calls points class with explicit variable flush denoting that the points must be calculated as a straight
            }
        }
    }
    private void checkPairs() 
    {
        pairs=0;
            if (card[0] == card[1])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[0] == card[2])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[0] == card[3])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[0] == card[4])
            {
                pairs++; //Adds one to the pairs counter
            } 

            if (card[1] == card[2])
            {
                pairs++; //Adds one to the pairs counter
            } 

            if (card[1] == card[3])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[1] == card[4])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[2] == card[3])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[2] == card[4])
            {
                pairs++; //Adds one to the pairs counter
            }

            if (card[3] == card[4])
            {
                pairs++; //Adds one to the pairs counter
            }

            switch(pairs) 
            {
                case 1:
                    JOptionPane.showMessageDialog(null, "You got a one pair!");
                    points(ONE_PAIR)
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "You got a two pair!");
                    points(TWO_PAIR);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "You got a three of a kind!");
                    points(THREE_OF_KIND);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "You got a four of a kind!");
                    points(FOUR_OF_KIND);
                    break;
                case 6
                    JOptionPane.showMessageDialog(null, "You got a full house!");
                    points(FULL_HOUSE);
               
                default:
                    JOptionPane.showMessageDialog(null, "Sorry, you didn't win a hand."); 
                    points(0);
                    break;
            }
    }

    private void slot1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slot1MouseClicked
        if(play && bet) 
        {
            hold1.setVisible(true); //Makes "Hold" visible when card 1 is clicked
            holdCard1 = true;
        }
        
    }//GEN-LAST:event_slot1MouseClicked

    private void slot2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slot2MouseClicked
        if(play && bet) 
        {
            hold2.setVisible(true); //Makes "Hold" visible when card 1 is clicked
            holdCard2 = true;
        }
    }//GEN-LAST:event_slot2MouseClicked
    
    private void slot3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slot3MouseClicked
        if(play && bet) 
        {
            hold3.setVisible(true); //Makes "Hold" visible when card 1 is clicked
            holdCard3 = true;
        }
    }//GEN-LAST:event_slot3MouseClicked

    private void slot4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slot4MouseClicked
        if(play && bet) 
        {
            hold4.setVisible(true); //Makes "Hold" visible when card 1 is clicked
            holdCard4 = true;
        }
    }//GEN-LAST:event_slot4MouseClicked

    private void slot5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_slot5MouseClicked
        if(play && bet) 
        {
            hold5.setVisible(true); //Makes "Hold" visible when card 1 is clicked
            holdCard5 = true;
        }
    }//GEN-LAST:event_slot5MouseClicked

    private void betMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betMaxActionPerformed
        if (bet == false) 
        {
            if (playCredits>0) 
            {
                playCredits-=5;  
                credits.setText("Credits: " + " " + playCredits);
                bet = true;
                play = true;
                betNumber.setText("Bet: 5");
            } 
            
            else 
            {
                JOptionPane.showMessageDialog(null, "You don't have enough credits! Please add more by clicking one of the buttons under"
                        + "the 'Add Money Button'");
            }
            
       }
        
    }//GEN-LAST:event_betMaxActionPerformed
        //To do: bet two or three or four
    private void betOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betOneActionPerformed
        
        if (playCredits >= (initialCredits-5) && counter<6)    
        {
           if (playCredits>0) 
            {
                playCredits-=1;  
                credits.setText("Credits: " + " " + playCredits);
                play = true;
                betNumber.setText("Bet: " + counter);
            } 
            
            else 
            {
                JOptionPane.showMessageDialog(null, "You don't have enough credits! Please add more by clicking one of the buttons under"
                        + "the 'Add Money Button'");
            }
            counter++;
        }
        bet = true;
        
    }//GEN-LAST:event_betOneActionPerformed

    private void creditsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creditsMouseClicked
        dollars = (playCredits/4.0);
        credits.setText("Money: " + " $" + dollars);   
        //To do: restore to original conditions when clicked
    }//GEN-LAST:event_creditsMouseClicked

    private void addTwentyFiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTwentyFiveMouseClicked
        playCredits+=(25*4);
        JOptionPane.showMessageDialog(null, "$25 or 80 credits has been added to your account.");
        credits.setText("Credits: " + " " + playCredits);
    }//GEN-LAST:event_addTwentyFiveMouseClicked

    private void addTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTenMouseClicked
        playCredits+=(10*4);
        JOptionPane.showMessageDialog(null, "$10 or 40 credits has been added to your account.");
        credits.setText("Credits: " + " " + playCredits); 
    }//GEN-LAST:event_addTenMouseClicked

    private void addFiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFiveMouseClicked
        playCredits+=(5*4);
        JOptionPane.showMessageDialog(null, "$5 or 20 credits has been added to your account.");
        credits.setText("Credits: " + " " + playCredits); 
    }//GEN-LAST:event_addFiveMouseClicked

    private void addOneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addOneMouseClicked
        playCredits+=(1*4);
        JOptionPane.showMessageDialog(null, "$1 or 4 credits has been added to your account.");
        credits.setText("Credits: " + " " + playCredits); 
    }//GEN-LAST:event_addOneMouseClicked
    
    private void points(int cardVal) 
    {            
        numBet = initialCredits - playCredits; 
        //calculate the # of points based on hand on bet amount
        pointsAdded = numBet * cardVal;
        playCredits += (pointsAdded);
        if (playCredits>initialCredits) 
        {
            JOptionPane.showMessageDialog(null, "You won " + pointsAdded + " credits. " + pointsAdded + " credits were added to your account."); 
        } 
        
        else if(playCredits == initialCredits)
        {
            JOptionPane.showMessageDialog(null, "You won " + pointsAdded + " credits, but overall, didn't gain any credits.");
        }
        
        else 
        {
            JOptionPane.showMessageDialog(null, "You didn't win any credits."); //If the initial amount of credits are the same
        }
        credits.setText("Credits: " + " " + playCredits);
    }
    private void nextHand() //reset vars
    {
        hold1.setVisible(false); 
        holdCard1 = false;
        
        hold2.setVisible(false); //Makes "Hold" visible when card 2 is clicked
        holdCard2 = false;
        
        hold3.setVisible(false); //Makes "Hold" visible when card 3 is clicked
        holdCard3 = false;
        
        hold4.setVisible(false); //Makes "Hold" visible when card 4 is clicked
        holdCard4 = false;
        
        hold5.setVisible(false); //Makes "Hold" visible when card 5 is clicked
        holdCard5 = false;
        
        bet = false;  
        play = false; 
        deal = false; 
        counter = 1;
        initialCredits = 0;
        numBet = 0;
        pointsAdded = 0;   
        initialCredits = playCredits;
        
        ImageIcon x = new ImageIcon("resources/BACK-1.jpg"); 
        slot2.setIcon(x);
        slot3.setIcon(x);
        slot4.setIcon(x);
        slot5.setIcon(x);
        
        credits.setText("Credits: " + " " + playCredits); 
        betNumber.setText("Bet: " + 0);
        
        ImageIcon table = new ImageIcon("resources/payTable.PNG"); 
        payTable.setIcon(table); 
        
        pairs = 0;
        startDeck.clear();
        shuffleDeck.clear();
        randCard();
    }
    
    public static void main(String args[]) 
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new NewJFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration 
    private javax.swing.JButton addTen;
    private javax.swing.JButton addTwentyFive;
    private javax.swing.JButton betMax;
    private javax.swing.JLabel betNumber;
    private javax.swing.JButton betOne;
    private javax.swing.JLabel credits;
    private javax.swing.JButton dealButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel hold1;
    private javax.swing.JLabel hold2;
    private javax.swing.JLabel hold3;
    private javax.swing.JLabel hold4;
    private javax.swing.JLabel hold5;
    private javax.swing.JButton loadButton;
    private javax.swing.JLabel payTable;
    private javax.swing.JLabel slot1;
    private javax.swing.JLabel slot2;
    private javax.swing.JLabel slot3;
    private javax.swing.JLabel slot4;
    private javax.swing.JLabel slot5;
    // End of variables declaration
}
