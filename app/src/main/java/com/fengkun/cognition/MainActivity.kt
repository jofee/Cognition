package com.fengkun.cognition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fengkun.cognition.databinding.ActivityMainBinding
import com.google.gson.Gson

val data =
    "[{name:\"菠萝\",res:\"pineapple\"},{name:\"胡萝卜\",res:\"carrot\"},{name:\"火龙果\",res:\"pitaya\"},{name:\"剪刀\",res:\"scissors\"},{name:\"猕猴桃\",res:\"kiwi\"},{name:\"茄子\",res:\"kiwi\"},{name:\"桃子\",res:\"peach\"},{name:\"西瓜\",res:\"watermelon\"},{name:\"香蕉\",res:\"banana\"},{name:\"钥匙\",res:\"key\"},{name:\"樱桃\",res:\"cherry\"},{name:\"自行车\",res:\"bicycle\"}]"
private lateinit var bingding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
        val view = bingding.root
        setContentView(view)
        bingding.name.text = "胡萝卜"
        bingding.image1.setImageResource(R.drawable.banana);
        bingding.image2.setImageResource(R.drawable.pitaya);
        bingding.image3.setImageResource(R.drawable.carrot);
    }

    fun init() {
        var gson: Gson = Gson()
    }
}