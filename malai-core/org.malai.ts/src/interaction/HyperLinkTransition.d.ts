import { OutputState, InputState } from "..";
import { TSTransition } from "./TSTransition";
export declare class HyperLinkTransition extends TSTransition {
    constructor(srcState: OutputState<Event>, tgtState: InputState<Event>);
    accept(event: Event): boolean;
    isGuardOK(event: Event): boolean;
    getAcceptedEvents(): Set<string>;
}
