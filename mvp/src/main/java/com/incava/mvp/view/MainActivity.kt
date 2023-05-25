package com.incava.mvp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.incava.mvp.databinding.ActivityMainBinding
import com.incava.mvp.model.Item
import com.incava.mvp.presenter.MainContract
import com.incava.mvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainContract.View {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var presenter: MainPresenter

    // 2. MVP [Model - View - Presenter]
    // 1) Model : MVC패턴의 모델과 같은 역할 [ 데이터 취급 : Item, Person, ItemModel .... ]
    // 2) View : 사용자가 볼 화면 및 이벤트 처리 [ activity_main.xml, MainActivity.kt ...]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter = MainPresenter()
        presenter.initial(this)

        binding.apply {
            btnSave.setOnClickListener {
                presenter.clickSave(
                    etName.text.toString(),
                    etEmail.text.toString()
                )
            }
            btnLoadData.setOnClickListener { presenter.clickLoad() }
        }
    }

    override fun showData(item: Item) {
        binding.tvData.text = item.email.plus(item.name)
    }

    override fun getContext() = this

    // ## MVP 장점 ##
    // 1. MVC처럼 데이터를 제어하는 코드가 Activity/Fragment 클래스 안에 없어서 간결함
    // 2. MVC보다 조금 더 명확하게 각 역할별 코드가 잘 분리되어 작성함.
    // 3. 각 역할이 인터페이스로 규격화되어서 유지보수나 인수인계가 용이함.
    // 4. view 안에서 model을 참조하고 있지 않기에 model 의 변화에 영향 받지 않음.


    // ## MVP 단점 ##
    //1. MVC보다 만들어야 할 기본 파일들이 많아서 구조가 더 복잡해 보임
    //2. view와 presenter가 1:1로 대응되어 파일들이 만들어짐. 파일이 엄청 많아짐.
    //3. 규모가 커지면 결국 presenter가 해야할 작업이 많아서 결국 비대해짐.
    



}