package com.fengkun.cognition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.fengkun.cognition.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlin.random.Random


private lateinit var bingding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var randomProductList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
        val view = bingding.root
        setContentView(view)
        bingding.name.text = "胡萝卜"
        init()
    }

    fun init() {

        val datastr = getAssetData(this, "data.json")
        var gson: Gson = Gson()
        var dataList: ArrayList<Product> =
            gson.fromJson(datastr, object : TypeToken<ArrayList<Product>>() {}.type)
        randomProductList = getThreeRandomProduct(dataList)

        val layoutManager = GridLayoutManager(this, 3)
        bingding.recyclerView.layoutManager = layoutManager;
        val adapter = ProductAdapter(randomProductList)
        adapter.itemClickListener = {
            if (dataList.size < 3)
                dataList = gson.fromJson(datastr, object : TypeToken<ArrayList<Product>>() {}.type)
            adapter.productList = getThreeRandomProduct(dataList)
            adapter.notifyDataSetChanged()
        }
        bingding.recyclerView.adapter = adapter


    }

    //随机三种不重复的物品
    fun getThreeRandomProduct(dataList: ArrayList<Product>): ArrayList<Product> {
        var max = dataList.size - 1
        var randomProductList: ArrayList<Product> = ArrayList<Product>()
        for (i in 1..3) {
            if (max < 0)
                break;
            val randomInt = (0..max).random()
            randomProductList.add(dataList[randomInt])
            dataList.removeAt(randomInt)
            max--

        }
        return randomProductList
    }
}