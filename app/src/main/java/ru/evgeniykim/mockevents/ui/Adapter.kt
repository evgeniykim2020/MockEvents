package ru.evgeniykim.mockevents.ui

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.evgeniykim.mockevents.databinding.ItemCardBinding
import ru.evgeniykim.mockevents.models.Event
import ru.evgeniykim.mockevents.models.EventsModel

class Adapter : RecyclerView.Adapter<Adapter.MainViewHolder>() {
    inner class MainViewHolder(val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffUtilCallback = object : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.id == newItem.id
        }

    }

    val differ = AsyncListDiffer(this, diffUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = differ.currentList[position]
    }
}