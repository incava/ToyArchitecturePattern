package com.incava.mvvm.viewmodel

import android.content.Context
import android.view.View
import androidx.databinding.ObservableField
import com.incava.mvvm.model.Item
import com.incava.mvvm.model.ItemModel


class MyViewModel(context: Context) {

    // view와 연결할 model 역할 클래스 참조변수
    var itemModel: ItemModel = ItemModel(context)

    // 값 변경이 관찰되는 데이터 멤버변수 ObservableXXX
    var model: ObservableField<Item> = ObservableField()

    init {
        model.set( Item("이름 없음","이메일 없음") )
    }

    // EditText 의 글씨를 가지고 있을 일반 변수
    private var name:String =""
    private var email:String = ""

    // EditText의 글씨가 변경될때 마다 반응하도록 등록한 메소드 2개
    fun changeName(s: CharSequence?, start:Int, end:Int, count:Int){
        this.name= s.toString()
    }

    fun changeEmail(s: CharSequence?, start:Int, end:Int, count:Int){
        this.email= s.toString()
    }


    // view 의 이벤트에 반응하여 model을 제어하도록 요청하는 기능 메소드들....
    fun clickedSave(view: View){
        itemModel.saveData(name, email)
    }

    fun clickedLoad(view:View){
        val item:Item= itemModel.loadData()
        model.set(item)
    }

}
