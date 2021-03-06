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

import java.util.Optional;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.Event;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.malai.javafx.interaction.JfxInteraction;

public class DragLock extends JfxInteraction<SrcTgtPointsData, DragLockFSM, Event> implements SrcTgtPointsData {
	private final DragLockFSM.DragLockFSMHandler handler;
	protected final DoubleClick firstClick;
	protected final DoubleClick sndClick;

	public DragLock() {
		super(new DragLockFSM());

		handler = new DragLockFSM.DragLockFSMHandler() {
			@Override
			public void onMove(final MouseEvent event) {
				sndClick.firstClick.setPointData(event);
				sndClick.firstClick.pointData.setModifiersData(event);
			}

			@Override
			public void reinitData() {
				DragLock.this.reinitData();
			}
		};

		firstClick = new DoubleClick(fsm.firstDbleClick);
		sndClick = new DoubleClick(fsm.sndDbleClick);
		fsm.buildFSM(handler);
	}

	@Override
	public void reinitData() {
		super.reinitData();
		firstClick.reinitData();
		sndClick.reinitData();
	}

	@Override
	public SrcTgtPointsData getData() {
		return this;
	}

	@Override
	public Optional<Node> getTgtObject() {
		return sndClick.getData().getSrcObject();
	}

	@Override
	public ReadOnlyObjectProperty<Point3D> tgtLocalPointProperty() {
		return sndClick.getData().srcLocalPointProperty();
	}

	@Override
	public ReadOnlyObjectProperty<Point3D> tgtScenePointProperty() {
		return sndClick.getData().srcScenePointProperty();
	}

	@Override
	public ReadOnlyObjectProperty<Node> tgtObjectProperty() {
		return sndClick.getData().srcObjectProperty();
	}

	@Override
	public Point3D getTgtLocalPoint() {
		return sndClick.getData().getSrcLocalPoint() == null ? getSrcLocalPoint() : sndClick.getData().getSrcLocalPoint();
	}

	@Override
	public Point3D getTgtScenePoint() {
		return sndClick.getData().getSrcScenePoint() == null ? getSrcScenePoint() : sndClick.getData().getSrcScenePoint();
	}

	@Override
	public ReadOnlyObjectProperty<Point3D> srcLocalPointProperty() {
		return firstClick.getData().srcLocalPointProperty();
	}

	@Override
	public ReadOnlyObjectProperty<Point3D> srcScenePointProperty() {
		return firstClick.getData().srcScenePointProperty();
	}

	@Override
	public ReadOnlyObjectProperty<Node> srcObjectProperty() {
		return firstClick.getData().srcObjectProperty();
	}

	@Override
	public boolean isAltPressed() {
		return firstClick.getData().isAltPressed();
	}

	@Override
	public boolean isCtrlPressed() {
		return firstClick.getData().isCtrlPressed();
	}

	@Override
	public boolean isShiftPressed() {
		return firstClick.getData().isShiftPressed();
	}

	@Override
	public boolean isMetaPressed() {
		return firstClick.getData().isMetaPressed();
	}

	@Override
	public MouseButton getButton() {
		return firstClick.getData().getButton();
	}
}
