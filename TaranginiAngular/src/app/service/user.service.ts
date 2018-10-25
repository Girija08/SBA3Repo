import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Customer } from '../model/customer';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  baseUrl: string;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:6565/users";
  }
  getBaseUrlById(id: number): string {
    return this.baseUrl + "/" + id;
  }


  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }

  addContact(customer: Customer): Observable<Customer> {
    return this.http.post(this.baseUrl, JSON.stringify(customer), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }

}
