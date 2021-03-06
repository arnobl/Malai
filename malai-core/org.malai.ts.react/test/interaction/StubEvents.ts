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

export function createMouseEvent(type: string, target: EventTarget, screenX ?: number, screenY ?: number, clientX ?: number,
                                 clientY?: number, button?: number): MouseEvent {

    const screenXvalue = screenX === undefined ? 0 : screenX;
    const screenYvalue = screenY === undefined ? 0 : screenY;
    const clientXvalue = clientX === undefined ? 0 : clientX;
    const clientYvalue = clientY === undefined ? 0 : clientY;
    const buttonValue = button === undefined ? 0 : button;
    return new MouseEvent(type, {
        view: window,
        bubbles: true,
        cancelable: false,
        detail: 1,
        screenX: screenXvalue,
        screenY: screenYvalue,
        clientX: clientXvalue,
        clientY: clientYvalue,
        ctrlKey: false,
        altKey: false,
        shiftKey: false,
        metaKey: false,
        button: buttonValue,
        relatedTarget: target
    });
}

export function createKeyEvent(type: string, keyCode: string): KeyboardEvent {
    return new KeyboardEvent(type, {
        cancelable: false,
        bubbles: true,
        view: window,
        code: keyCode,
        repeat: false
    });
}

export function createUIEvent(type: string): UIEvent {
    return new UIEvent(type, {
        detail : 0,
        bubbles: true,
        cancelable: false,
        scoped: true,
        view: window
    });
}
