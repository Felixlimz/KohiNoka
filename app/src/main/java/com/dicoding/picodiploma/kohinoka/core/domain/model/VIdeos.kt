package com.dicoding.picodiploma.kohinoka.core.domain.model

import android.os.Parcelable
import com.dicoding.picodiploma.kohinoka.core.data.entity.Id
import com.dicoding.picodiploma.kohinoka.core.data.entity.Snippet
import kotlinx.android.parcel.Parcelize

data class Videos (

    val snippet: Snippet,
    val id: Id
    )