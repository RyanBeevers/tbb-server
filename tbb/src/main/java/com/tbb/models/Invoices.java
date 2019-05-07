package com.example.demo.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="INVOICES")
public class Invoices {

    @Id
    @Column(name="invoice_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="invoice_seq")
    @SequenceGenerator(name="invoice_seq", sequenceName="invoice_seq", allocationSize = 1)
    private int invoiceId;

    @NotNull
    @Column(name="invoice_date_of_issue")
    private String invoiceDateOfIssue;

    @Column(name="invoice_discount")
    private double invoiceDiscount;

    @Column(name="invoice_total")
    private double invoiceTotal;

    @NotNull
    @Column(name="invoice_pay_by_date")
    private String invoicePayByDate;

    @Column(name="invoice_paid_date")
    private String invoicePaidDate;

    @NotNull
    @Column(name="invoice_paid_flag")
    private boolean invoicePaidFlag;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Users user;

    @JsonIgnore
    @OneToMany(mappedBy = "invoices", cascade = CascadeType.ALL)
    private List<Tasks> tasks;

    public Invoices() {
    }

    public Invoices(int invoiceId){
        super();
        this.invoiceId = invoiceId;
    }

    public Invoices(@NotNull String invoiceDateOfIssue, double invoiceDiscount, double invoiceTotal,
                    @NotNull String invoicePayByDate, String invoicePaidDate, @NotNull boolean invoicePaidFlag) {
        super();
        this.invoiceDateOfIssue = invoiceDateOfIssue;
        this.invoiceDiscount = invoiceDiscount;
        this.invoiceTotal = invoiceTotal;
        this.invoicePayByDate = invoicePayByDate;
        this.invoicePaidDate = invoicePaidDate;
        this.invoicePaidFlag = invoicePaidFlag;
    }


    public int getInvoiceId() {
        return invoiceId;
    }


    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }


    public String getInvoiceDateOfIssue() {
        return invoiceDateOfIssue;
    }


    public void setInvoiceDateOfIssue(String invoiceDateOfIssue) {
        this.invoiceDateOfIssue = invoiceDateOfIssue;
    }


    public double getInvoiceDiscount() {
        return invoiceDiscount;
    }


    public void setInvoiceDiscount(double invoiceDiscount) {
        this.invoiceDiscount = invoiceDiscount;
    }


    public double getInvoiceTotal() {
        return invoiceTotal;
    }


    public void setInvoiceTotal(double invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }


    public String getInvoicePayByDate() {
        return invoicePayByDate;
    }


    public void setInvoicePayByDate(String invoicePayByDate) {
        this.invoicePayByDate = invoicePayByDate;
    }


    public String getInvoicePaidDate() {
        return invoicePaidDate;
    }


    public void setInvoicePaidDate(String invoicePaidDate) {
        this.invoicePaidDate = invoicePaidDate;
    }


    public boolean isInvoicePaidFlag() {
        return invoicePaidFlag;
    }


    public void setInvoicePaidFlag(boolean invoicePaidFlag) {
        this.invoicePaidFlag = invoicePaidFlag;
    }


    public Users getUser() {
        return user;
    }


    public void setUser(Users user) {
        this.user = user;
    }


    public List<Tasks> getTasks() {
        return tasks;
    }


    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoices invoices = (Invoices) o;
        return invoiceId == invoices.invoiceId &&
                Double.compare(invoices.invoiceDiscount, invoiceDiscount) == 0 &&
                Double.compare(invoices.invoiceTotal, invoiceTotal) == 0 &&
                invoicePaidFlag == invoices.invoicePaidFlag &&
                Objects.equals(invoiceDateOfIssue, invoices.invoiceDateOfIssue) &&
                Objects.equals(invoicePayByDate, invoices.invoicePayByDate) &&
                Objects.equals(invoicePaidDate, invoices.invoicePaidDate) &&
                Objects.equals(user, invoices.user) &&
                Objects.equals(tasks, invoices.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, invoiceDateOfIssue, invoiceDiscount, invoiceTotal, invoicePayByDate, invoicePaidDate, invoicePaidFlag, user, tasks);
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "invoiceDateOfIssue='" + invoiceDateOfIssue + '\'' +
                ", invoiceDiscount=" + invoiceDiscount +
                ", invoiceTotal=" + invoiceTotal +
                ", invoicePayByDate='" + invoicePayByDate + '\'' +
                ", invoicePaidDate='" + invoicePaidDate + '\'' +
                ", invoicePaidFlag=" + invoicePaidFlag +
                '}';
    }
}
