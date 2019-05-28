package com.tbb.models;

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
    @SequenceGenerator(name="invoice_seq", sequenceName="inv_seq", allocationSize = 1)
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
    @Column(name="admin_id")
    private String adminId;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

    @JsonIgnore
    @OneToMany(mappedBy = "invoices", cascade = CascadeType.MERGE)
    private List<Tasks> tasks;

    public Invoices() {
    }

	public Invoices(int invoiceId, @NotNull String invoiceDateOfIssue, double invoiceDiscount, double invoiceTotal,
			@NotNull String invoicePayByDate, String invoicePaidDate, @NotNull boolean invoicePaidFlag,
			@NotNull String adminId) {
		super();
		this.invoiceId = invoiceId;
		this.invoiceDateOfIssue = invoiceDateOfIssue;
		this.invoiceDiscount = invoiceDiscount;
		this.invoiceTotal = invoiceTotal;
		this.invoicePayByDate = invoicePayByDate;
		this.invoicePaidDate = invoicePaidDate;
		this.invoicePaidFlag = invoicePaidFlag;
		this.adminId = adminId;
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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((invoiceDateOfIssue == null) ? 0 : invoiceDateOfIssue.hashCode());
		long temp;
		temp = Double.doubleToLongBits(invoiceDiscount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + invoiceId;
		result = prime * result + ((invoicePaidDate == null) ? 0 : invoicePaidDate.hashCode());
		result = prime * result + (invoicePaidFlag ? 1231 : 1237);
		result = prime * result + ((invoicePayByDate == null) ? 0 : invoicePayByDate.hashCode());
		temp = Double.doubleToLongBits(invoiceTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoices other = (Invoices) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (invoiceDateOfIssue == null) {
			if (other.invoiceDateOfIssue != null)
				return false;
		} else if (!invoiceDateOfIssue.equals(other.invoiceDateOfIssue))
			return false;
		if (Double.doubleToLongBits(invoiceDiscount) != Double.doubleToLongBits(other.invoiceDiscount))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		if (invoicePaidDate == null) {
			if (other.invoicePaidDate != null)
				return false;
		} else if (!invoicePaidDate.equals(other.invoicePaidDate))
			return false;
		if (invoicePaidFlag != other.invoicePaidFlag)
			return false;
		if (invoicePayByDate == null) {
			if (other.invoicePayByDate != null)
				return false;
		} else if (!invoicePayByDate.equals(other.invoicePayByDate))
			return false;
		if (Double.doubleToLongBits(invoiceTotal) != Double.doubleToLongBits(other.invoiceTotal))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoices [invoiceId=" + invoiceId + ", invoiceDateOfIssue=" + invoiceDateOfIssue + ", invoiceDiscount="
				+ invoiceDiscount + ", invoiceTotal=" + invoiceTotal + ", invoicePayByDate=" + invoicePayByDate
				+ ", invoicePaidDate=" + invoicePaidDate + ", invoicePaidFlag=" + invoicePaidFlag + ", adminId="
				+ adminId + "]";
	}

}
