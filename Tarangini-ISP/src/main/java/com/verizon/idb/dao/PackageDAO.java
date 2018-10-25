package com.verizon.idb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.idb.model.ISPPackage;

@Repository
public interface PackageDAO extends JpaRepository<ISPPackage, String> {
	
	boolean existsByPrice(double price);
	boolean existsBySpeed(int speed);
	boolean existsByMax(int max);
	
	ISPPackage findByPrice(double price);
	ISPPackage findBySpeed(int speed);
	ISPPackage findByMax(int max);
}
