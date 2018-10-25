
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ISPPackage } from '../../model/isppackage';
import { PackageService } from '../../service/package.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './package-list.component.html',
  styleUrls: ['./package-list.component.css']
})
export class PackageListComponent implements OnInit {

  ispPack: ISPPackage[];
  constructor(private packageService: PackageService
  ) { }

  ngOnInit() {
    this.packageService.getAllPackages().subscribe(
      (data) => this.ispPack = data
    );
  }
  apply(title: string) {
    alert(title);
  }
}


