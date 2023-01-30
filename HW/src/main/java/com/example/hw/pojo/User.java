package com.example.hw.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mytable")
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   @Column(nullable = false)
   private String firstname;
   @Column
   private String middlename;
   @Column(nullable = false)
   private String lastname;
   @Column//(nullable = false)
   private String dateofbirth;


   public User(String firstname, String lastname) {
      this.firstname = firstname;
      this.lastname = lastname;
   }

   public int getId() {
      return id;
   }

   public String getFirstname() {
      return firstname;
   }

   public String getMiddlename() {
      return middlename;
   }

   public String getLastname() {
      return lastname;
   }

   public String getDateofbirth() {
      return dateofbirth;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public void setMiddlename(String middlename) {
      this.middlename = middlename;
   }

   public void setLastname(String lastname) {
      this.lastname = lastname;
   }

   public void setDateofbirth(String dateofbirth) {
      this.dateofbirth = dateofbirth;
   }
}
