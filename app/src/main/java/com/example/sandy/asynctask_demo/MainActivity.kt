package com.example.sandy.asynctask_demo

import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.io.InputStream
import java.net.URL

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener({

            var obj=MyTask(imageView)
            obj.execute()
        })

        var policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)



    } //onCreate

    class MyTask(var iview:ImageView): AsyncTask<Unit, Unit, Unit>() {

        var ins:InputStream?=null

        override fun doInBackground(vararg params: Unit?) {

            var url=URL("https://i.pinimg.com/originals/f9/c7/07/f9c707de781a8fbb45bc7f2ac56106ff.jpg")
            ins=url.openStream()


        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            var bmp=BitmapFactory.decodeStream(ins)
            iview.setImageBitmap(bmp)

        }

    }

}

