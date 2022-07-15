package com.betulantep.recyclerviewdesign.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betulantep.recyclerviewdesign.model.News
import com.betulantep.recyclerviewdesign.databinding.RowNewsBinding

class NewsAdapter(var newsList: List<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(val binding: RowNewsBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = RowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) = with(holder.binding) {
        val news = newsList[position]
        val mContext = root.context
        ivNews.setImageResource(
            mContext.resources.getIdentifier(
                news.newsImageName,
                "drawable",
                mContext.packageName
            )
        )
        tvHeader1.text = news.newsHeader1
        tvHeader2.text = news.newsHeader2
        tvDate.text = news.newsDate
        tvReadNumber.text = news.newsReadNumber


    }

    override fun getItemCount(): Int = newsList.size
}
