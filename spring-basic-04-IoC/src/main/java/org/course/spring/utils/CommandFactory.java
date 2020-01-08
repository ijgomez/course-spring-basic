package org.course.spring.utils;

import java.util.HashMap;
import java.util.Map;

import org.course.spring.commands.CargarContexto;
import org.course.spring.commands.InstanciarBean;
import org.course.spring.commands.InyectarBean;

public class CommandFactory {

	private static CommandFactory instance;

	public static CommandFactory getInstancia() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		return instance;
	}

	private Map<CommandType, Command> map;

	/**
	 * New Instance
	 */
	private CommandFactory() {

	}

	private void inicializarOrdenes() {
		getMap().put(CommandType.LOAD_CONTEXT, new CargarContexto());
		getMap().put(CommandType.INSTANCE_BEAN, new InstanciarBean());
		getMap().put(CommandType.INYECTION_BEAN, new InyectarBean());
	}

	public Command getCommand(CommandType type) {
		return getMap().get(type);
	}

	private Map<CommandType, Command> getMap() {
		if (map == null) {
			map = new HashMap<>();
			inicializarOrdenes();
		}
		return map;
	}
}
