package l2kstudios.gme.swing.gameinterface.moveplacement;

import static l2kstudios.gme.swing.view.ColorConstants.ActionPlacement.CURSOR_COLOR;
import static l2kstudios.gme.swing.view.ColorConstants.ActionPlacement.SELECTABLE_SPACE_COLOR;

import java.awt.Graphics;
import java.util.Set;

import l2kstudios.gme.model.grid.Cursor;
import l2kstudios.gme.model.grid.playinggrid.PlayingGridSpace;
import l2kstudios.gme.swing.view.View;
import l2kstudios.gme.swing.view.ViewUtils;

public class MovePlacementView implements View {
	
	private Cursor cursor;
	private Set<PlayingGridSpace> moveableSpaces;
	
	public MovePlacementView() { }
	
	public MovePlacementView(Cursor cursor, Set<PlayingGridSpace> moveableSpaces) {
		this.cursor = cursor;
		this.moveableSpaces = moveableSpaces;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		drawMoveableSpaces(drawingCtx);
		drawCursor(drawingCtx);
	}

	private void drawMoveableSpaces(Graphics drawingCtx) {
		drawingCtx.setColor(SELECTABLE_SPACE_COLOR);
		
		moveableSpaces.forEach((space) -> {
			ViewUtils.drawFillRectAt(space, drawingCtx);
		});
	}

	private void drawCursor(Graphics drawingCtx) {
		drawingCtx.setColor(CURSOR_COLOR);
		ViewUtils.drawFillRectAt(cursor.getPosition(), drawingCtx);
	}

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}

	public Set<PlayingGridSpace> getMoveableSpaces() {
		return moveableSpaces;
	}

	public void setMoveableSpaces(Set<PlayingGridSpace> moveableSpaces) {
		this.moveableSpaces = moveableSpaces;
	}

}
