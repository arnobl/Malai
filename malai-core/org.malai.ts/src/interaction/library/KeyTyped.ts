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
import {TerminalState} from "../../../src-core/fsm/TerminalState";
import {KeyPressureTransition} from "../KeyPressureTransition";
import {KeyData} from "./KeyData";
import {KeyInteraction} from "./KeyInteraction";
import {StdState} from "../../../src-core/fsm/StdState";
import {KeyReleaseTransition} from "../KeyReleaseTransition";
import {CancellingState} from "../../../src-core/fsm/CancellingState";
import {TimeoutTransition} from "../../../src-core/fsm/TimeoutTransition";

export class KeyTypedFSM extends TSFSM<KeyTypedFSMHandler> {
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

        new  KeyPressureTransition(this.initState, pressed);
        new class extends KeyReleaseTransition {
            public action(event: Event) {
                if (dataHandler !== undefined && event instanceof KeyboardEvent) {
                    dataHandler.onKeyTyped(event);
                }
            }
        }(pressed, typed);
        new TimeoutTransition(pressed, cancel, KeyTypedFSM.SUPPLY_TIME_GAP);
    }

    public reinit(): void {
        super.reinit();
    }

    private static getTimeGap() {
        return KeyTypedFSM.timeGap;
    }
}

interface KeyTypedFSMHandler  extends FSMDataHandler {
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
