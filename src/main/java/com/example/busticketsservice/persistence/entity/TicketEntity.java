package com.example.busticketsservice.persistence.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tickets")
public class TicketEntity extends BaseEntity {

    @Column(name = "passenger_first_name")
    private String firstName;

    @Column(name = "passenger_last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    private RouteListEntity routeListEntity;


    @Column(name = "purchase_status")
    private String purchaseStatus;

    @Column(name = "unique_pay_id")
    private String uniquePayId;

    public TicketEntity() {
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

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }


    public String getUniquePayId() {
        return uniquePayId;
    }

    public void setUniquePayId(String uniquePayId) {
        this.uniquePayId = uniquePayId;
    }

    public RouteListEntity getRouteListEntity() {
        return routeListEntity;
    }

    public void setRouteListEntity(RouteListEntity routeListEntity) {
        this.routeListEntity = routeListEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity ticket = (TicketEntity) o;
        return Objects.equals(firstName, ticket.firstName) && Objects.equals(lastName, ticket.lastName) && Objects.equals(routeListEntity, ticket.routeListEntity) && Objects.equals(purchaseStatus, ticket.purchaseStatus) && Objects.equals(uniquePayId, ticket.uniquePayId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, routeListEntity, purchaseStatus, uniquePayId);
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", routeListEntity=" + routeListEntity +
                ", purchaseStatus='" + purchaseStatus + '\'' +
                ", uniquePayId='" + uniquePayId + '\'' +
                '}';
    }
}




