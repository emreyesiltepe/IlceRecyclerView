package com.h5190073.celal_emre_yesiltepe_final.network;

import com.h5190073.celal_emre_yesiltepe_final.model.IlceModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    //base url
    //
    @GET("TrabzonIlceJson.json")
    Observable<List<IlceModel>> ilceleriGetir();
}
