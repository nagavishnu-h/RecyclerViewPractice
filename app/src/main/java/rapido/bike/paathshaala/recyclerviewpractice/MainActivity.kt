package rapido.bike.paathshaala.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val startTimeOfApp = System.currentTimeMillis()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Debug.startMethodTracing("startup");
        setContentView(R.layout.activity_main)
        initialiseViews()
    }

    private fun initialiseViews(){
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerview.layoutManager = LinearLayoutManager(this)
        initialiseRecyclerView(recyclerview)
    }

    private fun initialiseRecyclerView(recyclerview: RecyclerView) {
        val adapter = CustomAdapter(getData())
        recyclerview.adapter = adapter
    }

    private fun getData(): ArrayList<ItemsViewModel> {
        val data = ArrayList<ItemsViewModel>()
        for (i in 1..20) {
            data.add(ItemsViewModel(androidx.appcompat.R.drawable.abc_star_half_black_48dp,
                "Item $i"
            ))
        }
        return data
    }

    override fun onResume() {
        super.onResume()
        val stopTimeOfApp = System.currentTimeMillis()
        val elapsedTime = stopTimeOfApp - startTimeOfApp
        Log.d("LaunchTime", elapsedTime.toString())
    }
}