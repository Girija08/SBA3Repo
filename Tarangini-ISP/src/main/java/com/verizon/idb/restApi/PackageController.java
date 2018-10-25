package com.verizon.idb.restApi;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.idb.model.ISPPackage;
import com.verizon.idb.service.PackageService;

@RestController
@CrossOrigin
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@GetMapping
	public ResponseEntity<List<ISPPackage>> getAllPackages() {
		return new ResponseEntity<>(packageService.getAllPackages(), HttpStatus.OK);
	}
	
}
