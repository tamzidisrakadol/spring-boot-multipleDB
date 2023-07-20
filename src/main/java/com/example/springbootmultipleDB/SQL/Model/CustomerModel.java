package com.example.springbootmultipleDB.SQL.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customer")
@Data
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String address;

    public CustomerModel(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public CustomerModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
