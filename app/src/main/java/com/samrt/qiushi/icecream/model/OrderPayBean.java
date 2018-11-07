package com.samrt.qiushi.icecream.model;

/**
 * Created by shilei on 2018/11/6
 * 订单支付结果查询
 */
public class OrderPayBean {

    /**
     * code : 200
     * msg : query order is successful
     * data : {"order":{"status":"1","price":"12","name":"郁金香","amount":"60","count":"5","order_number":"Cr-App154147465208045600","paytime":"2018-11-06 11:24:12"}}
     * json类型  备注： 订单状态码: 1=>已创建未支付，2=>支付成功待取货  3=>已取货，订单完成  4=>已评价  5=>退款订单
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
         * order : {"status":"1","price":"12","name":"郁金香","amount":"60","count":"5","order_number":"Cr-App154147465208045600","paytime":"2018-11-06 11:24:12"}
         */

        private OrderBean order;

        public OrderBean getOrder() {
            return order;
        }

        public void setOrder(OrderBean order) {
            this.order = order;
        }

        public static class OrderBean {
            /**
             * status : 1
             * price : 12
             * name : 郁金香
             * amount : 60
             * count : 5
             * order_number : Cr-App154147465208045600
             * paytime : 2018-11-06 11:24:12
             */

            private String status;
            private String price;
            private String name;
            private String amount;
            private String count;
            private String order_number;
            private String paytime;

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            private String timestamp;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getOrder_number() {
                return order_number;
            }

            public void setOrder_number(String order_number) {
                this.order_number = order_number;
            }

            public String getPaytime() {
                return paytime;
            }

            public void setPaytime(String paytime) {
                this.paytime = paytime;
            }
        }
    }
}
