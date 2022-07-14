package ru.barinov.studyapp

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RVAdapter: RecyclerView.Adapter<RVViewHolder>()  {

    private var itemList = listOf<DeviceEntity>()

    private var onClickInter: OnClickInterface? = null

    private var onClickAction: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onClickAction?.let{
                it.invoke(item.mac)
            }
        }
        holder.itemView.setOnLongClickListener {
            onClickInter?.doAction()
            true }
    }

    override fun getItemCount(): Int = itemList.size

    private fun getItem(position: Int): DeviceEntity = itemList[position]

    fun setAction(action: (String) -> Unit){
        onClickAction = action
    }

}