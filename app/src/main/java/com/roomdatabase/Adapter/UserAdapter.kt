package com.roomdatabase.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.roomdatabase.Model.User
import com.roomdatabase.R


class UserAdapter
 constructor(
    private val context:Context,
    private var userList:ArrayList<User>)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent,false))
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=userList[position]
        holder.name.text=user.name
        holder.age.text=user.age.toString()
        holder.dept.text=user.department
    }

    class UserViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val name:TextView=itemView.findViewById(R.id.name1)
        val age:TextView=itemView.findViewById(R.id.age1)
        val dept:TextView=itemView.findViewById(R.id.dept1)
    }

    fun setUser(userList: ArrayList<User>){
        this.userList=userList
        notifyDataSetChanged()
    }
}