package com.database.util;

import java.beans.IndexedPropertyDescriptor;
import java.beans.PropertyDescriptor;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ReflectionBeanUtils {
	public static Object cloneBean(Object bean)
		    throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException
		  {
		    Class clazz = bean.getClass();
		    Object newBean = clazz.newInstance();
		    PropertyUtils.copyProperties(newBean, bean);
		    return newBean;
		  }

		  public static Map describe(Object bean)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    if (bean == null)
		      return new HashMap();
		    PropertyDescriptor[] descriptors = 
		      PropertyUtils.getPropertyDescriptors(bean);
		    Map description = new HashMap(descriptors.length);
		    for (int i = 0; i < descriptors.length; i++) {
		      String name = descriptors[i].getName();
		      if (descriptors[i].getReadMethod() != null)
		        description.put(name, getProperty(bean, name));
		    }
		    return description;
		  }

		  public static String[] getArrayProperty(Object bean, String name)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    Object value = PropertyUtils.getProperty(bean, name);
		    if (value == null)
		      return null;
		    if ((value instanceof Collection)) {
		      ArrayList values = new ArrayList();
		      Iterator items = ((Collection)value).iterator();
		      while (items.hasNext()) {
		        Object item = items.next();
		        if (item == null)
		          values.add(null);
		        else
		          values.add(item.toString());
		      }
		      return (String[])values.toArray(new String[values.size()]);
		    }if (value.getClass().isArray()) {
		      ArrayList values = new ArrayList();
		      try {
		        int n = Array.getLength(value);
		        for (int i = 0; i < n; i++)
		          values.add(Array.get(value, i).toString());
		      }
		      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
		      {
		      }
		      return (String[])values.toArray(new String[values.size()]);
		    }
		    String[] results = new String[1];
		    results[0] = value.toString();
		    return results;
		  }

		  public static String getIndexedProperty(Object bean, String name)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    Object value = PropertyUtils.getIndexedProperty(bean, name);
		    return ConvertUtils.convert(value);
		  }

		  public static String getIndexedProperty(Object bean, String name, int index)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    StringBuffer sb = new StringBuffer(name);
		    sb.append('[');
		    sb.append(index);
		    sb.append(']');
		    Object value = PropertyUtils.getIndexedProperty(bean, sb.toString());
		    return ConvertUtils.convert(value);
		  }

		  public static String getNestedProperty(Object bean, String name)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    Object value = PropertyUtils.getNestedProperty(bean, name);
		    return ConvertUtils.convert(value);
		  }

		  public static String getProperty(Object bean, String name)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    return getNestedProperty(bean, name);
		  }

		  public static String getSimpleProperty(Object bean, String name)
		    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
		  {
		    Object value = PropertyUtils.getSimpleProperty(bean, name);
		    return ConvertUtils.convert(value);
		  }

		  public static void setFieldValue(Object bean, String name, Object value)
		    throws IllegalAccessException, InvocationTargetException
		  {
		    if ((bean == null) || (value == null)) {
		      return;
		    }

		    PropertyDescriptor descriptor = null;
		    try {
		      descriptor = PropertyUtils.getPropertyDescriptor(bean, name);
		    }
		    catch (Throwable t) {
		      descriptor = null;
		    }
		    if (descriptor != null)
		    {
		      Method setter = null;
		      if ((descriptor instanceof IndexedPropertyDescriptor))
		        setter = ((IndexedPropertyDescriptor)descriptor)
		          .getIndexedWriteMethod();
		      if (setter == null) {
		        setter = descriptor.getWriteMethod();
		      }

		      Class[] parameterTypes = setter.getParameterTypes();
		      Class parameterType = parameterTypes[0];

		      if (parameterTypes.length > 1) {
		        throw new IllegalArgumentException("属性写方法参数不能多于一个。");
		      }

		      Object parameter = new Object();

		      if (parameterType.isArray()) {
		        if ((value instanceof String)) {
		          String[] values = new String[1];
		          values[0] = ((String)value);
		          parameter = values;
		        } else if ((value instanceof String[])) {
		          parameter = value;
		        }
		      }
		      else if ((value instanceof String)) {
		        parameter = value;
		      } else if ((value instanceof String[])) {
		        parameter = ConvertUtils.convert((String[])value);
		      } else if ((value instanceof BigDecimal))
		      {
		        Long longs = new Long(String.valueOf(value));
		        parameter = longs;
		      }
		      else
		      {
		        parameter = value;
		      }
		      try
		      {
		        PropertyUtils.setProperty(bean, name, parameter);
		      } catch (NoSuchMethodException e) {
		        System.out.println(e.getMessage());
		      }
		    }
		  }

		  public static void setFieldValue(Object[] bean, String name, Object value)
		    throws IllegalAccessException, InvocationTargetException
		  {
		    if ((bean == null) || (value == null)) {
		      return;
		    }
		    for (int i = 0; i < bean.length; i++)
		    	setFieldValue(bean[i], name, value);
		  }

		  public static void populate(Object bean, Map properties)
		    throws IllegalAccessException, InvocationTargetException
		  {
		    if ((bean == null) || (properties == null)) {
		      return;
		    }

		    Iterator names = properties.keySet().iterator();
		    while (names.hasNext())
		    {
		      String name = (String)names.next();
		      if (name != null)
		      {
		        Object value = properties.get(name);

		        PropertyDescriptor descriptor = null;
		        try {
		          descriptor = PropertyUtils.getPropertyDescriptor(bean, name);
		        } catch (Throwable t) {
		          descriptor = null;
		        }
		        if (descriptor != null)
		        {
		          Method setter = null;
		          if ((descriptor instanceof IndexedPropertyDescriptor))
		            setter = ((IndexedPropertyDescriptor)descriptor)
		              .getIndexedWriteMethod();
		          if (setter == null)
		            setter = descriptor.getWriteMethod();
		          if (setter != null)
		          {
		            Class[] parameterTypes = setter.getParameterTypes();
		            Class parameterType = parameterTypes[0];

		            if (parameterTypes.length > 1) {
		              throw new IllegalArgumentException("属性写方法参数不能多于一个。");
		            }

		            Object parameter = new Object();
		            if (parameterType.isArray()) {
		              if ((value instanceof String)) {
		                String[] values = new String[1];
		                values[0] = ((String)value);
		                parameter = values;
		              } else if ((value instanceof String[])) {
		                parameter = value;
		              }
		            }
		            else if ((value instanceof String))
		              parameter = value;
		            else if ((value instanceof String[])) {
		              parameter = ConvertUtils.convert((String[])value);
		            }
		            try
		            {
		              PropertyUtils.setProperty(bean, name, parameter);
		            }
		            catch (NoSuchMethodException localNoSuchMethodException)
		            {
		            }
		          }
		        }
		      }
		    }
		  }
}
