package com.tbb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Component
@Table(name="SERVICES")
public class Services{

    @Id
    @Column(name="service_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="service_seq")
    @SequenceGenerator(name="service_seq", sequenceName="serv_seq", allocationSize = 1)
    private int serviceId;

    @NotNull
    @Column(name="card_title")
    private String cardTitle;

    @NotNull
    @Column(name="card_img")
    private String cardImg;

    @Column(name="card_title_2")
    private String cardTitle2;

    @NotNull
    @Column(name="card_desc")
    private String cardDesc;

    @NotNull
    @Column(name="card_pricing_detail")
    private double cardPricingDetail;
    
    @NotNull
    @Column(name="admin_id")
    private String adminId;

    public Services() {

    }

	public Services(int serviceId, @NotNull String cardTitle, @NotNull String cardImg, String cardTitle2,
			@NotNull String cardDesc, @NotNull double cardPricingDetail, @NotNull String adminId) {
		super();
		this.serviceId = serviceId;
		this.cardTitle = cardTitle;
		this.cardImg = cardImg;
		this.cardTitle2 = cardTitle2;
		this.cardDesc = cardDesc;
		this.cardPricingDetail = cardPricingDetail;
		this.adminId = adminId;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}

	public String getCardImg() {
		return cardImg;
	}

	public void setCardImg(String cardImg) {
		this.cardImg = cardImg;
	}

	public String getCardTitle2() {
		return cardTitle2;
	}

	public void setCardTitle2(String cardTitle2) {
		this.cardTitle2 = cardTitle2;
	}

	public String getCardDesc() {
		return cardDesc;
	}

	public void setCardDesc(String cardDesc) {
		this.cardDesc = cardDesc;
	}

	public double getCardPricingDetail() {
		return cardPricingDetail;
	}

	public void setCardPricingDetail(double cardPricingDetail) {
		this.cardPricingDetail = cardPricingDetail;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((cardDesc == null) ? 0 : cardDesc.hashCode());
		result = prime * result + ((cardImg == null) ? 0 : cardImg.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cardPricingDetail);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((cardTitle == null) ? 0 : cardTitle.hashCode());
		result = prime * result + ((cardTitle2 == null) ? 0 : cardTitle2.hashCode());
		result = prime * result + serviceId;
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
		Services other = (Services) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (cardDesc == null) {
			if (other.cardDesc != null)
				return false;
		} else if (!cardDesc.equals(other.cardDesc))
			return false;
		if (cardImg == null) {
			if (other.cardImg != null)
				return false;
		} else if (!cardImg.equals(other.cardImg))
			return false;
		if (Double.doubleToLongBits(cardPricingDetail) != Double.doubleToLongBits(other.cardPricingDetail))
			return false;
		if (cardTitle == null) {
			if (other.cardTitle != null)
				return false;
		} else if (!cardTitle.equals(other.cardTitle))
			return false;
		if (cardTitle2 == null) {
			if (other.cardTitle2 != null)
				return false;
		} else if (!cardTitle2.equals(other.cardTitle2))
			return false;
		if (serviceId != other.serviceId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", cardTitle=" + cardTitle + ", cardImg=" + cardImg
				+ ", cardTitle2=" + cardTitle2 + ", cardDesc=" + cardDesc + ", cardPricingDetail=" + cardPricingDetail
				+ ", adminId=" + adminId + "]";
	}

}
