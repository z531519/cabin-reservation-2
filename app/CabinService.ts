/**
 * Created by kdeleon on 4/14/16.
 */
import {Component} from 'angular2/core';

@Component({})
export class CabinService {
    listdata : any[];
    constructor() {
        this.listdata = ['Cabin A', 'Cabin B'];
    }

}