import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from '../../model/customer';
import { UserService } from '../../service/user.service';
import { WSAVERNOTSUPPORTED } from 'constants';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  customer: Customer;
  title: string;
  today = new Date();

  constructor(
    private activatedRoute: ActivatedRoute,
    private userService: UserService,
    private router: Router,

  ) { }

  ngOnInit() {
    this.customer = new Customer();
    this.activatedRoute.params.subscribe(
      (params) => {
        this.title = params['id'];
      }
    );
  }

  save() {

    this.userService.addContact(this.customer).subscribe(
      (data) => {
        this.customer = data;
        alert("Successfully Added");
        alert("Your order is successful.Our official will get in touch with you for installation on " + this.date() + " at " + this.customer.address);
        this.router.navigateByUrl("/listPackage");
      },
      (error) => { alert("Please enter the details"); }
    );
  }
  date(): Date {
    var someDate = new Date();
    var numberOfDaysToAdd = 4;
    someDate.setDate(someDate.getDate() + numberOfDaysToAdd);
    return someDate;
  }
}