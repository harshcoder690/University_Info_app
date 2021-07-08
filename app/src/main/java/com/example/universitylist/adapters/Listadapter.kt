package com.example.universitylist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.universitylist.R
import com.example.universitylist.UnversityresponseItem
import kotlinx.android.synthetic.main.item_univ.view.*

class Listadapter(): RecyclerView.Adapter<Listadapter.countryViewHolder>() {

    private var data: List<UnversityresponseItem> = ArrayList()
    var onItemClick: ((name: String,alphaTwoCode:String,webPages: String,domains: String,country: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): countryViewHolder {
        return countryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_univ, parent, false)
        )
    }
    fun swapData(data: List<UnversityresponseItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: countryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size


    inner class countryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: UnversityresponseItem) = with(itemView) {
            textView.text = item.name.toString()
            textView2.text = item.alphaTwoCode.toString()

            detailBtn.setOnClickListener {
                onItemClick?.invoke(item.name!!,item.alphaTwoCode!!, item.webPages!!.toString(), item.domains.toString(),item.country!!)
            }

            setOnClickListener {
                onItemClick?.invoke(item.name!!,item.alphaTwoCode!!, item.webPages!!.toString(), item.domains.toString(),item.country!!)
            }

        }

    }


}
