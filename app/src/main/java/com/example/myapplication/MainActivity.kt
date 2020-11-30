package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var listAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.Main) {

            try {
                val response= withContext(Dispatchers.IO) { Client.api.execute() }
                if (response.isSuccessful)
                {
                    val data = Gson().fromJson(response.body?.string(), Response::class.java)

                        bindCombineData(data.statewise[0])
                        bindStateWiseData(data.statewise.subList(1, data.statewise.size))

                }
            }
            catch (ex: Exception){
                print(ex)

            }

        }
        }

    private fun bindStateWiseData(subList: List<StatewiseItem>){
        listAdapter = ListAdapter(subList)
        list.addHeaderView(LayoutInflater.from(this).inflate(R.layout.list_header,list,false))
        list.adapter = listAdapter

    }

    private fun bindCombineData(data:StatewiseItem)
    {
        confirmedTv.text = data.confirmed
        activedTv.text = data.active
        recoveredTv.text = data.recovered
        deathedTv.text = data.deaths
    }

}