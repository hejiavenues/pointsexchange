package cn.cashbang.core.modules.generator.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.cashbang.core.common.exception.RRException;
import cn.cashbang.core.common.utils.DateUtils;
import cn.cashbang.core.common.utils.PropertiesUtils;
import cn.cashbang.core.modules.generator.constant.GenConstant;
import cn.cashbang.core.modules.generator.entity.ColumnEntity;
import cn.cashbang.core.modules.generator.entity.GeneratorParamEntity;
import cn.cashbang.core.modules.generator.entity.TableEntity;

/**
 * 代码生成器 工具类
 *
 * @author Tiny
 * @email xxx@cashbang.cn
 * @url www.cashbang.cn
 * @date 2017年8月29日 上午8:55:05
 */
public class GenUtils {

	public static List<String> getTemplates() {
		List<String> templates = new ArrayList<String>();
		templates.add("velocity/template/Entity.java.vm");
		templates.add("velocity/template/Mapper.java.vm");
		templates.add("velocity/template/Mapper.xml.vm");
		templates.add("velocity/template/Manager.java.vm");
		templates.add("velocity/template/ManagerImpl.java.vm");
		templates.add("velocity/template/Service.java.vm");
		templates.add("velocity/template/ServiceImpl.java.vm");
		templates.add("velocity/template/Controller.java.vm");
		templates.add("velocity/template/list.html.vm");
		templates.add("velocity/template/list.js.vm");
		templates.add("velocity/template/add.html.vm");
		templates.add("velocity/template/add.js.vm");
		templates.add("velocity/template/edit.html.vm");
		templates.add("velocity/template/edit.js.vm");
		templates.add("velocity/template/menu.sql.vm");
		return templates;
	}

	/**
	 * 生成代码
	 */
	public static void generatorCode(TableEntity table, List<ColumnEntity> columns, GeneratorParamEntity params,
			ZipOutputStream zip) {

		// 表名转换成Java类名

		// sys_user -> SysUser
		String className = tableToJava(table.getTableName(), PropertiesUtils.getInstance("velocity/generator").get("tablePrefix"));
		// SysUser
		table.setClassName(className);
		// sysUser
		table.setObjName(StringUtils.uncapitalize(className));

		// 列信息
		for (ColumnEntity column : columns) {
			// 列名转换，java属性名及对应方法名

			// user_id -> UserId
			String columnName = columnToJava(column.getColumnName());
			// userId
			column.setFieldName(StringUtils.uncapitalize(columnName));
			// UserId
			column.setMethodName(columnName);
			// 列数据类型转换
			String fieldType = PropertiesUtils.getInstance("velocity/generator").get(column.getDataType());
			column.setFieldType(fieldType);
			// 主键判断
			if ("PRI".equals(column.getColumnKey()) && table.getPk() == null) {
				table.setPk(column);
			}
		}
		table.setColumns(columns);

		// 没主键，则第一个字段为主键
		if (table.getPk() == null) {
			table.setPk(table.getColumns().get(0));
		}

		// 设置velocity资源加载器
		Properties prop = new Properties();
		prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.init(prop);

		// 封装模板数据
		Map<String, Object> map = new HashMap<>();
		map.put("tableName", table.getTableName());
		map.put("comments", table.getTableComment());
		map.put("pk", table.getPk());
		map.put("className", table.getClassName());
		map.put("objName", table.getObjName());
		map.put("functionCode", params.getFunctionCode());
		map.put("requestMapping", params.getRequestMapping());
		map.put("viewPath", params.getViewPath());
		map.put("authKey", urlToAuthKey(params.getRequestMapping()));
		map.put("columns", table.getColumns());
		map.put("package", PropertiesUtils.getInstance("velocity/generator").get("package"));
		map.put("module", params.getModule());
		map.put("author", PropertiesUtils.getInstance("velocity/generator").get("author"));
		map.put("email", PropertiesUtils.getInstance("velocity/generator").get("email"));
		map.put("url", PropertiesUtils.getInstance("velocity/generator").get("url"));
		map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_CHN_PATTERN));
		VelocityContext context = new VelocityContext(map);

		// 获取模板列表
		List<String> templates = getTemplates();
		for (String template : templates) {
			// 渲染模板
			StringWriter sw = new StringWriter();
			Template tpl = Velocity.getTemplate(template, "UTF-8");
			tpl.merge(context, sw);

			try {
				// 添加到zip
				if ("1".equals(params.getType())) {
					zip.putNextEntry(new ZipEntry(getFileName(template, table.getClassName(), params.getModule(),
							params.getFunctionCode(), PropertiesUtils.getInstance("velocity/generator").get("package"),params.getViewPath())));
				} else {
					zip.putNextEntry(new ZipEntry(getFileName(template, table.getClassName())));
				}
				IOUtils.write(sw.toString(), zip, "UTF-8");
				IOUtils.closeQuietly(sw);
				zip.closeEntry();
			} catch (IOException e) {
				throw new RRException("渲染模板失败，表名：" + table.getTableName(), e);
			}
		}
	}

	/**
	 * 列名转换成Java属性名
	 */
	public static String columnToJava(String columnName) {
		return WordUtils.capitalizeFully(columnName, new char[] { '_' }).replace("_", "");
	}

	/**
	 * 表名转换成Java类名
	 */
	public static String tableToJava(String tableName, String tablePrefix) {
		if (StringUtils.isNotBlank(tablePrefix)) {
			tableName = tableName.replace(tablePrefix, "");
		}
		return columnToJava(tableName);
	}

	/**
	 * 权限标识
	 * 
	 * @param url
	 * @return
	 */
	public static String urlToAuthKey(String url) {
		return url.replace("/", ":");
	}

	/**
	 * 获取文件名，不带包名
	 * 
	 * @param template
	 * @param className
	 * @return
	 */
	public static String getFileName(String template, String className) {
		String packagePath = "java" + File.separator;
		if (template.contains(GenConstant.JAVA_ENTITY)) {
			return packagePath + className + "Entity.java";
		}

		if (template.contains(GenConstant.JAVA_MAPPER)) {
			return packagePath + className + "Mapper.java";
		}

		if (template.contains(GenConstant.XML_MAPPER)) {
			return packagePath + className + "Mapper.xml";
		}

		if (template.contains(GenConstant.JAVA_MANAGER)) {
			return packagePath + className + "Manager.java";
		}

		if (template.contains(GenConstant.JAVA_MANAGER_IMPL)) {
			return packagePath + className + "ManagerImpl.java";
		}

		if (template.contains(GenConstant.JAVA_SERVICE)) {
			return packagePath + className + "Service.java";
		}

		if (template.contains(GenConstant.JAVA_SERVICE_IMPL)) {
			return packagePath + className + "ServiceImpl.java";
		}

		if (template.contains(GenConstant.JAVA_CONTROLLER)) {
			return packagePath + className + "Controller.java";
		}

		if (template.contains(GenConstant.HTML_LIST)) {
			return "view" + File.separator + "list.html";
		}

		if (template.contains(GenConstant.HTML_ADD)) {
			return "view" + File.separator + "add.html";
		}

		if (template.contains(GenConstant.HTML_EDIT)) {
			return "view" + File.separator + "edit.html";
		}

		if (template.contains(GenConstant.JS_LIST)) {
			return "js" + File.separator + "list.js";
		}

		if (template.contains(GenConstant.JS_ADD)) {
			return "js" + File.separator + "add.js";
		}

		if (template.contains(GenConstant.JS_EDIT)) {
			return "js" + File.separator + "edit.js";
		}

		if (template.contains(GenConstant.SQL_MENU)) {
			return className.toLowerCase() + "_menu.sql";
		}

		return null;
	}

	/**
	 * 获取文件名，带包名
	 */
	public static String getFileName(String template, String className, String module, String functionCode,
			String packageName,String viewPath) {
		String packagePath = "java" + File.separator;
		if (StringUtils.isNotBlank(packageName)) {
			packagePath += packageName.replace(".", File.separator) + File.separator + "modules" + File.separator + module + File.separator;
		}

		if (template.contains(GenConstant.JAVA_ENTITY)) {
			return packagePath + "entity" + File.separator + className + "Entity.java";
		}

		if (template.contains(GenConstant.JAVA_MAPPER)) {
			return packagePath + "dao" + File.separator + className + "Mapper.java";
		}

		if (template.contains(GenConstant.XML_MAPPER)) {
			return "resources" + File.separator + "mapper" + File.separator + module + File.separator + className + "Mapper.xml";
			//return packagePath + "dao" + File.separator + className + "Mapper.xml";
		}

		if (template.contains(GenConstant.JAVA_MANAGER)) {
			return packagePath + "manager" + File.separator + className + "Manager.java";
		}

		if (template.contains(GenConstant.JAVA_MANAGER_IMPL)) {
			return packagePath + "manager" + File.separator + "impl" + File.separator + className + "ManagerImpl.java";
		}

		if (template.contains(GenConstant.JAVA_SERVICE)) {
			return packagePath + "service" + File.separator + className + "Service.java";
		}

		if (template.contains(GenConstant.JAVA_SERVICE_IMPL)) {
			return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
		}

		if (template.contains(GenConstant.JAVA_CONTROLLER)) {
			return packagePath + "controller" + File.separator + className + "Controller.java";
		}

		if (template.contains(GenConstant.HTML_LIST)) {
			return "resources" + File.separator +"templates" + File.separator + viewPath + File.separator + "list.html";

			//return "view" + File.separator + functionCode + File.separator + "list.html";
		}

		if (template.contains(GenConstant.HTML_ADD)) {
			return "resources" + File.separator +"templates" + File.separator + viewPath + File.separator + "add.html";

			//return "view" + File.separator + functionCode + File.separator + "add.html";
		}

		if (template.contains(GenConstant.HTML_EDIT)) {
			return "resources" + File.separator +"templates" + File.separator + viewPath + File.separator + "edit.html";

			//return "view" + File.separator + functionCode + File.separator + "edit.html";
		}

		if (template.contains(GenConstant.JS_LIST)) {
			return "resources" + File.separator+"static"+File.separator+"js" + File.separator + viewPath + File.separator + "list.js";

			//return "js" + File.separator + functionCode + File.separator + "list.js";
		}

		if (template.contains(GenConstant.JS_ADD)) {
			return "resources" + File.separator+"static"+File.separator+"js" + File.separator + viewPath + File.separator + "add.js";

			//return "js" + File.separator + functionCode + File.separator + "add.js";
		}

		if (template.contains(GenConstant.JS_EDIT)) {
			return "resources" + File.separator+"static"+File.separator+"js" + File.separator + viewPath + File.separator + "edit.js";

			//return "js" + File.separator + functionCode + File.separator + "edit.js";
		}

		if (template.contains(GenConstant.SQL_MENU)) {
			return className.toLowerCase() + "_menu.sql";
		}

		return null;
	}
	
	/*public static void main(String[] args) {
		System.out.println(StringUtils.uncapitalize("user_id"));
		System.out.println(StringUtils.uncapitalize(columnToJava("user_id")));

		System.out.println(PropertiesUtils.getInstance("velocity/generator").get("package"));

	}*/

}