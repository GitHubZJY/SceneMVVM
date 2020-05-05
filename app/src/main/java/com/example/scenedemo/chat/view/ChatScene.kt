package com.example.scenedemo.chat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bytedance.scene.ktx.activityViewModels
import com.bytedance.scene.ktx.postDelayed
import com.bytedance.scene.ui.template.AppCompatScene
import com.example.scenedemo.R
import com.example.scenedemo.chat.viewmodel.ChatViewModel
import com.example.scenedemo.reward.viewmodel.RewardViewModel

class ChatScene : AppCompatScene() {

    private val mChatViewModel: ChatViewModel by activityViewModels()

    private var vChatRv: RecyclerView? = null


    override fun onCreateContentView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_chat, null, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setToolbarVisible(false)
        setStatusBarVisible(false)

        vChatRv = findViewById(R.id.chat_rv)

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

        postDelayed(Runnable {
            mChatViewModel.loadChatList()
        }, 1000)
    }

}