package com.zlm.kt.ui.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zlm.kt.R
import com.zlm.kt.data.model.api.UsersResponse
import com.zlm.kt.databinding.ListUserItemBinding
import com.zlm.kt.ui.users.UserItemViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * @author Milla
 * @create 2020/6/9
 */
class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private var context: Context
    private var userList:MutableList<UsersResponse> = arrayListOf<UsersResponse>()
    private var listener:OnUserDataCallback
    private val viewHolders: MutableList<UsersViewHolder> = mutableListOf()
    constructor(context: Context,cb:OnUserDataCallback) : super() {
        this.context = context
        this.listener = cb;
    }

    fun setUserList(list:List<UsersResponse>) {
        userList.clear();
        userList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListUserItemBinding.inflate(inflater, parent, false)
        val viewHolder = UsersViewHolder(binding, listener)
        binding.lifecycleOwner = viewHolder
        viewHolders.add(viewHolder)
        return viewHolder

    }


    override fun onViewAttachedToWindow(holder: UsersViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.markAttach()
    }

    override fun onViewDetachedFromWindow(holder: UsersViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.markDetach()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        var user = userList.get(position)
        holder.onBind(user)

        /*
        val viewModel = UserItemViewModel(user)
        holder.binding.setViewModel(viewModel)
         */

        holder.binding.root.setOnClickListener({ v-> if (listener != null)
        {
            listener.onItemClick(user)
        } })

    }

    fun setLifecycleDestroyed() {
        viewHolders.forEach {
            it.markDestroyed()
        }
    }

    class UsersViewHolder constructor(val binding: ListUserItemBinding, private val listener:OnUserDataCallback): RecyclerView.ViewHolder(binding.root),
            LifecycleOwner {

        private var lifecycleRegistry = LifecycleRegistry(this)
        private var wasPaused: Boolean = false

        init {
            lifecycleRegistry.markState(Lifecycle.State.INITIALIZED)
        }

        fun markCreated() {
            lifecycleRegistry.markState(Lifecycle.State.CREATED)
        }

        fun markAttach() {
            if (wasPaused) {
                lifecycleRegistry.markState(Lifecycle.State.RESUMED)
                wasPaused = false
            } else {
                lifecycleRegistry.markState(Lifecycle.State.STARTED)
            }
        }

        fun markDetach() {
            wasPaused = true
            lifecycleRegistry.markState(Lifecycle.State.CREATED)
        }

        fun markDestroyed() {
            lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
        }

        override fun getLifecycle(): Lifecycle {
            return lifecycleRegistry
        }

        fun onBind(user:UsersResponse) {
            val viewModel = UserItemViewModel(user)
            binding.setViewModel(viewModel)

            binding.root.setOnClickListener({ v-> if (listener != null)
            {
                listener.onItemClick(user)
            } })
        }
    }

    interface OnUserDataCallback {
        fun onItemClick(user : UsersResponse)
    }

}
