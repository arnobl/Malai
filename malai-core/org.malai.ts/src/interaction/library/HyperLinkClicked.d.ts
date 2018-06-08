import { TSFSM } from "../TSFSM";
import { WidgetData } from "../..";
import { FSMDataHandler } from "../FSMDataHandler";
import { TSInteraction } from "../TSInteraction";
export declare class HyperLinkClickedFSM extends TSFSM<HyperLinkedFSMHandler> {
    constructor();
    buildFSM(dataHandler?: HyperLinkedFSMHandler): void;
}
export interface HyperLinkedFSMHandler extends FSMDataHandler {
    initToClickedHandler(event: Event): void;
}
export declare class HyperLinkClicked extends TSInteraction<WidgetData<Element>, HyperLinkClickedFSM, Element> {
    private readonly handler;
    constructor();
    onNewNodeRegistered(node: EventTarget): void;
    onNodeUnregistered(node: EventTarget): void;
    getData(): WidgetData<Element>;
}
