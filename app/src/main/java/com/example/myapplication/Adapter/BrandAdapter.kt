package com.example.myapplication.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ViewholderBrandBinding
import com.example.myapplication.model.BrandModel

class BrandAdapter(val items:MutableList<BrandModel>):RecyclerView.Adapter<BrandAdapter.ViewHolder>() {

    private  var selectedPosition=-1
    private var lastSelectedPosition=-1
    private lateinit var  context: Context

    class ViewHolder(val binding:ViewholderBrandBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandAdapter.ViewHolder {
        context=parent.context
        val binding=ViewholderBrandBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandAdapter.ViewHolder, position: Int) {
        val item=items[position]
        holder.binding.title.text=item.title

        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .into(holder.binding.pic)

        holder.binding.root.setOnClickListener{

            lastSelectedPosition=selectedPosition
            selectedPosition=position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

        }
        holder.binding.title.setTextColor(context.resources.getColor(R.color.white))
        if(selectedPosition==position){

            holder.binding.pic.setBackgroundResource(0)
            holder.binding.mailLayout.setBackgroundResource(R.color.blue)
            ImageViewCompat.setImageTintList(holder.binding.pic, ColorStateList.valueOf(ContextCompat.getColor(context,R.color.white)))

            holder.binding.title.visibility=View.VISIBLE
        }else{
            holder.binding.pic.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.mailLayout.setBackgroundResource(0)
            ImageViewCompat.setImageTintList(holder.binding.pic, ColorStateList.valueOf(ContextCompat.getColor(context,R.color.black)))

            holder.binding.title.visibility=View.GONE


        }


    }

    override fun getItemCount(): Int = items.size

}
