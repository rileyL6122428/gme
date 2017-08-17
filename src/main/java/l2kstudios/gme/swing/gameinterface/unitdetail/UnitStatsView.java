package l2kstudios.gme.swing.gameinterface.unitdetail;

import java.awt.Graphics;

import l2kstudios.gme.model.unit.Unit;
import static l2kstudios.gme.model.unit.Unit.StatType.*;
import l2kstudios.gme.swing.view.View;

public class UnitStatsView implements View {
	
	private UnitDetailInterface unitDetailInterface;
	
	private static final int MARGIN_LEFT = 50;
	private static final int MARGIN_TOP = 25;
	
	private static final int COLUMN_MARGIN = 155;
	private static final int ROW_MARGIN = 25;
	
	public UnitStatsView(UnitDetailInterface unitDetailInterface) {
		this.unitDetailInterface = unitDetailInterface;
	}

	@Override
	public void draw(Graphics drawingCtx) {
		Unit unit = unitDetailInterface.getSelectedUnit();
		
		drawingCtx.drawString(unit.getName(), getXForColumn(0), getYForRow(0));
		
		drawingCtx.drawString("Health: " + unit.get(HEALTH) + " / " + unit.getMax(HEALTH), getXForColumn(0), getYForRow(1));
		drawingCtx.drawString("Momentum: " + unit.get(MOMENTUM) + " / " + unit.getMax(MOMENTUM), getXForColumn(1), getYForRow(1));
		
		drawingCtx.drawString("Strength: " + unit.get(STRENGTH), getXForColumn(0), getYForRow(2));
		drawingCtx.drawString("Magic: " + unit.get(MAGIC), getXForColumn(1), getYForRow(2));
		
		drawingCtx.drawString("Physical Defense: " + unit.get(PHYSICAL_DEFENSE), getXForColumn(0), getYForRow(3));
		drawingCtx.drawString("Magical Defense: " + unit.get(MAGICAL_DEFENSE), getXForColumn(1), getYForRow(3));
		
		drawingCtx.drawString("Intelligence: " + unit.get(INTELLIGENCE), getXForColumn(0), getYForRow(4));
		drawingCtx.drawString("Skill: " + unit.get(SKILL), getXForColumn(1), getYForRow(4));
		
		drawingCtx.drawString("Speed: " + unit.get(SPEED), getXForColumn(0), getYForRow(5));
		drawingCtx.drawString("Movement: " + unit.get(MOVEMENT), getXForColumn(1), getYForRow(5));
	}
	
	private int getXForColumn(int colIdx) {
		return MARGIN_LEFT + colIdx * COLUMN_MARGIN;
	}
	
	private int getYForRow(int rowIdx) {
		return MARGIN_TOP + rowIdx * ROW_MARGIN;
	}

}
