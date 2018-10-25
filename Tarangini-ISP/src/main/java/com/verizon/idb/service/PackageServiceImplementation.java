package com.verizon.idb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.idb.dao.PackageDAO;
import com.verizon.idb.model.ISPPackage;

@Service
public class PackageServiceImplementation implements PackageService {
	
	@Autowired
	private PackageDAO packageRepo;
	
	@Override
	public boolean existsByPrice(double price) {
		return packageRepo.existsByPrice(price);
	}

	@Override
	public boolean existsBySpeed(int speed) {
		return packageRepo.existsBySpeed(speed);
	}

	@Override
	public boolean existsByMax(int max) {
		return packageRepo.existsByMax(max);
	}

	@Override
	public ISPPackage findByPrice(double price) {
		return packageRepo.findByPrice(price);
	}

	@Override
	public ISPPackage findBySpeed(int speed) {
		return packageRepo.findBySpeed(speed);
	}

	@Override
	public ISPPackage findByMax(int max) {
		return packageRepo.findByMax(max);
	}

	@Override
	public List<ISPPackage> getAllPackages() {
		return packageRepo.findAll();
	}

}
