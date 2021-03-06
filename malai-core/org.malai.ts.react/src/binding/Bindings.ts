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

import {ButtonBinder} from "./ButtonBinder";
import {TSInteraction} from "../interaction/TSInteraction";
import {FSM} from "../src-core/fsm/FSM";
import {KeysPressedBinder} from "./KeysPressedBinder";
import {NodeBinder} from "./NodeBinder";
import {CommandImpl} from "../src-core/command/CommandImpl";
import {AnonCmdBinder} from "./AnonCmdBinder";
import {InteractionData} from "../src-core/interaction/InteractionData";
import {WidgetData} from "../src-core/interaction/WidgetData";
import {CheckBoxBinder} from "./CheckBoxBinder";
import {ColorPickerBinder} from "./ColorPickerBinder";
import {ComboBoxBinder} from "./ComboBoxBinder";
import {KeysData} from "../interaction/library/KeysData";
import {KeyNodeBinder} from "./KeyNodeBinder";
import {DnDBinder} from "./DnDBinder";
import {SrcTgtPointsData} from "../interaction/library/SrcTgtPointsData";
import {DragLockBinder} from "./DragLockBinder";

/**
 * Creates binding builder to build a binding between a given interaction and the given command type.
 * This builder is dedicated to bind node interactions to commands.
 * Do not forget to call bind() at the end of the build to execute the builder.
 * @param cmdProducer The command to produce.
 * @param interaction The user interaction to perform on nodes
 * @return The binding builder. Cannot be null.
 * @throws NullPointerException If the given class is null.
 */
export function nodeBinder<D extends InteractionData, C extends CommandImpl, I extends TSInteraction<D, FSM<Event>, {}>>
        (interaction: I, cmdProducer: (i?: D) => C): NodeBinder<C, I, D> {
    return new NodeBinder(interaction, cmdProducer);
}

/**
 * Creates binding builder to build a binding between a button interaction and the given command type.
 * Do not forget to call bind() at the end of the build to execute the builder.
 * @param cmdProducer The command to produce.
 * @return The binding builder. Cannot be null.
 * @throws NullPointerException If the given class is null.
 */
export function buttonBinder<C extends CommandImpl>(cmdProducer: (i?: WidgetData<Element>) => C): ButtonBinder<C> {
    return new ButtonBinder<C>(cmdProducer);
}

/**
 * Creates binding builder to build a binding between a KeysPressure interaction (done on a Node) and the given command type.
 * Do not forget to call bind() at the end of the build to execute the builder.
 * @param cmd The anonymous command to produce.
 * @return The binding builder. Cannot be null.
 * @throws NullPointerException If the given class is null.
 */
export function anonCmdBinder<D extends InteractionData, I extends TSInteraction<D, FSM<Event>, {}>>
        (interaction: I, cmd: () => void): AnonCmdBinder<I, D> {
    return new AnonCmdBinder(interaction, cmd);
}

export function dndBinder<C extends CommandImpl>
    (cmdProducer: (i?: SrcTgtPointsData) => C, srcOnUpdate: boolean, cancellable: boolean):  DnDBinder<C> {
    return new DnDBinder(cmdProducer, srcOnUpdate, cancellable);
}

export function dragLockBinder<C extends CommandImpl>
    (cmdProducer: (i?: SrcTgtPointsData) => C):  DragLockBinder<C> {
    return new DragLockBinder(cmdProducer);
}

/**
 * Creates binding builder to build a binding between a checkbox interaction and the given command type.
 * Do not forget to call bind() at the end of the build to execute the builder.
 * @param cmdProducer The command to produce.
 * @return The binding builder. Cannot be null.
 * @throws NullPointerException If the given class is null.
 */
export function boxCheckedBinder<C extends CommandImpl>(cmdProducer: (i?: WidgetData<Element>) => C): CheckBoxBinder<C> {
    return new CheckBoxBinder<C>(cmdProducer);
}

/**
 * Creates binding builder to build a binding between a colorpicked interaction and the given command type.
 * Do not forget to call bind() at the end of the build to execute the builder.
 * @param cmdProducer The command to produce.
 * @return The binding builder. Cannot be null.
 * @throws NullPointerException If the given class is null.
 */
export function colorPickedBinder<C extends CommandImpl>(cmdProducer: (i ?: WidgetData<Element>) => C): ColorPickerBinder<C> {
    return new ColorPickerBinder<C>(cmdProducer);
}

/**
 * Creates binding builder to build a binding between a combobox interaction and the given command type.
 * Do not forget to call bind() at the end of the build to execute the builder.
 * @param cmdProducer The command to produce.
 * @return The binding builder. Cannot be null.
 * @throws NullPointerException If the given class is null.
 */
export function comboBoxBinder<C extends CommandImpl>(cmdProducer: (i ?: WidgetData<Element>) => C): ComboBoxBinder<C> {
    return new ComboBoxBinder<C>(cmdProducer);
}

export function keyNodeBinder<C extends CommandImpl>(cmdProducer: (i ?: KeysData) => C): KeyNodeBinder<C> {
    return new KeyNodeBinder<C>(cmdProducer);
}

export function keysPressedBinder<C extends CommandImpl>(cmdProducer: (i ?: KeysData) => C): KeysPressedBinder<C> {
    return new KeysPressedBinder<C>(cmdProducer);
}
