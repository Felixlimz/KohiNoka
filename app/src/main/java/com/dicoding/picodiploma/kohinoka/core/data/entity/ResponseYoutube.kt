package com.dicoding.picodiploma.kohinoka.core.data.entity

import com.google.gson.annotations.SerializedName

data class ResponseYoutube(

	@field:SerializedName("regionCode")
	val regionCode: String,

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("nextPageToken")
	val nextPageToken: String,

	@field:SerializedName("pageInfo")
	val pageInfo: PageInfo,

	@field:SerializedName("etag")
	val etag: String,

	@field:SerializedName("items")
	val items: List<ItemsItem>
)

data class Id(

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("videoId")
	val videoId: String
)

data class ItemsItem(

	@field:SerializedName("snippet")
	val snippet: Snippet,

	@field:SerializedName("kind")
	val kind: String,

	@field:SerializedName("etag")
	val etag: String,

	@field:SerializedName("id")
	val id: Id
)

data class PageInfo(

	@field:SerializedName("totalResults")
	val totalResults: Int,

	@field:SerializedName("resultsPerPage")
	val resultsPerPage: Int
)

data class Snippet(

	@field:SerializedName("publishTime")
	val publishTime: String,

	@field:SerializedName("publishedAt")
	val publishedAt: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("thumbnails")
	val thumbnails: Thumbnails,

	@field:SerializedName("channelId")
	val channelId: String,

	@field:SerializedName("channelTitle")
	val channelTitle: String,

	@field:SerializedName("liveBroadcastContent")
	val liveBroadcastContent: String
)

data class Medium(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)

data class High(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)

data class JsonMemberDefault(

	@field:SerializedName("width")
	val width: Int,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("height")
	val height: Int
)

data class Thumbnails(

	@field:SerializedName("default")
	val jsonMemberDefault: JsonMemberDefault,

	@field:SerializedName("high")
	val high: High,

	@field:SerializedName("medium")
	val medium: Medium
)
