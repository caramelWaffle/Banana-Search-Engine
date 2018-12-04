package com.log;

import java.util.List;

public abstract interface BufferLog {
	public abstract void debug(String paramString1, String paramString2);

	public abstract void info(String paramString1, String paramString2);

	public abstract void error(String paramString1, String paramString2);

	public abstract void error(String paramString1, String paramString2, Throwable paramThrowable);

	public abstract void fatal(String paramString1, String paramString2);

	public abstract void fatal(String paramString1, String paramString2, Throwable paramThrowable);

	public abstract void putBuf(String paramString, LogBean paramLogBean);

	public abstract List getBuf(String paramString);

	public abstract void removeBuf(String paramString);	
}
