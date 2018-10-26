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

public class SavingAccount extends Account{
    private Keypad keypad; // initialize references to keypad  
    private double interestRate = 0.001; // use to save interest rate
    
    // SavingAccount constructor 
    public SavingAccount(int theAccountNumber, int thePIN, double theAvailableBalance, 
            double theTotalBalance){
        super(theAccountNumber, thePIN,  theAvailableBalance, theTotalBalance ); // initialize superclass variables
    }
     // set interest rate
    public void setInterestRate(){
        interestRate = keypad.getDoubleInput();
    }
     // get interest rate
    public double getInterestRate(){
        return interestRate;
    }
}
