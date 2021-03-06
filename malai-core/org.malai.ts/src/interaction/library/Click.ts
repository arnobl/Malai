/*
 * This file is part of Malai.
 * Copyright (c) 2009-2018 Arnaud BLOUIN
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
import {ClickTransition} from "../ClickTransition";
import {InputState} from "../../src-core/fsm/InputState";
import {OutputState} from "../../src-core/fsm/OutputState";
import {PointInteraction} from "./PointInteraction";
import {PointData} from "./PointData";

export class ClickFSM extends TSFSM<ClickFSMHandler> {
    private checkButton: number | undefined;

    public constructor() {
        super();
    }

    public buildFSM(dataHandler?: ClickFSMHandler): void {
        if (this.states.length > 1) {
            return;
        }

        super.buildFSM(dataHandler);
        const clicked = new TerminalState<Event>(this, "clicked");
        this.addState(clicked);

        new class extends ClickTransition {
            private readonly _parent: ClickFSM;

            public constructor(parent: ClickFSM, srcState: OutputState<Event>, tgtState: InputState<Event>) {
                super(srcState, tgtState);
                this._parent = parent;
            }

            public action(event: Event): void {
                if (event instanceof MouseEvent) {
                    this._parent.setCheckButton(event.button);

                    if (dataHandler !== undefined) {
                        dataHandler.initToClicked(event);
                    }
                }
            }

            public isGuardOK(event: Event): boolean {
                return super.isGuardOK(event) && this._parent.checkButton === undefined ||
                    (event instanceof MouseEvent && event.button === this._parent.checkButton);
            }
        }(this, this.initState, clicked);
    }

    public getCheckButton(): number {
        return this.checkButton === undefined ? -1 : this.checkButton;
    }

    public setCheckButton(buttonToCheck: number): void {
        if (this.checkButton === undefined) {
            this.checkButton = buttonToCheck;
        }
    }

    public reinit(): void {
        super.reinit();
        this.checkButton = undefined;
    }
}

export interface ClickFSMHandler extends FSMDataHandler {
    initToClicked(event: MouseEvent): void;
}

export class Click extends PointInteraction<PointData, ClickFSM, Node> {
    private readonly handler: ClickFSMHandler;

    /**
     * Creates the interaction.
     */
    public constructor(fsm?: ClickFSM) {
        super(fsm === undefined ? new ClickFSM() : fsm);

        this.handler = new class implements ClickFSMHandler {
            private readonly _parent: Click;

            constructor(parent: Click) {
                this._parent = parent;
            }

            public initToClicked(event: MouseEvent): void {
                this._parent.setPointData(event);
            }

            public reinitData(): void {
                this._parent.reinitData();
            }
        }(this);

        this.getFsm().buildFSM(this.handler);
    }

    public getData(): PointData {
        return this;
    }
}
