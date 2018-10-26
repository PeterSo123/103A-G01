// BankDatabase.java
// Represents the bank account information database 
 
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
public class BankDatabase
{
   private Account accounts[]; // array of Accounts
//============================modified part=======================      
   private SavingAccount savingAccounts[];
   private CurrentAccount currentAccounts[];   
   // no-argument BankDatabase constructor initializes accounts
   public BankDatabase()
   {
      accounts = new Account[ 4 ]; // 4 accounts for testing
      savingAccounts = new SavingAccount[ 2 ]; // create array to save saving account number
      currentAccounts = new CurrentAccount[ 2 ];// create array to save current account number

      savingAccounts[ 0 ] = new SavingAccount(12345, 54321, 1000.0, 1200.0);
      savingAccounts[ 1 ] = new SavingAccount(98765, 56789, 200.0, 200.0);
      currentAccounts[ 0 ] = new CurrentAccount(12340, 54321, 1000.0, 1200.0);
      currentAccounts[ 1 ] = new CurrentAccount(98760, 56789, 200.0, 200.0);
      
      // put saving account and current account saving into array of accounts
      for(int i = 0, j = 0, k = 0; k < accounts.length; ){
          accounts[k++] = savingAccounts[i++];
          accounts[k++] = currentAccounts[j++];
      }

   } // end no-argument BankDatabase constructor
 //============================modified part=======================      
   // retrieve Account object containing specified account number
   private Account getAccount( int accountNumber )
   {
      // loop through accounts searching for matching account number
      for ( Account currentAccount : accounts )
      {
         // return current account if match found
         if ( currentAccount.getAccountNumber() == accountNumber )
            return currentAccount;
      } // end for

      return null; // if no matching account was found, return null
   } // end method getAccount

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount( userAccountNumber );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         return userAccount.validatePIN( userPIN );
      else
         return false; // account number not found, so return false
   } // end method authenticateUser

   // return available balance of Account with specified account number
   public double getAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   public double getTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getTotalBalance();
   } // end method getTotalBalance

   // credit an amount to Account with specified account number
   public void credit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).credit( amount );
   } // end method credit

   // debit an amount from of Account with specified account number
   public void debit( int userAccountNumber, double amount )
   {
      getAccount( userAccountNumber ).debit( amount );
   } // end method debit
 
 //============================modified part=======================   
      //for transfer to get account number
   public int getTransferAccountNumber(int i){
       return accounts[i].getAccountNumber();
   }
   public int getAccountsQuantity(){
       return accounts.length;
   }
   
   public void transferCredit( int userAccountNumber, double amount ){
      getAccount( userAccountNumber ).transferCredit( amount );
   }
  
   // check the acount is saving account or current account
   public boolean isSavingAccountOrCurrent(int userAccountNumber){
       int i = 0;
       for(; i < accounts.length; i++){
           if(accounts[i].getAccountNumber() == userAccountNumber)
               break;
       }
       if(i%2 == 0)
           return true;
       else
           return false;
 //============================modified part=======================      
   }
   
} // end class BankDatabase



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