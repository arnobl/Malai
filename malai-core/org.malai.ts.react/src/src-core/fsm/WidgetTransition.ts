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

import {Transition} from "./Transition";
import {OutputState} from "./OutputState";
import {InputState} from "./InputState";

/**
 * This transition must be used to use a widget within an interaction.
 * @author Arnaud BLOUIN
 * @param {*} srcState
 * @param {*} tgtState
 * @class
 * @extends Transition
 */
export abstract class WidgetTransition<E, T> extends Transition<E> {
    /**
     * The pressed button.
     */
    protected widget: T;

    protected constructor(srcState: OutputState<E>, tgtState: InputState<E>) {
        super(srcState, tgtState);
    }

    /**
     * @return {*} The widget used.
     */
    public getWidget(): T {
        return this.widget;
    }

    /**
     * Sets the widget.
     * @param {*} widget The widget to set. Nothign done if null.
     */
    public setWidget(widget: T): void {
        if (widget !== undefined) {
            this.widget = widget;
        }
    }
}
