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

import {KeysPressedBinder} from "../../src/binding/KeysPressedBinder";
import {TSWidgetBinding} from "../../src/binding/TSWidgetBinding";
import {EventRegistrationToken} from "../../src/interaction/Events";
import {KeysData} from "../../src/interaction/library/KeysData";
import {KeysPressed} from "../../src/interaction/library/KeysPressed";
import {StubCmd} from "../command/StubCmd";
import {StubFSMHandler} from "../fsm/StubFSMHandler";
import {createKeyEvent} from "../interaction/StubEvents";

jest.mock("../fsm/StubFSMHandler");
jest.mock("../command/StubCmd");

let div: HTMLElement;
let binding: TSWidgetBinding<StubCmd, KeysPressed, KeysData>;

beforeEach(() => {
    jest.clearAllMocks();
    const binder = new KeysPressedBinder(() => new StubCmd());
    document.documentElement.innerHTML = "<html><div id='dv1'></div></html>";
    const elt = document.getElementById("dv1");
    if (elt !== null) {
        div = elt;
        binder.on(div);
    }
    binding = binder.bind();
});

test("KeysPressedBinder produces a binding", () => {
    expect(binding).not.toBeNull();
});

test("Press keys triggers the interaction", () => {
    const handler = new StubFSMHandler();
    binding.getInteraction().getFsm().addHandler(handler);
    div.dispatchEvent(createKeyEvent(EventRegistrationToken.KeyDown, "ControlLeft"));
    div.dispatchEvent(createKeyEvent(EventRegistrationToken.KeyDown, "KeyS"));
    div.dispatchEvent(createKeyEvent(EventRegistrationToken.KeyUp, "KeyS"));
    expect(handler.fsmStops).toHaveBeenCalledTimes(1);
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
});
