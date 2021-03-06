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

import {Undoable} from "./Undoable";

/**
 * This handler must help object that want to be aware of undone/redone event (for instance, to update some widgets).
 * @author Arnaud BLOUIN
 * @since 0.1
 * @class
 */
export interface UndoHandler {
    /**
     * Notifies the handler that the stored undoable objects have been all removed.
     * @since 0.2
     */
    onUndoableCleared(): void;

    /**
     * Actions to do when an undoable object is added to the undo register.
     * @param {*} undoable The undoable object added to the undo register.
     * @since 0.2
     */
    onUndoableAdded(undoable: Undoable): void;

    /**
     * Actions to do when an undoable object is undone.
     * @param {*} undoable The undone object.
     * @since 0.2
     */
    onUndoableUndo(undoable: Undoable): void;

    /**
     * Actions to do when an undoable object is redone.
     * @param {*} undoable The redone object.
     * @since 0.2
     */
    onUndoableRedo(undoable: Undoable): void;
}

