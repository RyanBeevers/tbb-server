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

    @NotNull
    @Column(name="first_name")
    private String firstName;

    @NotNull
    @Column(name="last_name")
    private String lastName;
    
    @NotNull
    @Column(name="business_name")
    private String businessName;

    @NotNull
    @Column(name="work_phone")
    private String workPhone;

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

    
	@Id
    @Column(name="user_id")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_seq")
//    @SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize = 1)
    private String userId;
    
    @NotNull
    @Column(name="email")
    private String email;
    
    @NotNull
    @Column(name="already_texted")
    private boolean alreadyTexted;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Tasks> tasks;

    public Users() {
    }

    public Users(String userId){
        super();
        this.userId=userId;
    }

	public Users(@NotNull String firstName, @NotNull String lastName, @NotNull String businessName,
			@NotNull String workPhone, @NotNull String businessStreetAddress, @NotNull String businessCity,
			@NotNull String businessState, @NotNull String businessZip, @NotNull String businessCountry, String userId,
			@NotNull String email, @NotNull boolean alreadyTexted, List<Tasks> tasks) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.businessName = businessName;
		this.workPhone = workPhone;
		this.businessStreetAddress = businessStreetAddress;
		this.businessCity = businessCity;
		this.businessState = businessState;
		this.businessZip = businessZip;
		this.businessCountry = businessCountry;
		this.userId = userId;
		this.email = email;
		this.alreadyTexted = alreadyTexted;
		this.tasks = tasks;
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

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAlreadyTexted() {
		return alreadyTexted;
	}

	public void setAlreadyTexted(boolean alreadyTexted) {
		this.alreadyTexted = alreadyTexted;
	}

	public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", businessName=" + businessName
				+ ", workPhone=" + workPhone + ", businessStreetAddress=" + businessStreetAddress + ", businessCity="
				+ businessCity + ", businessState=" + businessState + ", businessZip=" + businessZip
				+ ", businessCountry=" + businessCountry + ", userId=" + userId + ", email=" + email
				+ ", alreadyTexted=" + alreadyTexted + ", tasks=" + tasks + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (alreadyTexted ? 1231 : 1237);
		result = prime * result + ((businessCity == null) ? 0 : businessCity.hashCode());
		result = prime * result + ((businessCountry == null) ? 0 : businessCountry.hashCode());
		result = prime * result + ((businessName == null) ? 0 : businessName.hashCode());
		result = prime * result + ((businessState == null) ? 0 : businessState.hashCode());
		result = prime * result + ((businessStreetAddress == null) ? 0 : businessStreetAddress.hashCode());
		result = prime * result + ((businessZip == null) ? 0 : businessZip.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((workPhone == null) ? 0 : workPhone.hashCode());
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
		Users other = (Users) obj;
		if (alreadyTexted != other.alreadyTexted)
			return false;
		if (businessCity == null) {
			if (other.businessCity != null)
				return false;
		} else if (!businessCity.equals(other.businessCity))
			return false;
		if (businessCountry == null) {
			if (other.businessCountry != null)
				return false;
		} else if (!businessCountry.equals(other.businessCountry))
			return false;
		if (businessName == null) {
			if (other.businessName != null)
				return false;
		} else if (!businessName.equals(other.businessName))
			return false;
		if (businessState == null) {
			if (other.businessState != null)
				return false;
		} else if (!businessState.equals(other.businessState))
			return false;
		if (businessStreetAddress == null) {
			if (other.businessStreetAddress != null)
				return false;
		} else if (!businessStreetAddress.equals(other.businessStreetAddress))
			return false;
		if (businessZip == null) {
			if (other.businessZip != null)
				return false;
		} else if (!businessZip.equals(other.businessZip))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (workPhone == null) {
			if (other.workPhone != null)
				return false;
		} else if (!workPhone.equals(other.workPhone))
			return false;
		return true;
	}
  	
}
