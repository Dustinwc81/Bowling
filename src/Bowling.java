import java.util.Scanner;

public class Bowling
{

	public static void main(String [] args)
	{
		Scanner input = new Scanner (System.in);

		String playerName;
		int totalScore = 0;
		int roll3 = 0;
		int [] roll1 = new int [10];
		int [] roll2 = new int [10];
		int [] frameScore = new int [10];
		int [] score = new int [10];

		System.out.println("Please enter your name: ");
		playerName = input.nextLine();

		System.out.println("WELCOME " + playerName + " to bowling 2017!!\n");
		System.out.println("***** Please enter 10 for a Strike *****");
		System.out.println("****** Otherwise enter all scores ******");
		System.out.println("************* GOOD LUCK ****************");

		for(int i = 0; i < frameScore.length; i++)
		{
			if(i < 9)
			{
				System.out.print("Frame" + " " + (i + 1) + " \n");
				System.out.print("Enter Score for roll 1 on Frame " + (i + 1));
				roll1 [i] = input.nextInt();
				input.nextLine();
				
				while(roll1 [i]<0 || roll1 [i]>10)
				{
					System.out.println("Invalid entry:  Please enter a Roll 0-10: \n");
					roll1[i] = input.nextInt();
					input.nextLine();
				}


				if(roll1 [i] == 10)
				{
					System.out.println("GREAT STRIKE!!\n");
					frameScore [i] = 10;
					System.out.println("Frame " + (i + 1) + " score is: " + frameScore [i] + "\n");
				}
				else
				{
					System.out.println("Please enter score for roll 2 on Frame " + (i + 1));
					roll2 [i] = input.nextInt();
					input.nextLine();
					
					while(roll1[i] + roll2 [i] < 0 || roll1[i] + roll2 [i] >10)
					{
						System.out.println("Invalid entry:  Please enter a valid second roll 0-10: \n");
						roll2[i] = input.nextInt();
						input.nextLine();
					}

					if(roll1 [i] + roll2 [i] == 10)
					{
						System.out.println("Nice Spare\n");
						frameScore [i] = 10;
						System.out.println("Frame " + (i + 1) + " score is: " + frameScore [i] + "\n");
					}
					else
					{
						frameScore [i] = roll1 [i] + roll2 [i];
						System.out.println("Frame " + (i + 1) + " score is: " + frameScore [i] + "\n");
					}
				}
			}

			//10th frame

			if(i == 9)
			{

				System.out.println("Please enter score for roll 1 on Frame 10: ");
				roll1 [i] = input.nextInt();
				input.nextLine();

				if(roll1[i] == 10)
				{
					System.out.println("GREAT STRIKE!!\n");
					System.out.println("Please enter score for roll 2 on Frame 10: ");
					roll2 [i]= input.nextInt();
					input.nextLine();
					
					if(roll2[i] == 10)
					{
						System.out.println("GREAT STRIKE!!\n");
					}

					System.out.println("Please enter score for roll 3 on Frame 10: ");
					roll3 = input.nextInt();
					input.nextLine();
					
					if(roll3 == 10)
					{
						System.out.println("GREAT STRIKE!!\n");
					}

					frameScore [i] = roll1 [i] + roll2 [i] + roll3;
					System.out.println("Frame 10 score is: " + frameScore [i] + "\n");
				}
				else
				{
					System.out.println("Please enter score for roll 2 on Frame 10: ");
					roll2 [i] = input.nextInt();
					input.nextLine();

					if(roll1 [i] + roll2 [i] == 10)
					{
						System.out.println("Nice Spare\n");
						System.out.println("Please enter score for roll 3 on Frame 10: ");
						roll3 = input.nextInt();
						input.nextLine();

						frameScore [i] = roll1 [i] + roll2 [i] + roll3;
						System.out.println("Frame 10 score is: " + frameScore [i] + "\n");
					}
					else
					{
						frameScore [i] = roll1 [i] + roll2 [i];
						System.out.println("Frame 10 score is: " + frameScore [i] + "\n");
					}
				}
				
				// use a printf statement here to show the frames/rolls/and Scorecard

				System.out.printf("\t\t\t\t\t\t%s SCORECARD\n\n", playerName);

				System.out.print("Frame: \t\t 1 \t 2 \t 3 \t 4 \t 5 \t 6 \t 7 \t 8 \t 9 \t 10\n");

				System.out.printf("Rolls:\t\t%d %d\t%d %d\t%d %d\t%d %d\t%d %d\t%d %d\t%d %d\t%d %d\t%d %d\t%d %d %d\n", 
						roll1[0], roll2[0], roll1[1],roll2[1], roll1[2], roll2[2], 
						roll1[3], roll2[3], roll1[4], roll2[4], roll1[5], roll2[5], roll1[6], roll2[6], roll1[7], roll2[7], 
						roll1[8], roll2[8], roll1[9], roll2[9], roll3);

				System.out.printf("Frame Score:\t%d \t %d \t %d \t %d \t %d \t %d \t %d \t %d \t %d \t  %d\n", 
						frameScore[0], frameScore[1], frameScore[2], frameScore[3], frameScore[4],
						frameScore[5], frameScore[6], frameScore[7], frameScore[8], frameScore[9]);
			}
		}
		input.close();

		// tally the entire score through frame 8
		// 1st roll == 10;  score = frame

		for(int i = 0; i < frameScore.length; i++)
		{
			if (i < 8)	
			{
				if(roll1[i] == 10)	//1st roll a strike , initialize the scoring
				{
					if(roll1[i+1] == 10)  //1st roll a strike on next frame
					{		
						if(roll1[i+2] == 10) //1st roll a strike on next frame
						{
							score[i] = 30;						

						}
						else
						{
							score[i] = 20 + roll1[i+2];
						}
					}
					else
					{
						//if roll 1 next frame doesn't equal ten 
						score[i] = 10 + roll1[i+1] + roll2[i+1];

					}
				}
				else
				{
					score[i] = roll1[i] + roll2[i];


					if(score[i] == 10)		//spare
					{
						score[i] = 10 + roll1[i+1];

					}
				}
			}
			
			if(i >= 8)	
			{
				if(roll1[8] == 10)		//frame 9
				{
					if(roll1[9] == 10)
					{
						if(roll2[9] == 10)
						{
							score[8] = 30;
						}
							
					}
					else
					{
						score[8] = 10 + roll1[9] + roll2[9];
					}
				}
				else
				{
					score[8] = roll1[9] + roll2[9];
					
					if(score[8] == 10)
					{
						score[8] = 10 + roll1[9];
					}
				}
				
				if(roll1[9] == 10)		//frame 10
				{
					score[9] = 10 + roll2[9] + roll3;
				}
				else
				{
					score[9] = roll1[9] + roll2[9];
					
					if(roll1[9] + roll2[9] == 10)
					{
						score[9] = 10 + roll3;
					}
				}
			}
		}
		
		System.out.printf("Score:\t\t%d \t %d \t %d \t %d \t %d \t %d \t %d \t %d \t %d \t  %d\n", 
				score[0], score[1], score[2], score[3], score[4],
				score[5], score[6], score[7], score[8], score[9]);
		
		totalScore = score[0] + score[1] + score[2] + score[3] + score[4] + score[5] + score[6] + score[7] + score[8] + score[9];
		System.out.println("\nYour Total Score is: " + totalScore);
		
		
	}	
}

