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

public class CurrentAccount extends Account{
    private Keypad keypad; // initialize references to keypad  
    private int overdrawnLimit; // use to save overdrawn limit
    
    // CurrentAccountr constructor 
    public CurrentAccount(int theAccountNumber, int thePIN, double theAvailableBalance, 
            double theTotalBalance){
        super(theAccountNumber, thePIN,  theAvailableBalance, theTotalBalance ); // initialize superclass variables
        overdrawnLimit = 10000; // 10000 overdrawn limit
    }
    // set overdrawn limit
    public void setOverdrawnLimit(){
        overdrawnLimit = keypad.getInput();
    }
    // return overdrawn limit
    public int getOverdrawnLimit(){
        return overdrawnLimit;
    }
}
