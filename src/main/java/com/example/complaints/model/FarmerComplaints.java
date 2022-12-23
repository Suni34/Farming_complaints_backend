package com.example.complaints.model;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@Entity
@Table(name="complaints")
@Builder
public class FarmerComplaints {

   @Id
   @GeneratedValue
    @Column(name="id")
    private long id;
    
    @Column(name="productid")
    private long productid;
    
   @NotBlank(message="ProductName should not be blank")
   @NotNull(message="Please Enter productName..ProductName should not be null")
    @Column(name="productname")
    private String productname;
    
   @Min(value=0,message="must be equal to or grater than 0")
   @Max(value=10,message="must be equal to or less than 10")
   @Column(name="points")
    private int points;
    
    @NotBlank(message="complaints should not be blank")
    @NotNull(message="Please Enter your complaint..complaint should not be null")
    @Column(name="complaints")
    private String complaints;



   public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public long getProductid() {
		return productid;
	}



	public void setProductid(long productid) {
		this.productid = productid;
	}



	public String getProductname() {
		return productname;
	}



	public void setProductname(String productname) {
		this.productname = productname;
	}



	public int getPoints() {
		return points;
	}



	public void setPoints(int points) {
		this.points = points;
	}



	public String getComplaints() {
		return complaints;
	}



	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}



public FarmerComplaints(long productid, String productname, int points, String complaints) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.points = points;
		this.complaints = complaints;
	}



@Override
    public String toString() {
        return "FarmerComplaints [id=" + id + ", productid=" + productid + ", productname=" + productname + ", points="
                + points + ", complaints=" + complaints + "]";
    }





public FarmerComplaints() {
	super();
}






    
    
    
}