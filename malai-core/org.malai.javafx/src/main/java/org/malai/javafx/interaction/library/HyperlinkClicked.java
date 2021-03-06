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
package org.malai.javafx.interaction.library;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Hyperlink;
import org.malai.javafx.interaction.JfxInteraction;

/**
 * A user interaction for hyperlinks.
 * @author Arnaud BLOUIN
 */
public class HyperlinkClicked extends JfxInteraction<WidgetData<Hyperlink>, HyperlinkClickedFSM, Hyperlink> {
	private final HyperlinkClickedFSM.HyperlinkClickedFSMHandler handler;

	/**
	 * Creates the interaction.
	 */
	public HyperlinkClicked() {
		super(new HyperlinkClickedFSM());

		handler = new HyperlinkClickedFSM.HyperlinkClickedFSMHandler() {
			@Override
			public void initToClickedHandler(final ActionEvent event) {
				if(event.getSource() instanceof Hyperlink) {
					widget = (Hyperlink) event.getSource();
				}
			}

			@Override
			public void reinitData() {
				HyperlinkClicked.this.reinitData();
			}
		};

		fsm.buildFSM(handler);
	}

	@Override
	protected void onNewNodeRegistered(final Node node) {
		if(node instanceof Hyperlink) {
			registerActionHandler(node);
		}
	}

	@Override
	public WidgetData<Hyperlink> getData() {
		return this;
	}

	@Override
	protected void onNodeUnregistered(final Node node) {
		if(node instanceof Hyperlink) {
			unregisterActionHandler(node);
		}
	}
}
