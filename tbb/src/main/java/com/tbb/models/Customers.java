package com.tbb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Component
@Table(name="CUSTOMERS")
public class Customers {

    @Id
    @Column(name="CUST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cust_seq")
    @SequenceGenerator(name="cust_seq", sequenceName="customers_seq", allocationSize = 1)
    private int customerId;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="business_name")
    private String businessName;

    @NotNull
    @Column(name="type_of_business")
    private String typeOfBusiness;

    @NotNull
    @Column(name="work_phone")
    private String workPhone;

    @Column(name="personal_phone")
    private String personalPhone;

    @NotNull
    @Column(name="business_street_address")
    private String businessStreetAddress;

    @NotNull
    @Column(name="business_city")
    private String businessCity;

    @NotNull
    @Column(name="business_state")
    private String businessState;

    @NotNull
    @Column(name="business_zip")
    private String businessZip;

    @NotNull
    @Column(name="business_country")
    private String businessCountry;

    @OneToMany(mappedBy = "invoiceId", cascade = CascadeType.ALL)
    private List<Invoices> invoices;

    public Customers() {
    }

    public Customers(@NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull String businessName, @NotNull String typeOfBusiness, @NotNull String workPhone, String personalPhone, @NotNull String businessStreetAddress, @NotNull String businessCity, @NotNull String businessState, @NotNull String businessZip, @NotNull String businessCountry, List<Invoices> invoices) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.businessName = businessName;
        this.typeOfBusiness = typeOfBusiness;
        this.workPhone = workPhone;
        this.personalPhone = personalPhone;
        this.businessStreetAddress = businessStreetAddress;
        this.businessCity = businessCity;
        this.businessState = businessState;
        this.businessZip = businessZip;
        this.businessCountry = businessCountry;
        this.invoices = invoices;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTypeOfBusiness() {
        return typeOfBusiness;
    }

    public void setTypeOfBusiness(String typeOfBusiness) {
        this.typeOfBusiness = typeOfBusiness;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getPersonalPhone() {
        return personalPhone;
    }

    public void setPersonalPhone(String personalPhone) {
        this.personalPhone = personalPhone;
    }

    public String getBusinessStreetAddress() {
        return businessStreetAddress;
    }

    public void setBusinessStreetAddress(String businessStreetAddress) {
        this.businessStreetAddress = businessStreetAddress;
    }

    public String getBusinessCity() {
        return businessCity;
    }

    public void setBusinessCity(String businessCity) {
        this.businessCity = businessCity;
    }

    public String getBusinessState() {
        return businessState;
    }

    public void setBusinessState(String businessState) {
        this.businessState = businessState;
    }

    public String getBusinessZip() {
        return businessZip;
    }

    public void setBusinessZip(String businessZip) {
        this.businessZip = businessZip;
    }

    public String getBusinessCountry() {
        return businessCountry;
    }

    public void setBusinessCountry(String businessCountry) {
        this.businessCountry = businessCountry;
    }

    public List<Invoices> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoices> invoices) {
        this.invoices = invoices;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", businessName='" + businessName + '\'' +
                ", typeOfBusiness='" + typeOfBusiness + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", personalPhone='" + personalPhone + '\'' +
                ", businessStreetAddress='" + businessStreetAddress + '\'' +
                ", businessCity='" + businessCity + '\'' +
                ", businessState='" + businessState + '\'' +
                ", businessZip='" + businessZip + '\'' +
                ", businessCountry='" + businessCountry + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
