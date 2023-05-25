package com.incava.mvp.presenter

import com.incava.mvp.model.Item
import com.incava.mvp.model.ItemModel

class MainPresenter : MainContract.Presenter{

    var view : MainContract.View ?= null //1. view역할을 수행하는 클래스는 MainContract
    var model : ItemModel? = null //2. model 역할을 수행하는 클래스 참조변수

    //present가 연결한 2개의 참조 변수를 생성 및 전달 받는 메서드 정의

    fun initial(view:MainContract.View){
        this.view = view
        model = ItemModel(view.getContext())
    }

    //view의 save 버튼 클릭 이벤트를 대신 처리해주는 기능메소드
    override fun clickSave(name: String, email: String) {
        model?.saveData(name,email)
    }

    override fun clickLoad() {
        var item : Item? = model?.loadData()
        item?.let {
            view?.showData(it)
        }
    }

}