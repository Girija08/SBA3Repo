import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { ISPPackage } from '../model/isppackage';
@Injectable({
  providedIn: 'root'
})
export class PackageService {

  baseUrl: string;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:6565/package";
  }
  getBaseUrlById(id: number): string {
    return this.baseUrl + "/" + id;
  }

  getAllPackages(): Observable<ISPPackage[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }
}
