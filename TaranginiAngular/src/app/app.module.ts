import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { CustomerFormComponent } from './component/customer-form/customer-form.component';
import { PackageListComponent } from './component/package-list/package-list.component';



const paths: Routes = [

  { path: 'listPackage', component: PackageListComponent },
  { path: 'addCustomer/:id', component: CustomerFormComponent },


];
@NgModule({
  declarations: [
    AppComponent,
    CustomerFormComponent,
    PackageListComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
