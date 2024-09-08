package com.cwjy.bs.common;

/**
 * @author xgp
 * @version 1.0
 * @date 3/15 17:52
 * @table
 * @description
 */
import lombok.Data;

@Data
public class ResponseEntity<T> {
    private T data;
    private String status;
    private String code;
    public ResponseEntity(ResponseStatus status,T data){
        this.data=data;
        this.status=status.toString();
    }
    public static ResponseEntity<String> error(){
        return new ResponseEntity(ResponseStatus.ERROR,"system error");
    }
    public static ResponseEntity error(String code,Object t){
        return new ResponseEntity(code,ResponseStatus.ERROR,t);
    }
    public static ResponseEntity error(Object t){
        return new ResponseEntity(ResponseStatus.ERROR,t);
    }
    public static ResponseEntity success(Object t){
        return new ResponseEntity(ResponseStatus.SUCCESS,t);
    }
    public static ResponseEntity success(String code,Object t){
        return new ResponseEntity(code,ResponseStatus.SUCCESS,t);
    }
    public ResponseEntity(String code,ResponseStatus status,T data){
        this.data=data;
        this.status=status.toString();
        this.code=code;
    }
    public ResponseEntity(String status,T data){
        this.data=data;
        this.status=status;
    }

    public ResponseEntity(String code,String status,T data){
        this.data=data;
        this.status=status;
        this.code=code;
    }
    public ResponseEntity(){};
}

