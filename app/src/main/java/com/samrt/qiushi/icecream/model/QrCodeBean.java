package com.samrt.qiushi.icecream.model;

/**
 * Created by shilei on 2018/10/31
 */

public class QrCodeBean {

    /**
     * code : 200
     * msg : Get WechatQRcode Successful
     * data : {"code_url":"weixin://wxpay/bizpayurl?pr=X4Zyvpg","order_number":"TnclM0QlM0Q="}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code_url : weixin://wxpay/bizpayurl?pr=X4Zyvpg
         * order_number : TnclM0QlM0Q=
         */

        private String code_url;
        private String order_number;

        public String getCode_url() {
            return code_url;
        }

        public void setCode_url(String code_url) {
            this.code_url = code_url;
        }

        public String getOrder_number() {
            return order_number;
        }

        public void setOrder_number(String order_number) {
            this.order_number = order_number;
        }
    }
}
