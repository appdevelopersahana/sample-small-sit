package com.example.user.searchablerecyclerview.NetCalls;

import android.content.Intent;

import com.example.user.searchablerecyclerview.models.modified.ApplianceData;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 3/22/2018.
 */

public class MakeNetCalls {
    private OkHttpClient mClient;
    private List<Object> mSellersList;
    private ApplianceData mApplianceData;
    private String mResponse;
    private CallBack mCallBack;
    private static MakeNetCalls sMakeNetCalls;

    public static MakeNetCalls getInstance() {
        if (sMakeNetCalls == null)
            sMakeNetCalls = new MakeNetCalls();
        return sMakeNetCalls;
    }

    public void getProductValues(final CallBack callBack, final String input) {
        mClient = new OkHttpClient();
        mSellersList = new ArrayList<>();
        Request request = new Request.Builder().url("http://www.mocky.io/v2/5adb5c572900004e003e3df3").build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.getMessage();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                mResponse = response.body().string();
                Gson gson = new Gson();
                mApplianceData = gson.fromJson(mResponse, ApplianceData.class);
                mSellersList.clear();
                if (input.contains("lg") || input.contains("inspire")) {
                    if (input.contains("55lj550t") || input.contains("tv")) {
                        mSellersList.addAll(mApplianceData.lgTv);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else if (input.contains("ac") || input.contains("js-q18cuxa")) {
                        mSellersList.addAll(mApplianceData.lgAc);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else if (input.contains("mobiles") || input.contains("lgh930ds") || input.contains("inspire")) {
                        mSellersList.addAll(mApplianceData.lgMobiles);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else {
                        mSellersList.addAll(mApplianceData.lgTv);
                        mSellersList.addAll(mApplianceData.lgMobiles);
                        mSellersList.addAll(mApplianceData.lgAc);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    }
                } else if (input.contains("samsung") || input.contains("galaxy")) {
                    if (input.contains("tv") || input.contains("ua49m5000arlxl")) {
                        mSellersList.addAll(mApplianceData.samsungTv);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else if (input.contains("ac") || input.contains("ar12nc1udmc")) {
                        mSellersList.addAll(mApplianceData.samsungAc);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else if (input.contains("mobiles") || input.contains("s9") || input.contains("sm-g965fzpd")) {
                        mSellersList.addAll(mApplianceData.samsungMobiles);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else {
                        mSellersList.addAll(mApplianceData.samsungMobiles);
                        mSellersList.addAll(mApplianceData.samsungTv);
                        mSellersList.addAll(mApplianceData.samsungAc);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    }
                } else if (input.contains("panasonic")) {
                    mSellersList.addAll(mApplianceData.panasonicAC);
                    if (callBack != null)
                        callBack.onSuccess(mSellersList);

                } else if (input.contains("sony") || input.contains("xperia") || input.contains("xa1")) {
                    if (input.contains("mobiles") || input.contains("g3416")) {
                        mSellersList.addAll(mApplianceData.sonyMobiles);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else if (input.contains("tv")) {
                        mSellersList.addAll(mApplianceData.sonyTv);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else if (input.equals("sony")) {
                        mSellersList.addAll(mApplianceData.sonyTv);
                        mSellersList.addAll(mApplianceData.sonyMobiles);
                        if (callBack != null)
                            callBack.onSuccess(mSellersList);
                    } else {
                        for (int index = 0; index < mApplianceData.sonyTv.size(); index++) {
                            String compare = mApplianceData.sonyTv.get(index).applianceName.toLowerCase();
                            boolean tr = compare.contains(input);
                            if (tr == true) {
                                mSellersList.add(mApplianceData.sonyTv.get(index));
                                if (callBack != null)
                                    callBack.onSuccess(mSellersList);
                            }
                        }
                    }
                } else if (input.contains("smart") || input.contains("tv")) {
                    mSellersList.addAll(mApplianceData.samsungTv);
                    mSellersList.addAll(mApplianceData.sonyTv);
                    mSellersList.addAll(mApplianceData.lgTv);
                    if (callBack != null)
                        callBack.onSuccess(mSellersList);
                } else if (input.contains("mobiles")) {
                    mSellersList.addAll(mApplianceData.samsungMobiles);
                    mSellersList.addAll(mApplianceData.lgMobiles);
                    mSellersList.addAll(mApplianceData.sonyMobiles);
                    if (callBack != null)
                        callBack.onSuccess(mSellersList);
                } else if (input.contains("ac") || input.contains("split")) {
                    mSellersList.addAll(mApplianceData.lgAc);
                    mSellersList.addAll(mApplianceData.samsungAc);
                    mSellersList.addAll(mApplianceData.panasonicAC);
                    if (callBack != null)
                        callBack.onSuccess(mSellersList);
                }
            }
        });

    }

    public interface CallBack {
        void onSuccess(List<Object> sellersData);

    }
}
