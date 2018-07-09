import {CommandImpl, SrcTgtPointsData} from 'org.malai.ts-dev';


export class DrawPartCircle extends CommandImpl {

  private tgtData: SrcTgtPointsData;
  private tgtElem: SVGSVGElement;

  public constructor (tgtData: SrcTgtPointsData) {
    super();
    this.tgtData = tgtData;
  }

  protected doCmdBody(): void {
    this.tgtElem = <SVGSVGElement>this.tgtData.getTgtObject().get();
    const src: SVGCircleElement = <SVGCircleElement> this.tgtData.getSrcObject().get();
    const clone = <typeof src>src.cloneNode(true);
    clone.setAttribute('cx', this.tgtData.getTgtClientX().toString());
    clone.setAttribute('cy', this.tgtData.getTgtClientY().toString());
    clone.setAttribute('transform', 'translate(-20, -20)');
    this.tgtElem.appendChild(clone);
  }

  canDo(): boolean {
    return true;
  }
}
