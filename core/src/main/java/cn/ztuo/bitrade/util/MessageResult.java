package cn.ztuo.bitrade.util;


import com.alibaba.fastjson.JSONObject;

/**
 * @author gs
 */
public class MessageResult {
	private Object data;
	public MessageResult(int code , String msg){
		this.code = code;
		this.message = msg;
	}
    public MessageResult(int code , String msg,Object object,Long total){
        this.code = code;
        this.message = msg;
        this.total = total;
        this.data = object;
    }
	public MessageResult(int code , String msg, Object object){
		this.code = code;
		this.message = msg;
		this.data = object;
	}
	public MessageResult() {
		// TODO Auto-generated constructor stub
	}
	
	public static MessageResult success(){
		return new MessageResult(0,"SUCCESS");
	}
	public static MessageResult success(String msg){
		return new MessageResult(0,msg);
	}
	public static MessageResult success(String msg,Object data){
		return new MessageResult(0,msg,data);
	}
    public static MessageResult successDataAndTotal(Object object,Long total){
	    return new MessageResult(0,"SUCCESS",object,total);
    }

	public static MessageResult error(int code,String msg){
		return new MessageResult(code,msg);
	}
	public static MessageResult error(String msg){
		return new MessageResult(500,msg);
	}
	
	private int code;
	private String message;
	private Object Data;
	private Long total;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
	@Override
    public String toString(){
		return JSONObject.toJSONString(this);
		//return "{\"code\":"+code+",\"message\":\""+message+"\"}";
	}
	public Object getData() {
		return Data;
	}
	public void setData(Object data) {
		Data = data;
	}

	public static MessageResult getSuccessInstance(String message ,Object data){
		MessageResult result = success(message);
		result.setData(data);
		return result ;
	}
}
