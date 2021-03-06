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

// IMPORTANT : this interaction is not fully supported by Web browsers yet.
// see https://developer.mozilla.org/fr/docs/Web/HTML/Element/menu for more information.

import {FSMDataHandler} from "../FSMDataHandler";
import {TSFSM} from "../TSFSM";
import {TerminalState} from "../../src-core/fsm/TerminalState";
import {isMenuButton} from "../Events";
import {TSInteraction} from "../TSInteraction";
import {WidgetData} from "../../src-core/interaction/WidgetData";
import {MenuButtonPressedTransition} from "../MenuButtonPressedTransition";


export class MenuButtonPressedFSM extends TSFSM<MenuButtonPressedFSMHandler> {
    public constructor() {
        super();
    }

    public buildFSM(dataHandler?: MenuButtonPressedFSMHandler): void {
        if (this.states.length > 1) {
            return;
        }
        super.buildFSM(dataHandler);
        const pressed: TerminalState<Event> = new TerminalState<Event>(this, "pressed");
        this.addState(pressed);

        new class extends MenuButtonPressedTransition {
            public action(event: Event): void {
                if (event.target !== null && isMenuButton(event.target) && dataHandler !== undefined) {
                    dataHandler.initToPressedHandler(event);
                }
            }
        }(this.initState, pressed);
    }
}

export interface MenuButtonPressedFSMHandler extends FSMDataHandler {
    initToPressedHandler(event: Event): void;
}

/**
 * A user interaction for menu buttons.
 * @author Gwendal Didot
 */
export class MenuButtonPressed extends TSInteraction<WidgetData<Element>, MenuButtonPressedFSM, Element> {
    private readonly handler: MenuButtonPressedFSMHandler;

    /**
     * Create the interaction.
     */
    public constructor() {
        super(new MenuButtonPressedFSM());

        this.handler = new class implements MenuButtonPressedFSMHandler {
            private readonly _parent: MenuButtonPressed;

            constructor(parent: MenuButtonPressed) {
                this._parent = parent;
            }

            public initToPressedHandler(event: Event): void {
                if (event.target !== null && isMenuButton(event.target)) {
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
        if (isMenuButton(node)) {
            this.registerActionHandlerClick(node);
        }
    }

    public onNodeUnregistered(node: EventTarget): void {
        if (isMenuButton(node)) {
            this.unregisterActionHandlerClick(node);
        }
    }

    public getData(): WidgetData<Element> {
        return this;
    }
}
