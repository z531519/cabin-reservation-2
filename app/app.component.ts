
import { Component }       from 'angular2/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';
import { HTTP_PROVIDERS }    from 'angular2/http';

import { HeroService }     from './hero.service';
import { HeroesComponent } from './heroes.component';
import { HeroDetailComponent} from './hero-detail.component';
import { DashboardComponent } from './dashboard.component';
import { TopMenuComponent } from './top-menu.component';

import { AssetsComponent } from './assets/assets.component';
import { EmployeesComponent, EmployeeEditComponent } from './employees/employees.component';
import { EmployeesService } from './employees/employees.service';

// import { EmployeeEditComponent } from './employees/employee-edit.component';

@Component({
  selector: 'my-app',
  template: `
  <h1>{{title}}</h1>

  <top-menu></top-menu>

  <!--<nav>-->
    <!--<a [routerLink]="['Dashboard']">Dashboard</a>-->
    <!--<a [routerLink]="['Heroes']">Heroes</a>-->
  <!--</nav>-->


  <router-outlet></router-outlet>
  `,
  // styleUrls: ['app/app.component.css'],
  directives: [ROUTER_DIRECTIVES,TopMenuComponent],
  providers: [
    ROUTER_PROVIDERS,
    HTTP_PROVIDERS,
    HeroService,
    EmployeesService
  ]
})

@RouteConfig([
  {
    path: '/assets',
    name: 'Assets',
    component: AssetsComponent,
    useAsDefault: true
  },
  {
    path: '/employees',
    name: 'Employees',
    component: EmployeesComponent
  },
  {
    path: '/employees/:id',
    name: 'Edit Employee',
    component: EmployeeEditComponent
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: DashboardComponent,
  },
  {
    path: '/heroes',
    name: 'Heroes',
    component: HeroesComponent
  },
  {
    path: '/detail/:id',
    name: 'HeroDetail',
    component: HeroDetailComponent
  }
])

export class AppComponent {
  title = 'Cabin Reservations';
}
