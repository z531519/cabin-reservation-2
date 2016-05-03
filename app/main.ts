import {bootstrap}    from 'angular2/platform/browser';
import { HTTP_PROVIDERS }    from 'angular2/http';
// Add all operators to Observable
import 'rxjs/Rx';
import {AppComponent} from './app.component';
import {CabinService} from './CabinService';

bootstrap(AppComponent, [HTTP_PROVIDERS,CabinService]);
