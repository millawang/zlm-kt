package com.zlm.kt.ui.adapter;

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zlm.kt.data.model.api.UsersResponse
import com.zlm.kt.databinding.ListUserItemBinding
import com.zlm.kt.ui.users.UserItemViewModel


/**
 * @author Milla
 * @create 2020/6/9
 */
class UsersAdapter : RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private var context: Context
    private var userList:MutableList<UsersResponse> = arrayListOf<UsersResponse>()
    private var listener:OnUserDataCallback

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
        val dataBinding = ListUserItemBinding.inflate(inflater, parent, false)
        return UsersViewHolder(dataBinding, listener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.onBind(userList.get(position))
    }

    class UsersViewHolder constructor(private val dataBinding: ListUserItemBinding, private val listener:OnUserDataCallback): RecyclerView.ViewHolder(dataBinding.root) {

        fun onBind(user:UsersResponse) {
            val viewModel = UserItemViewModel(user)
            dataBinding.setViewModel(viewModel)

            dataBinding.root.setOnClickListener({ v-> if (listener != null)
            {
                listener.onItemClick(user)
            } })

        }

    }

    interface OnUserDataCallback {
        fun onItemClick(user : UsersResponse)
    }

}
