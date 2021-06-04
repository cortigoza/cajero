/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos Ortigoza
 */
public class accountBank {

    private double balance;

    public accountBank(double initial) {
        balance = initial;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void consign(double balance) {
        this.balance += balance;
    }

    public void retire(double balance) {
        this.balance -= balance;
    }
}
