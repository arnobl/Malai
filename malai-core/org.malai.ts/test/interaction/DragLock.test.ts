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

import {FSMHandler} from "../../src/src-core/fsm/FSMHandler";
import {StubFSMHandler} from "../fsm/StubFSMHandler";
import {DragLock} from "../../src/interaction/library/DragLock";
import {createKeyEvent, createMouseEvent} from "./StubEvents";
import {EventRegistrationToken, KeyCode} from "../../src/interaction/Events";

jest.mock("../fsm/StubFSMHandler");

let interaction: DragLock;
let canvas: HTMLElement;
let handler: FSMHandler;

beforeEach(() => {
    jest.clearAllMocks();
    jest.useFakeTimers();
    handler = new StubFSMHandler();
    interaction = new DragLock();
    interaction.log(true);
    // interaction.getFsm().log(true);
    interaction.getFsm().addHandler(handler);
    document.documentElement.innerHTML = "<html><div><canvas id='canvas1' /></div></html>";
    const elt = document.getElementById("canvas1");
    if (elt !== null) {
        canvas = elt;
    }
});

test("Drag lock is ok", () => {
    interaction.registerToNodes([canvas]);
    canvas.click();
    canvas.click();
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas));
    canvas.click();
    canvas.click();
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmStops).toHaveBeenCalledTimes(1);
    expect(handler.fsmCancels).not.toHaveBeenCalled();
});

test("Drag lock requires a least a move", () => {
    interaction.registerToNodes([canvas]);
    canvas.click();
    canvas.click();
    canvas.click();
    canvas.click();
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmStops).not.toHaveBeenCalled();
    expect(handler.fsmCancels).toHaveBeenCalledTimes(1);
});

test("Drag lock canceled on ESC", () => {
    interaction.registerToNodes([canvas]);
    canvas.click();
    canvas.click();
    canvas.dispatchEvent(createKeyEvent(EventRegistrationToken.KeyDown, String(KeyCode.ESCAPE)));
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmStops).not.toHaveBeenCalled();
    expect(handler.fsmCancels).toHaveBeenCalledTimes(1);
});

test("Check data with a normal execution", () => {
    let srcX = -1;
    let srcY = -1;
    let tgtX = -1;
    let tgtY = -1;
    interaction.getFsm().addHandler(new class extends StubFSMHandler {

        public fsmStops() {
            srcX = interaction.getData().getSrcClientX();
            srcY = interaction.getData().getSrcClientY();
            tgtX = interaction.getData().getTgtClientX();
            tgtY = interaction.getData().getTgtClientY();
        }

    }());
    interaction.processEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 11, 23));
    interaction.processEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 11, 23));
    interaction.processEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas, undefined, undefined, 20, 30));
    interaction.processEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 22, 33));
    interaction.processEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 22, 33));
    expect(srcX).toBe(11);
    expect(srcY).toBe(23);
    expect(tgtX).toBe(22);
    expect(tgtY).toBe(33);
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmUpdates).toHaveBeenCalledTimes(2);
    expect(handler.fsmStops).toHaveBeenCalledTimes(1);
    expect(handler.fsmCancels).not.toHaveBeenCalled();
});

test("Check update work during move", () => {
    interaction.registerToNodes([canvas]);
    canvas.click();
    canvas.click();
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas));
    expect(handler.fsmUpdates).toHaveBeenCalledTimes(2);
});

test("Check data update during a move", () => {
    interaction.registerToNodes([canvas]);
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 11, 23));
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 11, 23));
    interaction.getFsm().addHandler(new class extends StubFSMHandler {

        public fsmUpdates() {
            expect(interaction.getData().getTgtClientX()).toBe(30);
            expect(interaction.getData().getTgtClientY()).toBe(40);
        }
    }());
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas, undefined, undefined, 30, 40));
    expect(handler.fsmCancels).not.toHaveBeenCalled();
});

test("Check data reinitialisation", () => {
    interaction.registerToNodes([canvas]);
    canvas.click();
    canvas.click();
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas));
    canvas.click();
    canvas.click();
    expect(interaction.getData().getSrcClientX()).toBe(0);
    expect(interaction.getData().getSrcClientY()).toBe(0);
    expect(interaction.getData().getTgtClientX()).toBe(0);
    expect(interaction.getData().getTgtClientY()).toBe(0);
});

test("Check if canceled with Esc after a move", () => {
    interaction.registerToNodes([canvas]);
    canvas.click();
    canvas.click();
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas));
    canvas.dispatchEvent(createKeyEvent(EventRegistrationToken.KeyDown, "Escape"));
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmCancels).toHaveBeenCalledTimes(1);
    expect(handler.fsmStops).not.toHaveBeenCalled();
});

test("Check if the last DoubleClick with a different button don't stop the interaction", () => {
    interaction.registerToNodes([canvas]);
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 11, 23, 1));
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 11, 23, 1));
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.MouseMove, canvas, undefined, undefined, 20, 30, 1));
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 20, 30, 0));
    canvas.dispatchEvent(createMouseEvent(EventRegistrationToken.Click, canvas, undefined, undefined, 20, 30, 0));
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmStops).not.toHaveBeenCalled();
});
