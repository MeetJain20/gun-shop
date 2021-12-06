package GS;

import java.util.Scanner;

public class Test {

	public static void frontPage() {
		boolean querying = true;
		try ( // Our input scanner
				Scanner scan = new Scanner(System.in)) {
			while (querying) {

				// Print the menu
				System.out.printf("\n\n- - - -╾━╤デ╦︻  Welcome To Lock 'N Loaded  ︻╦デ╤━╾- - - -\n\n\n");
				System.out.printf("Please Choose the required option\n\n\n");

				System.out.printf("1. User Login and Shop\n");
				System.out.printf("2. User SignUp\n");
				System.out.printf("3. Admin Login\n");
				System.out.printf("4. Exit\n");
				System.out.printf("\n\n- - - -╾━╤デ╦︻ *********************** ︻╦デ╤━╾- - - -\n\n");
				System.out.printf("Enter Your Choice : ");

				String input = scan.nextLine();

				int answer;
				try {
					answer = Integer.valueOf(input);
				} catch (Exception e) {
					answer = -1;
				}
				if (answer == -1 || answer < 1 || answer > 4) {
					// User entered incorrect input
					System.out.printf("Incorrect Input!!!\n");
					System.out.printf("Please enter a number from 1-4\n");
				}

				else if (answer == 1) {
					Login L = new Login();
					L.log(scan);
				}

				else if (answer == 2) {
					Signup S = new Signup();
					S.sign(scan);
				}

				else if (answer == 3) {

					System.out.println("Verfiy Yourself as Admin : ");
					System.out.printf("Enter UserId : ");

					String userId = scan.nextLine();
					int val;
					try {
						val = Integer.valueOf(userId);
					} catch (Exception e) {
						val = -1;
					}
					System.out.printf("Enter Password : ");
					String pass = scan.nextLine();

					AdminVerify AV = new AdminVerify();
					if (val == AV.getUserId() && pass.equals(AV.getPassword())) {
						Adminpage ap = new Adminpage();
						ap.adpage(scan);

					} else {
						System.out.printf("\nIncorrect Username or Password !!!\nPlease Try Again !!!\n");
					}
				} else if (answer == 4) {
					querying = false;

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		
		int length = args.length; 
		  switch(length) 
		  { 
		   case 1: 
		      { 
		       System.out.printf("Help\nThe user should enter 2 arguments -\n1) path of csv file\n 2)user should enter 'm' - model , 'u' - user , 'l' - logbook for entering the data to  tables  .");
		       break; 
		      } 
		   case 2: 
		      { 	
		    	  
		    	  if(args[1] == "m") {
		    		  CSVReader.fill(args[0], 1);    		  
		    	  }else if(args[1] == "u") {
		    		  CSVReader.fill("u", 1);
		    	  }else if(args[1] == "l") {
		    		  CSVReader.fill("l", 1);
		    	  }
		    	  else {
		    		  System.out.println(" Wrong Input (only m, u, l is accepted)");
		    	  }
		       break; 
		      }
		   case 0 :
			   break;
		      default: 
		      { 
		       System.out.printf("Invalid Input !!!\n"); 
		      } 
		  }
		
		frontPage();
		System.out.printf("Rock 'N Roll Baby\n");

	}
}
