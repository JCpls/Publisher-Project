package com.justin.publisher

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justin.publisher.databinding.ActivityItemBinding

class MainAdapter(
    private val onClickListenerDetail: OnClickListenerDetail
)
    : ListAdapter<CartData, MainAdapter.CartToCashViewHolder>(DiffCallback()) {

    class CartToCashViewHolder(val binding: ActivityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartData: CartData) {
            Log.d("justin", "CartToCashViewHolder")
            // *****要先在Adapter綁定後，才能在viewItem XML 帶入<variable>
//            binding.articleTitle.text = cartData.title
//            binding.authorName.text = cartData.name
//            binding.createdTime.text = cartData.time
//            binding.articleContent.text = cartData.content
//

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): CartToCashViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ActivityItemBinding.inflate(
                    layoutInflater, parent, false
                )
                return CartToCashViewHolder(binding)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CartData>() {
        override fun areItemsTheSame(oldItem: CartData, newItem: CartData): Boolean {
            return oldItem === newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: CartData, newItem: CartData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            CartToCashViewHolder {
        return CartToCashViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: CartToCashViewHolder, position: Int) {

        val selectedItem = getItem(position)
        holder.bind(selectedItem)
        holder.itemView.setOnClickListener {
            Log.d("justin", " holder.itemView.setOnClickListener")
            onClickListenerDetail.onClick(selectedItem)

        }
    }

    class OnClickListenerDetail(val clickListener: (cartData: CartData) -> Unit) {
        fun onClick(cartData: CartData) = clickListener(cartData)
    }
}