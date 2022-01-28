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
    private RouteListEnity routeListEnity;


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

    public RouteListEnity getRouteListEnity() {
        return routeListEnity;
    }

    public void setRouteListEnity(RouteListEnity routeListEnity) {
        this.routeListEnity = routeListEnity;
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

    @Override
    public String toString() {
        return "TicketEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", routeListEnity=" + routeListEnity +
                ", purchaseStatus='" + purchaseStatus + '\'' +
                ", uniquePayId='" + uniquePayId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketEntity ticket = (TicketEntity) o;
        return Objects.equals(firstName, ticket.firstName) && Objects.equals(lastName, ticket.lastName) && Objects.equals(routeListEnity, ticket.routeListEnity) && Objects.equals(uniquePayId, ticket.uniquePayId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, routeListEnity, uniquePayId);
    }
}
