import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from './employee/employee';
import { EmployeeService } from './employee/employee.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
    this.getEmployees();
  }
  title = 'front';
  public employees: Employee[] = [];
  constructor(private employeeService: EmployeeService) {}
  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe({
      next: (value: Employee[]) => {
        this.employees = value;
        console.table(value);
      },
      error: (error: HttpErrorResponse) => {
        console.log(error);
      },
      complete: () => {
        console.log('done');
      },
    });
  }
}
