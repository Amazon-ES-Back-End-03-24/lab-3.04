package org.ironhack.lab304.model;

import jakarta.persistence.*;
import org.ironhack.lab304.enums.CustomerStatus;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(columnDefinition = "ENUM('None', 'Silver', 'Gold')")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name = "total_customer_mileage")
    private Integer totalCustomerMileage;

    @OneToMany(mappedBy = "customer")
    List<FlightBooking> bookings;

    public Customer() {
    }

    public Customer(Integer customerId, String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage, List<FlightBooking> bookings) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
        this.bookings = bookings;
    }

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public List<FlightBooking> getBookings() {
        return bookings;
    }

    public void setBookings(List<FlightBooking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && customerStatus == customer.customerStatus && Objects.equals(totalCustomerMileage, customer.totalCustomerMileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerStatus, totalCustomerMileage);
    }
}
