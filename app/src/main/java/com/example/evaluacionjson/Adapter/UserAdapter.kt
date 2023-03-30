package com.example.evaluacionjson.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evaluacionjson.databinding.ItemViewBinding

class UserAdapter(private val userList: ArrayList<UserData>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun load(item: UserData) {
           with(binding){
               idCtv.text = item.id
               nombrestv.text = item.name
               apellidostv.text = item.secondName
               fechaNactv.text = item.dateBorn
               titulotv.text = item.tittle
               emailtv.text = item.email
               facultadtv.text = item.faculty


           }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val userItem = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(userItem)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.load(this.userList[position])
    }
}