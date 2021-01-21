package com.h5190073.celal_emre_yesiltepe_final.util;

import com.google.gson.Gson;
import com.h5190073.celal_emre_yesiltepe_final.model.IlceModel;

public class ObjectUtil {
    public  static String ilceToJsonString(IlceModel ilceModel)
    {
        Gson gson = new Gson();
        return   gson.toJson(ilceModel);
    }

    public  static IlceModel jsonStringToIlce(String jsonString)
    {
        Gson gson = new Gson();
        return  gson.fromJson(jsonString,IlceModel.class);
    }
}
