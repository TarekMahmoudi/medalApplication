package com.mahmoudi.projectone.ui.main.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudi.projectone.data.model.RecordsModel
import com.mahmoudi.projectone.databinding.RowMedalBinding

class RecordsAdapter (private val list: List<RecordsModel>): RecyclerView.Adapter<RecordsAdapter.MedalViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MedalViewHolder {
        val binding = RowMedalBinding.inflate(LayoutInflater.from(parent.context),parent,false )
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.bind(list[position])

    }
    class MedalViewHolder(private val binding: RowMedalBinding):
            RecyclerView.ViewHolder(binding.root){
                fun bind(item: RecordsModel){
                    binding.model=item
                }
            }

    override fun getItemCount(): Int {
        return list.size
    }

}