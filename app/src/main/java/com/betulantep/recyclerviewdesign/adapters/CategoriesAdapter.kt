package com.betulantep.recyclerviewdesign.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betulantep.recyclerviewdesign.model.Category
import com.betulantep.recyclerviewdesign.databinding.RowCategoryBinding

class CategoriesAdapter(var categoryList: List<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    class CategoriesViewHolder(val binding: RowCategoryBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = RowCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) =
        with(holder.binding) {
            val category = categoryList[position]
            val mContext = root.context
            ivCategory.setImageResource(
                mContext.resources.getIdentifier(
                    category.categoryImageName,
                    "drawable",
                    mContext.packageName
                )
            )
            tvCategory.text = category.categoryName
        }

    override fun getItemCount(): Int = categoryList.size
}






































