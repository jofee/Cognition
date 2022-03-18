package com.fengkun.cognition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    private var context: Context?=null
    var itemClickListener: ListItemClickListener? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image);
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_product, parent, false)
        context = parent.context
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val product: Product = productList[holder.adapterPosition]
        context?.resources?.let {
            holder.image.setImageResource(
                it.getIdentifier(
                    product.res,
                    "drawable",
                    context?.packageName
                )
            )
        }
        holder.itemView.setOnClickListener {
            itemClickListener?.invoke(position)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}

typealias ListItemClickListener = (Int) -> Unit //设置item控件的点击事件