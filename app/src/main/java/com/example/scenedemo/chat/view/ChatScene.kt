package com.example.scenedemo.chat.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.scene.ktx.activityViewModels
import com.bytedance.scene.ktx.postDelayed
import com.example.scenedemo.R
import com.example.scenedemo.base.BaseScene
import com.example.scenedemo.chat.viewmodel.ChatViewModel

class ChatScene : BaseScene() {

    private val mChatViewModel: ChatViewModel by activityViewModels()

    private var vChatRv: RecyclerView? = null


    override fun onInflaterViewId(): Int {
        return R.layout.layout_chat
    }

    override fun onBindView(view: View?) {
        vChatRv = findViewById(R.id.chat_rv)
    }

    override fun bindObserver() {
        mChatViewModel.getChatListData().observe(this, Observer {
            vChatRv?.apply {
                layoutManager = LinearLayoutManager(requireSceneContext(), RecyclerView.VERTICAL,  false)
                adapter = ChatListAdapter(requireSceneContext(), it)
                adapter?.apply {
                    notifyDataSetChanged()
                    scrollToPosition(itemCount - 1)
                }
            }
        })
    }

    override fun setData() {
        postDelayed(Runnable {
            mChatViewModel.loadChatList()
        }, 1000)
    }

}