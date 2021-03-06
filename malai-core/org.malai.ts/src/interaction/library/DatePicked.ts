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
import {TerminalState} from "../../src-core/fsm/TerminalState";
import {isDatePicker} from "../Events";
import {FSMDataHandler} from "../FSMDataHandler";
import {TSInteraction} from "../TSInteraction";
import {WidgetData} from "../../src-core/interaction/WidgetData";
import {DatePickedTransition} from "../DatePickedTransition";

export class DatePickedFSM extends TSFSM<DatePickedHandler> {
    public constructor() {
        super();
    }

    public buildFSM(dataHandler?: DatePickedHandler): void {
        if (this.states.length > 1) {
            return ;
        }

        super.buildFSM(dataHandler);
        const picked: TerminalState<Event> = new TerminalState<Event>(this, "picked");
        this.addState(picked);

        new class extends DatePickedTransition {
            public action(event: Event): void {
                if (event.target !== null && isDatePicker(event.target) && dataHandler !== undefined) {
                    dataHandler.initToPickedHandler(event);
                }
            }
        }(this.initState, picked);
    }
}


export interface DatePickedHandler  extends FSMDataHandler {
    initToPickedHandler(event: Event): void;
}

/**
 * A user interaction for Date input.
 * @author Gwendal DIDOT
 */

export class DatePicked extends TSInteraction<WidgetData<Element>, DatePickedFSM, Element> {
    private readonly handler: DatePickedHandler;

    /**
     * Creates the interaction.
     */
    public constructor() {
        super(new DatePickedFSM());

        this.handler = new class implements DatePickedHandler {
            private readonly _parent: DatePicked;

            constructor(parent: DatePicked) {
                this._parent = parent;
            }

            public initToPickedHandler(event: Event): void {
                if (event.target !== null && isDatePicker(event.target)) {
                    this._parent._widget = event.currentTarget as Element;
                }
            }

            public reinitData(): void {
                this._parent.reinitData();
            }

        }(this);

        this.fsm.buildFSM(this.handler);
    }

    public onNewNodeRegistered(node: EventTarget): void {
        if (isDatePicker(node)) {
            this.registerActionHandlerInput(node);
        }
    }

    public onNodeUnregistered(node: EventTarget): void {
        if (isDatePicker(node)) {
            this.unregisterActionHandlerInput(node);
        }
    }

    public getData(): WidgetData<Element> {
        return this;
    }
}
