import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {MArray} from 'org.malai.ts-dev';

@Component({
  selector: 'app-fsmpart-selector',
  templateUrl: './fsmpart-selector.component.html',
  styleUrls: ['./fsmpart-selector.component.css']
})
export class FSMpartSelectorComponent implements OnInit {

  @ViewChild ('InitState') init_part: ElementRef;
  @ViewChild ('StdState') stnd_part: ElementRef;
  @ViewChild ('TerminalState') term_part: ElementRef;

  part: MArray<EventTarget> = new MArray<EventTarget>();

  @Input () name: string;

  constructor() {
  }

  ngOnInit() {
    this.part.push(this.init_part.nativeElement, this.stnd_part.nativeElement, this.term_part.nativeElement);
  }

}
