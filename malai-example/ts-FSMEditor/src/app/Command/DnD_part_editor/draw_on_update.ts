import {CommandImpl, SrcTgtPointsData} from 'org.malai.ts-dev';

export class DrawOnuUdate extends CommandImpl {

  private tgtData: SrcTgtPointsData;
  private srcTgt: HTMLDivElement;
  private tgtElem: HTMLElement;

  public constructor (tgtData: SrcTgtPointsData) {
    super();
    this.tgtData = tgtData;
  }
  canDo(): boolean {
    return true;
  }

  protected doCmdBody(): void {
    this.tgtElem = <HTMLElement>this.tgtData.getTgtObject().get();
    this.srcTgt = <HTMLDivElement>this.tgtData.getSrcObject().get();
    console.log('test');
  }

}
