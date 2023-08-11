package com.example.countries

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountriesAdapter(private val dataSet: ArrayList<ItemViewModel>) :
    RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {

    private var onClickListener: OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

      val item=dataSet[position]
        val countryName = dataSet[position].name
        holder.textView.text = countryName

        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position,item)
        }
    }

    fun setOnClickListener(onClickListener: OnClickListener){

        this.onClickListener=onClickListener
    }

    interface OnClickListener{

        fun onClick(position:Int,model:ItemViewModel)
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val textView: TextView = ItemView.findViewById(R.id.textView)
    }
}

class ItemViewModel(val name: String, val population: Int?, val captial:String?, val img: String?):java.io.Serializable {

}

