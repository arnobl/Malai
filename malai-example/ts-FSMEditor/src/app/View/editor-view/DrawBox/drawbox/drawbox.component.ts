import {Component, ElementRef, Input, OnInit, ViewChild} from '@angular/core';
import {DnD, nodeBinder, SrcTgtPointsData} from 'org.malai.ts-dev';
import {DrawPart} from '../../../../Command/DnD_part_editor/draw-part';
import {FSMpartSelectorComponent} from '../../fsmpart-selector/fsmpart-selector.component';

@Component({
  selector: 'app-drawbox',
  templateUrl: './drawbox.component.html',
  styleUrls: ['./drawbox.component.css']
})
export class DrawboxComponent implements OnInit {

  @Input () fsm_selector: FSMpartSelectorComponent;
  @ViewChild ('DrawBox') drawbox: ElementRef;

  constructor() { }

  ngOnInit() {
    nodeBinder<SrcTgtPointsData, DrawPart, DnD>(new DnD(false, false), i => new DrawPart(i))
      .on(this.fsm_selector.part)
      .on(this.drawbox.nativeElement)
      .when(i =>  i.getSrcObject().get() !== this.drawbox.nativeElement)
      .bind();
  }

}
