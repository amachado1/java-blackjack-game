import java.util.Scanner;

public class blackjack {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
	
		//Prompts the user to type either yes or no to start the game
		System.out.println("Type yes to start a game of Blackjack. Type no if you want to quit out.");
		String userAnswer = scnr.nextLine();
		
		//The player gets 2500 chips
		int userAmount = 2500;
		
		System.out.println("You get " + userAmount + " free chips");
		
		String userDraw;
		String dealer;
		
		//If player types yes then the game begins
		while (userAnswer.equals("yes") || userAnswer.equals("Yes")) {
			
			//Player is prompted to type in how many chips to bet
			System.out.println("Type in how many chips you are betting:");
			int userBet = scnr.nextInt();
			
			//The amount of chips player has is subtracted by how many chips player bets
			userAmount = userAmount - userBet;
			
			//Draws a random number card from 1-11
			int userCard = (int) ((Math.random() * 10) + 1);
			
			//Default statement in order to draw first card
			userDraw = "draw";
			
			//New loop starts the game
			while (userDraw.equals("draw") || userDraw.equals("Draw")) {
				
				//Displays the current total number the player has after every draw
				System.out.println("Current total: " + userCard);
				
				//Prompts the user to draw a new card or to stay
				System.out.println("Type draw to draw another card. Type stay to stop.");
				
				userDraw = scnr.next();
				
				//If the user types to draw then a new card is drawn
				if (userDraw.equals("draw") || userDraw.equals("Draw")) {
					userCard = userCard + ((int) (Math.random() * 10) + 1);
					
					//If the user reaches 21 exactly then they win automatically and the loop is broken
					if (userCard == 21) {
						break;
					}
					//If the user surpasses 21 then they lose automatically and the loop breaks
					else if (userCard > 21) {
						break;
					}
				}
			}
			
			//After the user's turn is up, the dealer draws their cards
			int dealerHand = (int) ((Math.random() * 10) + 1);
			dealer = "play";
			
			System.out.println();
			System.out.println("Dealer's turn");
			System.out.println();
			
			while (dealer.equals("play")) {
				
				//Dealer "AI" will keep drawing cards until it reaches a satisfactory number
				if (dealerHand >= 1 && dealerHand <= 17) {
					
					//If the dealer reaches a satisfactory amount it will check to see if it surpasses the user's total
					if (dealerHand > userCard) {
						
						//The dealer is scripted to stop if the above criteria is met.
						dealer = "stop";
					}
					
					//However if the above criteria is not met then the dealer will continue to draw until it either busts or surpasses the player
					else {
					System.out.println("Dealer's hand: " + dealerHand);
					dealerHand = dealerHand + (int) ((Math.random() * 10) + 1);
					dealer = "play";
					}
				}
				
				//Dealer stops once it reaches the satisfactory total
				else {
					dealer = "stop";
				}
				
				//Displays dealer's total hand after it finishes
				System.out.println("Dealer's Hand: " + dealerHand);
				
			}
			
			//These if statements are to check for a winner
			
			/*Winning Pools:
			 * Player win = Bet x 2
			 * Player obtains Blackjack = Bet x 3
			 * Stalement = Return bet amount to player
			 * Player loses = Player loses what they bet
			*/
			
			//If statement 1 checks to see if the dealer wins
			if (dealerHand > userCard && dealerHand <= 21) {
				System.out.println();
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println();
				System.out.println("Dealer wins");
			}
			
			//If statement 2 checks to see if the player wins
			else if (dealerHand > 21 && userCard <= 21) {
				System.out.println();
				System.out.println("Dealer Busted");
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println();
				System.out.println("You Win!!!");
				
				//If player wins then they win back their x2 of their bet
				userAmount = (userBet * 2) + userAmount;
			}
			
			//If statement 3 checks to see if the player's hand busted leading to the dealer winning
			else if (dealerHand <= 21 && userCard > 21) {
				System.out.println();
				System.out.println("You Busted");
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println();
				System.out.println("You Lose");
			}
			
			//If statement 4 checks to see if both the dealer and player had the same hand
			else if(dealerHand == userCard && userCard <= 21 && dealerHand <= 21) {
				System.out.println();
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println("Both hands are equal");
				System.out.println();
				System.out.println("Bet is pushed back");
				
				//Player receives back what they bet due to a stalemate
				userAmount = userAmount + userBet;
			}
			
			//If statement 5 checks to see if both the dealer and player busted
			else if (dealerHand > 21 && userCard > 21) {
				System.out.println();
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println("Both busted");
				System.out.println();
				System.out.println("No one wins");
			}
			
			//If statement 6 checks to see if the player obtained a blackjack (Hand reaches 21)
			else if (userCard == 21 && dealerHand != 21) {
				System.out.println();
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println();
				System.out.println("BLACKJACK! You win!");
				
				//Player wins 3 times more of their bet if they obtain a blackjack
				userAmount = (userBet * 3) + userAmount;
			}
			
			//If statement 7 checks to see if the dealer obtained a blackjack (Hand reaches 21)
			else if (dealerHand == 21 && userCard != 21) {
				System.out.println();
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println("Dealer obtained Blackjack");
				System.out.println();
				System.out.println("You lose");
			}
			
			//Default statement
			else {
				System.out.println();
				System.out.println("Dealer's final hand: " + dealerHand);
				System.out.println("Your final hand: " + userCard);
				System.out.println();
				System.out.println("You win!!!");
				
				//If player wins then they win back their x2 of their bet
				userAmount = (userBet * 2) + userAmount;
			}
			
			//First it checks to see if the player has sufficient chips to play again
			if (userAmount > 0) {
				
				//It then prompts the player to play again
				System.out.println("Do you wanna play again? Type yes to play again. Type no to stop playing.");
				System.out.println();
				
				//Displays the player's chip amount
				System.out.println("Current Amount: " + userAmount + " chips");
				userAnswer = scnr.next();
			}
			
			//If the user has insufficient chips to play then the game automatically exits
			else {
				System.out.println("Insufficient Amount of chips to play");
				System.out.println();
				userAnswer = "no";
			}
		}
		
		//Displays thank you message
		System.out.println("Thanks for playing this game!!! :)");

	}

}
