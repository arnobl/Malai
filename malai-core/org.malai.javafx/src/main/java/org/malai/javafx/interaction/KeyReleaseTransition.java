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
package org.malai.javafx.interaction;

import java.util.Collections;
import java.util.Set;
import javafx.event.Event;
import javafx.scene.input.KeyEvent;
import org.malai.fsm.InputState;
import org.malai.fsm.OutputState;

/**
 * This transition corresponds to a release of a key of a keyboard.
 * @author Arnaud BLOUIN
 */
public class KeyReleaseTransition extends InputEventTransition<KeyEvent> {
	/**
	 * Creates the transition.
	 */
	public KeyReleaseTransition(final OutputState<Event> srcState, final InputState<Event> tgtState) {
		super(srcState, tgtState);
	}

	@Override
	protected boolean accept(final Event event) {
		return event != null && event.getEventType() == KeyEvent.KEY_RELEASED;
	}

	@Override
	protected boolean isGuardOK(final Event event) {
		return true;
	}

	@Override
	public Set<Object> getAcceptedEvents() {
		return Collections.singleton(KeyEvent.KEY_RELEASED);
	}
}
