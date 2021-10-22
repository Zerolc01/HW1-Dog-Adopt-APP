package com.lc.dog_adopt

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.widget.Button


class Dog constructor(name : String,intro: String){
    var DogName : String = name
    var DogIntro : String = intro
//    var DogDeName : String = namedetail
//    var DogDetail : String = details
}



class TestAdapter(arrayData: ArrayList<Dog>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listData: List<Dog> = arrayData
    private var AClickListener : ClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.intro, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DogViewHolder) {
            holder.DogNameView?.text = listData[position].DogName
            holder.DogIntroView?.text = listData[position].DogIntro
//            holder.DogDenameView?.text = listData[position].DogDeName
//            holder.DogDetailView?.text = listData[position].DogDetail

        }
        holder.itemView.setOnClickListener{
            AClickListener?.onItemClick(position)
        }

    }

    interface ClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(onItemClickListener: ClickListener) {
        this.AClickListener = onItemClickListener
    }


}

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var DogNameView: TextView? = null
    var DogIntroView: TextView? = null
//    var DogDenameView : TextView? = null
//    var DogDetailView : TextView? = null

    init {
        DogNameView = itemView.findViewById(R.id.dog_text_name)
        DogIntroView = itemView.findViewById(R.id.dog_text_intro)
//        DogDenameView = itemView.findViewById(R.id.DetailName)
//        DogDetailView = itemView.findViewById(R.id.Detailtxt)

    }
}