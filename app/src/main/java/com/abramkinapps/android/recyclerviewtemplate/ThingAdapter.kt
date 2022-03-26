package com.abramkinapps.android.recyclerviewtemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abramkinapps.android.recyclerviewtemplate.databinding.ThingItemBinding


// Класс для связки данных с компонентом и отслеживания изменений
class ThingAdapter : RecyclerView.Adapter<ThingAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    // Свой интерфейс для отслеживания кликов по элементу
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {

        mListener = listener
    }

    val thingList = ArrayList<Thing>()

    // Внутренний класс, который служит контейнером для всех компонентов, которые входят в один элемент списка
    inner class ViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {

        val binding = ThingItemBinding.bind(itemView)

        fun bind(thing: Thing) = with(binding) {
            imageViewItem.setImageResource(thing.imageId)
            textViewItem.text = thing.title
        }

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)
            }
        }
    }

    // Вызывается при создании "контейнера" для каждого элемента списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thing_item, parent, false)
        return ViewHolder(view, mListener)

    }

    // Вызывается каждый раз при заполнении элемента по позиции (position)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(thingList[position])

    }

    // Количество элементов списка
    override fun getItemCount(): Int {
        return thingList.size
    }

    // Функция для добавления списка экземпляров Thing
    fun addThings(list: List<Thing>) {
        thingList.clear()
        thingList.addAll(list)
        notifyDataSetChanged()  //(изменить) лучше обрабатывать каждое событие добавления/удаления/изменения элемента,
                                // чем обновлять весь список
    }
}