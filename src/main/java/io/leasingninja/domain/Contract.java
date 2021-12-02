package io.leasingninja.domain;

import java.time.LocalDate;

public class Contract {

    private String contractNumber;
	private String lessee;
	private String car;
	private double price;
//	private String currency;
    private double installment;
	private LocalDate signDate;

    public Contract() {
    }

    public String getNumber() {
        return contractNumber;
    }

    public void setNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getLessee() {
        return lessee;
    }

    public void setLessee(String lessee) {
        this.lessee = lessee;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getInstallment() {
        return installment;
    }

    public void setInstallment(double installment) {
        this.installment = installment;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

}