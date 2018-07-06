import {Component, OnInit, ViewChild} from '@angular/core';
import {FSMpartSelectorComponent} from './fsmpart-selector/fsmpart-selector.component';


@Component({
  selector: 'app-editor-view',
  templateUrl: './editor-view.component.html',
  styleUrls: ['./editor-view.component.css']
})
export class EditorViewComponent implements OnInit {
  constructor() { }

  @ViewChild ('FSMselector') fsmSelector: FSMpartSelectorComponent;

  ngOnInit() {
  }
}
