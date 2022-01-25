package com.example.busticketsservice.persistence.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "route_list")
public class RouteListEnity extends BaseEntity {

    @Column(name = "from_station")
    private String fromStation;

    @Column(name = "where_station")
    private String whereStation;

    @Column(name = "seats_number")
    private int seatsInRoute;

    @Column(name = "free_seats")
    private int freeSeats;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "price")
    private float price;

    public RouteListEnity() {
    }

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getWhereStation() {
        return whereStation;
    }

    public void setWhereStation(String whereStation) {
        this.whereStation = whereStation;
    }

    public int getSeatsInRoute() {
        return seatsInRoute;
    }

    public void setSeatsInRoute(int seatsInRoute) {
        this.seatsInRoute = seatsInRoute;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteListEnity that = (RouteListEnity) o;
        return seatsInRoute == that.seatsInRoute && freeSeats == that.freeSeats && Float.compare(that.price, price) == 0 && Objects.equals(fromStation, that.fromStation) && Objects.equals(whereStation, that.whereStation) && Objects.equals(departureTime, that.departureTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromStation, whereStation, seatsInRoute, freeSeats, departureTime, price);
    }
}
