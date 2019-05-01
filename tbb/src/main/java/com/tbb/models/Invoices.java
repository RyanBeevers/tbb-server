package com.tbb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
    private Date invoiceDateOfIssue;

    @Column(name="invoice_discount")
    private double invoiceDiscount;

    @Column(name="invoice_total")
    private double invoiceTotal;

    @NotNull
    @Column(name="invoice_pay_by_date")
    private Date invoicePayByDate;

    @Column(name="invoice_paid_date")
    private Date invoicePaidDate;

    @NotNull
    @Column(name="invoice_paid_flag")
    private boolean invoicePaidFlag;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cust_id")
    private Customers customer;

    @OneToMany(mappedBy = "invoices", cascade = CascadeType.ALL)
    private List<Tasks> tasks;

    public Invoices() {
    }

    public Invoices(@NotNull Date invoiceDateOfIssue, double invoiceDiscount, double invoiceTotal, @NotNull Date invoicePayByDate, Date invoicePaidDate, @NotNull boolean invoicePaidFlag, @NotNull Customers customer, List<Tasks> tasks) {
        this.invoiceDateOfIssue = invoiceDateOfIssue;
        this.invoiceDiscount = invoiceDiscount;
        this.invoiceTotal = invoiceTotal;
        this.invoicePayByDate = invoicePayByDate;
        this.invoicePaidDate = invoicePaidDate;
        this.invoicePaidFlag = invoicePaidFlag;
        this.customer = customer;
        this.tasks = tasks;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDateOfIssue() {
        return invoiceDateOfIssue;
    }

    public void setInvoiceDateOfIssue(Date invoiceDateOfIssue) {
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

    public Date getInvoicePayByDate() {
        return invoicePayByDate;
    }

    public void setInvoicePayByDate(Date invoicePayByDate) {
        this.invoicePayByDate = invoicePayByDate;
    }

    public Date getInvoicePaidDate() {
        return invoicePaidDate;
    }

    public void setInvoicePaidDate(Date invoicePaidDate) {
        this.invoicePaidDate = invoicePaidDate;
    }

    public boolean isInvoicePaidFlag() {
        return invoicePaidFlag;
    }

    public void setInvoicePaidFlag(boolean invoicePaidFlag) {
        this.invoicePaidFlag = invoicePaidFlag;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Invoices{" +
                "invoiceId=" + invoiceId +
                ", invoiceDateOfIssue=" + invoiceDateOfIssue +
                ", invoiceDiscount=" + invoiceDiscount +
                ", invoiceTotal=" + invoiceTotal +
                ", invoicePayByDate=" + invoicePayByDate +
                ", invoicePaidDate=" + invoicePaidDate +
                ", invoicePaidFlag=" + invoicePaidFlag +
                ", customer=" + customer +
                ", tasks=" + tasks +
                '}';
    }
}
