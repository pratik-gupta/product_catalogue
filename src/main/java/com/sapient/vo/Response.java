package com.sapient.vo;

/**
 * Response Model is to wrap the final response and sent to the client.
 * @author pratikgupta
 *
 */
public class Response {

	    private Object object;
	    private String status;
	    private String errorCode;
	    private String errorMsg;

	    public Object getObject() {
	        return object;
	    }
	    public void setObject(Object object) {
	        this.object = object;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    public String getErrorCode() {
	        return errorCode;
	    }
	    public void setErrorCode(String errorCode) {
	        this.errorCode = errorCode;
	    }
	    public String getErrorMsg() {
	        return errorMsg;
	    }
	    public void setErrorMsg(String errorMsg) {
	        this.errorMsg = errorMsg;
	    }
}

