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
    @SequenceGenerator(name="service_seq", sequenceName="service_seq", allocationSize = 1)
    private int serviceId;

    @NotNull
    @Column(name="card_title")
    private String cardTitle;

    @NotNull
    @Column(name="card_img")
    private String cardImg;

    @NotNull
    @Column(name="card_title_2")
    private String cardTitle2;

    @NotNull
    @Column(name="card_desc")
    private String cardDesc;

    @NotNull
    @Column(name="card_pricing_detail")
    private double cardPricingDetail;

    public Services() {

    }

    public Services(int serviceId, String cardTitle, String cardImg, String cardTitle2, String cardDesc, double cardPricingDetail) {
        this.serviceId = serviceId;
        this.cardTitle = cardTitle;
        this.cardImg = cardImg;
        this.cardTitle2 = cardTitle2;
        this.cardDesc = cardDesc;
        this.cardPricingDetail = cardPricingDetail;
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

    @java.lang.Override
    public java.lang.String toString() {
        return "Services{" +
                "serviceId=" + serviceId +
                ", cardTitle='" + cardTitle + '\'' +
                ", cardImg='" + cardImg + '\'' +
                ", cardTitle2='" + cardTitle2 + '\'' +
                ", cardDesc='" + cardDesc + '\'' +
                ", cardPricingDetail=" + cardPricingDetail +
                '}';
    }
}
