package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class UserProperties {
	private Properties properties = null;
	private OutputStream fo = null;
	private InputStream fi = null;

	private Properties defaultProperties;
	private String fileName = null;
	private String comment;

	/**
	 * 
	 * 如果文件不存在，会自动重建，并且设置默认值
	 * 
	 * @param fileName
	 * @param defaultProperties
	 * @param comment
	 */
	public UserProperties(String fileName, Map<String, String> defaultProperties, String comment) {
		this.fileName = fileName;
		this.comment = comment;
		this.defaultProperties = setDefaultProperties(defaultProperties);

		properties = new Properties();
		File file = new File(fileName);
		try {
			if (!file.exists()) {
				file.createNewFile();
				fo = new FileOutputStream(fileName);

				properties = defaultProperties();
				properties.store(fo, comment);

				fo.close();
			}

			fi = new FileInputStream(fileName);
			properties.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if (fi != null) {
					fi.close();
				}
				if (fo != null)
					fo.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (fi != null) {
					fi.close();
				}
				if (fo != null)
					fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Properties getProperties() {
		return properties;
	}

	public Properties defaultProperties() {
		return defaultProperties;
	}

	public void save() {
		File file = new File(fileName);
		try {
			if (file.exists()) {
				file.createNewFile();
				fo = new FileOutputStream(fileName);

				properties.store(fo, comment);

				fo.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				if (fo != null)
					fo.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (fo != null)
					fo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getProperty(String property) {
		if (properties.getProperty(property) == null) {
			return defaultProperties.getProperty(property);
		}
		return properties.getProperty(property);
	}

	public void setProperty(String property, String value) {
		properties.setProperty(property, value);
		save();
	}

	public String getProperty(String property, String defaultValue) {
		return properties.getProperty(property, defaultValue);
	}

	public Properties setDefaultProperties(Map<String, String> defaultProperties) {
		Properties p = new Properties();
		Iterator it = defaultProperties.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry property = (Map.Entry) it.next();
			p.put(property.getKey(), property.getValue());

			it.remove();
		}

		return p;
	}
}
