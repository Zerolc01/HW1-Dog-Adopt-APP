package com.lc.dog_adopt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var listView: RecyclerView? = null

    //初始化数据

    private fun initData(): ArrayList<Dog> {
        var listData = ArrayList<Dog>()
        for(i in 1..10) {
//            var age:Int = i % 5
//            listData.add(Dog("Dog$i", "  My name is Doggy $i, will you be my friend?","Doggy $i", " I am a $age-year-old dog."))
            listData.add(Dog("Dog$i", "  My name is Doggy $i, will you be my friend?"))
        }

        return listData
    }
    //设置adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<RecyclerView>(R.id.list)
        var listData = initData()
        var testAdapter = TestAdapter(listData)
        listView?.adapter = testAdapter
        //LayoutManger必须设置，否则不显示列表
        listView?.layoutManager = LinearLayoutManager(this)
        var thisContext = this
        testAdapter.setOnItemClickListener(object:TestAdapter.ClickListener{
            override fun onItemClick(position: Int) {
                var no: Int = position + 1

                val intent = Intent(thisContext, ExtraIntro::class.java)
                intent.putExtra("No", no)
                startActivity(intent)
            }
        })

    }
}