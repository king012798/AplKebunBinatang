package com.example.aplikasikebunbinatang

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list_bintang_buas.view.*

class MainActivity : AppCompatActivity() {

    var listBinatang = ArrayList<Binatang>()
    var adapter: AdapterBinatang? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        listBinatang.add(
            Binatang("Beruang", "Binatang dalam kelas mamalia yang tergolong ordo Carnivora, familia Ursidae.", R.drawable.beruang, true)
        )

        listBinatang.add(
            Binatang("Buaya", "Reptil bertubuh besar yang hidup di air", R.drawable.buaya, true)
        )

        listBinatang.add(
            Binatang("Cobra", " Nama umum dari berbagai ular elapid , yang sebagian besar milik genus Naja", R.drawable.cobra, true)
        )

        listBinatang.add(
            Binatang("Gajah", "Mamalia besar dari famili Elephantidae dan ordo Proboscidea", R.drawable.gajah, false)
        )

        listBinatang.add(
            Binatang("Harimau", " Hewan yang tergolong dalam filum Chordata, subfilum vertebrata, kelas mamalia, pemakan daging (karnivora), keluarga felidae (kucing), genus panthera, dan tergolong dalam spesies tigris.", R.drawable.harimau, true)
        )

        listBinatang.add(
            Binatang("Jerapah", "Mamalia berkuku genap endemik Afrika dan merupakan spesies hewan tertinggi yang hidup di darat. Jerapah jantan dapat mencapai tinggi 4,8 sampai 5,5 meter dan memiliki berat yang dapat mencapai 1.360 kilogram. ", R.drawable.jerapah, false)
        )

        listBinatang.add(
            Binatang("Kuda Nil", "Mamalia dari keluarga Hippopotamidae yang berukuran besar, omnivora, dan berasal dari Afrika sub-Sahara. Kuda nil adalah hewan darat terbesar ketiga setelah gajah dan badak putih.", R.drawable.kudanil, true)
        )

        listBinatang.add(
            Binatang("Singa", "Spesies hewan dari keluarga felidae atau jenis kucing. Singa merupakan hewan yang hidup berkelompok.", R.drawable.singa, true)
        )

        adapter = AdapterBinatang(this, listBinatang)
        lvBinatang.adapter = adapter

    }

    inner class AdapterBinatang: BaseAdapter{
        var listBinatang = ArrayList<Binatang> ()
        var context: Context?=null

        constructor(context: Context, listOfAnimals: ArrayList<Binatang>):super(){
            this.listBinatang = listOfAnimals
            this.context = context
        }

        override fun getView(p0: Int, p1: View?, p3: ViewGroup?): View{
            val binatang = listBinatang[p0]
            if(binatang.binatangBuas == true){
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var myView = inflator.inflate(R.layout.item_list_bintang_buas, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imGGambarBinatang.setImageResource(binatang.gambar!!)
                myView.imGGambarBinatang.setOnClickListener{

                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)

                }
                return myView
            }else{
                val binatang = listBinatang[p0]
                val inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                var myView = inflator.inflate(R.layout.item_list_binatang, null)
                myView.txtNama.text = binatang.nama!!
                myView.txtDesc.text = binatang.deskripsi!!
                myView.imGGambarBinatang.setImageResource(binatang.gambar!!)
                myView.imGGambarBinatang.setOnClickListener{
                    val intent = Intent(context, DetailBinatang::class.java)
                    intent.putExtra("nama", binatang.nama!!)
                    intent.putExtra("deskripsi", binatang.deskripsi!!)
                    intent.putExtra("gambar", binatang.gambar!!)
                    context!!.startActivity(intent)
                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            return listBinatang[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return listBinatang.size
        }
    }
}
