package com.zlm.kt.utils

import android.view.View
import android.view.ViewGroup.MarginLayoutParams
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

/**
 * @author Milla
 * @create 2020/4/2
 */
object BindingUtil {
    // -------------------------------------------
    @BindingAdapter(value = ["imageUrl", "radius"], requireAll = false)
    fun setImageUrl(imageView: ImageView, url: String?, radius: Int) {
        val context = imageView.context
        var default_radius = 4
        var requestOptions = RequestOptions()
        if (radius > 0) {
            default_radius = radius
        }
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(default_radius))
        Glide.with(context).load(url).apply(requestOptions).into(imageView)
    }

    // -------------------------------------------
    @JvmStatic
    @BindingAdapter("imageUrlToCircle")
    fun setImageUrlCircle(imageView: ImageView, url: String?) {
        val context = imageView.context
        Glide.with(context).load(url).apply(RequestOptions.circleCropTransform()).into(imageView)
    }

    // -------------------------------------------
    @BindingAdapter("characterBackground")
    fun setCharacterBackground(textView: TextView, res: Int) {
        val context = textView.context
        if (res != 0) {
            textView.background = context.getDrawable(res)
        }
    }

    @BindingAdapter("characterText")
    fun setCharacterText(textView: TextView, res: Int) {
        val context = textView.context
        if (res != 0) {
            textView.setTextColor(context.resources.getColor(res))
        }
    }

    // -------------------------------------------
    @BindingAdapter("btnTextColor")
    fun setBtnTextColor(button: Button, res: Int) {
        val context = button.context
        if (res != 0) {
            button.setTextColor(context.resources.getColor(res))
        }
    }

    // -------------------------------------------
    @BindingAdapter("android:layout_marginTop")
    fun setLayoutMarginTop(view: View, margin: Float) {
        val lp = view.layoutParams as MarginLayoutParams
        if (lp != null) {
            lp.setMargins(lp.leftMargin, margin.toInt(), lp.rightMargin, lp.bottomMargin)
            view.layoutParams = lp
        }
    }
}