package com.example.countries.dto

import com.google.gson.annotations.SerializedName


data class Countries (

  @SerializedName("name"         ) var name         : Name?             = Name(),
  @SerializedName("tld"          ) var tld          : ArrayList<String> = arrayListOf(),
  @SerializedName("cca2"         ) var cca2         : String?           = null,
  @SerializedName("ccn3"         ) var ccn3         : String?           = null,
  @SerializedName("cca3"         ) var cca3         : String?           = null,
  @SerializedName("cioc"         ) var cioc         : String?           = null,
  @SerializedName("independent"  ) var independent  : Boolean?          = null,
  @SerializedName("status"       ) var status       : String?           = null,
  @SerializedName("unMember"     ) var unMember     : Boolean?          = null,
  @SerializedName("idd"          ) var idd          : Idd?              = Idd(),
  @SerializedName("capital"      ) var capital      : ArrayList<String> = arrayListOf(),
  @SerializedName("altSpellings" ) var altSpellings : ArrayList<String> = arrayListOf(),
  @SerializedName("region"       ) var region       : String?           = null,
  @SerializedName("subregion"    ) var subregion    : String?           = null,
  @SerializedName("languages"    ) var languages    : HashMap<String,String>?       = HashMap(),
  @SerializedName("latlng"       ) var latlng       : ArrayList<Double>    = arrayListOf(),
  @SerializedName("landlocked"   ) var landlocked   : Boolean?          = null,
  @SerializedName("borders"      ) var borders      : ArrayList<String> = arrayListOf(),
  @SerializedName("area"         ) var area         : Double?              = null,
  @SerializedName("flag"         ) var flag         : String?           = null,
  @SerializedName("maps"         ) var maps         : Maps?             = Maps(),
  @SerializedName("population"   ) var population   : Int?              = null,
  @SerializedName("fifa"         ) var fifa         : String?           = null,
  @SerializedName("car"          ) var car          : Car?              = Car(),
  @SerializedName("timezones"    ) var timezones    : ArrayList<String> = arrayListOf(),
  @SerializedName("continents"   ) var continents   : ArrayList<String> = arrayListOf(),
  @SerializedName("flags"        ) var flags        : Flags?            = Flags(),
  @SerializedName("coatOfArms"   ) var coatOfArms   : CoatOfArms?       = CoatOfArms(),
  @SerializedName("startOfWeek"  ) var startOfWeek  : String?           = null,
  @SerializedName("capitalInfo"  ) var capitalInfo  : CapitalInfo?      = CapitalInfo()

)