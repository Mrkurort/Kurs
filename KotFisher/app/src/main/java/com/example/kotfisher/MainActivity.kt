package com.example.kotfisher

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var adapter:myAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList <ListItem>()
        val rcView:RecyclerView = findViewById(R.id.rcView)
        val nav_view:NavigationView = findViewById(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)

        list.addAll(fillArras(resources.getStringArray(R.array.bus),
            (resources.getStringArray(R.array.bus_content)),getImageId(R.array.bus_image_array)))

        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = myAdapter(list,this)
        rcView.adapter = adapter




    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.id_fish->{
                Toast.makeText(this,"Выбран раздел: Рыбы", Toast.LENGTH_SHORT).show()

                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.bus),
                    (resources.getStringArray(R.array.bus_content)),getImageId(R.array.bus_image_array)))
            }
            R.id.id_na-> {
                Toast.makeText(this,"Выбран раздел: Наживки", Toast.LENGTH_SHORT).show()

                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.marsh),
                    (resources.getStringArray(R.array.marsh_content)),getImageId(R.array.marsh_image_array)))
            }
        }

        var drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    fun fillArras(titleArray:Array<String>, contentArray: Array<String>, imageArray:IntArray):List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size - 1)
        {
            var listItem = ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray
    {

        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)

        for(i in ids.indices){
            ids[i] = tArray.getResourceId(i, 0)
        }

        tArray.recycle()
        return ids
    }
}