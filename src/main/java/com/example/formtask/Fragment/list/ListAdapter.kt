package com.example.formtask.Fragment.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.formtask.Model.User
import com.example.formtask.R
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var addressList = emptyList<User>()

    class  MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            val currentItem = addressList[position]
                holder.itemView.id_txt.text = currentItem.id.toString()
                holder.itemView.address_txt.text = currentItem.address
                holder.itemView.postal_txt.text = currentItem.postal
                holder.itemView.city_txt.text = currentItem.city
                holder.itemView.country_txt.text = currentItem.country
            }

    override fun getItemCount(): Int {
        return addressList.size
    }
    fun setData(user: List<User>) {
        this.addressList = user
        notifyDataSetChanged()
    }


}


