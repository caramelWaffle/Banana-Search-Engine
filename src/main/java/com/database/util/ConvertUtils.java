package com.database.util;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Vector;

public class ConvertUtils
{
  public static String convert(Object value)
  {
    if (value == null)
      return null;
    if (value.getClass().isArray()) {
      value = Array.get(value, 0);
      if (value == null) {
        return null;
      }
      return value.toString();
    }
    return value.toString();
  }

  public static BigDecimal[] convertToBd(String[] tmp)
  {
    BigDecimal[] b = new BigDecimal[tmp.length];
    for (int i = 0; i < tmp.length; i++)
      b[i] = new BigDecimal(tmp[i]);
    return b;
  }

  public static Vector convertToVector(String[] arr)
  {
    int num = arr.length;
    Vector v = new Vector(num);
    for (int i = 0; i < num; i++) {
      Vector child = new Vector(1);
      child.add(arr[i]);
      v.add(child);
    }
    return v;
  }

  public static String formatEditMoney(String s)
  {
    if ((s == null) || (s.equals("")))
      return "";
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format(Double.parseDouble(roundTool(s)));
  }

  public static String formatMoney(double num)
  {
    if (num == 0.0D) return "";
    DecimalFormat df = new DecimalFormat("###,##0.00");
    return df.format(num);
  }

  public static String formatMoney(String s)
  {
    if ((s == null) || (s.equals("")))
      return "";
    return formatMoney(Double.parseDouble(s));
  }

  public static String round(String s)
  {
    if ((s == null) || (s.equals("")))
      return "";
    double num = Double.parseDouble(s);
    if (num == 0.0D) return "";
    DecimalFormat df = new DecimalFormat("0");
    return df.format(num);
  }

  public static String roundTool(String s)
  {
    int pos = s.indexOf(".");
    if (pos > 0) {
      String a = s.substring(pos + 2, pos + 3);
      if ((s.substring(pos + 3, pos + 4).equals("5")) && (
        (s.substring(pos + 2, pos + 3).equals("6")) || (s.substring(pos + 2, pos + 3).equals("4")))) {
        s = s.substring(0, pos + 3) + "6" + s.substring(pos + 4);
      }
    }
    return s;
  }

  public static String unFormatMoney(String value)
  {
    if ((value == null) || 
      (value.trim().length() == 0) || 
      (value.equalsIgnoreCase("null")))
      return "0";
    value = roundTool(value);
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format(Double.parseDouble(value.replace(',', '\000')));
  }
}