package ATM;

import States.ATMState;
import States.IdleState;

public class ATM {
    private static ATM atm = new ATM();

    ATMState currentState;

    private int atmBalance;
    int numOf2000;
    int numOf500;
    int numOf100;

    private ATM() {

    }

    public static ATM getAtm() {
        atm.setCurrentState(new IdleState());
        return atm;
    }

    public static void setAtm(ATM atm) {
        ATM.atm = atm;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int numOf2000, int numOf500, int numOf100) {
        this.atmBalance = atmBalance;
        this.numOf2000 = numOf2000;
        this.numOf500 = numOf500;
        this.numOf100 = numOf100;
    }

    public int getNumOf2000() {
        return numOf2000;
    }

    public int getNumOf500() {
        return numOf500;
    }

    public int getNumOf100() {
        return numOf100;
    }

    public void deductATMBalance(int amount) {
        atmBalance -= amount;
    }

    public void deductNumOf2000(int amount) {
        numOf2000 -= amount;
    }

    public void deductNumOf500(int amount) {
        numOf500 -= amount;
    }

    public void deductNumOf100(int amount) {
        numOf100 -= amount;
    }

    public void printATM() {
        System.out.println("ATM Balance: " + atmBalance);
        System.out.println("Num of 2000: " + numOf2000);
        System.out.println("Num of 500: " + numOf500);
        System.out.println("Num of 100: " + numOf100);
    }
}
