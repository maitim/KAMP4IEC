package edu.kit.ipd.sdq.kamp4iec.core;

import edu.kit.ipd.sdq.kamp.workplan.AbstractActivityElementType;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.FunctionBlock;
import edu.kit.ipd.sdq.kamp4iec.model.IECModel.GlobalVariable;;

public enum IECActivityElementType implements AbstractActivityElementType {
	FUNCTIONBLOCK(FunctionBlock.class),
	GLOBALVARIABLE(GlobalVariable.class);
	private final Class<?> clazz;
	private final String name;
	
	private IECActivityElementType(Class<?> clazz) {
		this.clazz = clazz;
		this.name = clazz.getSimpleName();
	}

	@Override
	public Class<?> getElementClass() {
		return clazz;
	}
	
	@Override
	public String getName() {
		return name;
	}

	public static IECActivityElementType[] getTopLevelArchitectureActivityElementTypes() {	
		return new IECActivityElementType[]{GLOBALVARIABLE, FUNCTIONBLOCK};
	}

}