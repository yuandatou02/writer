package com.huang.writer.ui

import android.os.Bundle
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.huang.writer.R

class MainActivity : AppCompatActivity() {

    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.grid_view)

        // 模拟书籍数据
        val bookList = listOf(
            Book("美女如云", "异想天开"),
            Book("大昏君", "黄文"),
            Book("女神调教手册", "黄文"),
            Book("赘婿的荣耀改", "黄文")
        )

        // 设置适配器
        gridView.adapter = object : BaseAdapter() {
            override fun getCount(): Int = bookList.size

            override fun getItem(p0: Int): Any = bookList[p0]

            override fun getItemId(p0: Int): Long = p0.toLong()

            override fun getView(p0: Int, p1: android.view.View?, p2: android.view.ViewGroup?): android.view.View {
                val view = layoutInflater.inflate(R.layout.book_item, p2, false)
                val bookCover: ImageView = view.findViewById(R.id.book_cover)
                val bookTitle: TextView = view.findViewById(R.id.book_title)
                val bookAuthor: TextView = view.findViewById(R.id.book_author)

                val book = bookList[p0]
                bookTitle.text = book.title
                bookAuthor.text = book.author

                return view
            }
        }
    }

    data class Book(val title: String, val author: String)
}