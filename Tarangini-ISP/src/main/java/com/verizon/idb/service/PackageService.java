package com.verizon.idb.service;

import java.util.List;

import com.verizon.idb.model.ISPPackage;


public interface PackageService {

	boolean existsByPrice(double price);
	boolean existsBySpeed(int speed);
	boolean existsByMax(int max);
	
	ISPPackage findByPrice(double price);
	ISPPackage findBySpeed(int speed);
	ISPPackage findByMax(int max);
	
	List<ISPPackage> getAllPackages();
}
