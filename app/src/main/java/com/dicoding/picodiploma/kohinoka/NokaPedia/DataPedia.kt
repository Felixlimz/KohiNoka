package com.dicoding.picodiploma.kohinoka.NokaPedia

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataPedia(
    var contentId : String,
    var title : String,
    var description : String,
    var image: Int
): Parcelable
