/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.io.Serializable;
import java.time.*;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Carlos Ortigoza
 */
@ManagedBean(name = "bankbean", eager = true)
@RequestScoped
public class Bankbean implements Serializable {

    private String history = " Fecha:" + LocalDate.now() + " " + LocalTime.now();

    private String message;
    private Double amount;
    private Double remainder;

    /**
     *
     * Creates a new instance of Bankbean
     */
    public Bankbean() {
    }

    public ArrayList<histories> getListHistory() {
        return listHistory;
    }

    public ArrayList<accountBank> getTotaList() {
        return totaList;
    }

    public Double getRemainder() {
        return remainder;
    }

    public void setRemainder(Double remainder) {
        this.remainder = remainder;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double consult() {
        return totaList.get(0).getBalance();
    }

    public static final ArrayList<accountBank> totaList = new ArrayList<accountBank>(Arrays.asList(
            new accountBank(100000.0)
    ));

    public static final ArrayList<histories> listHistory = new ArrayList<histories>(Arrays.asList(
            new histories("Saldo inicial: 100000")
    ));

    public void retire(Double value) {
        totaList.get(0).retire(value);
        this.message = "Saldo retirado\n nuevo saldo:" + this.consult();
        listHistory.add(new histories("Retiro realizado: " + value + " " + history));
    }

    public void consign() {
        totaList.add(new accountBank(amount));
        totaList.get(0).consign(amount);
        this.message = "Saldo consignado\n nuevo saldo: " + this.consult();
        listHistory.add(new histories("Consignacion realizada: " + amount + " " + history));
    }

    public void extract() {
        if (remainder > totaList.get(0).getBalance()) {
            message = "Saldo insuficiente";
            return;
        }
        this.retire(remainder);
        message = "Retiro exitoso,\n nuevos saldo:" + this.consult();
    }

}
