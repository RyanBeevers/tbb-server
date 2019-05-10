package com.tbb.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Component
@Table(name="USERS")
public class Users {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
    @SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize = 1)
    private int userId;

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;

    @NotNull
    @Column(name="role_type")
    private String roleType;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @NotNull
    @Column(name="business_name")
    private String businessName;

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

    @NotNull
    @Column(name="already_texted")
    private boolean alreadyTexted;

    @NotNull
    @Column(name="first_time_login")
    private boolean firstTimeLogIn;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Tasks> tasks;

    public Users() {
    }

    public Users(int userId){
        super();
        this.userId=userId;
    }

    public Users(@NotNull String firstName, @NotNull String lastName, @NotNull String roleType, @NotNull String email, @NotNull String password, @NotNull String businessName, String typeOfBusiness, @NotNull String workPhone, String personalPhone, @NotNull String businessStreetAddress, @NotNull String businessCity, @NotNull String businessState, @NotNull String businessZip, @NotNull String businessCountry, @NotNull boolean alreadyTexted, @NotNull boolean firstTimeLogIn, List<Tasks> tasks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleType = roleType;
        this.email = email;
        this.password = password;
        this.businessName = businessName;
        this.typeOfBusiness = typeOfBusiness;
        this.workPhone = workPhone;
        this.personalPhone = personalPhone;
        this.businessStreetAddress = businessStreetAddress;
        this.businessCity = businessCity;
        this.businessState = businessState;
        this.businessZip = businessZip;
        this.businessCountry = businessCountry;
        this.alreadyTexted = alreadyTexted;
        this.firstTimeLogIn = firstTimeLogIn;
        this.tasks = tasks;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isAlreadyTexted() {
        return alreadyTexted;
    }

    public void setAlreadyTexted(boolean alreadyTexted) {
        this.alreadyTexted = alreadyTexted;
    }

    public boolean isFirstTimeLogIn() {
        return firstTimeLogIn;
    }

    public void setFirstTimeLogIn(boolean firstTimeLogIn) {
        this.firstTimeLogIn = firstTimeLogIn;
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
        Users users = (Users) o;
        return userId == users.userId &&
                alreadyTexted == users.alreadyTexted &&
                firstTimeLogIn == users.firstTimeLogIn &&
                Objects.equals(firstName, users.firstName) &&
                Objects.equals(lastName, users.lastName) &&
                Objects.equals(roleType, users.roleType) &&
                Objects.equals(email, users.email) &&
                Objects.equals(password, users.password) &&
                Objects.equals(businessName, users.businessName) &&
                Objects.equals(typeOfBusiness, users.typeOfBusiness) &&
                Objects.equals(workPhone, users.workPhone) &&
                Objects.equals(personalPhone, users.personalPhone) &&
                Objects.equals(businessStreetAddress, users.businessStreetAddress) &&
                Objects.equals(businessCity, users.businessCity) &&
                Objects.equals(businessState, users.businessState) &&
                Objects.equals(businessZip, users.businessZip) &&
                Objects.equals(businessCountry, users.businessCountry) &&
                Objects.equals(tasks, users.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, roleType, email, password, businessName, typeOfBusiness, workPhone, personalPhone, businessStreetAddress, businessCity, businessState, businessZip, businessCountry, alreadyTexted, firstTimeLogIn, tasks);
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roleType='" + roleType + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", businessName='" + businessName + '\'' +
                ", typeOfBusiness='" + typeOfBusiness + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", personalPhone='" + personalPhone + '\'' +
                ", businessStreetAddress='" + businessStreetAddress + '\'' +
                ", businessCity='" + businessCity + '\'' +
                ", businessState='" + businessState + '\'' +
                ", businessZip='" + businessZip + '\'' +
                ", businessCountry='" + businessCountry + '\'' +
                ", alreadyTexted=" + alreadyTexted +
                ", firstTimeLogIn=" + firstTimeLogIn +
                '}';
    }
}
