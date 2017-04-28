package l2kstudios.gme.view;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import l2kstudios.gme.model.level.Level;

public class UnitViewList implements InitializingBean, View {
	
	@Autowired
	private Level level;
	
	@Autowired 
	private UnitViewFactory unitViewFactory;
	
	private List<UnitView> unitViews;
	
	public void draw() {
		unitViews.forEach(UnitView::draw);
	}

	@Override
	public void afterPropertiesSet() throws Exception {		
		unitViews = level.getUnits().stream()
									.map(unitViewFactory::newUnitView)
									.collect(Collectors.toList());
	}
}
