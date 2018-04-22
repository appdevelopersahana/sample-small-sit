package com.example.user.searchablerecyclerview.models.modified;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class ApplianceData{

	@SerializedName("sonyMobiles")
	public List<SonyMobiles> sonyMobiles;

	@SerializedName("lgMobiles")
	public List<LgMobiles> lgMobiles;

	@SerializedName("sonyTv")
	public List<SonyTv> sonyTv;

	@SerializedName("samsungAc")
	public List<SamsungAc> samsungAc;

	@SerializedName("samsungTv")
	public List<SamsungTv> samsungTv;

	@SerializedName("panasonicAC")
	public List<PanasonicAC> panasonicAC;

	@SerializedName("lgTv")
	public List<LgTv> lgTv;

	@SerializedName("lgAc")
	public List<LgAc> lgAc;

	@SerializedName("samsungMobiles")
	public List<SamsungMobiles> samsungMobiles;
}