import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import {Kweet} from "./Kweet";

@Injectable()
export class OverviewService {
  private baseUrl = 'http://localhost:8080/Kwetter/api';
  private user:string = "Peter";

  constructor(private http: Http) {
  }

  addKweet(kweet: string) : Observable<Kweet>{
    let headers = new Headers({'Content-Type': 'application/json'});
    let options = new RequestOptions({headers: headers});
    return this.http.post(this.baseUrl + "/kweet/" + this.user +"/" + kweet, {}, options).map(this.extractData);
  }

  public extractData(res: Response) {
    let body = res.text();
    return JSON.parse(body) || {};
  }


  private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

  getTimeline(): Observable<Kweet[]>{
    return Observable.interval(2000)
      .switchMap(() => this.http.get(this.baseUrl + "/kweet/")
        .map(this.extractData)
        .catch((error: any) => Observable.throw(error.json().error || 'Server error')));
  }
}
