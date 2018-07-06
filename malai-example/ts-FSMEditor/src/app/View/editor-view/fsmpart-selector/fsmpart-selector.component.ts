import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {FSMpartComponent} from './fsmpart/fsmpart.component';
import {MArray} from 'org.malai.ts-dev';

@Component({
  selector: 'app-fsmpart-selector',
  templateUrl: './fsmpart-selector.component.html',
  styleUrls: ['./fsmpart-selector.component.css']
})
export class FSMpartSelectorComponent implements OnInit {

  @ViewChild ('InitState') init_part: SVGCircleElement;
  @ViewChild ('StndState') stnd_part: FSMpartComponent;

  part: MArray<EventTarget>;

  @Input () name: string;

  constructor() {
    this.part = new MArray<EventTarget>();
  }

  ngOnInit() {
    this.part.push(this.init_part);
  }

}
