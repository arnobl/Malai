import {CommandImpl, SrcTgtPointsData} from 'org.malai.ts-dev';


export class DrawPart extends CommandImpl {

  private tgtData: SrcTgtPointsData;
  private tgtElem: SVGSVGElement;

  public constructor (tgtData: SrcTgtPointsData) {
    super();
    this.tgtData = tgtData;
  }

  protected doCmdBody(): void {
    this.tgtElem = <SVGSVGElement>this.tgtData.getTgtObject().get();
    const src: SVGCircleElement = <SVGCircleElement> this.tgtData.getSrcObject().get();
    this.tgtElem.appendChild(src.cloneNode(false));
  }

  canDo(): boolean {
    return true;
  }
}
