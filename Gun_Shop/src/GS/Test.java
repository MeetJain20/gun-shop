/*
package GS;

import java.util.Scanner;

public class Test {
	
	public static void frontPage(){
		boolean querying = true;
		try ( //Our input scanner
	               Scanner scan = new Scanner(System.in)) {
	           while(querying)
	           {
	        	   
	               //Print the menu
	        	   System.out.println();
	        	   System.out.println("#################################");
	               System.out.println("Please Choose the required option");
	            
	               System.out.println("1. User Login and Shop");
	               System.out.println("2. User SignUp ");
	               System.out.println("3. Admin Login");
	               System.out.println("4. Exit");
	               System.out.println("#################################");
	               System.out.println();
	               
	               System.out.println("Enter Your Choice");
	               
	               String input = scan.nextLine();
	               
	               int answer;
	               try{
	            	   answer=Integer.valueOf(input);
	               }
	               catch(Exception e)
	               {
	            	   answer=-1;
	               }
	               if(answer == -1 || answer < 1 || answer > 4)
	               {
	                   //User entered incorrect input
	                   System.out.println("Incorrect Input!");
	                   System.out.println("Please enter a number 1-4");
	               }
	               
	               else if (answer==1){
	            	   Login L = new Login();
	            	   L.log(scan);
	               }
	               
	               else if (answer==2){
	            	   Signup S= new Signup();
	            	   S.sign(scan);
	               }
	               
	               
	               else if (answer==3){
	            	   
	            	   System.out.println("Verfiy Yourself as Admin");
	            	   System.out.println("UserId");
	            	   
	            	   String userId= scan.nextLine();
	            	   int val;
		               try{
		            	   val=Integer.valueOf(userId);
		               }
		               catch(Exception e)
		               {
		            	   val=-1;
		               }
	            	   System.out.println("Password");
	            	   String pass = scan.nextLine();
	            	   
	            	   System.out.println(pass);
	            	   AdminVerify AV= new AdminVerify();
	            	   if (val==AV.getUserId() && pass.equals(AV.getPassword()))
	            	   {
	            		   Adminpage ap= new Adminpage();
		            	   ap.adpage(scan);
		            	   
	            	   }
	            	   else{
	            		   System.out.println("Incorrect Username or Password");
	            	   }
	               }
	               else if (answer == 4)
	               {
	            	   querying = false;
	            	   
	               }
	               
	           }
	        
	      }
			catch (Exception e)
		      {
				System.out.println(e);
		      }
		
	}
	public static void main(String[] args) {
	
		System.out.println("Welcome to Lock-N-Loaded !");
	    frontPage();
	    System.out.println("Rock-N-Roll Baby");
	    
	}
}
*/

package GS;

import java.util.Scanner;

public class Test {
	
	public static void frontPage(){
		boolean querying = true;
		try ( //Our input scanner
	               Scanner scan = new Scanner(System.in)) {
	           while(querying)
	           {
	        	   
	               //Print the menu
	        	   System.out.printf("\n\n- - - -╾━╤デ╦︻  Welcome To Lock 'N Loaded  ︻╦デ╤━╾- - - -\n\n\n");
	               System.out.printf("Please Choose the required option\n\n\n");
	            
	               System.out.printf("1. User Login and Shop\n");
	               System.out.printf("2. User SignUp\n");
	               System.out.printf("3. Admin Login\n");
	               System.out.printf("4. Exit\n");
	               System.out.printf("\n\n- - - -╾━╤デ╦︻ *************************** ︻╦デ╤━╾- - - -\n\n");
	               System.out.printf("Enter Your Choice : ");
	               
	               String input = scan.nextLine();
	               
	               int answer;
	               try{
	            	   answer=Integer.valueOf(input);
	               }
	               catch(Exception e)
	               {
	            	   answer=-1;
	               }
	               if(answer == -1 || answer < 1 || answer > 4)
	               {
	                   //User entered incorrect input
	                   System.out.printf("Incorrect Input!!!\n");
	                   System.out.printf("Please enter a number from 1-4\n");
	               }
	               
	               else if (answer==1){
	            	   Login L = new Login();
	            	   L.log(scan);
	               }
	               
	               else if (answer==2){
	            	   Signup S= new Signup();
	            	   S.sign(scan);
	               }
	               
	               
	               else if (answer==3){
	            	   
	            	   System.out.println("Verfiy Yourself as Admin : ");
	            	   System.out.printf("Please Enter UserId : ");
	            	   
	            	   String userId= scan.nextLine();
	            	   int val;
		               try{
		            	   val=Integer.valueOf(userId);
		               }
		               catch(Exception e)
		               {
		            	   val=-1;
		               }
	            	   System.out.printf("Please Enter Password : ");
	            	   String pass = scan.nextLine();
	            	   
	            	   System.out.printf(pass);
	            	   AdminVerify AV= new AdminVerify();
	            	   if (val==AV.getUserId() && pass.equals(AV.getPassword()))
	            	   {
	            		   Adminpage ap= new Adminpage();
		            	   ap.adpage(scan);
		            	   
	            	   }
	            	   else{
	            		   System.out.printf("Incorrect Username or Password !!!\nPlease Try Again !!!\n");
	            	   }
	               }
	               else if (answer == 4)
	               {
	            	   querying = false;
	            	   
	               }
	               
	           }
	        
	      }
			catch (Exception e)
		      {
				System.out.println(e);
		      }
		
	}
	public static void main(String[] args) {
	
	    frontPage();
	    System.out.printf("Rock 'N Roll Baby\n");
	    
	}
}
