package com.betulantep.recyclerviewdesign.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betulantep.recyclerviewdesign.model.News
import com.betulantep.recyclerviewdesign.databinding.RowNewsVerticalBinding

class NewsVerticalAdapter(var newsList:List<News>):RecyclerView.Adapter<NewsVerticalAdapter.NewsVerticalViewHolder>() {
    class NewsVerticalViewHolder(val binding: RowNewsVerticalBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVerticalViewHolder {
        val view = RowNewsVerticalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsVerticalViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsVerticalViewHolder, position: Int) = with(holder.binding) {
        val news = newsList[position]
        val mContext = root.context
        ivNews.setImageResource(mContext.resources.getIdentifier(news.newsImageName,"drawable",mContext.packageName))
        tvHeader1.text = news.newsHeader1
        tvHeader2.text = news.newsHeader2
        tvDate.text = news.newsDate
        tvReadNumber.text = news.newsReadNumber
    }

    override fun getItemCount(): Int = newsList.size
}