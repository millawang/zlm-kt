package com.zlm.kt.data.model.api;

import android.os.Parcel
import android.os.Parcelable


/**
 * @author Milla
 * @create 2020/6/9
 */
class UsersResponse(

        val login: String,
        val  id: String,
        val  node_id: String,
        val  avatar_url: String,
        val  gravatar_id: String,
        val  url: String,
        val  html_url: String,
        val  followers_url: String,
        val  following_url: String,
        val   gists_url: String,
        val  starred_url: String,
        val  subscriptions_url: String,
        val  organizations_url: String,
        val  repos_url: String,
        val  events_url: String,
        val  received_events_url: String,
        val  type: String,
        val  site_admin: String) : Parcelable {

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<UsersResponse> {
            override fun createFromParcel(parcel: Parcel) = UsersResponse(parcel)
            override fun newArray(size: Int) = arrayOfNulls<UsersResponse>(size)
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
            site_admin = parcel.readString()
    )

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
    }

    override fun describeContents() = 0
}


