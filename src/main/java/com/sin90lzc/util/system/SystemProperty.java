package com.sin90lzc.util.system;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class SystemProperty {
	private static final transient Log log=LogFactory.getLog(SystemProperty.class);
	
	public static final String WRAP_LINE_CHAR=System.lineSeparator();
	
	public static final String USER_DIR_PROP="user.dir";
	public final static String getProjectRootDir(){
		String projectRootDir=System.getProperty(USER_DIR_PROP);
		log.debug(projectRootDir);
		return projectRootDir;
	}
	
	public final static String printSystemProperties(){
		Properties props=System.getProperties();
		StringBuffer propsBuffer=new StringBuffer();
		Set<Entry<Object, Object>> entries=props.entrySet();
		for(Entry<Object, Object> entry:entries){
			String line=entry.getKey()+"="+entry.getValue();
			propsBuffer.append(line).append('\n');
			System.out.println(line);
		}
		return propsBuffer.toString();
	}
}
