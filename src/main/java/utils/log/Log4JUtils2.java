package utils.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.ReflectionUtil;

/**
 * @author fangh1
 * 
 *         Log4j2 第2版
 *
 */
public class Log4JUtils2 {

	private static Logger logger;

	public static Logger getLogger() {
		if (null == logger) {
			// 1.Java8 废弃了Reflection.getCallerClass()
			// logger =
			// LogManager.getLogger(Reflection.getCallerClass().getName());
			// 2.log4j2 Uitl 包里面有ReflectionUtil
			logger = LogManager.getLogger(ReflectionUtil.getCallerClass(1).getName());
			// logger.debug("调用者类名" + Reflection.getCallerClass().getName());
		}
		return logger;
	}

}