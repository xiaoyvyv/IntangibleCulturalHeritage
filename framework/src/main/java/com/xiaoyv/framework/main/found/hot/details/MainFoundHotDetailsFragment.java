package com.xiaoyv.framework.main.found.hot.details;

import android.annotation.SuppressLint;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotBean;
import com.xiaoyv.cultureengine.module.main.found.comment.FoundCommentBean;
import com.xiaoyv.framework.BaseFragment;
import com.xiaoyv.framework.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 非遗文化 App
 *
 * @author 王怀玉
 * @since 2020/2/22
 */
public class MainFoundHotDetailsFragment extends BaseFragment<MainFoundHotDetailsContract.Presenter> implements MainFoundHotDetailsContract.View {
    private RecyclerView mainFoundHotDetailsRecyclerView;
    private MainFoundHotDetailsAdapter mainFoundHotDetailsAdapter;
    private ImageView mainFoundHotDetailsHeader;
    private AppCompatImageView mainFoundHotDetailsImage;
    private AppCompatImageView mainFoundHotDetailsLike;
    private AppCompatTextView mainFoundHotDetailsTitle;
    private AppCompatTextView mainFoundHotDetailsName;
    private AppCompatTextView mainFoundHotDetailsLikeCount;
    private AppCompatTextView mainFoundHotDetailsContent;

    public static MainFoundHotDetailsFragment newInstance() {
        return new MainFoundHotDetailsFragment();
    }


    @Override
    public void setPresenter(MainFoundHotDetailsContract.Presenter presenter) {
        super.setFragmentPresenter(presenter);
    }

    @Override
    public boolean isToolbarCanBack() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main_found_hot_details;
    }

    @Override
    public void initView() {
        mainFoundHotDetailsRecyclerView = findView(R.id.main_found_hot_details_recycler_view);

        mainFoundHotDetailsHeader = findView(R.id.main_found_hot_details_header);
        mainFoundHotDetailsImage = findView(R.id.main_found_hot_details_image);
        mainFoundHotDetailsTitle = findView(R.id.main_found_hot_details_title);
        mainFoundHotDetailsName = findView(R.id.main_found_hot_details_name);
        mainFoundHotDetailsLike = findView(R.id.main_found_hot_details_like);
        mainFoundHotDetailsLikeCount = findView(R.id.main_found_hot_details_like_count);

        mainFoundHotDetailsContent = findView(R.id.main_found_hot_details_content);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void initData() {
        mainFoundHotDetailsAdapter = new MainFoundHotDetailsAdapter(R.layout.fragment_main_found_hot_details_item, new ArrayList<>());
        mainFoundHotDetailsAdapter.bindToRecyclerView(mainFoundHotDetailsRecyclerView);
        mainFoundHotDetailsRecyclerView.setAdapter(mainFoundHotDetailsAdapter);

        // 测试数据
        mainFoundHotDetailsContent.setText(" 1953年，张秀芳的师傅翁行凡在北京参加全国首届民间音乐舞蹈会演，演出的《夫妻观灯》获得金质奖章，受到周恩来、朱德等中央领导的接见。由于多采取师徒世代口传的形式以及其他种种原因，随着名老艺人的相继去世，光山花鼓戏剧目不断减少，面临着后继乏人、无法传承的窘境，亟待扶植和保护。2004年，光山花鼓戏被列为河南省民间文化遗产重点抢救项目，2007年被列入第一批河南省非物质文化遗产名录，2014年被国务院公布为第四批国家级非物质文化遗产项目。\n" +
                "\n" +
                "该县文联主席张志娥介绍，为支持这一剧种的传承和创新，县里有关部门搭建了广阔的平台，鼓励老艺人招收学徒，并直接补贴资金帮助戏班购置服装、道具等，逢年过节还组织各戏班到指定地点演出。现在，花鼓戏已经成为当地民间艺术的龙头，带动了地灯戏、皮影戏、狮舞、龙舞、旱船等地方戏和民间表演艺术的蓬勃发展。\n" +
                "\n" +
                "由于嗓子清脆明亮，张秀芳有个外号“百灵鸟”。她说：“当初师傅收了8个徒弟，我是关门弟子。如今我也收了8个徒弟，第一个是我爱人，最小的一个是我女儿，她1999年出生，学戏已经两年多了。”眼见着县里从最初只有几十个花鼓戏演员，到现在七八百人的规模，“百灵鸟”的唱腔更动听了，劲儿也更足了。自从摘掉了穷帽，老百姓的日子好过了，也更加注重文化生活，她的戏班子日程排得很满，除了传统节假日，乡亲们无论红白喜事总喜欢唱大戏，一个花鼓戏演员年收入七八万元根本不是问题。\n" +
                "\n" +
                "“总书记的鼓励，让我心里暖暖的。”张秀芳说，“我一定会好好唱，把光山花鼓戏发扬光大，一代一代传承下去。” ");
    }

    @Override
    public void showParentData(FoundHotBean.FoundHot foundHot) {
        Glide.with(this).load(foundHot.getHeader()).into(mainFoundHotDetailsHeader);
        Glide.with(this).load(foundHot.getBackground()).into(mainFoundHotDetailsImage);
        mainFoundHotDetailsLikeCount.setText(String.valueOf(foundHot.getLike()));
        mainFoundHotDetailsName.setText(foundHot.getName());
        mainFoundHotDetailsTitle.setText(foundHot.getTitle());
        mainFoundHotDetailsLike.setOnClickListener(v -> {
            ToastUtils.showShort(getString(R.string.tips_like));
            mainFoundHotDetailsLikeCount.setText(String.valueOf(Integer.valueOf(mainFoundHotDetailsLikeCount.getText().toString()) + 1));
        });

        toolbar.setTitle(foundHot.getTitle());
    }

    @Override
    public void showCommentItem(FoundCommentBean foundCommentBean) {
        List<FoundCommentBean.FoundComment> comments = foundCommentBean.getFoundComments();
        if (ObjectUtils.isNotEmpty(comments)) {
            mainFoundHotDetailsAdapter.setNewData(comments);
        }
    }

}
