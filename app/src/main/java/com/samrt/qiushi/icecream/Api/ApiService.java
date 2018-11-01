package com.samrt.qiushi.icecream.Api;

import com.samrt.qiushi.icecream.model.ProductBean;
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
    String BASE_URL = "https://partner.creamyice.com/ver3/";
    //获取微信二维码URl
    String API_WECHAT_CODE = "native.php";

    /**
     * @param sn
     * @return
     */
    @POST(API_WECHAT_CODE)
    @FormUrlEncoded
    Call<QrCodeBean> getWeChatCode(@Field("sn") String sn, @Field("fee") String fee,
                                   @Field("product") String s, @Field("wid") String wid, @Field("token") String token);


}
