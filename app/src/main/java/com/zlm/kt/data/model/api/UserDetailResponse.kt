package com.zlm.kt.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Milla
 * @create 2020/6/9
 */
 class UserDetailResponse (
    val login:String,
    val id:String,
    val node_id:String,
    val avatar_url:String,
    val gravatar_id:String,
    val url: String,
    val html_url:String,
    val followers_url:String,
    val following_url:String,
    val gists_url:String,
    val starred_url:String,
    val subscriptions_url:String,
    val organizations_url:String,
    val repos_url:String,
    val events_url:String,
    val received_events_url:String,
    val type: String,
    val site_admin: String,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: String,
    val hireable: String,
    val bio: String,
    val twitter_username: String,
    val public_repos: String,
    val public_gists: String,
    val followers: String,
    val following: String,
    val created_at: String,
    val updated_at: String) : Parcelable {

        companion object {
            @JvmField
            val CREATOR = object : Parcelable.Creator<UserDetailResponse> {
                override fun createFromParcel(parcel: Parcel) = UserDetailResponse(parcel)
                override fun newArray(size: Int) = arrayOfNulls<UserDetailResponse>(size)
            }
        }
    private constructor(parcel: Parcel) : this(
            login = parcel.readString(),
            id = parcel.readString(),
            node_id = parcel.readString(),
            avatar_url = parcel.readString(),
            gravatar_id = parcel.readString(),
            url = parcel.readString(),
            html_url = parcel.readString(),
            followers_url = parcel.readString(),
            following_url = parcel.readString(),
            gists_url = parcel.readString(),
            starred_url = parcel.readString(),
            subscriptions_url = parcel.readString(),
            organizations_url = parcel.readString(),
            repos_url = parcel.readString(),
            events_url = parcel.readString(),
            received_events_url = parcel.readString(),
            type = parcel.readString(),
            site_admin = parcel.readString(),
            name = parcel.readString(),
            company = parcel.readString(),
            blog = parcel.readString(),
            location = parcel.readString(),
            email = parcel.readString(),
            hireable = parcel.readString(),
            bio = parcel.readString(),
            twitter_username = parcel.readString(),
            public_repos = parcel.readString(),
            public_gists = parcel.readString(),
            followers = parcel.readString(),
            following = parcel.readString(),
            created_at  = parcel.readString(),
            updated_at = parcel.readString())


    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.login)
        dest.writeString(this.id)
        dest.writeString(this.node_id)
        dest.writeString(this.avatar_url)
        dest.writeString(this.gravatar_id)
        dest.writeString(this.url)
        dest.writeString(this.html_url)
        dest.writeString(this.followers_url)
        dest.writeString(this.following_url)
        dest.writeString(this.gists_url)
        dest.writeString(this.starred_url)
        dest.writeString(this.subscriptions_url)
        dest.writeString(this.organizations_url)
        dest.writeString(this.repos_url)
        dest.writeString(this.events_url)
        dest.writeString(this.received_events_url)
        dest.writeString(this.type)
        dest.writeString(this.site_admin)
        dest.writeString(this.name)
        dest.writeString(this.company)
        dest.writeString(this.blog)
        dest.writeString(this.location)
        dest.writeString(this.email)
        dest.writeString(this.hireable)
        dest.writeString(this.bio)
        dest.writeString(this.twitter_username)
        dest.writeString(this.public_repos)
        dest.writeString(this.public_gists)
        dest.writeString(this.followers)
        dest.writeString(this.following)
        dest.writeString(this.created_at)
        dest.writeString(this.updated_at)
    }

    override fun describeContents() = 0
}
