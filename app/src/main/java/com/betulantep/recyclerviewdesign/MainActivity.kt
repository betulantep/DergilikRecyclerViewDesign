package com.betulantep.recyclerviewdesign

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.betulantep.recyclerviewdesign.adapters.CategoriesAdapter
import com.betulantep.recyclerviewdesign.adapters.NewsAdapter
import com.betulantep.recyclerviewdesign.adapters.NewsHorizontalAdapter
import com.betulantep.recyclerviewdesign.adapters.NewsVerticalAdapter
import com.betulantep.recyclerviewdesign.databinding.ActivityMainBinding
import com.betulantep.recyclerviewdesign.model.Category
import com.betulantep.recyclerviewdesign.model.News
import com.betulantep.recyclerviewdesign.util.RecyclerItemDecoration
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RoundedCornerTreatment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryList: ArrayList<Category>
    private lateinit var newsList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavView.background = null

        bottomAppBarCornerRadius()
        categoryListAdd()
        newsListAdd()

        //Categories
        binding.rvCategories.layoutManager =
            StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)
        binding.rvCategories.adapter = CategoriesAdapter(categoryList)

        //News
        rvNewsLinearAdapter() //Default RecyclerView
        binding.rvNews.addItemDecoration(RecyclerItemDecoration())

        binding.ivMainView.setOnClickListener { rvNewsLinearAdapter() }

        binding.ivVerticalView.setOnClickListener {
            binding.rvNews.layoutManager = LinearLayoutManager(applicationContext)
            binding.rvNews.adapter = NewsVerticalAdapter(newsList)
        }

        binding.ivHorizontalView.setOnClickListener {
            binding.rvNews.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            binding.rvNews.adapter = NewsHorizontalAdapter(newsList)
        }
    }

    private fun rvNewsLinearAdapter() = with(binding) {
        rvNews.layoutManager = LinearLayoutManager(applicationContext)
        rvNews.adapter = NewsAdapter(newsList)
    }

    private fun newsListAdd() {
        newsList = ArrayList()
        val news1 = News(
            1,
            "Bug??n neler ya??and???",
            "Dergilik'le 2 dakikada g??n??n ??zeti!",
            "09/07/2022", "3369", "the_summary_of_the_day2"
        )
        val news2 = News(
            2,
            "MediaTrend",
            "Tatilde yan??n??zdan ay??rmaman??z gerekenler!",
            "09/07/2022", "939", "news_travel1"
        )
        val news3 = News(
            3,
            "Popular Science",
            "Maddeler nas??l bir araya geliyor?",
            "09/07/2022", "1296", "news_science"
        )
        val news4 = News(
            4,
            "Yemek Zevki",
            "Yaz aylar??na ??zel buz gibi ??orbalar!",
            "09/07/2022", "15863", "news_food"
        )
        val news5 = News(
            5,
            "Digital Report",
            "Yapay zeka ??a????!",
            "09/07/2022", "8965", "news_technology"
        )
        val news6 = News(
            6,
            "Homeart",
            "Mutfakta yeni trendler!",
            "09/07/2022", "2635", "news_decoration"
        )
        val news7 = News(
            7,
            "Platin",
            "??stanbul ve Ankara'n??n k??lt??r yollar??!",
            "09/07/2022", "8475", "news_culture"
        )
        val news8 = News(
            8,
            "Ailemiz",
            "Bebek odas??nda mutlaka olmas?? gerekenler!",
            "09/07/2022", "1596", "news_life"
        )
        val news9 = News(
            9,
            "Y??ksek Teknoloji",
            "Cenneti and??ran g??zelli??iyle Sey??eller!",
            "09/07/2022", "4856", "news_travel2"
        )
        val news10 = News(
            10,
            "Atlas Tarih",
            "8 bin y??ll??k kent!",
            "09/07/2022", "12968", "news_history"
        )

        newsList.add(news1)
        newsList.add(news2)
        newsList.add(news3)
        newsList.add(news4)
        newsList.add(news5)
        newsList.add(news6)
        newsList.add(news7)
        newsList.add(news8)
        newsList.add(news9)
        newsList.add(news10)
    }

    private fun categoryListAdd() {
        categoryList = ArrayList()
        val c1 = Category(1, "Teknoloji", "technology")
        val c2 = Category(2, "Spor", "sport")
        val c3 = Category(3, "Magazin", "magazine")
        val c4 = Category(4, "Yemek", "food")
        val c5 = Category(5, "Ya??am", "life")
        val c6 = Category(6, "Sa??l??k", "health")
        val c7 = Category(7, "Moda", "fashion")
        val c8 = Category(8, "K??lt??r & Sanat", "culture_and_art")
        val c9 = Category(9, "E??itim", "education")
        val c10 = Category(10, "Dekorasyon", "decoration")

        categoryList.add(c1)
        categoryList.add(c2)
        categoryList.add(c3)
        categoryList.add(c4)
        categoryList.add(c5)
        categoryList.add(c6)
        categoryList.add(c7)
        categoryList.add(c8)
        categoryList.add(c9)
        categoryList.add(c10)
    }

    private fun bottomAppBarCornerRadius() {
        val bottomBarBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel = bottomBarBackground.shapeAppearanceModel
            .toBuilder()
            .setAllCorners(RoundedCornerTreatment()).setTopLeftCorner(CornerFamily.ROUNDED, 50f)
            .setAllCorners(RoundedCornerTreatment()).setTopRightCorner(CornerFamily.ROUNDED, 50f)
            .build()
    }

}



