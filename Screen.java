// Screen.java
// Represents the screen of the ATM
 
/*
CCN2242 Object Oriented Programming
*******Group103A-G01*******
|-------------------------|
|Student Name: | ID:      |
|-------------------------|
|CHAN Chi Nok* | 17081358A|
|CHENG Yue Ting| 17034751A| 
|CHEUNG Tsz Kin| 17116222A| 
|LAM Fuk Kwan  | 17175050A|
|LAM Ho Yin    | 17172060A| 
|SO Man Lung   | 17180545A|
|-------------------------|
 */

/**
 *
 *Make by group 103A-G01
 * 
 */

public class Screen
{
   // displays a message without a carriage return
   public void displayMessage( String message ) 
   {
      System.out.print( message ); 
   } // end method displayMessage

   // display a message with a carriage return
   public void displayMessageLine( String message ) 
   {
      System.out.println( message );   
   } // end method displayMessageLine

   // display a dollar amount
   public void displayDollarAmount( double amount )
   {
      System.out.printf( "$%,.2f", amount );   
   } // end method displayDollarAmount 
} // end class Screen



/**************************************************************************
 * (C) Copyright 1992-2007 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/