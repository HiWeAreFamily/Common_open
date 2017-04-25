1.默认情况下 是Commons-Loggin+Log4j
	A．Commons-Loggin(JCL)提供的是一个日志(Log)接口(interface)，兼顾轻量级和不依赖于具体的日志实现工具。它提供日志操作抽象，使用不同的具体日志实现工具;
		org.apache.commons.logging.Log的具体实现有如下：
		-org.apache.commons.logging.impl.Jdk14Logger　使用JDK1.4。
		-org.apache.commons.logging.impl.Log4JLogger　使用Log4J。
		-org.apache.commons.logging.impl.LogKitLogger　使用 avalon-Logkit。
		-org.apache.commons.logging.impl.SimpleLog　common-logging自带日志实现类。它实现了Log接口，把日志消息都输出到系统错误流System.err 中。 
		-org.apache.commons.logging.impl.NoOpLog　common-logging自带日志实现类。它实现了Log接口。 其输出日志的方法中不进行任何操作。
	B. Log4j的强大，同时开发者又不希望对Log4j的依赖性太强。所以目前比较流行的是Commons-logging和Log4j结合使用。

	C.步骤
   		下载commons-logging.jar和log4j.jar包，能后把它们放到工程的lib目录下，引入工程中。

  		在属性文件common-logging.properties中设置实现接口的类。如下(这里设置Log4j为所使用的日志包)：
				org.apache.commons.logging.Log=org.apache.commons.logging.impl.Log4JCategoryLog
	D.Apache Commons-logging使用流程	
		private static Log log = LogFactory.getLog(Test.class);
			log.debug("Debug info.");
	       log.info("Info info");
	       log.warn("Warn info");
	       log.error("Error info");
	       log.fatal("Fatal info");
2.为了不用每次每个类都写"private static Log log = LogFactory.getLog(Test.class);"
	Log4J 第一版本就直接用Log4JUtil1.java;
	Log4J 第二版本就直接用Log4JUtil2.java;