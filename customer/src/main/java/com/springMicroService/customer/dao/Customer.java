package com.springMicroService.customer.dao;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fname;
    private String lname;
    private String email;
}
