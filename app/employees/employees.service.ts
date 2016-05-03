import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Observable}     from 'rxjs/Observable';
import {Headers, RequestOptions} from 'angular2/http';

@Injectable()
export class EmployeesService {

  constructor(private http:Http) {}

  getEmployees() {
    // return Promise.resolve(this.ASSETS);
    return this.http.get('http://localhost:9090/employees')
      .map(this.extractData);
  }

  private extractData(res: Response) {
    if (res.status < 200 || res.status >= 300) {
      throw new Error('Bad response status: ' + res.status);
    }
    let body = res.json();
    return body || { };
  }

  getEmployee(id:string) {
    return this.http.get('http://localhost:9090/employees/' + id)
      .map(this.extractData);

  }

  updateEmployee(employee:any) {
    console.log(employee);
    let body = JSON.stringify(employee );
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    return this.http.post('http://localhost:9090/employees/' + employee.id, body, options)
      .map(this.extractData)
      .catch(this.handleError);
  }
  private handleError (error: any) {
    // In a real world app, we might send the error to remote logging infrastructure
    let errMsg = error.message || 'Server error';
    console.error(errMsg); // log to console instead
    return Observable.throw(errMsg);
  }

}
