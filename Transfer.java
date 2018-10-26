/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

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

public class Transfer extends Transaction{
    
    private Keypad keypad; // reference to keypad
    private Screen screen; // reference to screen
    private BankDatabase bankdatabase; // reference to bankdatabase
	//declare instance variable
    private int transferAccountNumber;
    private double transferAmount;
    
    // Transfer constructor 
    public Transfer(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad){
        super(userAccountNumber, atmScreen, atmBankDatabase); // initialize superclass variables
        keypad = atmKeypad; // initialize references to keypad  
        // get reference
        screen = getScreen();
        bankdatabase = getBankDatabase();     
    } // end Transfer constructor
    
    // input transfer account Number
    public void setTransferAccountNumber(){
        transferAccountNumber = keypad.getInput();
    }
    
    // return account number 
    public int getTransferAccountNumber(){
        return transferAccountNumber;
    }
    
    // input transfer amount
    public void setTransferAmount(){
        transferAmount = keypad.getDoubleInput();
    }
    
    // return Amount
    public double getTransferAmount(){
        return transferAmount;
    }
    
    //check transfer account is exist
    public boolean isTransferAccountExist(){
        for(int i = 0; i < bankdatabase.getAccountsQuantity(); i++){
            if(transferAccountNumber == bankdatabase.getTransferAccountNumber(i))
                return true;
        }
        return false;
    }
    
    //confirm user input correct data
    public boolean confirmToTransfer(){
        screen.displayMessageLine(" ");
        screen.displayMessage("Transfer Account Number: "); //display Transfer account Number
        System.out.println(transferAccountNumber); // user input account number again
        screen.displayMessage("Transfer Amount: ");  //display Transfer Amount
        screen.displayDollarAmount(transferAmount);
        System.out.print("\n");
        boolean correctInput = false;
        int option = 0;
        while(!correctInput){ // while loop
            // prompt user input ""Yes" or "No"
            screen.displayMessage("\nYes - Press 1  ||  No - Press 2: ");
            option = keypad.getInput();
            if(option == 1 || option == 2)  //check the input is valid
                correctInput = true;
            else
                screen.displayMessageLine("Wrong Input. Please enter again.");
        } // end while loop
        if(option == 1) 
            return true; // user input 1 will return true
        else
            return false; // user input 2 will return false
    }
    
    // perform transaction
    public void execute(){
        //user input the tansfer account number
        screen.displayMessageLine(" ");
        screen.displayMessage("Please Enter the Transfer Account Number: ");
        setTransferAccountNumber();
        
        // check whether the transfer account is exist 
        if(isTransferAccountExist() == false){
            screen.displayMessage("----------------------------------------");
            screen.displayMessageLine("\n**Transfer Account doesn't exist.**");
            screen.displayMessageLine("**Transfer Failure**");
            screen.displayMessageLine("----------------------------------------");
            return;
        }
        
        // check whether the transfer account is current login account  
        if(transferAccountNumber == super.getAccountNumber()){
            screen.displayMessage("----------------------------------------");
            screen.displayMessageLine("\n**You cannot transfer to your own account.**");
            screen.displayMessageLine("**Transfer Failure**");
            screen.displayMessageLine("----------------------------------------");
            return;
        }
        
        // prompt user input the transfer amount 
        screen.displayMessage("Please Enter the Transfer Amount: ");
        setTransferAmount();
        
        // check whether the amount is valid
        if(transferAmount <= 0){
            screen.displayMessage("----------------------------------------");
            screen.displayMessageLine("\n**Transfer Amount should be greater than 0**");
            screen.displayMessageLine("**Transfer Failure**");
            screen.displayMessageLine("----------------------------------------");
            return;
        }
        
        //call method to confirm the data by user input is correct 
        if(confirmToTransfer() == false){
            screen.displayMessageLine("Transfer Cancelled");
            return;
        }
        
        //check whether the user has enough money in the account 
        if(transferAmount > bankdatabase.getTotalBalance(super.getAccountNumber()) ||
                transferAmount > bankdatabase.getAvailableBalance(super.getAccountNumber())){
            screen.displayMessage("---------------------------------------------");
            screen.displayMessageLine("\n**You have not sufficient balance to transfer**");
            screen.displayMessageLine("**Transfer Failure**");
            screen.displayMessageLine("---------------------------------------------");
            return;
        }
        
        //change amount of account, if the transfer is success
        bankdatabase.transferCredit(transferAccountNumber, transferAmount);
        bankdatabase.debit(super.getAccountNumber(), transferAmount);
        System.out.println("\n**Transfer Successful**");
        System.out.println("You transfer $" + transferAmount + " to account ** " + transferAccountNumber + " **" );
        //For checking transfer account whether receive the amount or not
        //BalanceInquiry balanceInquiry = new BalanceInquiry(transferAccountNumber,screen,bankdatabase);
        //balanceInquiry.execute();
    } //end executo
}// end class tranfer 
