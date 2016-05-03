import {Component, OnInit} from 'angular2/core';
import {AssetsService} from './assets.services';

@Component({
    selector: 'assets',
    templateUrl: 'app/assets/assets.component.html',
    providers: [AssetsService]
})


export class AssetsComponent implements OnInit {
  assets: [any];

  constructor(private _assetsService:AssetsService) {
  }

  ngOnInit() {
    // this._assetsService.getHeroes().then( assets => this.assets = assets);
    this._assetsService.getAssets().subscribe(
      assets => this.assets = assets);
  }
}
