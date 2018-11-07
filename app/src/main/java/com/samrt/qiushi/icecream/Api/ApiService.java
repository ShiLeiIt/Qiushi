package com.samrt.qiushi.icecream.Api;

import com.samrt.qiushi.icecream.model.OrderPayBean;
import com.samrt.qiushi.icecream.model.ProductBean;
import com.samrt.qiushi.icecream.model.ProductInfoBean;
import com.samrt.qiushi.icecream.model.QrCodeBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shilei on 2018/10/31
 */

public interface ApiService {
    //BaseUrl
    String BASE_URL = "https://partner.creamyice.com/app1/";
    //获取微信二维码URl
    String API_WECHAT_CODE = "native.php";

    //获取产品信息
    String API_PRODUCT_INFO = "product.php";

    //订单支付结果查询
    String API_ORDER_PAY_INFO = "order.php";

    /**
     * @param sn
     * @return
     */
    @POST(API_WECHAT_CODE)
    @FormUrlEncoded
    Call<QrCodeBean> getWeChatCode(@Field("wid") int wid, @Field("token") String token, @Field("sn") String sn,
                                   @Field("product") String product);


    /***
     *
     * @param wid APP商户标识
     * @param token 接口调用凭证
     * @param sn 机器唯一标识
     * @return
     */
    @FormUrlEncoded
    @POST(API_PRODUCT_INFO)
    Call<ProductInfoBean> getProductInfo(@Field("wid") int wid, @Field("token") String token, @Field("sn") String sn);


    @FormUrlEncoded
    @POST(API_ORDER_PAY_INFO)
    Call<OrderPayBean> getOrderPayInfo(@Field("wid") int wid, @Field("token") String token, @Field("sn") String sn,
                                       @Field("type") String type, @Field("order_number") String orderNumber);

}
