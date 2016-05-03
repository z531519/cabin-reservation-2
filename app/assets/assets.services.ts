import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Observable}     from 'rxjs/Observable';

@Injectable()
export class AssetsService {

  ASSETS = ['A', 'B'];

  constructor(private http:Http) {}

  getAssets() {
    // return Promise.resolve(this.ASSETS);
    return this.http.get('http://localhost:9090/assets')
      .map(this.extractData);
  }

  private extractData(res: Response) {
    if (res.status < 200 || res.status >= 300) {
      throw new Error('Bad response status: ' + res.status);
    }
    let body = res.json();
    return body || { };
  }

}
