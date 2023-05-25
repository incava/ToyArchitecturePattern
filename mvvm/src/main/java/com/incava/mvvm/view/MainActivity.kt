package com.incava.mvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.incava.mvvm.R
import com.incava.mvvm.databinding.ActivityMainBinding
import com.incava.mvvm.viewmodel.MyViewModel
import java.util.Collections

class MainActivity : AppCompatActivity() {


    // MVVM [ Model - View - ViewModel ] : view와 model의 데이터를 연결해 놓아서 model 데이터가 변경될 때 별도의 처리코드 없이 view가
    // 1) Model - 다른 패턴의 model과 같음 [ Item, ItemModel ]
    // 2) View - 사용자가 볼 화면. 클릭이벤트를 처리하여 ViewModel에게 model 제어를 요청
    // 3) ViewModel - 뷰와 모델을 연결하는 역할, View가 연결한 데이터를

    // View는 ViewModel을 참조하고, ViewModel 은 Model을 참조하고 있음.

    //MVVM을 위해서는 [ dataBinding : 데이터바인딩 ] 기술을 사용해 일반적으로 구현

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        binding.vm = MyViewModel(this)

    }
}