package com.h5190073.celal_emre_yesiltepe_final.model;


import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class IlceModel {
    @SerializedName("IlceAdi")
    @Expose
    private String ilceAdi;
    @SerializedName("Nufusu")
    @Expose
    private String nufusu;
    @SerializedName("MeshurYemegi")
    @Expose
    private String meshurYemegi;
    @SerializedName("TarihiAciklama")
    @Expose
    private String tarihiAciklama;
    @SerializedName("KucukResimUrl")
    @Expose
    private String kucukResimUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;

    public String getIlceAdi() {
        return ilceAdi;
    }

    public void setIlceAdi(String ilceAdi) {
        this.ilceAdi = ilceAdi;
    }

    public String getNufusu() {
        return nufusu;
    }

    public void setNufusu(String nufusu) {
        this.nufusu = nufusu;
    }

    public String getMeshurYemegi() {
        return meshurYemegi;
    }

    public void setMeshurYemegi(String meshurYemegi) {
        this.meshurYemegi = meshurYemegi;
    }

    public String getTarihiAciklama() {
        return tarihiAciklama;
    }

    public void setTarihiAciklama(String tarihiAciklama) {
        this.tarihiAciklama = tarihiAciklama;
    }

    public String getKucukResimUrl() {
        return kucukResimUrl;
    }

    public void setKucukResimUrl(String kucukResimUrl) {
        this.kucukResimUrl = kucukResimUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }

}
