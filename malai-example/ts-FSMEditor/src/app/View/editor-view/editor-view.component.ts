import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {FSMpartSelectorComponent} from './fsmpart-selector/fsmpart-selector.component';
import {DnD, nodeBinder, SrcTgtPointsData} from 'org.malai.ts-dev';
import {DrawPartCircle} from '../../Command/DnD_part_editor/draw_part_circle';
import {DrawboxComponent} from './DrawBox/drawbox/drawbox.component';
import {DrawPartGroup} from '../../Command/DnD_part_editor/draw-part_group';


@Component({
  selector: 'app-editor-view',
  templateUrl: './editor-view.component.html',
  styleUrls: ['./editor-view.component.css']
})
export class EditorViewComponent implements OnInit, AfterViewInit {
  constructor() { }

  @ViewChild ('FSMselector') fsmSelector: FSMpartSelectorComponent;
  @ViewChild ('DrawBox') drawbox: DrawboxComponent;

  ngOnInit(): void {
  }

  ngAfterViewInit() {
    nodeBinder<SrcTgtPointsData, DrawPartCircle, DnD>(new DnD(false, false), i => new DrawPartCircle(i))
      .on(this.fsmSelector.init_part.nativeElement).on(this.fsmSelector.stnd_part.nativeElement)
      .on(this.drawbox.drawbox.nativeElement)
      .when(i =>  i.getSrcObject().get() !== this.drawbox.drawbox.nativeElement)
      .bind();

    nodeBinder<SrcTgtPointsData, DrawPartGroup, DnD>(new DnD(false, false), i => new DrawPartGroup(i))
      .on(this.fsmSelector.term_part.nativeElement)
      .when(i =>  i.getSrcObject().get() !== this.drawbox.drawbox.nativeElement)
      .bind();
  }
}
