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

import {FSMHandler} from "../../src/src-core/fsm/FSMHandler";
import {StubFSMHandler} from "../fsm/StubFSMHandler";
import {BoxChecked} from "../../src/interaction/library/BoxChecked";

jest.mock("../fsm/StubFSMHandler");

let interaction: BoxChecked;
let boxCheck: HTMLElement;
let handler: FSMHandler;

beforeEach(() => {
    jest.clearAllMocks();
    handler = new StubFSMHandler();
    interaction = new BoxChecked();
    interaction.log(true);
    interaction.getFsm().log(true);
    interaction.getFsm().addHandler(handler);
    document.documentElement.innerHTML = "<html><div><input id='bc1' type='checkbox'></div></html>";
    const elt = document.getElementById("bc1");
    if (elt !== null) {
        boxCheck = elt;
    }
});

test("Click event start and stop the interaction CheckBox", () => {
    interaction.registerToNodes([boxCheck]);
    boxCheck.click();
    expect(handler.fsmStops).toHaveBeenCalledTimes(1);
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
});

test("Input event trigger the interaction CheckBox", () => {
    interaction.registerToNodes([boxCheck]);
    boxCheck.dispatchEvent(new Event("input"));
    expect(handler.fsmStarts).toHaveBeenCalledTimes(1);
    expect(handler.fsmStops).toHaveBeenCalledTimes(1);
});

test("Other event don't trigger the interaction CheckBox", () => {
    interaction.registerToNodes([boxCheck]);
    boxCheck.dispatchEvent(new Event("change"));
    boxCheck.dispatchEvent(new Event("update"));
    expect(handler.fsmStarts).not.toHaveBeenCalled();
});
