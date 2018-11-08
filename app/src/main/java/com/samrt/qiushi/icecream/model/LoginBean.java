package com.samrt.qiushi.icecream.model;

/**
 * Created by shilei on 2018/11/8
 * 商户登录Bean
 */
public class LoginBean {

    /**
     * code : 200
     * msg : quer user successful
     * data : {"status":"FAILURE","msg":"Sorry ! Account OR Password Error...","account":"test","username":"I Dont Know","lastlogin":1541487229}
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
         * status : FAILURE
         * msg : Sorry ! Account OR Password Error...
         * account : test
         * username : I Dont Know
         * lastlogin : 1541487229
         */

        private String status;
        private String msg;
        private String account;
        private String username;
        private int lastlogin;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getLastlogin() {
            return lastlogin;
        }

        public void setLastlogin(int lastlogin) {
            this.lastlogin = lastlogin;
        }
    }
}
