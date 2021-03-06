/*
 * This file is part of Malai.
 * Copyright (c) 2009-2018 Arnaud BLOUIN Gwendal DIDOT
 * Malai is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later version.
 * Malai is distributed without any warranty; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 */

import {TSFSM} from "../TSFSM";
import {FSMDataHandler} from "../FSMDataHandler";
import {TerminalState} from "../../src-core/fsm/TerminalState";
import {KeyPressureTransition} from "../KeyPressureTransition";
import {KeyData} from "./KeyData";
import {KeyInteraction} from "./KeyInteraction";
import {StdState} from "../../src-core/fsm/StdState";
import {KeyReleaseTransition} from "../KeyReleaseTransition";
import {CancellingState} from "../../src-core/fsm/CancellingState";
import {TimeoutTransition} from "../../src-core/fsm/TimeoutTransition";
import {OutputState} from "../../src-core/fsm/OutputState";
import {InputState} from "../../src-core/fsm/InputState";

export class KeyTypedFSM extends TSFSM<KeyTypedFSMHandler> {
    private checkKey: string | undefined;

    /** The time gap between the two spinner events. */
    private static readonly timeGap = 1000;
    /** The supplier that provides the time gap. */
    private static readonly SUPPLY_TIME_GAP = () => KeyTypedFSM.getTimeGap();

    public constructor() {
        super();
    }

    public buildFSM(dataHandler?: KeyTypedFSMHandler) {
        if (this.states.length > 1) {
            return;
        }

        super.buildFSM(dataHandler);
        const pressed: StdState<Event> = new StdState<Event>(this, "pressed");
        const typed: TerminalState<Event> = new TerminalState<Event>(this, "typed");
        const cancel: CancellingState<Event> = new CancellingState<Event>(this, "cancel");

        this.addState(pressed);
        this.addState(typed);
        this.addState(cancel);

        new  class extends KeyPressureTransition {
            private readonly _parent: KeyTypedFSM;

            public constructor(parent: KeyTypedFSM, srcState: OutputState<Event>, tgtState: InputState<Event>) {
                super(srcState, tgtState);
                this._parent = parent;
            }

            public action(event: Event) {
                if (event instanceof KeyboardEvent) {
                    this._parent.setCheckKey(event.code);
                }
            }

        }(this, this.initState, pressed);

        new class extends KeyReleaseTransition {
            private readonly _parent: KeyTypedFSM;

            public constructor(parent: KeyTypedFSM, srcState: OutputState<Event>, tgtState: InputState<Event>) {
                super(srcState, tgtState);
                this._parent = parent;
            }

            public isGuardOK(event: Event) {
                return super.isGuardOK(event) && this._parent.checkKey === undefined ||
                    (event instanceof KeyboardEvent && event.code === this._parent.checkKey);
            }

            public action(event: Event) {
                if (dataHandler !== undefined && event instanceof KeyboardEvent) {
                    dataHandler.onKeyTyped(event);
                }
            }
        }(this, pressed, typed);
        new TimeoutTransition(pressed, cancel, KeyTypedFSM.SUPPLY_TIME_GAP);
    }

    public getCheckKey() {
        return this.checkKey === undefined ? "" : this.checkKey;
    }

    public setCheckKey(keyToCheck: string) {
        if (this.checkKey === undefined) {
            this.checkKey = keyToCheck;
        }
    }

    public reinit(): void {
        super.reinit();
    }

    private static getTimeGap() {
        return KeyTypedFSM.timeGap;
    }
}

export interface KeyTypedFSMHandler  extends FSMDataHandler {
    onKeyTyped(event: Event): void;
}

/**
 * A user interaction for pressing and releasing a key on a keyboard
 * @author Gwendal DIDOT
 */

export class KeyTyped extends KeyInteraction<KeyData, KeyTypedFSM, Node> {

    private readonly handler: KeyTypedFSMHandler;

    public constructor(fsm?: KeyTypedFSM) {
        super(fsm === undefined ? new KeyTypedFSM() : fsm);

        this.handler = new class implements KeyTypedFSMHandler {
            private readonly _parent: KeyTyped;

            public constructor(parent: KeyTyped) {
                this._parent = parent;
            }

            public onKeyTyped(event: KeyboardEvent): void {
                this._parent.setKeyData(event);
            }

            public reinitData(): void {
                this._parent.reinitData();
            }
        }(this);
        this.getFsm().buildFSM(this.handler);

    }

    public getData(): KeyData {
        return this;
    }
}
