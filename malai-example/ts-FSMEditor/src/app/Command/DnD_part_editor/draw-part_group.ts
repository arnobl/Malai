import {CommandImpl, SrcTgtPointsData} from 'org.malai.ts-dev';

export class DrawPartGroup extends CommandImpl {

  private tgtData: SrcTgtPointsData;
  private tgtElem: SVGSVGElement;


  public constructor (tgtData: SrcTgtPointsData) {
    super();
    this.tgtData = tgtData;
  }

  canDo(): boolean {
    return true;
  }

  protected doCmdBody(): void {
    this.tgtElem = <SVGSVGElement>this.tgtData.getTgtObject().get();
    const src: SVGGElement = <SVGGElement> this.tgtData.getSrcObject().get();
    const clone = <typeof src>src.cloneNode(true);
    clone.setAttribute('cx', this.tgtData.getTgtClientX().toString());
    clone.setAttribute('cy', this.tgtData.getTgtClientY().toString());
    this.tgtElem.appendChild(clone);
  }
}
