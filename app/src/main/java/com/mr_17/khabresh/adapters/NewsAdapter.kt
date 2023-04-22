package com.mr_17.khabresh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mr_17.khabresh.R
import com.mr_17.khabresh.databinding.ItemArticlePreviewBinding
import com.mr_17.khabresh.models.Article

class NewsAdapter(
    val listener: OnClickListener
): RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            ItemArticlePreviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ArticleViewHolder(val binding: ItemArticlePreviewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val article = differ.currentList[position]
            binding.apply {
                Glide.with(this.root).load(article.urlToImage).into(ivArticleImage)
                tvSource.text = article.source.name
                tvTitle.text = article.title
                tvDescription.text = article.description
                tvPublishedAt.text = article.publishedAt
                root.setOnClickListener{
                    listener.onClick(article)
                }
            }
        }
    }

    interface OnClickListener{
        fun onClick(article: Article)
    }
}