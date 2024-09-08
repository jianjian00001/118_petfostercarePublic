package com.cwjy.bs.common;

/**
 * @author xgp
 * @version 1.0
 * @date 1/30 13:11
 * @table
 * @description
 */
public class EnumCommon {

    /**订单状态*/
    public enum OrderStatus{

        /**未付款*/
        UNPAID(1, "未付款"),
        /**已付款*/
        ALREADY_PAID(2, "已付款"),
        /**未发货*/
        NOT_SHIPPED(3, "未发货"),
        /**已发货*/
        SHIPPED(4, "已发货"),
        /**退款中*/
        REFUNDING(5, "退款中"),
        /**交易成功*/
        SUCCESSFUL_TRANSACTION(6, "交易成功"),
        /**交易失败*/
        TRANSACTION_FAILED(7, "交易失败");

        private int code;
        private String name;
        OrderStatus(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(OrderStatus orderStatus: OrderStatus.values()) {
                if(orderStatus.getCode()==code) {
                    return orderStatus.name;
                }
            }
            return null;
        }
    }



    /**订单支付类型*/
    public enum OrderPaymentTypes{

        /**微信*/
        WECHAT(1, "微信"),
        /**支付宝*/
        ALIPAY(2, "支付宝"),
        /**银联*/
        UNIONPAY(3, "银联"),
        /**其他*/
        OTHER(4, "其他");


        private int code;
        private String name;
        OrderPaymentTypes(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }



    /**订单是否评价*/
    public enum OrderBuyerRate{

        /**已评价*/
        YES(1, "已评价"),
        /**未评价*/
        NO(0, "未评价");


        private int code;
        private String name;
        OrderBuyerRate(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }


    /**退货订单状态*/
    public enum OrderReturnStatus{

        /**已评价*/
        REJECTED(0, "已拒绝"),
        /**未评价*/
        APPLYING(1, "申请中"),
        /**已评价*/
        WAITING_FOR_INPUT(2, "等待客户物流单号输入"),
        /**未评价*/
        IN_TRANSIT(3, "运输中"),
        /**已评价*/
        COMPLETED(4, "退款已完成");


        private int code;
        private String name;
        OrderReturnStatus(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(OrderReturnStatus orderReturnStatus: OrderReturnStatus.values()) {
                if(orderReturnStatus.getCode()==code) {
                    return orderReturnStatus.name;
                }
            }
            return null;
        }
    }


    /**退货订单状态*/
    public enum OrderRefundType{

        /**已评价*/
        ONLY_REFUND(1, "仅退款"),
        /**未评价*/
        REFUNDS(2, "退货退款");


        private int code;
        private String name;
        OrderRefundType(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(OrderReturnStatus orderReturnStatus: OrderReturnStatus.values()) {
                if(orderReturnStatus.getCode()==code) {
                    return orderReturnStatus.name;
                }
            }
            return null;
        }
    }


    /**宠物类型*/
    public enum PetType{

        /**纯种狗*/
        PUREBRED_DOG(1, "纯种狗"),
        /**纯种猫*/
        PUREBRED_CAT(2, "纯种猫"),
        /**普通狗*/
        ORDINARY_DOG(3, "普通狗"),
        /**普通猫*/
        NORMAL_CAT(4, "普通猫"),
        /**其他*/
        OTHER(5, "其他");

        private int code;
        private String name;
        PetType(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(PetType petType: PetType.values()) {
                if(petType.getCode()==code) {
                    return petType.name;
                }
            }
            return null;
        }
    }

    /**是否发情*/
    public enum IsInHeat{


        /**普通猫*/
        YES(0, "在发情"),
        /**其他*/
        NO(0, "为发情");

        private int code;
        private String name;
        IsInHeat(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(IsInHeat isInHeat: IsInHeat.values()) {
                if(isInHeat.getCode()==code) {
                    return isInHeat.name;
                }
            }
            return null;
        }
    }


    /**寄养状态*/
    public enum FosterCareStatus{

        MERCHANT_HAS_Refuse(0, "商家已拒绝,请重新申请！"),
        /**预约申请中*/
        APPLYING(1, "预约申请中 - 待商家确认！"),
        /**商家已同意,等待宠物入住*/
        MERCHANT_HAS_AGREED(2, "商家已同意,等待宠物入住！"),
        /**寄养预约超时*/
        FOSTER_CARE_OVERTIME(3, "预约超时 - 已失效！"),
        /**成功入住*/
        CHECK_IN_SUCCESSFULLY(4, "成功入住！"),
        /**入住失败*/
        FAILURE(5, "入住失败！"),
        /**寄养成功，已出店！*/
        CARRY_OUT(6, "寄养完成，已出店！"),
        /**已超订单预计寄养时间*/
        TIME_OUT (7, "已超订单预计寄养时间！"),
        /**寄养成功，已评价！*/
        CARRY_OUT_EVALUATED(8, "寄养完成，已评价！");

        private int code;
        private String name;
        FosterCareStatus(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(FosterCareStatus fosterCareStatus: FosterCareStatus.values()) {
                if(fosterCareStatus.getCode()==code) {
                    return fosterCareStatus.name;
                }
            }
            return null;
        }
    }


    /**是否注射狂犬疫苗*/
    public enum WhetherToInjectRabiesVaccine{

        /**纯种狗*/
        YES(1, "已注射"),
        /**纯种猫*/
        NO(2, "未注射");

        private int code;
        private String name;
        WhetherToInjectRabiesVaccine(int code,String name){
            this.code = code;
            this.name = name;
        }

        public int getCode() {
            return code;
        }

        public String getName() {
            return name;
        }

        public static String getNameByCode(int code){
            for(WhetherToInjectRabiesVaccine whether: WhetherToInjectRabiesVaccine.values()) {
                if(whether.getCode()==code) {
                    return whether.name;
                }
            }
            return null;
        }
    }

}
