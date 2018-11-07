package com.samrt.qiushi.icecream.model;

import java.util.List;

/**
 * Created by shilei on 2018/11/6
 * 产品信息Bean
 */
public class ProductInfoBean {

    /**
     * code : 200
     * msg : query product is successful
     * data : {"product":[{"id":"1","name":"郁金香雪吻冰淇淋","price":"15","description":"脆皮脆筒、优质小麦粉","img":"/we/app/yujinxiang.jpg"},{"id":"2","name":"格罗宁根黑松冰淇淋","price":"12","description":"竹炭粉、优质小麦粉","img":"/we/app/geluoning.jpg"},{"id":"3","name":"海芽圣杯","price":"18","description":"来自荷兰海牙的绝顶风情","img":"/we/app/haiya.jpg"}]}
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
        private List<ProductBean> product;

        public List<ProductBean> getProduct() {
            return product;
        }

        public void setProduct(List<ProductBean> product) {
            this.product = product;
        }

        public static class ProductBean {
            /**
             * id : 1
             * name : 郁金香雪吻冰淇淋
             * price : 15
             * description : 脆皮脆筒、优质小麦粉
             * img : /we/app/yujinxiang.jpg
             */

            private String id;
            private String name;
            private double price;
            private String description;
            private String img;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
