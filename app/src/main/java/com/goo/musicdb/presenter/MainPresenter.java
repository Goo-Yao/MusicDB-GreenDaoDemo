package com.goo.musicdb.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.goo.musicdb.adapter.RVMainAdapter;
import com.goo.musicdb.base.BasePresenter;
import com.goo.musicdb.entity.MainItemInfo;
import com.goo.musicdb.model.MainModel;
import com.goo.musicdb.model.mInterface.MainMInterface;
import com.goo.musicdb.utils.AppConstants;
import com.goo.musicdb.utils.SpUtils;
import com.goo.musicdb.view.activity.MainActivity;
import com.goo.musicdb.view.vinterface.MainVInterface;


public class MainPresenter extends BasePresenter<MainVInterface> {
    private MainMInterface mModel;

    public MainPresenter(MainVInterface viewInterface) {
        super(viewInterface);
        mModel = new MainModel();
    }

    /**
     * 初始化测试数据
     *
     * @param handler
     */
    public void initTestData(final Handler handler) {
        if (!(boolean) SpUtils.getParam((MainActivity) view, AppConstants.INIT_DATA_KEY, false)) {
            view.showInitPD();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mModel.initTestData((MainActivity) view);
                    Message msg = new Message();
                    msg.what = AppConstants.DATA_INIT_DONE;
                    handler.sendMessage(msg);
                }
            }).start();
            SpUtils.setParam((MainActivity) view, AppConstants.INIT_DATA_KEY, true);
        }
    }

    /**
     * 获取已配置的RVAdapter
     *
     * @param context
     * @return
     */
    public RVMainAdapter getRVAdapter(final Context context) {
        RVMainAdapter adapter = new RVMainAdapter(context, mModel.getAMData());
        adapter.setOnRvItemClickListener(new RVMainAdapter.OnRvItemClickListener() {
            @Override
            public void onItemClick(View v, MainItemInfo mainItemInfo) {
                view.startActivityWithAnim(mainItemInfo.getName());
            }
        });
        return adapter;
    }

    /**
     * 触摸动画
     *
     * @param adapter
     * @return
     */
    public ItemTouchHelper getItemTouchHelper(final RVMainAdapter adapter) {
        return new ItemTouchHelper(new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeMovementFlags(ItemTouchHelper.UP |
                        ItemTouchHelper.DOWN, 0);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getAdapterPosition();
                int toPosition = target.getAdapterPosition();
                adapter.swapData(fromPosition, toPosition);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

        });
    }
}
