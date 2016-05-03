import { Component } from 'angular2/core';
import { Router } from 'angular2/router';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';
import { HeroService } from './hero.service';
import { Hero } from './hero';

@Component({
    selector: 'top-menu',
    template: `
    <ul class="nav nav-pills">
        <li [class.active]="router.isRouteActive(router.generate(['/Assets']))"><a [routerLink]="['Assets']">Assets</a></li>
        <li [class.active]="router.isRouteActive(router.generate(['/Employees']))"><a [routerLink]="['Employees']">Employees</a></li>
        <li [class.active]="router.isRouteActive(router.generate(['/Employees']))"><a ui-sref="reservations" href="#/reservations">Reservations</a></li>
        <li [class.active]="router.isRouteActive(router.generate(['/Employees']))"><a ui-sref="seasons" href="#/seasons">Season Bids</a></li>
        <li [class.active]="router.isRouteActive(router.generate(['/Employees']))"><a ui-sref="employeebids" href="#/bids/employees">Employee Bids</a></li>
    </ul>
    `,
    directives: [ROUTER_DIRECTIVES]
})
export class TopMenuComponent {

  constructor(public router:Router){}

}
