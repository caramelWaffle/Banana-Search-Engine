package com.log;

public class LogBean {
	  private String logId;
	  private int logLev;
	  private String logContent;
	  private Throwable exception;

	  public void setLogId(String logId)
	  {
	    this.logId = logId;
	  }

	  public String getLogId() {
	    return this.logId;
	  }

	  public void setLogLev(int logLev) {
	    this.logLev = logLev;
	  }

	  public int getLogLev() {
	    return this.logLev;
	  }

	  public void setLogContent(String logContent) {
	    this.logContent = logContent;
	  }

	  public String getLogContent() {
	    return this.logContent;
	  }

	  public void setException(Throwable e) {
	    this.exception = e;
	  }

	  public Throwable getException() {
	    return this.exception;
	  }
}
