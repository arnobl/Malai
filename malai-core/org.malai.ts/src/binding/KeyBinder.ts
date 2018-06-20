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

import {Binder, CommandImpl, KeyData, KeyPressed} from "..";
// import {LinkedList} from "typescript-logging";


/**
 * The binding builder to create bindings between a combobox interaction and a given command.
 * @param <C> The type of the command to produce.
 * @author Gwendal Didot
 */

export class KeyBinder<C extends CommandImpl, B extends KeyBinder<C, B>> extends Binder<C, KeyPressed, KeyData, B> {
    // private readonly codes: LinkedList<number>;
    // private readonly checkCode: boolean;

    public constructor(modifierAccepted: boolean, cmdProducer: (i ?: KeyData) => C) {
        super(new KeyPressed(modifierAccepted), cmdProducer);
        // this.codes = new LinkedList<number>();
        // const keys: LinkedList<String> = new LinkedList<String>();
        // keys.addTail(this.interaction.getKey());
        // this.checkCode = (this.codes.getSize() === 0) || this.codes.getSize() === keys.getSize() && keys && this.checkConditions;
        // }
    }
}

