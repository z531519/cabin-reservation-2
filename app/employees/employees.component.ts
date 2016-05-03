import {Component, OnInit, Input} from 'angular2/core';
import {CORE_DIRECTIVES, FORM_DIRECTIVES} from 'angular2/common';
import {DATEPICKER_DIRECTIVES} from 'ng2-bootstrap/ng2-bootstrap';
import {EmployeesService} from './employees.service';
import { Router, RouteParams } from 'angular2/router';
// import * as moment from 'moment';

@Component({
    selector: 'employees',
    templateUrl: 'app/employees/employees.component.html'
})

export class EmployeesComponent implements OnInit {
  employees: [any];

  constructor(private _router:Router, private _employeesService:EmployeesService) {
  }

  ngOnInit() {
    // this._assetsService.getHeroes().then( assets => this.assets = assets);
    this._employeesService.getEmployees().subscribe(
      employees =>
      this.employees = employees
    );
  }

  editEmployee(_id: string) {
    let editEmployeeLink = ['Edit Employee', {id:_id}];
    this._router.navigate(editEmployeeLink);
  }
}


@Component({
    selector: 'employee-edit',
    templateUrl: 'app/employees/employee-edit.component.html',
    directives: [DATEPICKER_DIRECTIVES, CORE_DIRECTIVES, FORM_DIRECTIVES]
})

export class EmployeeEditComponent implements OnInit {
  @Input()
  employee: any;
  @Input()
  hireDate: string;

  errorMessage: string;

  constructor(private _routeParams: RouteParams, private _employeesService:EmployeesService) {
  }

  ngOnInit() {
    let id = this._routeParams.get('id');
    this._employeesService.getEmployee(id)
      .subscribe(
        employee => { this.employee = employee;
        this.hireDate = moment(this.employee.hired).format('YYYY-MM-DD');
        }
      );
  }

  updateEmployee() {
    this.employee.hired = moment(this.hireDate).toDate().getTime();
    this._employeesService.updateEmployee(this.employee).subscribe(
      error =>  this.errorMessage = <any>error);
  }

  goBack() {
    window.history.back();
  }

}
